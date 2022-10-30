package com.unix.radiojavan.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "tbl_music")
public class Music implements Parcelable {

    public Music(String id, String catId, String mp3Type, String mp3Title, String mp3Url, String mp3ThumbnailB, String mp3ThumbnailS, String mp3Duration, String mp3Artist, String mp3Description, String totalRate, String rateAvg, String totalViews, String totalDownload, String cid, String categoryName, String categoryImage, String categoryImageThumb) {
        this.id = id;
        this.catId = catId;
        this.mp3Type = mp3Type;
        this.mp3Title = mp3Title;
        this.mp3Url = mp3Url;
        this.mp3ThumbnailB = mp3ThumbnailB;
        this.mp3ThumbnailS = mp3ThumbnailS;
        this.mp3Duration = mp3Duration;
        this.mp3Artist = mp3Artist;
        this.mp3Description = mp3Description;
        this.totalRate = totalRate;
        this.rateAvg = rateAvg;
        this.totalViews = totalViews;
        this.totalDownload = totalDownload;
        this.cid = cid;
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.categoryImageThumb = categoryImageThumb;
    }

    @Ignore
    public Music(int musicId, String id, String catId, String mp3Type, String mp3Title, String mp3Url, String mp3ThumbnailB, String mp3ThumbnailS, String mp3Duration, String mp3Artist, String mp3Description, String totalRate, String rateAvg, String totalViews, String totalDownload, String cid, String categoryName, String categoryImage, String categoryImageThumb) {
        this.musicId = musicId;
        this.id = id;
        this.catId = catId;
        this.mp3Type = mp3Type;
        this.mp3Title = mp3Title;
        this.mp3Url = mp3Url;
        this.mp3ThumbnailB = mp3ThumbnailB;
        this.mp3ThumbnailS = mp3ThumbnailS;
        this.mp3Duration = mp3Duration;
        this.mp3Artist = mp3Artist;
        this.mp3Description = mp3Description;
        this.totalRate = totalRate;
        this.rateAvg = rateAvg;
        this.totalViews = totalViews;
        this.totalDownload = totalDownload;
        this.cid = cid;
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.categoryImageThumb = categoryImageThumb;
    }

    @PrimaryKey(autoGenerate = true)
    private int musicId;

    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    private String id;
    @SerializedName("cat_id")
    @Expose
    @ColumnInfo(name = "catId")
    private String catId;
    @SerializedName("mp3_type")
    @Expose
    @ColumnInfo(name = "mp3Type")
    private String mp3Type;
    @SerializedName("mp3_title")
    @Expose
    @ColumnInfo(name = "mp3Title")
    private String mp3Title;
    @SerializedName("mp3_url")
    @Expose
    @ColumnInfo(name = "mp3Url")
    private String mp3Url;
    @SerializedName("mp3_thumbnail_b")
    @Expose
    @ColumnInfo(name = "mp3_thumbnail_s")
    private String mp3ThumbnailB;
    @SerializedName("mp3_thumbnail_s")
    @Expose
    @ColumnInfo(name = "mp3ThumbnailS")
    private String mp3ThumbnailS;
    @SerializedName("mp3_duration")
    @Expose
    @ColumnInfo(name = "mp3Duration")
    private String mp3Duration;
    @SerializedName("mp3_artist")
    @Expose
    @ColumnInfo(name = "mp3Artist")
    private String mp3Artist;
    @SerializedName("mp3_description")
    @Expose
    @ColumnInfo(name = "mp3Description")
    private String mp3Description;
    @SerializedName("total_rate")
    @Expose
    @ColumnInfo(name = "totalRate")
    private String totalRate;
    @SerializedName("rate_avg")
    @Expose
    @ColumnInfo(name = "rateAvg")
    private String rateAvg;
    @SerializedName("total_views")
    @Expose
    @ColumnInfo(name = "totalViews")
    private String totalViews;
    @SerializedName("total_download")
    @Expose
    @ColumnInfo(name = "totalDownload")
    private String totalDownload;
    @SerializedName("cid")
    @Expose
    @ColumnInfo(name = "cid")
    private String cid;
    @SerializedName("category_name")
    @Expose
    @ColumnInfo(name = "categoryName")
    private String categoryName;
    @SerializedName("category_image")
    @Expose
    @ColumnInfo(name = "categoryImage")
    private String categoryImage;
    @SerializedName("category_image_thumb")
    @Expose
    @ColumnInfo(name = "categoryImageThumb")
    private String categoryImageThumb;

