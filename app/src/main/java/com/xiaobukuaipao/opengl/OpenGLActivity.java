package com.xiaobukuaipao.opengl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by xiaobu1 on 16-1-27.
 */
public class OpenGLActivity extends Activity {

    private Button theFirstChapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opengl);

        theFirstChapter = (Button) findViewById(R.id.the_first_chapter);

        setUIListeners();
    }

    private void setUIListeners() {
        theFirstChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpenGLActivity.this, TheFirstChapterActivity.class);
                startActivity(intent);
            }
        });
    }

}
