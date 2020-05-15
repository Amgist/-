package com.example.administrator.read.Y_Utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.read.R;

import java.util.ArrayList;

public class XTextView extends View {

    private TextPaint textPaint;
    private float density;
    private String textContent;
    private int textColor;
    private String textAlignment;
    private float textSize;
    private float textSpacingAdd;
    private float textSpacingMult;

    public XTextView(Context context) {
        this(context, null, 0);
    }

    public XTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.XTextView);
        textContent = a.getString(R.styleable.XTextView_textContent);
        textColor = a.getColor(R.styleable.XTextView_textColor, Color.BLACK);
        textAlignment = a.getString(R.styleable.XTextView_textXAlignment);
        textSize = a.getDimension(R.styleable.XTextView_textSize, 20);
        textSpacingAdd = a.getFloat(R.styleable.XTextView_textSpacingAdd, 0.0F);
        textSpacingMult = a.getFloat(R.styleable.XTextView_textSpacingMult, 1.0F);


        init();
    }


    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public void setTextSpacingAdd(float textSpacingAdd) {
        this.textSpacingAdd = textSpacingAdd;
    }

    public void setTextSpacingMult(float textSpacingMult) {
        this.textSpacingMult = textSpacingMult;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public void setTextAlignment(String textAlignment) {
        this.textAlignment = textAlignment;
    }

    public void setTextContent(final String content) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                contents = XTextUtils.getContentList(content);
            }
        }.run();

    }

    private ArrayList<String> contents;

    private void init() {

        density = getResources().getDisplayMetrics().density;

        textPaint = new TextPaint();
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawText(canvas);
    }

    private int cnt = 0;
    private String totalText = "";

    private void drawText(Canvas canvas) {

        if (cnt >= contents.size()) {
            return;
        }
        totalText += contents.get(cnt);
        StaticLayout layout = null;
        if (textAlignment.equals("normal")) {
            //textPaint(TextPaint 类型)设置了字符串格式及属性的画笔,240为设置画多宽后换行，后面的参数是对齐方式及行间距
            layout = new StaticLayout(totalText, textPaint, getWidth() - (int) (20 * density), Layout.Alignment.ALIGN_NORMAL, textSpacingMult, textSpacingAdd, true);
        } else if (textAlignment.equals("center")) {
            layout = new StaticLayout(totalText, textPaint, getWidth() - (int) (20 * density), Layout.Alignment.ALIGN_CENTER, textSpacingMult, textSpacingAdd, true);
        } else if (textAlignment.equals("opposite")) {
            layout = new StaticLayout(totalText, textPaint, getWidth() - (int) (20 * density), Layout.Alignment.ALIGN_OPPOSITE, textSpacingMult, textSpacingAdd, true);

        }

        //从 (10,10)的位置开始绘制
        canvas.translate(10 * density, 150 * density);

        layout.draw(canvas);

        cnt++;

        startText();
    }

    public void startText() {
        if (cnt != contents.size()) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    invalidate();
                }
            }, time);
        }
    }

    private long time = 50;

    public void setDelayPlayTime(long time) {
        this.time = time;
    }
}