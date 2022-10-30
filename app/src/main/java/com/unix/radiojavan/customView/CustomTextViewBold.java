package com.unix.radiojavan.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextViewBold extends AppCompatTextView {
    public CustomTextViewBold(@NonNull Context context) {
        super(context);
        changeFont(context);
    }

    public CustomTextViewBold(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        changeFont(context);
    }

    public CustomTextViewBold(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        changeFont(context);
    }

    private void changeFont(@NonNull Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/IRANSans_Bold.ttf");
        setTypeface(typeface);
    }

}
