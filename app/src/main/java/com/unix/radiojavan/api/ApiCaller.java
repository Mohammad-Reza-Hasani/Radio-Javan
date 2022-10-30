package com.unix.radiojavan.api;

import com.unix.radiojavan.models.ArtistModel;
import com.unix.radiojavan.models.BaseModel;
import com.unix.radiojavan.models.CategoryModel;
import com.unix.radiojavan.models.IResponseMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCaller {


    IService iService;

    public ApiCaller() {
        iService = ApiClient.getRetrofit().create(IService.class);
    }


    public void getLatestMusics(IResponseMessage listener) {
        iService.getLatestMusics().enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {

                listener.onResponse(response.body());

            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {

                listener.onFailure(t.getMessage());
            }
        });

    }


    public void getArtistsList(IResponseMessage listener) {
        iService.getArtistsList().enqueue(new Callback<ArtistModel>() {
            @Override
            public void onResponse(Call<ArtistModel> call, Response<ArtistModel> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<ArtistModel> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
    }

    public void getCategoryList(IResponseMessage listener) {

        iService.getCategoryList().enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<CategoryModel> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });

    }


    public void getMusicById(String id, IResponseMessage listener) {

        iService.getMusicsByCategory(id).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });

    }


}
