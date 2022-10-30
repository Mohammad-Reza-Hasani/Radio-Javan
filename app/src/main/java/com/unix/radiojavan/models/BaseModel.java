package com.unix.radiojavan.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseModel {


    @SerializedName("ONLINE_MP3")
    @Expose
    private List<Music> onlineMp3 = null;

    public List<Music> getOnlineMp3() {
        return onlineMp3;
    }

    public void setOnlineMp3(List<Music> onlineMp3) {
        this.onlineMp3 = onlineMp3;
    }


}
