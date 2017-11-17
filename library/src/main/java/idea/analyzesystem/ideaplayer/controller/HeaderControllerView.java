package idea.analyzesystem.ideaplayer.controller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by idea on 2017/11/17.
 */

public class HeaderControllerView extends BaseControllerLayout implements View.OnClickListener {

    ImageView backView;

    TextView titleTextView;

    public HeaderControllerView(Context context) {
        this(context,null,0);
    }

    public HeaderControllerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HeaderControllerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTheme();
    }

    private void initTheme() {

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        backView = (ImageView) getChildAt(0);
        titleTextView = (TextView) getChildAt(1);
        backView.setOnClickListener(this);

    }

    public void setTitle(String title){
        titleTextView.setText(title);
    }

    @Override
    public void hide() {
          TranslateAnimationHelper.translateY(this,0,-1);
    }

    @Override
    public void show() {
         TranslateAnimationHelper.translateY(this,-1,0);
    }

    @Override
    public void onClick(View v) {
        if(onHeaderControllerListener!=null){
            onHeaderControllerListener.onVideoBack();
        }
    }


    public interface OnHeaderControllerListener{

        void onVideoBack();

    }

    private OnHeaderControllerListener onHeaderControllerListener;

    public OnHeaderControllerListener getOnHeaderControllerListener() {
        return onHeaderControllerListener;
    }

    public void setOnHeaderControllerListener(OnHeaderControllerListener onHeaderControllerListener) {
        this.onHeaderControllerListener = onHeaderControllerListener;
    }
}
