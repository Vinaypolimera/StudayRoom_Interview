package com.poli.studayroominterview.retroapi;

public class ApiUtil {
    /**
     * Use the BASE_URL when goes to production
     */
    private static final String BASE_URL = "https://api.stackexchange.com/";


    public static RetrofitInterface getServiceClass(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitInterface.class);
    }
}