package com.unix.radiojavan.activity;


import androidx.appcompat.app.AppCompatActivity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.unix.radiojavan.R;
import com.unix.radiojavan.databinding.ActivityMusicPlayerBinding;
import com.unix.radiojavan.db.RoomDb;
import com.unix.radiojavan.models.Music;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class MusicPlayerActivity extends AppCompatActivity {


    ActivityMusicPlayerBinding binding;
    Music music;
    MediaPlayer mediaPlayer;
    RoomDb roomDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        music = getIntent().getExtras().getParcelable("music");

        Glide.with(getApplicationContext()).load(music.getMp3ThumbnailB())
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(15, 3)))
                .into((binding.imgMusicCover));


        Glide.with(getApplicationContext()).load(music.getMp3ThumbnailB()).circleCrop().into(binding.imgMusic);

        binding.txtTitle.setText(music.getMp3Title());

        roomDb = RoomDb.getInstance(getApplicationContext());

        if (!roomDb.idao().isRowExist(Integer.parseInt(music.getId()))) {

            binding.imgFavorite.setImageResource(R.drawable.ic_favorite_border_24);
        } else {

            binding.imgFavorite.setImageResource(R.drawable.ic_favorite_red_32);
        }



        binding.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!roomDb.idao().isRowExist(Integer.parseInt(music.getId()))) {
                    roomDb.idao().insertMusic(music);
                    binding.imgFavorite.setImageResource(R.drawable.ic_favorite_red_32);
                } else {
                    roomDb.idao().deleteMusic(Integer.parseInt(music.getId()));
                    binding.imgFavorite.setImageResource(R.drawable.ic_favorite_border_24);
                }
            }
        });


        mediaPlayer = new MediaPlayer();


        try {
            mediaPlayer.setDataSource(music.getMp3Url());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.start();
        binding.imgPlay.setImageResource(R.drawable.ic_pause_24);

        binding.imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mediaPlayer.isPlaying()) {
                    binding.imgPlay.setImageResource(R.drawable.ic_play_arrow_24);
                    mediaPlayer.pause();
                } else {
                    binding.imgPlay.setImageResource(R.drawable.ic_pause_24);
                    mediaPlayer.start();
                }


            }
        });

        int mediaPos = mediaPlayer.getCurrentPosition();
        int mediaMax = mediaPlayer.getDuration();
        binding.seekbarMusic.setMax(mediaMax);
        binding.seekbarMusic.setProgress(mediaPos);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (mediaPlayer.isPlaying()) {

                    binding.seekbarMusic.setProgress(mediaPlayer.getCurrentPosition());


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            binding.txtDuration.setText(splitTime(mediaPlayer.getDuration()));
                            binding.txtPosition.setText(splitTime(mediaPlayer.getCurrentPosition()));
                        }
                    });


                }

            }
        }, 0, 1000);


        binding.imgBack.bringToFront();
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    public String splitTime(long milliseconds) {

        String result;
        long minutes = (milliseconds / 1000) / 60;
        long seconds = (milliseconds / 1000) % 60;

        if (minutes < 10 && seconds < 10) {
            return "0" + minutes + " : " + "0" + seconds;
        } else if (minutes < 10) {
            return "0" + minutes + " : " + seconds;
        } else if (seconds < 10) {
            return minutes + " : " + "0" + seconds;
        }
        result = minutes + " : " + seconds;

        return result;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying())
            mediaPlayer.stop();
    }
}