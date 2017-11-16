package idea.analyzesystem.ijkplayer.simple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import idea.analyzesystem.player.timebar.RecordDataExistTimeSegment;
import idea.analyzesystem.player.timebar.TimeBarView;

/**
 * Created by idea on 2017/11/15.
 */

public class Activity_TimeBarView extends AppCompatActivity implements View.OnClickListener {

    private String TAG = MainActivity.class.getSimpleName();
    private TextView currentTimeTextView;
    private Button zoomInButton, zoomOutButton;
    private TimeBarView mTimebarView;

    private Button mDayBt;
    private Button mHourBt;
    private Button mMinuteBt;
    private long currentRealDateTime = System.currentTimeMillis();

    private static long ONE_MINUTE_IN_MS = 60 * 1000;
    private static long ONE_HOUR_IN_MS = 60 * ONE_MINUTE_IN_MS;
    private static long ONE_DAY_IN_MS = 24 * ONE_HOUR_IN_MS;

    private SimpleDateFormat zeroTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timebar);
        mTimebarView = (TimeBarView) findViewById(R.id.TimeBarView);
        currentTimeTextView = (TextView) findViewById(R.id.current_time_tv);
        zoomInButton = (Button) findViewById(R.id.timebar_zoom_in_btn);
        zoomOutButton = (Button) findViewById(R.id.timebar_zoom_out_btn);
        mDayBt = (Button) findViewById(R.id.day);
        mHourBt = (Button) findViewById(R.id.hour);
        mMinuteBt = (Button) findViewById(R.id.minute);

        zoomInButton.setOnClickListener(this);
        zoomOutButton.setOnClickListener(this);
        mDayBt.setOnClickListener(this);
        mHourBt.setOnClickListener(this);
        mMinuteBt.setOnClickListener(this);

        String startData = "2017-11-16 00:00:00";
        String endData = "2017-11-16 24:00:00";
        long timebarLeftEndPointTime = 0;
        long timebarRightEndPointTime = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            timebarLeftEndPointTime = simpleDateFormat.parse(startData).getTime();
            timebarRightEndPointTime = simpleDateFormat.parse(endData).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mTimebarView.initTimebarLengthAndPosition(timebarLeftEndPointTime,
                timebarRightEndPointTime - 1000, currentRealDateTime);

        final List<RecordDataExistTimeSegment> recordDataList = new ArrayList<>();
        recordDataList.add(new RecordDataExistTimeSegment(timebarLeftEndPointTime + ONE_HOUR_IN_MS * 2, timebarLeftEndPointTime + ONE_HOUR_IN_MS * 3));
        recordDataList.add(new RecordDataExistTimeSegment(timebarLeftEndPointTime + ONE_HOUR_IN_MS * 5, timebarLeftEndPointTime + ONE_HOUR_IN_MS * 7));
        recordDataList.add(new RecordDataExistTimeSegment(timebarLeftEndPointTime + ONE_HOUR_IN_MS * 13, timebarLeftEndPointTime + ONE_HOUR_IN_MS * 16));

        mTimebarView.setRecordDataExistTimeClipsList(recordDataList);

        mTimebarView.openMove();
        mTimebarView.checkVideo(true);


        mTimebarView.setOnBarMoveListener(new TimeBarView.OnBarMoveListener() {
            @Override
            public void onBarMove(long screenLeftTime, long screenRightTime, long currentTime) {
                if (currentTime == -1) {
                    Toast.makeText(getApplicationContext(), "当前时刻没有录像", Toast.LENGTH_SHORT).show();
                }
                currentTimeTextView.setText(zeroTimeFormat.format(currentTime));
            }

            @Override
            public void OnBarMoveFinish(long screenLeftTime, long screenRightTime, long currentTime) {
                currentTimeTextView.setText(zeroTimeFormat.format(currentTime));
            }
        });

        mTimebarView.setOnBarScaledListener(new TimeBarView.OnBarScaledListener() {
            @Override
            public void onOnBarScaledMode(int mode) {
                Log.d(TAG, "onOnBarScaledMode()" + mode);
            }

            @Override
            public void onBarScaled(long screenLeftTime, long screenRightTime, long currentTime) {
                currentTimeTextView.setText(zeroTimeFormat.format(currentTime));
                Log.d(TAG, "onBarScaled()");
            }

            @Override
            public void onBarScaleFinish(long screenLeftTime, long screenRightTime, long currentTime) {
                Log.d(TAG, "onBarScaleFinish()");
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.timebar_zoom_in_btn:
                mTimebarView.scaleByPressingButton(true);
                break;
            case R.id.timebar_zoom_out_btn:
                mTimebarView.scaleByPressingButton(false);
                break;
            case R.id.day:
                mTimebarView.setMode(3);
                break;
            case R.id.hour:
                mTimebarView.setMode(2);
                break;
            case R.id.minute:
                mTimebarView.setMode(1);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimebarView.recycle();
    }
}
