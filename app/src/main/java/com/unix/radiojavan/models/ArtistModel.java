package com.unix.radiojavan.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistModel {

    @SerializedName("ONLINE_MP3")
    @Expose
    List<Artist> artistList;

    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }
}
