package com.poli.studayroominterview.beans;

import com.google.gson.annotations.SerializedName;

public class OwnerDetails {

    @SerializedName("title")
    private String title;

    @SerializedName("profile_image")
    private String profileImage;

    public String getTitle() {
        return title;
    }

    public String getProfileImage() {
        return profileImage;
    }
}
