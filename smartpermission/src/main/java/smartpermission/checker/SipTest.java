package smartpermission.checker;

import android.content.Context;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;
import android.net.sip.SipProfile.Builder;

class SipTest implements PermissionTest {
    private Context mContext;

    SipTest(Context context) {
        this.mContext = context;
    }

    public boolean test() throws Throwable {
        if (SipManager.isApiSupported(this.mContext)) {
            SipManager manager = SipManager.newInstance(this.mContext);
            if (manager != null) {
                Builder builder = new Builder("Permission", "127.0.0.1");
                builder.setPassword("password");
                SipProfile profile = builder.build();
                manager.open(profile);
                manager.close(profile.getUriString());
            }
        }
        return true;
    }
}
