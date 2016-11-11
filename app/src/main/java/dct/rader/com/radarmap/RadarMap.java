package dct.rader.com.radarmap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by EZ on 2016/10/28.
 */

public class RadarMap extends View {
    private int mWidth;
    private int mHeight;
    private Paint mPaint;
    private Context mContext;
    public RadarMap(Context context) {
        this(context,null);
    }

    public RadarMap(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public RadarMap(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        mContext=context;
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(50);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth/2,mHeight/2);

        //雷达图
        Path path=new Path();
        path.moveTo(-400,0);
        path.lineTo(-200,(int)Math.sqrt(120000));
        path.lineTo(200,(int)Math.sqrt(120000));
        path.lineTo(400,0);
        path.lineTo(200,-(int)Math.sqrt(120000));
        path.lineTo(-200,-(int)Math.sqrt(120000));
        path.close();

        canvas.save();
        canvas.drawPath(path,mPaint);
        canvas.scale(0.8f,0.8f);
        mPaint.setStrokeWidth(2/0.8f);
        canvas.drawPath(path,mPaint);
        canvas.restore();
        canvas.save();
        canvas.scale(0.6f,0.6f);
        mPaint.setStrokeWidth(2/0.6f);
        canvas.drawPath(path,mPaint);
        canvas.restore();
        canvas.save();
        canvas.scale(0.4f,0.4f);
        mPaint.setStrokeWidth(2/0.4f);
        canvas.drawPath(path,mPaint);

        canvas.restore();
        canvas.save();
        canvas.scale(0.2f,0.2f);
        mPaint.setStrokeWidth(2/0.2f);
        canvas.drawPath(path,mPaint);
        canvas.restore();


        path.moveTo(0,0);
        path.lineTo(-400,0);

        path.moveTo(0,0);
        path.lineTo(-200,(int)Math.sqrt(120000));

        path.moveTo(0,0);
        path.lineTo(200,(int)Math.sqrt(120000));
        path.moveTo(0,0);
        path.lineTo(400,0);
        path.moveTo(0,0);
        path.lineTo(200,-(int)Math.sqrt(120000));
        path.moveTo(0,0);
        path.lineTo(-200,-(int)Math.sqrt(120000));
        mPaint.setStrokeWidth(2f);
        canvas.drawPath(path,mPaint);


        Path tu=new Path();
        Paint newPaint=new Paint();
        tu.moveTo(-200,0);
        tu.lineTo(-200,-(int)Math.sqrt(120000));
        tu.lineTo(100,-(int)Math.sqrt(120000)/2);
        tu.lineTo(400,0);
        tu.lineTo(100,(int)Math.sqrt(120000)/2);
        tu.lineTo(-100,(int)Math.sqrt(120000)/2);
        tu.lineTo(-200,0);
        newPaint.setStyle(Paint.Style.FILL);
        newPaint.setColor(Color.YELLOW);
        newPaint.setAlpha(200);
        canvas.drawPath(tu,newPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText("a",-450,0,mPaint);
        canvas.drawText("b",-225,(int)Math.sqrt(151875),mPaint);
        canvas.drawText("c",225,(int)Math.sqrt(151875),mPaint);
        canvas.drawText("d",420,0,mPaint);
        canvas.drawText("e",225,-(int)Math.sqrt(151875)+30,mPaint);
        canvas.drawText("f",-225,-(int)Math.sqrt(151875)+30,mPaint);

    }

}
