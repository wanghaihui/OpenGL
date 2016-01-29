package com.xiaobukuaipao.opengl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by xiaobu1 on 16-1-27.
 */
public class TheFirstChapterActivity extends Activity {

    private GLSurfaceView glSurfaceView;
    // 渲染集
    private boolean rendererSet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_the_first_chapter);

        glSurfaceView = new GLSurfaceView(this);

        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

        if (supportsEs2) {
            // Request an OpenGL ES 2.0 compatible(兼容的) context.
            glSurfaceView.setEGLContextClientVersion(2);
            // Assign(分配, 选择) our renderer(渲染器)
            glSurfaceView.setRenderer(new FirstOpenGLProjectRenderer());

            rendererSet = true;
        } else {
            Toast.makeText(this, "This device does not support OpenGL ES 2.0.", Toast.LENGTH_LONG).show();
            return;
        }
    }

}
