package smartpermission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog.Calls;
import android.support.annotation.RequiresPermission;

class CallLogReadTest implements PermissionTest {
    private ContentResolver mResolver;

    CallLogReadTest(Context context) {
        this.mResolver = context.getContentResolver();
    }

    @RequiresPermission("android.permission.READ_CALL_LOG")
    public boolean test() throws Throwable {
        Cursor cursor = this.mResolver.query(Calls.CONTENT_URI, new String[]{"_id", "number", "type"}, null, null, null);
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
