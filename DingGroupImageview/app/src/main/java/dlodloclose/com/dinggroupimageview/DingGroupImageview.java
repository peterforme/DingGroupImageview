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

    private ArrayList<String> names = new ArrayList<>();

    public DingGroupImageview(Context context) {
        this(context, null);
    }

    public DingGroupImageview(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DingGroupImageview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //test
        names.add("华");
        names.add("演");
        names.add("蓉");
        names.add("峻");

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.storageView);
        st_radius = typedArray.getDimension(R.styleable.storageView_st_radius, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,30,getResources().getDisplayMetrics()));

        //all text size
        totalTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, typedArray.getDimension(R.styleable.storageView_totalTextSize, 16), getResources().getDisplayMetrics());

        totalBound = new Rect();
        mPaint.setTextSize(totalTextSize);

        typedArray.recycle();
    }

    //重写OnDraw（）函数，在每次重绘时自主实现绘图
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);//设置画笔宽度
        //画圆弧
        RectF rectTmp = new RectF (0,0,2*st_radius,2*st_radius);
        canvas.drawArc(rectTmp,0,90,true,mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectTmp,90,90,true,mPaint);

        mPaint.setColor(Color.BLACK);
        canvas.drawArc(rectTmp,180,90,true,mPaint);

        mPaint.setColor(Color.GREEN);
        canvas.drawArc(rectTmp,270,90,true,mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(2);//设置画笔宽度
        canvas.drawLine(0,st_radius,st_radius * 2,st_radius,mPaint);
        canvas.drawLine(st_radius,0,st_radius,st_radius * 2,mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(totalTextSize);

        if(names.size() >= 4) {
            totalText = names.get(0);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius / 5 * 4 - totalBound.width(), st_radius / 5 * 4, mPaint);

            totalText = names.get(1);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius / 5 * 6, st_radius / 5 * 4, mPaint);

            totalText = names.get(2);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius / 5 * 4 - totalBound.width(), st_radius / 5 * 6 + totalBound.height(), mPaint);

            totalText = names.get(3);
            mPaint.getTextBounds(totalText, 0, totalText.length(), totalBound);
            canvas.drawText(totalText, st_radius / 5 * 6, st_radius / 5 * 6 + totalBound.height(), mPaint);
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
            width = measureWidth;
        }

        if (measureHeightMode == MeasureSpec.EXACTLY)
        {
            height = measureHeight;
        } else
        {
            height = measureHeight;
        }


        setMeasuredDimension((measureWidthMode == MeasureSpec.EXACTLY) ? measureWidth: width, (measureHeightMode == MeasureSpec.EXACTLY) ? measureHeight: height);

    }

}