package idea.analyzesystem.ideaplayer.controller;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by idea on 2017/10/23.
 */

public class TranslateAnimationHelper {

    public static void translateX(View view, int translateStartX,int translateEndX){
        Animation animation = new TranslateAnimation(translateStartX*view.getMeasuredWidth(), translateEndX*view.getMeasuredWidth(), 0, 0);
        animation.setDuration(500);
        animation.setRepeatCount(0);//动画的重复次数
        animation.setFillAfter(true);//设置为true，动画转化结束后被应用
        view.startAnimation(animation);//开始动画
    }

    public static void translateY(View view,int translateStartY,int translateEndY){
        Animation animation = new TranslateAnimation(0, 0,translateStartY*view.getMeasuredHeight(),translateEndY*view.getMeasuredHeight());
        animation.setDuration(500);
        animation.setRepeatCount(0);//动画的重复次数
        animation.setFillAfter(true);//设置为true，动画转化结束后被应用
        view.startAnimation(animation);//开始动画
    }
}
