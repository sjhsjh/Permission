package com.smartpermission.utils;

import android.util.Log;

import com.smartpermission.BuildConfig;


public class ApLog {
    private static boolean sEnable = false;
    private static String sTag = "CPermissionApi";

    public static void setEnable(boolean enable) {
        sEnable = enable;
    }

    public static void setTag(String tag) {
        sTag = tag;
    }

    public static void v(String message) {
        if (sEnable) {
            Log.v(sTag, message);
        }
    }

    public static void v(Throwable e) {
        if (sEnable) {
            Log.v(sTag, BuildConfig.FLAVOR, e);
        }
    }

    public static void v(String message, Throwable e) {
        if (sEnable) {
            Log.v(sTag, message, e);
        }
    }

    public static void i(String message) {
        if (sEnable) {
            Log.i(sTag, message);
        }
    }

    public static void i(Throwable e) {
        if (sEnable) {
            Log.i(sTag, BuildConfig.FLAVOR, e);
        }
    }

    public static void i(String message, Throwable e) {
        if (sEnable) {
            Log.i(sTag, message, e);
        }
    }

    public static void d(String message) {
        if (sEnable) {
            Log.d(sTag, message);
        }
    }

    public static void d(Throwable e) {
        if (sEnable) {
            Log.d(sTag, BuildConfig.FLAVOR, e);
        }
    }

    public static void d(String message, Throwable e) {
        if (sEnable) {
            Log.d(sTag, message, e);
        }
    }

    public static void w(String message) {
        if (sEnable) {
            Log.w(sTag, message);
        }
    }

    public static void w(Throwable e) {
        if (sEnable) {
            Log.w(sTag, BuildConfig.FLAVOR, e);
        }
    }

    public static void w(String message, Throwable e) {
        if (sEnable) {
            Log.w(sTag, message, e);
        }
    }

    public static void e(String message) {
        if (sEnable) {
            Log.e(sTag, message);
        }
    }

    public static void e(Throwable e) {
        if (sEnable) {
            Log.e(sTag, BuildConfig.FLAVOR, e);
        }
    }

    public static void e(String message, Throwable e) {
        if (sEnable) {
            Log.e(sTag, message, e);
        }
    }
}
