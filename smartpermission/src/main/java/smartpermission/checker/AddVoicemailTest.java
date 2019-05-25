package smartpermission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.VoicemailContract.Voicemails;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

class AddVoicemailTest implements PermissionTest {
    private ContentResolver mResolver;

    AddVoicemailTest(Context context) {
        this.mResolver = context.getContentResolver();
    }

    @RequiresApi(api = 14)
    public boolean test() throws Throwable {
        try {
            Uri mBaseUri = Voicemails.CONTENT_URI;
            ContentValues contentValues = new ContentValues();
            contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("number", "1");
            contentValues.put("duration", Integer.valueOf(1));
            contentValues.put("source_package", "permission");
            contentValues.put("source_data", "permission");
            contentValues.put("is_read", Integer.valueOf(0));
            long id = ContentUris.parseId(this.mResolver.insert(mBaseUri, contentValues));
            if (this.mResolver.delete(mBaseUri, "_id=?", new String[]{Long.toString(id)}) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            String message = e.getMessage();
            if (TextUtils.isEmpty(message)) {
                return false;
            }
            if (message.toLowerCase().contains("add_voicemail")) {
                return false;
            }
            return true;
        }
    }
}
