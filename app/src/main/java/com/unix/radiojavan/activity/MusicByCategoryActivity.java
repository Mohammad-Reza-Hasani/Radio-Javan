package com.unix.radiojavan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.unix.radiojavan.adapter.MusicsAdapter;
import com.unix.radiojavan.api.ApiCaller;
import com.unix.radiojavan.databinding.ActivityMusicByCategoryBinding;
import com.unix.radiojavan.models.BaseModel;
import com.unix.radiojavan.models.Category;
import com.unix.radiojavan.models.IResponseMessage;

public class MusicByCategoryActivity extends AppCompatActivity {


    ActivityMusicByCategoryBinding binding;
    Category category;
    ApiCaller apiCaller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicByCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        category = getIntent().getExtras().getParcelable("categoryData");

        binding.txtTitle.setText(category.getCategoryName());
        apiCaller = new ApiCaller();


        apiCaller.getMusicById(category.getCid(), new IResponseMessage() {
            @Override
            public void onResponse(Object responseMessage) {

                BaseModel baseModel = (BaseModel) responseMessage;
                binding.recyclerMusicByCategory.setAdapter(new MusicsAdapter(getApplicationContext(), baseModel.getOnlineMp3()));
                binding.recyclerMusicByCategory.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                binding.recyclerMusicByCategory.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            }

            @Override
            public void onFailure(String errorResponseMassage) {

            }
        });

    }
}