package com.poli.studayroominterview.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseObject {
    @SerializedName("items")
    private ItemObject[] mItemObjects;

    public ItemObject[] getItemObjects() {
        return mItemObjects;
    }

    public ItemObject[] getItemObjects(String tag) {
        ArrayList<ItemObject> itemObjectsList = new ArrayList<>();

        for(int i =0; i< mItemObjects.length; i++)
        {
            if(mItemObjects[i].isContainsTag(tag)){
                itemObjectsList.add(mItemObjects[i++]);
            }
        }

        ItemObject[] itemObjectsArray = new ItemObject[itemObjectsList.size()];
        return itemObjectsList.toArray(itemObjectsArray);
    }
}
