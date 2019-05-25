package com.smartpermission.checker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

class PhoneStateReadTest implements PermissionTest {
    private Context mContext;

    PhoneStateReadTest(Context context) {
        this.mContext = context;
    }

    @SuppressLint({"HardwareIds"})
    public boolean test() throws Throwable {
        return !TextUtils.isEmpty(((TelephonyManager) this.mContext.getSystemService("phone")).getSubscriberId());
    }
}
