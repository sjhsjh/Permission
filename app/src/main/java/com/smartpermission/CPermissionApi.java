package com.smartpermission;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import com.smartpermission.inter.Request;
import com.smartpermission.inter.SettingService;
import com.smartpermission.setting.PermissionSetting;
import com.smartpermission.source.AppActivitySource;
import com.smartpermission.source.ContextSource;
import com.smartpermission.source.Source;

import java.util.List;

public class CPermissionApi {
    private static final RequestFactory FACTORY;

    private interface RequestFactory {
        Request create(Source source);
    }

    private static class LRequestFactory implements RequestFactory {
        private LRequestFactory() {
        }

        public Request create(Source source) {
            return new LRequest(source);
        }
    }

    @RequiresApi(api = 23)
    private static class MRequestFactory implements RequestFactory {
        private MRequestFactory() {
        }

        public Request create(Source source) {
            return new MRequest(source);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            FACTORY = new MRequestFactory();
        } else {
            FACTORY = new LRequestFactory();
        }
    }

    @NonNull
    public static SettingService permissionSetting(@NonNull Context context) {
        return new PermissionSetting(new ContextSource(context));
    }

    @NonNull
    public static Request with(@NonNull Context context) {
        return FACTORY.create(new ContextSource(context));
    }

    public static boolean hasAlwaysDeniedPermission(@NonNull Activity activity, @NonNull List<String> deniedPermissions) {
        return hasAlwaysDeniedPermission(new AppActivitySource(activity), (List) deniedPermissions);
    }

    public static boolean hasAlwaysDeniedPermission(@NonNull Source source, @NonNull List<String> deniedPermissions) {
        for (String permission : deniedPermissions) {
            if (!source.isShowRationalePermission(permission)) {
                return true;
            }
        }
        return false;
    }

    private CPermissionApi() {
    }
}
