package com.pitch.deck.shopeasy.common.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.pitch.deck.shopeasy.R;


/**
 * Created by sangeetha on 18/8/17.
 */

/**
 * Custom Textview class, used to load different types of fonts.
 */
public class StyledTextView extends AppCompatTextView {
    private static final String DEFAULT_FONT = "fonts/Roboto-Regular.ttf";

    public StyledTextView(Context context) {
        super(context);
        init();
    }

    public StyledTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public StyledTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.CustomFonts);
        String customFont = a.getString(R.styleable.CustomFonts_customTypeface);

        if (!isInEditMode())
            setCustomFont(ctx, customFont);
        a.recycle();
    }

    public boolean setCustomFont(Context ctx, String asset) {
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), asset);

        } catch (Exception e) {
            // If no typeface attribute is specify in xml.
            return false;
        }
        setTypeface(tf);
        return true;
    }


    private void init() {
        if (!isInEditMode())
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), DEFAULT_FONT));
    }
}
