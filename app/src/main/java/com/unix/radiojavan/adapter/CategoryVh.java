package com.unix.radiojavan.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.unix.radiojavan.R;
import com.unix.radiojavan.customView.CustomTextViewMedium;

class CategoryVH extends RecyclerView.ViewHolder {

    public AppCompatImageView img_category;
    public CustomTextViewMedium txt_title;
    public CardView card_category;


    public CategoryVH(@NonNull View itemView) {
        super(itemView);
        img_category = itemView.findViewById(R.id.img_category);
        txt_title = itemView.findViewById(R.id.txt_title);
        card_category = itemView.findViewById(R.id.card_category);
    }
}
