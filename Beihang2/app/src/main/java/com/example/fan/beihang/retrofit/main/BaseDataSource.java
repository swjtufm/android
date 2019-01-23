package com.example.fan.beihang.retrofit.main;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseDataSource {

    private int DEFAULT_TIMEOUT = 20;

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build();

    /**
     * 基础 Retrofit 网络请求库
     */


//    protected Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(Constants.URL).client(client)
////            .addConverterFactory(NobodyConverterFactory.create())
//            .addConverterFactory(ResponseConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build();

    protected Retrofit retrofit1 = new Retrofit.Builder()
            .baseUrl(Constants.URL_8070).client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();


}
