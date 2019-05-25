package com.smartpermission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract.Calendars;
import android.support.annotation.RequiresApi;
import android.support.annotation.RequiresPermission;

class CalendarReadTest implements PermissionTest {
    private ContentResolver mResolver;

    CalendarReadTest(Context context) {
        this.mResolver = context.getContentResolver();
    }

    @RequiresApi(14)
    @RequiresPermission("android.permission.READ_CALENDAR")
    public boolean test() throws Throwable {
        Cursor cursor = this.mResolver.query(Calendars.CONTENT_URI, new String[]{"_id", "name"}, null, null, null);
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
