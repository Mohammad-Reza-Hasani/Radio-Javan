package com.unix.radiojavan.customView;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextViewMedium extends AppCompatTextView {


    public CustomTextViewMedium(@NonNull Context context) {
        super(context);
        changeFont(context);
    }

    private void changeFont(@NonNull Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/IRANSans_Medium.ttf");
        setTypeface(typeface);
    }

    public CustomTextViewMedium(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        changeFont(context);
    }

    public CustomTextViewMedium(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        changeFont(context);
    }




}
