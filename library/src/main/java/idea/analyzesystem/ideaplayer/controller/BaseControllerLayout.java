package idea.analyzesystem.ideaplayer.controller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by idea on 2017/11/17.
 */

public abstract class BaseControllerLayout extends LinearLayout implements OnAutoVisibilityListener {

    public BaseControllerLayout(Context context) {
        super(context);
    }

    public BaseControllerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseControllerLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
