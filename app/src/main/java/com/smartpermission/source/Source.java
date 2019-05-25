package com.smartpermission.source;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;

import java.lang.reflect.Method;

public abstract class Source {
    public abstract Context getContext();

    public abstract void startActivity(Intent intent);

    public abstract void startActivityForResult(Intent intent, int i);

    public final boolean isShowRationalePermission(String permission) {
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        PackageManager packageManager = getContext().getPackageManager();
        try {
            Method method = packageManager.getClass().getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class});
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return ((Boolean) method.invoke(packageManager, new Object[]{permission})).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }
}
