package com.poli.studayroominterview.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BaseObject {
    @SerializedName("items")
    private List<ItemObject> mItemObjects;

    public List<ItemObject> getItemObjects() {
        return mItemObjects;
    }

    public ArrayList<ItemObject> getItemObjects(String tag) {
        ArrayList<ItemObject> itemObjectsList = new ArrayList<>();

        for(ItemObject itemObject : mItemObjects)
        {
            if(itemObject.isContainsTag(tag)){
                itemObjectsList.add(itemObject);
            }
        }
        return itemObjectsList;
    }
}
