package com.poli.studayroominterview.beans;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ItemObject {

    @SerializedName("tags")
    private String[] tags;

    @SerializedName("owner")
    private OwnerDetails ownerDetails;

    @SerializedName("title")
    private String title;

    public String[] getTags() {
        return tags;
    }

    public String getTagstoStrings(){
        String tagString = "";
        if(tags != null && tags.length > 0){
            int i = 0;
            for(String tag : tags){
                tagString += "# "+tags[i++]+"  ";
            }
        }
        return tagString;
    }

    public OwnerDetails getOwnerDetails() {
        return ownerDetails;
    }

    public String getTitle() {
        return title;
    }

    public String getOwnerProfileImage() {
        String imageUrl = "";
        if(ownerDetails != null)
            imageUrl = ownerDetails.getProfileImage();
        return imageUrl;
    }

    public boolean isContainsTag(String tag){
        boolean isContains = false;
        if(tags != null && tag.length() > 0 && Arrays.asList(tags).contains(tag))
            isContains = true;

        return isContains;
    }

}
