package com.smartpermission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CallLog.Calls;
import android.support.annotation.RequiresPermission;

class CallLogWriteTest implements PermissionTest {
    private ContentResolver mResolver;

    CallLogWriteTest(Context context) {
        this.mResolver = context.getContentResolver();
    }

    @RequiresPermission("android.permission.WRITE_CALL_LOG")
    public boolean test() throws Throwable {
        boolean var3 = false;
        try {
            ContentValues content = new ContentValues();
            content.put("type", Integer.valueOf(1));
            content.put("number", "1");
            content.put("date", Integer.valueOf(20080808));
            content.put("new", "0");
            var3 = ContentUris.parseId(this.mResolver.insert(Calls.CONTENT_URI, content)) > 0;
            this.mResolver.delete(Calls.CONTENT_URI, "number=?", new String[]{"1"});

        } catch (Throwable th) {
            this.mResolver.delete(Calls.CONTENT_URI, "number=?", new String[]{"1"});
        }
        return var3;

    }
}
