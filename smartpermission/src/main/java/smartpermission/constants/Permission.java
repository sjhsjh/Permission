package smartpermission.constants;

import android.content.Context;

import com.smartpermission.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import com.gz.gb.gbpermisson.BuildConfig;
//import com.gz.gb.gbpermisson.R;

public final class Permission {
    public static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    public static final String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String ADD_VOICEMAIL = "com.android.voicemail.permission.ADD_VOICEMAIL";
    public static final String BODY_SENSORS = "android.permission.BODY_SENSORS";
    public static final String CALL_PHONE = "android.permission.CALL_PHONE";
    public static final String CAMERA = "android.permission.CAMERA";
    public static final String GET_ACCOUNTS = "android.permission.GET_ACCOUNTS";
    public static final String PROCESS_OUTGOING_CALLS = "android.permission.PROCESS_OUTGOING_CALLS";
    public static final String READ_CALENDAR = "android.permission.READ_CALENDAR";
    public static final String READ_CALL_LOG = "android.permission.READ_CALL_LOG";
    public static final String READ_CONTACTS = "android.permission.READ_CONTACTS";
    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String READ_SMS = "android.permission.READ_SMS";
    public static final String RECEIVE_MMS = "android.permission.RECEIVE_MMS";
    public static final String RECEIVE_SMS = "android.permission.RECEIVE_SMS";
    public static final String RECEIVE_WAP_PUSH = "android.permission.RECEIVE_WAP_PUSH";
    public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
    public static final String SEND_SMS = "android.permission.SEND_SMS";
    public static final String USE_SIP = "android.permission.USE_SIP";
    public static final String WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";
    public static final String WRITE_CALL_LOG = "android.permission.WRITE_CALL_LOG";
    public static final String WRITE_CONTACTS = "android.permission.WRITE_CONTACTS";
    public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";

