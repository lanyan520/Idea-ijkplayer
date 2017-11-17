package idea.analyzesystem.ijkplayer.simple;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import idea.analyzesystem.ideaplayer.controller.BaseVideoControllerView;
import idea.analyzesystem.ideaplayer.controller.HeaderControllerView;

/**
 * Created by idea on 2017/11/16.
 */

public class Activity_BaseControllerView extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_basecontrollerview);

        BaseVideoControllerView baseVideoControllerView = (BaseVideoControllerView) findViewById(R.id.BaseVideoControllerView);
        baseVideoControllerView.setTitle("BaseVideoControllerView");
        baseVideoControllerView.setOnHeaderControllerListener(new HeaderControllerView.OnHeaderControllerListener() {
            @Override
            public void onVideoBack() {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }
}
