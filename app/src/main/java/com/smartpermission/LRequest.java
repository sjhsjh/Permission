package com.smartpermission;

import android.support.annotation.NonNull;

import com.smartpermission.checker.PermissionChecker;
import com.smartpermission.checker.StrictChecker;
import com.smartpermission.inter.Action;
import com.smartpermission.inter.Rationale;
import com.smartpermission.inter.Request;
import com.smartpermission.source.Source;
import com.smartpermission.usage.PermissionRecorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LRequest implements Request {
    private static final PermissionChecker CHECKER = new StrictChecker();
    private Action mDenied;
    private Action mGranted;
    private String[] mPermissions;
    private Source mSource;

    LRequest(Source source) {
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
        List<String> deniedList = getDeniedPermissions(this.mSource, this.mPermissions);
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

    private static List<String> getDeniedPermissions(@NonNull Source source, @NonNull String... permissions) {
        List<String> deniedList = new ArrayList(1);
        for (String permission : permissions) {
            if (!CHECKER.hasPermission(source.getContext(), permission)) {
                deniedList.add(permission);
            }
        }
        return deniedList;
    }
}
