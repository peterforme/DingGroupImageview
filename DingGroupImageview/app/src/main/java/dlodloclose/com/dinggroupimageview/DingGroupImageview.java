package dlodloclose.com.dinggroupimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by admin on 2017/3/10.
 */
public class DingGroupImageview extends View {

    private String namespace = "http://schemas.android.com/apk/res-auto";
    private Paint mPaint;
    private Rect totalBound;

    //圆的半径
    private float st_radius;

    private int totalTextSize;
    private String totalText ;

    private int firstColor;
    private int secondColor;
    private int thirdColor;
    private int fourthColor;

    private ArrayList<String> names = new ArrayList<>();

    public DingGroupImageview(Context context) {
        this(context, null);
    }

    public DingGroupImageview(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DingGroupImageview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);//设置画笔宽度

        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.storageView);
        st_radius = typedArray.getDimension(R.styleable.storageView_st_radius, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,30,getResources().getDisplayMetrics()));

        //all text size
        totalTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, typedArray.getDimension(R.styleable.storageView_totalTextSize, 16), getResources().getDisplayMetrics());

        totalBound = new Rect();
        mPaint.setTextSize(totalTextSize);

        //设置默认的颜色,如果需要在xml设置，可自行修改
        firstColor = getResources().getColor(R.color.first);
        secondColor = getResources().getColor(R.color.second);
        thirdColor = getResources().getColor(R.color.third);
        fourthColor = getResources().getColor(R.color.fourth);

        typedArray.recycle();
    }

    public void setNames(ArrayList<String> temp){
        names.clear();
        names.addAll(temp);
        invalidate();
    }

    public void setFirstColor(int firstColor) {
        this.firstColor = firstColor;
        invalidate();
    }

    public void setSecondColor(int secondColor) {
        this.secondColor = secondColor;
        invalidate();
    }

    public void setThirdColor(int thirdColor) {
        this.thirdColor = thirdColor;
        invalidate();
    }

    public void setFourthColor(int fourthColor) {
        this.fourthColor = fourthColor;
        invalidate();
    }

    //获取名字的后几个字，num表示数量，例如num=2表示返回后两个字
    private String getLast2Character(String name , int num){
        if(name.length() <= num){
            return name;
        }else{
            return name.substring( name.length() - num );
        }
    }


    //重写OnDraw（）函数，在每次重绘时自主实现绘图
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        RectF rectTmp = new RectF (0,0,2*st_radius,2*st_radius);

        if(names == null || names.size() == 0){

            mPaint.setColor(firstColor);
            //画圆弧
            canvas.drawArc(rectTmp,0,360,true,mPaint);
        }
        else if(names.size() == 1){
            mPaint.setColor(firstColor);
            //画圆弧
            canvas.drawArc(rectTmp,0,360,true,mPaint);

            mPaint.setStrokeWidth(2);//设置画笔宽度
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(totalTextSize);

            totalText = getLast2Character( names.get(0) , 2);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius  - totalBound.width() / 2, st_radius + totalBound.height() / 2, mPaint);

        }else if(names.size() == 2){
            mPaint.setColor(firstColor);
            //画圆弧
            canvas.drawArc(rectTmp,0,180,true,mPaint);

            mPaint.setColor(secondColor);
            canvas.drawArc(rectTmp,180,180,true,mPaint);

            mPaint.setColor(Color.WHITE);
            mPaint.setStrokeWidth(2);//设置画笔宽度
            canvas.drawLine(0,st_radius,st_radius * 2,st_radius,mPaint);

            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(totalTextSize);

            totalText = getLast2Character( names.get(0) , 2);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius  - totalBound.width() / 2, st_radius / 5 * 4 , mPaint);

            totalText = getLast2Character( names.get(1) , 2);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius  - totalBound.width() / 2, st_radius / 5 * 6 + totalBound.height() , mPaint);

        }else if(names.size() == 3){
            mPaint.setColor(firstColor);
            //画圆弧
            canvas.drawArc(rectTmp,0,90,true,mPaint);

            mPaint.setColor(secondColor);
            canvas.drawArc(rectTmp,90,180,true,mPaint);


            mPaint.setColor(thirdColor);
            canvas.drawArc(rectTmp,270,90,true,mPaint);

            mPaint.setColor(Color.WHITE);
            mPaint.setStrokeWidth(2);//设置画笔宽度
            canvas.drawLine(st_radius,st_radius,st_radius * 2,st_radius,mPaint);
            canvas.drawLine(st_radius,0,st_radius,st_radius * 2,mPaint);

            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(totalTextSize);


            totalText = getLast2Character( names.get(0) , 1);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius / 5 * 6, st_radius / 5 * 6 + totalBound.height(), mPaint);

            totalText = getLast2Character( names.get(1) , 1);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius / 5 * 4 - totalBound.width(), st_radius + totalBound.height() / 2, mPaint);

            totalText = getLast2Character( names.get(2) , 1);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius / 5 * 6, st_radius / 5 * 4, mPaint);
        }
        else if(names.size() >= 4) {
            mPaint.setColor(firstColor);
            //画圆弧
            canvas.drawArc(rectTmp,0,90,true,mPaint);

            mPaint.setColor(secondColor);
            canvas.drawArc(rectTmp,90,90,true,mPaint);

            mPaint.setColor(thirdColor);
            canvas.drawArc(rectTmp,180,90,true,mPaint);

            mPaint.setColor(fourthColor);
            canvas.drawArc(rectTmp,270,90,true,mPaint);

            mPaint.setColor(Color.WHITE);
            mPaint.setStrokeWidth(2);//设置画笔宽度
            canvas.drawLine(0,st_radius,st_radius * 2,st_radius,mPaint);
            canvas.drawLine(st_radius,0,st_radius,st_radius * 2,mPaint);

            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(totalTextSize);

            totalText = getLast2Character( names.get(0) , 1);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius / 5 * 6, st_radius / 5 * 6 + totalBound.height(), mPaint);

            totalText = getLast2Character( names.get(1) , 1);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius / 5 * 4 - totalBound.width(), st_radius / 5 * 6 + totalBound.height(), mPaint);

            totalText = getLast2Character( names.get(2) , 1);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius / 5 * 4 - totalBound.width(), st_radius / 5 * 4, mPaint);

            totalText = getLast2Character( names.get(3) , 1);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius / 5 * 6, st_radius / 5 * 4, mPaint);

        }


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        int height ;
        int width ;

        if (measureWidthMode == MeasureSpec.EXACTLY)
        {
            width = measureWidth;
        } else
        {
            width = (int)(st_radius * 2 + 0.5);
        }

        if (measureHeightMode == MeasureSpec.EXACTLY)
        {
            height = measureHeight;
        } else
        {
            height = (int)(st_radius * 2 + 0.5);
        }


        setMeasuredDimension( width,  height);

    }

}