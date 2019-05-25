package com.smartpermission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

import java.util.HashMap;
import java.util.UUID;

@RequiresApi(api = 23)
public final class PermissionActivity extends Activity {
    private static final String KEY_INPUT_PERMISSIONS = "KEY_INPUT_PERMISSIONS";
    private static final String KEY_LISTENER = "KEY_LISTENER";
    private static HashMap<String, PermissionListener> mListenerMap = new HashMap();
    private String mListenerKey = null;

    interface PermissionListener {
        void onRequestPermissionsResult(@NonNull String[] strArr);
    }

    public static void requestPermission(Context context, String[] permissions, PermissionListener permissionListener) {
        if (mListenerMap == null) {
            mListenerMap = new HashMap();
        }
        String key = UUID.randomUUID().toString();
        mListenerMap.put(key, permissionListener);
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(KEY_INPUT_PERMISSIONS, permissions);
        intent.putExtra(KEY_LISTENER, key);
        context.startActivity(intent);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        invasionStatusBar(this);
        Intent intent = getIntent();
        String[] permissions = intent.getStringArrayExtra(KEY_INPUT_PERMISSIONS);
        this.mListenerKey = intent.getStringExtra(KEY_LISTENER);
        if (permissions == null || this.mListenerKey == null || mListenerMap == null || mListenerMap.get(this.mListenerKey) == null) {
            finish();
        } else {
            requestPermissions(permissions, 1);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (!(this.mListenerKey == null || mListenerMap == null || mListenerMap.get(this.mListenerKey) == null)) {
            ((PermissionListener) mListenerMap.get(this.mListenerKey)).onRequestPermissionsResult(permissions);
        }
        finish();
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.mListenerKey != null && mListenerMap != null && mListenerMap.get(this.mListenerKey) != null) {
            mListenerMap.remove(this.mListenerKey);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private static void invasionStatusBar(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility((decorView.getSystemUiVisibility() | 1024) | 256);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }
}
