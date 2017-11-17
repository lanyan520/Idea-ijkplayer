package idea.analyzesystem.ideaplayer;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * @author idea
 * Created by idea on 2017/11/15.
 */

public class IdeaVideoView extends FrameLayout {

    public IdeaVideoView(@NonNull Context context) {
        super(context);
    }

    public IdeaVideoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IdeaVideoView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
