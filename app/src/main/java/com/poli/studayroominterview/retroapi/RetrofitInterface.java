package com.poli.studayroominterview.retroapi;

import com.poli.studayroominterview.beans.BaseObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("/2.2/search?order=desc&sort=activity&intitle=perl&site=stackoverflow")
    Call<BaseObject> getBaseObject();

}
