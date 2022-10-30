package com.unix.radiojavan.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist {


    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("artist_name")
    @Expose
    String artistName;
    @SerializedName("artist_image")
    @Expose
    String artistImage;
    @SerializedName("artist_image_thumb")
     @Expose
    String artistImageThumb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistImage() {
        return artistImage;
    }

    public void setArtistImage(String artistImage) {
        this.artistImage = artistImage;
    }

    public String getArtistImageThumb() {
        return artistImageThumb;
    }

    public void setArtistImageThumb(String artistImageThumb) {
        this.artistImageThumb = artistImageThumb;
    }
}
