package com.smartpermission.checker;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.Arrays;
import java.util.List;

public final class StandardChecker implements PermissionChecker {
    public boolean hasPermission(@NonNull Context context, @NonNull String... permissions) {
        return hasPermission(context, Arrays.asList(permissions));
    }

    public boolean hasPermission(@NonNull Context context, @NonNull List<String> permissions) {
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        for (String permission : permissions) {
            if (context.checkPermission(permission, Process.myPid(), Process.myUid()) == -1) {
                return false;
            }
            String op = AppOpsManager.permissionToOp(permission);
            if (TextUtils.isEmpty(op)) {
                return true;
            }
            if (((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(op, context.getPackageName()) != 0) {
                return false;
            }
        }
        return true;
    }
}
