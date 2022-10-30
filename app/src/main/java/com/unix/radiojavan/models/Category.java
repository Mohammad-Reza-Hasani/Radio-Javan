package com.unix.radiojavan.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category implements Parcelable {


    @SerializedName("cid")
    @Expose
    String cid;

    @SerializedName("category_name")
    @Expose
    String categoryName;

    @SerializedName("category_image")
    @Expose
    String categoryImage;

    @SerializedName("category_image_thumb")
    @Expose
    String categoryImageThumb;


    public Category() {
    }

    protected Category(Parcel in) {
        cid = in.readString();
        categoryName = in.readString();
        categoryImage = in.readString();
        categoryImageThumb = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cid);
        parcel.writeString(categoryName);
        parcel.writeString(categoryImage);
        parcel.writeString(categoryImageThumb);
    }
}