    public static final class Group {
        public static final String[] CALENDAR = new String[]{Permission.READ_CALENDAR, Permission.WRITE_CALENDAR};
        public static final String[] CAMERA = new String[]{Permission.CAMERA};
        public static final String[] CONTACTS = new String[]{Permission.READ_CONTACTS, Permission.WRITE_CONTACTS, Permission.GET_ACCOUNTS};
        public static final String[] LOCATION = new String[]{Permission.ACCESS_FINE_LOCATION, Permission.ACCESS_COARSE_LOCATION};
        public static final String[] MICROPHONE = new String[]{Permission.RECORD_AUDIO};
        public static final String[] PHONE = new String[]{Permission.READ_PHONE_STATE, Permission.CALL_PHONE, Permission.READ_CALL_LOG, Permission.WRITE_CALL_LOG, Permission.ADD_VOICEMAIL, Permission.USE_SIP, Permission.PROCESS_OUTGOING_CALLS};
        public static final String[] SENSORS = new String[]{Permission.BODY_SENSORS};
        public static final String[] SMS = new String[]{Permission.SEND_SMS, Permission.RECEIVE_SMS, Permission.READ_SMS, Permission.RECEIVE_WAP_PUSH, Permission.RECEIVE_MMS};
        public static final String[] STORAGE = new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE};
    }

    public static List<String> transformText(Context context, String... permissions) {
        return transformText(context, Arrays.asList(permissions));
    }

    public static List<String> transformText(Context context, String[]... groups) {
        List permissionList = new ArrayList();
        for (String[] group : groups) {
            permissionList.addAll(Arrays.asList(group));
        }
        return transformText(context, permissionList);
    }

    public static List<String> transformText(Context context, List<String> permissions) {
        List<String> textList = new ArrayList();
        for (String permission : permissions) {
            byte obj = -1;
            switch (permission.hashCode()) {
                case -2062386608:
                    if (permission.equals(READ_SMS)) {
                        obj = 18;
                        break;
                    }
                    break;
                case -1928411001:
                    if (permission.equals(READ_CALENDAR)) {
                        obj = 0;
                        break;
                    }
                    break;
                case -1921431796:
                    if (permission.equals(READ_CALL_LOG)) {
                        obj = 11;
                        break;
                    }
                    break;
                case -1888586689:
                    if (permission.equals(ACCESS_FINE_LOCATION)) {
                        obj = 6;
                        break;
                    }
                    break;
                case -1479758289:
                    if (permission.equals(RECEIVE_WAP_PUSH)) {
                        obj = 19;
                        break;
                    }
                    break;
                case -1238066820:
                    if (permission.equals(BODY_SENSORS)) {
                        obj = 15;
                        break;
                    }
                    break;
                case -895679497:
                    if (permission.equals(RECEIVE_MMS)) {
                        obj = 20;
                        break;
                    }
                    break;
                case -895673731:
                    if (permission.equals(RECEIVE_SMS)) {
                        obj = 17;
                        break;
                    }
                    break;
                case -406040016:
                    if (permission.equals(READ_EXTERNAL_STORAGE)) {
                        obj = 21;
                        break;
                    }
                    break;
                case -63024214:
                    if (permission.equals(ACCESS_COARSE_LOCATION)) {
                        obj = 7;
                        break;
                    }
                    break;
                case -5573545:
                    if (permission.equals(READ_PHONE_STATE)) {
                        obj = 9;
                        break;
                    }
                    break;
                case 52602690:
                    if (permission.equals(SEND_SMS)) {
                        obj = 16;
                        break;
                    }
                    break;
                case 112197485:
                    if (permission.equals(CALL_PHONE)) {
                        obj = 10;
                        break;
                    }
                    break;
                case 214526995:
                    if (permission.equals(WRITE_CONTACTS)) {
                        obj = 4;
                        break;
                    }
                    break;
                case 463403621:
                    if (permission.equals(CAMERA)) {
                        obj = 2;
                        break;
                    }
                    break;
                case 603653886:
                    if (permission.equals(WRITE_CALENDAR)) {
                        obj = 1;
                        break;
                    }
                    break;
                case 610633091:
                    if (permission.equals(WRITE_CALL_LOG)) {
                        obj = 12;
                        break;
                    }
                    break;
                case 784519842:
                    if (permission.equals(USE_SIP)) {
                        obj = 13;
                        break;
                    }
                    break;
                case 952819282:
                    if (permission.equals(PROCESS_OUTGOING_CALLS)) {
                        obj = 14;
                        break;
                    }
                    break;
                case 1271781903:
                    if (permission.equals(GET_ACCOUNTS)) {
                        obj = 5;
                        break;
                    }
                    break;
                case 1365911975:
                    if (permission.equals(WRITE_EXTERNAL_STORAGE)) {
                        obj = 22;
                        break;
                    }
                    break;
                case 1831139720:
                    if (permission.equals(RECORD_AUDIO)) {
                        obj = 8;
                        break;
                    }
                    break;
                case 1977429404:
                    if (permission.equals(READ_CONTACTS)) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            String message;
            switch (obj) {
                case 0:
                case 1:
                    message = context.getString(R.string.permission_name_calendar);
                    if (!textList.contains(message)) {
                        textList.add(message);
                        break;
                    }
                    break;
                case 2:
                    message = context.getString(R.string.permission_name_camera);
                    if (!textList.contains(message)) {
                        textList.add(message);
                        break;
                    }
                    break;
                case 3:
                case 4:
                case 5:
                    message = context.getString(R.string.permission_name_contacts);
                    if (!textList.contains(message)) {
                        textList.add(message);
                        break;
                    }
                    break;
                case 6:
                case 7:
                    message = context.getString(R.string.permission_name_location);
                    if (!textList.contains(message)) {
                        textList.add(message);
                        break;
                    }
                    break;
                case 8:
                    message = context.getString(R.string.permission_name_microphone);
                    if (!textList.contains(message)) {
                        textList.add(message);
                        break;
                    }
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    message = context.getString(R.string.permission_name_phone);
                    if (!textList.contains(message)) {
                        textList.add(message);
                        break;
                    }
                    break;
                case 15:
                    message = context.getString(R.string.permission_name_sensors);
                    if (!textList.contains(message)) {
                        textList.add(message);
                        break;
                    }
                    break;
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                    message = context.getString(R.string.permission_name_sms);
                    if (!textList.contains(message)) {
                        textList.add(message);
                        break;
                    }
                    break;
                case 21:
                case 22:
                    message = context.getString(R.string.permission_name_storage);
                    if (!textList.contains(message)) {
                        textList.add(message);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        return textList;
    }
}
