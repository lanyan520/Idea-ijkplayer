package idea.analyzesystem.ideaplayer.controller;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by idea on 2017/11/17.
 */

public class BaseVideoControllerView extends RelativeLayout implements OnAutoVisibilityListener,TouchControllerView.OnToggleViewVisibilityListener {

    HeaderControllerView headerControllerView;
    FooterControllerView footerControllerView;
    TouchControllerView touchControllerView;

    private boolean isShowController = true;

    public BaseVideoControllerView(@NonNull Context context) {
        this(context,null,0);
    }

    public BaseVideoControllerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseVideoControllerView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        touchControllerView = (TouchControllerView) getChildAt(0);
        headerControllerView = (HeaderControllerView) getChildAt(1);
        footerControllerView = (FooterControllerView) getChildAt(2);

        touchControllerView.setOnToggleViewVisibilityListener(this);
    }

    public void setTitle(String title){
        headerControllerView.setTitle(title);
    }
    @Override
    public void hide() {
        headerControllerView.hide();
        footerControllerView.hide();
        isShowController =!isShowController;
    }

    @Override
    public void show() {
        headerControllerView.show();
        footerControllerView.show();
        isShowController =!isShowController;
    }

    @Override
    public void toggleVisibility() {

        if(isShowController){
            hide();
        }else{
            show();
        }

    }

    public void setOnHeaderControllerListener(HeaderControllerView.OnHeaderControllerListener onHeaderControllerListener) {
        headerControllerView.setOnHeaderControllerListener(onHeaderControllerListener);
    }
}
