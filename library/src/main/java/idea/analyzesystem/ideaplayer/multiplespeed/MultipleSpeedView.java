package idea.analyzesystem.ideaplayer.multiplespeed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import idea.analyzesystem.ideaplayer.DensityHelper;

/**
 * @author idea
 * Created by idea on 2017/11/16.
 */

public class MultipleSpeedView extends View implements View.OnClickListener{

    public static final int SPEED_ONE = 1;
    public static final int SPEED_TWO = 2;
    public static final int SPEED_FOUR = 4;
    public static final int SPEED_EIGHT = 8;
    @IntDef({SPEED_ONE,SPEED_TWO,SPEED_FOUR,SPEED_EIGHT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode{

    }

    private int currentMode = SPEED_ONE;

    private int circleColor = Color.parseColor("#d4d4d4");

    private int borderColor = Color.parseColor("#11ADFB");

    private int textColor = Color.parseColor("#11ADFB");

    private String text = "";

    private int padding = DensityHelper.dip2px(getContext(),5);

    private float radioSize = DensityHelper.dip2px(getContext(),2);

    private float circleSize = 2.0f;

    private float borderSize = 5.0f;

    private Paint circlePaint;

    private Paint borderPaint;

    private Paint textPaint;



    public MultipleSpeedView(Context context) {
        this(context,null,0);
    }

    public MultipleSpeedView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MultipleSpeedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnClickListener(this);
        initTheme();
        initPaint();
    }

    private void initTheme() {
        //TODO TypedArray
    }

    private void initPaint() {

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(circleColor);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(circleSize);

        borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        borderPaint.setColor(borderColor);
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(borderSize);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(textColor);
        textPaint.setTextSize(DensityHelper.dip2px(getContext(), 16));
        textPaint.setFakeBoldText(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int size = 0;
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (width > height) {
            size = height;
        } else {
            size = width;
        }
        setMeasuredDimension(size, size);

    }

    @Override
    public void onClick(View v) {

        @Mode int mode = currentMode;
        switch (currentMode){
            case SPEED_ONE:
                mode = SPEED_TWO;
                break;
            case SPEED_TWO:
                mode = SPEED_FOUR;
                break;
            case SPEED_FOUR:
                mode = SPEED_EIGHT;
                break;
            case SPEED_EIGHT:
                mode = SPEED_ONE;
                break;
        }

        setCurrentMode(mode);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        text = getText();
        Rect rect = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), rect);
        int textWidth = rect.width();
        int textHeight = rect.height();

        drawCircle(canvas);

        drawBorder(canvas,rect);

        drawModeText(canvas,textWidth,textHeight);

    }


    private void drawModeText(Canvas canvas,int textWidth,int textHeight) {

        canvas.drawText(text,getMeasuredWidth()/2-textWidth/2,getMeasuredWidth()/2+textHeight/2,textPaint);

    }

    private void drawCircle(Canvas canvas) {

        canvas.drawCircle(getMeasuredWidth()/2,getMeasuredWidth()/2,getMeasuredWidth()/2-circleSize,circlePaint);

    }

    private void drawBorder(Canvas canvas,Rect rect) {

        RectF rectF = new RectF();
        rectF.left = getMeasuredWidth()/2-rect.width()/2-padding;
        rectF.top = getMeasuredHeight()/2-rect.height()/2-padding;
        rectF.right = getMeasuredWidth()/2+rect.width()/2+padding;
        rectF.bottom = getMeasuredHeight()/2+rect.height()/2+padding;

        canvas.drawRoundRect(rectF,radioSize,radioSize,borderPaint);
    }

    public int getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(@Mode int currentMode) {
        if(this.currentMode!=currentMode){
            this.currentMode = currentMode;
            postInvalidate();
            invalidate();

            if(onMultipleSpeedListener!=null){
                onMultipleSpeedListener.onMultipleSpeedModeChange(this.currentMode);
            }
        }
    }

    public String getText() {
        text = currentMode+"X";
        return text;
    }

    public interface OnMultipleSpeedListener{

        /**
         * 倍速播放变化了回调该函数
         * @param mode
         */
        void onMultipleSpeedModeChange(@Mode int mode);
    }

    private OnMultipleSpeedListener onMultipleSpeedListener;

    public OnMultipleSpeedListener getOnMultipleSpeedListener() {
        return onMultipleSpeedListener;
    }

    public void setOnMultipleSpeedListener(OnMultipleSpeedListener onMultipleSpeedListener) {
        this.onMultipleSpeedListener = onMultipleSpeedListener;
    }

}
