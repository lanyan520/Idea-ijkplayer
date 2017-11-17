package idea.analyzesystem.ideaplayer.controller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by idea on 2017/11/17.
 */

public class FooterControllerView extends BaseControllerLayout{

    public FooterControllerView(Context context) {
        this(context,null,0);
    }

    public FooterControllerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FooterControllerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public void hide() {
        TranslateAnimationHelper.translateY(this,0,1);
    }

    @Override
    public void show() {
        TranslateAnimationHelper.translateY(this,1,0);
    }
}
