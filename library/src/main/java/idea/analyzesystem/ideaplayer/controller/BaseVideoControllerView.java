package idea.analyzesystem.ideaplayer.controller;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by idea on 2017/11/17.
 */

public class BaseVideoControllerView extends FrameLayout {

    public BaseVideoControllerView(@NonNull Context context) {
        super(context);
    }

    public BaseVideoControllerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseVideoControllerView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
