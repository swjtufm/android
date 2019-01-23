package com.example.fan.beihang;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SearchAPI {

   //请求的Action，类似于方法名
    @GET("/v1/profiles")//请求的地址

    io.reactivex.Observable<JsonsRootBean> search(@Query("keyword") String keyword,@Header("token") String token);


}
