package com.smartpermission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.Telephony.Sms;
import android.support.annotation.RequiresApi;

class SmsReadTest implements PermissionTest {
    private ContentResolver mResolver;

    SmsReadTest(Context context) {
        this.mResolver = context.getContentResolver();
    }

    @RequiresApi(api = 19)
    public boolean test() throws Throwable {
        Cursor cursor = this.mResolver.query(Sms.CONTENT_URI, new String[]{"_id", "address", "person", "body"}, null, null, null);
        if (cursor == null) {
            return false;
        }
        try {
            CursorTest.read(cursor);
            return true;
        } finally {
            cursor.close();
        }
    }
}
