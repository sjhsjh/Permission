package smartpermission.usage;

import java.util.Map;

public interface Recorder {
    void record(String str, Map<String, Object> map);
}
