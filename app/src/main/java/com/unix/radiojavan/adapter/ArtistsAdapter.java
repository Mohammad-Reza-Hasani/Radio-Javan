package com.unix.radiojavan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.unix.radiojavan.R;
import com.unix.radiojavan.customView.CustomTextViewMedium;
import com.unix.radiojavan.models.Artist;

import java.util.List;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ArtistsVH> {


    Context context;
    List<Artist> artistList;
    public ArtistsAdapter(Context context,List<Artist> artistList) {
        this.context = context;
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public ArtistsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.artists_row,null);
        return new ArtistsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistsVH holder, int position) {

        Artist artist = artistList.get(position);
        holder.txt_title.setText(artist.getArtistName());
        Glide.with(context).load(artist.getArtistImage()).into(holder.img_artist);

    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    public class ArtistsVH extends RecyclerView.ViewHolder{


        AppCompatImageView img_artist;
        CustomTextViewMedium txt_title;

        public ArtistsVH(@NonNull View itemView) {
            super(itemView);
            img_artist = itemView.findViewById(R.id.img_artist);
            txt_title = itemView.findViewById(R.id.txt_title);
        }
    }


}
