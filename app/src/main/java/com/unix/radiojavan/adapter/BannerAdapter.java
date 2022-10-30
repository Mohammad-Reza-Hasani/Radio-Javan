package com.unix.radiojavan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.unix.radiojavan.R;
import com.unix.radiojavan.models.Music;

import java.util.List;

public class BannerAdapter extends PagerAdapter {


    List<Music> musicList;
    Context context;

    public BannerAdapter( Context context,List<Music> musicList) {
        this.musicList = musicList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.banner_row, null);

        AppCompatImageView img_banner = view.findViewById(R.id.img_banner);

        container.addView(view, 0);

        Music music = musicList.get(position);
        Glide.with(context).load(music.getMp3ThumbnailB()).into(img_banner);

        return view;
    }
}
