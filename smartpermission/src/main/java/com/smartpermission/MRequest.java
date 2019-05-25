package com.smartpermission;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import com.smartpermission.checker.DoubleChecker;
import com.smartpermission.checker.PermissionChecker;
import com.smartpermission.checker.StandardChecker;
import com.smartpermission.inter.Action;
import com.smartpermission.inter.Rationale;
import com.smartpermission.inter.Request;
import com.smartpermission.inter.RequestExecutor;
import com.smartpermission.source.Source;
import com.smartpermission.usage.PermissionRecorder;
import com.smartpermission.usage.Recorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiresApi(api = 23)
class MRequest implements Request, RequestExecutor, PermissionActivity.PermissionListener {
    private static final PermissionChecker CHECKER = new StandardChecker();
    private static final PermissionChecker DOUBLE_CHECKER = new DoubleChecker();
    private Action mDenied;
    private String[] mDeniedPermissions;
    private Action mGranted;
    private String[] mPermissions;
    private Rationale mRationaleListener;
    private Recorder mRecorder;
    private Source mSource;

    MRequest(Source source) {
        this.mSource = source;
    }

    @NonNull
    public Request permission(String... permissions) {
        this.mPermissions = permissions;
        return this;
    }

    @NonNull
    public Request permission(String[]... groups) {
        List<String> permissionList = new ArrayList();
        for (String[] group : groups) {
            permissionList.addAll(Arrays.asList(group));
        }
        this.mPermissions = (String[]) permissionList.toArray(new String[permissionList.size()]);
        return this;
    }

    @NonNull
    public Request rationale(Rationale listener) {
        this.mRationaleListener = listener;
        return this;
    }

    @NonNull
    public Request onGranted(Action granted) {
        this.mGranted = granted;
        return this;
    }

    @NonNull
    public Request onDenied(Action denied) {
        this.mDenied = denied;
        return this;
    }

    public void start() {
        PermissionRecorder.recordStart(Arrays.asList(this.mPermissions));
        List<String> deniedList = getDeniedPermissions(CHECKER, this.mSource, this.mPermissions);
        this.mDeniedPermissions = (String[]) deniedList.toArray(new String[deniedList.size()]);
        if (this.mDeniedPermissions.length > 0) {
            List<String> rationaleList = getRationalePermissions(this.mSource, this.mDeniedPermissions);
            if (rationaleList.size() <= 0 || this.mRationaleListener == null) {
                execute();
                return;
            }
            this.mRationaleListener.showRationale(this.mSource.getContext(), rationaleList, this);
            PermissionRecorder.recordRationale(rationaleList);
            return;
        }
        callbackSucceed();
    }

    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.requestPermission(this.mSource.getContext(), this.mDeniedPermissions, this);
    }

    public void cancel() {
        onRequestPermissionsResult(this.mDeniedPermissions);
    }

    public void onRequestPermissionsResult(@NonNull String[] permissions) {
        List<String> deniedList = getDeniedPermissions(DOUBLE_CHECKER, this.mSource, permissions);
        if (deniedList.isEmpty()) {
            callbackSucceed();
        } else {
            callbackFailed(deniedList);
        }
    }

    private void callbackSucceed() {
        List<String> permissionList = Arrays.asList(this.mPermissions);
        try {
            if (this.mGranted != null) {
                this.mGranted.onAction(permissionList);
            }
            PermissionRecorder.recordGranted(permissionList);
        } catch (Exception e) {
            if (this.mDenied != null) {
                this.mDenied.onAction(permissionList);
            }
        }
    }

    private void callbackFailed(@NonNull List<String> deniedList) {
        if (this.mDenied != null) {
            this.mDenied.onAction(deniedList);
        }
        PermissionRecorder.recordDenied(deniedList);
    }

    private static List<String> getDeniedPermissions(PermissionChecker checker, @NonNull Source source, @NonNull String... permissions) {
        List<String> deniedList = new ArrayList(1);
        for (String permission : permissions) {
            if (!checker.hasPermission(source.getContext(), permission)) {
                deniedList.add(permission);
            }
        }
        return deniedList;
    }

    private static List<String> getRationalePermissions(@NonNull Source source, @NonNull String... permissions) {
        List<String> rationaleList = new ArrayList(1);
        for (String permission : permissions) {
            if (source.isShowRationalePermission(permission)) {
                rationaleList.add(permission);
            }
        }
        return rationaleList;
    }
}
