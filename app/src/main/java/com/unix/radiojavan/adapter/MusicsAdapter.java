package com.unix.radiojavan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.unix.radiojavan.R;
import com.unix.radiojavan.activity.MusicPlayerActivity;
import com.unix.radiojavan.customView.CustomTextViewMedium;
import com.unix.radiojavan.models.Music;

import java.util.List;

public class MusicsAdapter extends RecyclerView.Adapter<MusicsAdapter.MusicsVH> {


    Context context;
    List<Music> musicList;

    public MusicsAdapter(Context context, List<Music> musicList) {
        this.context = context;
        this.musicList = musicList;
    }

    @NonNull
    @Override
    public MusicsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.musics_row, null);
        return new MusicsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicsVH holder, int position) {

        Music music = musicList.get(position);

        holder.txt_title.setText(music.getMp3Title());
        Glide.with(context).load(music.getMp3ThumbnailB()).into(holder.img_video);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context, MusicPlayerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("music",music);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class MusicsVH extends RecyclerView.ViewHolder {

        CustomTextViewMedium txt_title;
        AppCompatImageView img_video;
        CardView cardView;

        public MusicsVH(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            img_video = itemView.findViewById(R.id.img_artist);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }


}
