package com.unix.radiojavan.api;

import com.unix.radiojavan.models.ArtistModel;
import com.unix.radiojavan.models.BaseModel;
import com.unix.radiojavan.models.CategoryModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IService {

    @GET("api.php?latest")
    Call<BaseModel> getLatestMusics();


    @GET("api.php?recent_artist_list")
    Call<ArtistModel> getArtistsList();

    @GET("api.php?cat_list")
    Call<CategoryModel> getCategoryList();

    @GET("api.php")
    Call<BaseModel> getMusicsByCategory(@Query("cat_id")String catId);
}