    public Music() {
    }

    protected Music(Parcel in) {
        id = in.readString();
        catId = in.readString();
        mp3Type = in.readString();
        mp3Title = in.readString();
        mp3Url = in.readString();
        mp3ThumbnailB = in.readString();
        mp3ThumbnailS = in.readString();
        mp3Duration = in.readString();
        mp3Artist = in.readString();
        mp3Description = in.readString();
        totalRate = in.readString();
        rateAvg = in.readString();
        totalViews = in.readString();
        totalDownload = in.readString();
        cid = in.readString();
        categoryName = in.readString();
        categoryImage = in.readString();
        categoryImageThumb = in.readString();
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        @Override
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getMp3Type() {
        return mp3Type;
    }

    public void setMp3Type(String mp3Type) {
        this.mp3Type = mp3Type;
    }

    public String getMp3Title() {
        return mp3Title;
    }

    public void setMp3Title(String mp3Title) {
        this.mp3Title = mp3Title;
    }

    public String getMp3Url() {
        return mp3Url;
    }

    public void setMp3Url(String mp3Url) {
        this.mp3Url = mp3Url;
    }

    public String getMp3ThumbnailB() {
        return mp3ThumbnailB;
    }

    public void setMp3ThumbnailB(String mp3ThumbnailB) {
        this.mp3ThumbnailB = mp3ThumbnailB;
    }

    public String getMp3ThumbnailS() {
        return mp3ThumbnailS;
    }

    public void setMp3ThumbnailS(String mp3ThumbnailS) {
        this.mp3ThumbnailS = mp3ThumbnailS;
    }

    public String getMp3Duration() {
        return mp3Duration;
    }

    public void setMp3Duration(String mp3Duration) {
        this.mp3Duration = mp3Duration;
    }

    public String getMp3Artist() {
        return mp3Artist;
    }

    public void setMp3Artist(String mp3Artist) {
        this.mp3Artist = mp3Artist;
    }

    public String getMp3Description() {
        return mp3Description;
    }

    public void setMp3Description(String mp3Description) {
        this.mp3Description = mp3Description;
    }

    public String getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(String totalRate) {
        this.totalRate = totalRate;
    }

    public String getRateAvg() {
        return rateAvg;
    }

    public void setRateAvg(String rateAvg) {
        this.rateAvg = rateAvg;
    }

    public String getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(String totalViews) {
        this.totalViews = totalViews;
    }

    public String getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(String totalDownload) {
        this.totalDownload = totalDownload;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryImageThumb() {
        return categoryImageThumb;
    }

    public void setCategoryImageThumb(String categoryImageThumb) {
        this.categoryImageThumb = categoryImageThumb;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(catId);
        parcel.writeString(mp3Type);
        parcel.writeString(mp3Title);
        parcel.writeString(mp3Url);
        parcel.writeString(mp3ThumbnailB);
        parcel.writeString(mp3ThumbnailS);
        parcel.writeString(mp3Duration);
        parcel.writeString(mp3Artist);
        parcel.writeString(mp3Description);
        parcel.writeString(totalRate);
        parcel.writeString(rateAvg);
        parcel.writeString(totalViews);
        parcel.writeString(totalDownload);
        parcel.writeString(cid);
        parcel.writeString(categoryName);
        parcel.writeString(categoryImage);
        parcel.writeString(categoryImageThumb);
    }
}
