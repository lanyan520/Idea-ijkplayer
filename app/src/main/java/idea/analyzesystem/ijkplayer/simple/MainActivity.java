package idea.analyzesystem.ijkplayer.simple;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerOnClickListener();


    }

    private void registerOnClickListener() {

        LinearLayout linearLayoutOne = (LinearLayout) findViewById(R.id.ijkplayer_layout_one);
        for (int i = 0 ;i<linearLayoutOne.getChildCount();i++){
            linearLayoutOne.getChildAt(i).setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.TouchControllerView:

                break;
            case R.id.TimeBarView:
                startActivity(Activity_TimeBarView.class);
                break;

            case R.id.multipleSpeed:
                startActivity(Activity_MultipleSpeedView.class);
                break;
        }
    }

    public void startActivity(Class cls){
        startActivity(new Intent(this,cls));
    }
}
