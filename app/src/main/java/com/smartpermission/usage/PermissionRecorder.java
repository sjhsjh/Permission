package com.smartpermission.usage;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionRecorder {
    private static final String KEY_ACTION = "action";
    private static final String KEY_PERMISSION = "permission";
    private static final String PATH = "C_PERMISSION";
    private static final String VALUE_DENIED = "denied";
    private static final String VALUE_GRANTED = "granted";
    private static final String VALUE_RATIONALE = "rationale";
    private static final String VALUE_REQUEST = "request";
    private static Recorder sRecorder;

    public static void presetRecorder(Recorder recorder) {
        sRecorder = recorder;
    }

    private static void record(@NonNull List<String> permissionList, @NonNull String action) {
        if (sRecorder != null) {
            for (String permission : permissionList) {
                Map<String, Object> values = new HashMap();
                values.put(KEY_PERMISSION, permission);
                values.put(KEY_ACTION, action);
                sRecorder.record(PATH, values);
            }
        }
    }

    public static void recordStart(@NonNull List<String> requestList) {
        record(requestList, VALUE_REQUEST);
    }

    public static void recordGranted(@NonNull List<String> grantedList) {
        record(grantedList, VALUE_GRANTED);
    }

    public static void recordDenied(@NonNull List<String> deniedList) {
        record(deniedList, VALUE_DENIED);
    }

    public static void recordRationale(@NonNull List<String> rationaleList) {
        record(rationaleList, VALUE_RATIONALE);
    }
}
