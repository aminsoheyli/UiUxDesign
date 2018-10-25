package com.example.uiuxdesign.custom_views.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.example.uiuxdesign.custom_views.helpers.FormatHelper;


/**
 * Created by Mostafa
 */
public class MyTextView extends android.support.v7.widget.AppCompatTextView {

    public MyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/IRANSansMobile_Light.ttf");
            setTypeface(tf);
        }
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        text = FormatHelper.toPersianNumber(text.toString());
        super.setText(text, type);
    }

}