package com.example.slavick.engeneeringidea;


import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

public class Retrofit {
    public static final String ENDPOINT = "http://www.mocky.io";
    private static ApiInterface apiInterface;
    static {
        initialize();
    }
    interface ApiInterface{
        @GET("/v2/59c92a123f0000780183f72d")
        void getUsers(Callback<List<User>> callback);

        @GET("/v2/59c92a123f0000780183f72d")
        void getWrongUsers(Callback<List<WrongUser>> callback);
    }
    public static void initialize(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        apiInterface = restAdapter.create(ApiInterface.class);
    }

    public static void getUsers(Callback<List<User>> callback){
        apiInterface.getUsers(callback);
    }

    public static void getWrongUsers(Callback<List<WrongUser>> callback) {apiInterface.getWrongUsers(callback);}

}
