package smartpermission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CalendarContract.Calendars;
import android.support.annotation.RequiresApi;

import java.util.TimeZone;

class CalendarWriteTest implements PermissionTest {
    private static final String ACCOUNT = "permission@gmail.com";
    private static final String NAME = "PERMISSION";
    private ContentResolver mResolver;

    CalendarWriteTest(Context context) {
        this.mResolver = context.getContentResolver();
    }

    @RequiresApi(api = 14)
    public boolean test() throws Throwable {
        boolean var5 = false;
        try {
            TimeZone timeZone = TimeZone.getDefault();
            ContentValues value = new ContentValues();
            value.put("name", NAME);
            value.put("account_name", ACCOUNT);
            value.put("account_type", "LOCAL");
            value.put("calendar_displayName", NAME);
            value.put("visible", Integer.valueOf(1));
            value.put("calendar_color", Integer.valueOf(-16776961));
            value.put("calendar_access_level", Integer.valueOf(700));
            value.put("sync_events", Integer.valueOf(1));
            value.put("calendar_timezone", timeZone.getID());
            value.put("ownerAccount", NAME);
            value.put("canOrganizerRespond", Integer.valueOf(0));
            var5 = ContentUris.parseId(this.mResolver.insert(Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", NAME).appendQueryParameter("account_type", "LOCAL").build(), value)) > 0;
            this.mResolver.delete(Calendars.CONTENT_URI.buildUpon().build(), "account_name=?", new String[]{ACCOUNT});

        } catch (Throwable th) {
            this.mResolver.delete(Calendars.CONTENT_URI.buildUpon().build(), "account_name=?", new String[]{ACCOUNT});
        }
        return var5;
    }

}
