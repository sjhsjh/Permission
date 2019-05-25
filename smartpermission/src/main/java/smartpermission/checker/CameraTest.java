package smartpermission.checker;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

class CameraTest implements PermissionTest {
    private static final Callback CALLBACK = new Callback() {
        public void surfaceCreated(SurfaceHolder holder) {
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
        }
    };
    private static final PreviewCallback PREVIEW_CALLBACK = new PreviewCallback() {
        public void onPreviewFrame(byte[] data, Camera camera) {
        }
    };
    private SurfaceHolder mHolder;

    CameraTest(Context context) {
        this.mHolder = new SurfaceView(context).getHolder();
        this.mHolder.addCallback(CALLBACK);
    }

    public boolean test() throws Throwable {
        Camera camera = null;
        try {
            camera = Camera.open();
            camera.setParameters(camera.getParameters());
            camera.setPreviewDisplay(this.mHolder);
            camera.setPreviewCallback(PREVIEW_CALLBACK);
            camera.startPreview();
            return true;
        } finally {
            if (camera != null) {
                camera.stopPreview();
                camera.setPreviewDisplay(null);
                camera.setPreviewCallback(null);
                camera.release();
            }
        }
    }
}
