package com.poli.studayroominterview.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemObject {

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName("owner")
    private OwnerDetails ownerDetails;

    @SerializedName("title")
    private String title;

    public List<String> getTags() {
        return tags;
    }

    public String getTagstoStrings(){
        String tagString = "";
        if(tags != null && tags.size() > 0){
            int i = 0;
            for(String tag : tags){
                tagString += "# "+tag+"  ";
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

    public boolean isContainsTag(String str){
        boolean isContains = false;
        if(tags != null && str != null) {
            for(String tag : tags){
                if(tag.contains(str)){
                    isContains = true;
                    break;
                }
            }
        }
        return isContains;
    }
}
