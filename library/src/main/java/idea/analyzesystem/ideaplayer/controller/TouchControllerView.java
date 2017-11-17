package idea.analyzesystem.ideaplayer.controller;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by idea on 2017/11/17.
 */

public class TouchControllerView extends View implements View.OnClickListener {

    public TouchControllerView(Context context) {
        super(context);
    }

    public TouchControllerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchControllerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.parseColor("#00000000"));
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(onToggleViewVisibilityListener!=null){
            onToggleViewVisibilityListener.toggleVisibility();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }

    public interface OnScaleVideoViewPixelListener{

        /**
         * 手势缩放改变画面
         * @param value
         */
        void onScalePixe(float value);
    }

    public interface OnToggleViewVisibilityListener{

        /**
         * 显示或者隐藏header footer
         */
        void toggleVisibility();
    }

    private OnScaleVideoViewPixelListener onScaleVideoViewPixelListener;

    private OnToggleViewVisibilityListener onToggleViewVisibilityListener;

    public OnScaleVideoViewPixelListener getOnScaleVideoViewPixelListener() {
        return onScaleVideoViewPixelListener;
    }

    public void setOnScaleVideoViewPixelListener(OnScaleVideoViewPixelListener onScaleVideoViewPixelListener) {
        this.onScaleVideoViewPixelListener = onScaleVideoViewPixelListener;
    }

    public OnToggleViewVisibilityListener getOnToggleViewVisibilityListener() {
        return onToggleViewVisibilityListener;
    }

    public void setOnToggleViewVisibilityListener(OnToggleViewVisibilityListener onToggleViewVisibilityListener) {
        this.onToggleViewVisibilityListener = onToggleViewVisibilityListener;
    }
}
