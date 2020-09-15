package com.poli.studayroominterview.ui;

import android.util.Log;

import com.poli.studayroominterview.beans.BaseObject;
import com.poli.studayroominterview.beans.ItemObject;
import com.poli.studayroominterview.retroapi.ApiUtil;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class ActivityModel extends ViewModel {

    private final String LOG_TAG = ActivityModel.class.getSimpleName();
    private MutableLiveData<ItemObject[]> mItemObjectArrayLiveData;
    private BaseObject mBaseObject;

    public ActivityModel(){
        mItemObjectArrayLiveData = new MutableLiveData<>();
        requestServerData();
    }

    public MutableLiveData<ItemObject[]> getItemObjectArrayLiveData() {
        return mItemObjectArrayLiveData;
    }

    public void requestServerData(){
        ApiUtil.getServiceClass().getBaseObject().enqueue(new Callback<BaseObject>() {
            @Override
            @EverythingIsNonNull
            public void onResponse(Call<BaseObject> call, Response<BaseObject> response) {
                Log.i(LOG_TAG," onResponse ==========>  "+response.isSuccessful());
                if(response.isSuccessful()){
                        mBaseObject = response.body();
                        if(mBaseObject != null)
                            mItemObjectArrayLiveData.postValue(mBaseObject.getItemObjects());
                }
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<BaseObject> call, Throwable t) {
                Log.e(LOG_TAG,"  ----> onFailure  Response Failed :: "+t);
            }
        });
    }

    public void updateDataWithTag(String tag) {
        if(mBaseObject == null)
            return;
        Log.d(LOG_TAG,"updateDataWithTag==========> "+tag+".");
        mItemObjectArrayLiveData.postValue(mBaseObject.getItemObjects(tag));
    }
}
