package com.smartpermission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;

class ContactsReadTest implements PermissionTest {
    private ContentResolver mResolver;

    ContactsReadTest(Context context) {
        this.mResolver = context.getContentResolver();
    }

    public boolean test() throws Throwable {
        Cursor cursor = this.mResolver.query(Phone.CONTENT_URI, new String[]{"_id", "data1"}, null, null, null);
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
