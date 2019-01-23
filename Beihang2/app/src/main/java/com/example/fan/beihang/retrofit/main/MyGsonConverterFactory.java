package com.example.fan.beihang.retrofit.main;


import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;

import java.io.EOFException;
import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 *
 *
 * 自定义Gson响应体变换器
 *  code = 200 时正常解析，code ！= 200 时 抛出ResultException
 * @param <T>
 */

public class MyGsonConverterFactory <T> implements Converter<ResponseBody,T> {

    private String TAG = "MyGsonConverterFactory";
    private Gson gson;
    private final TypeAdapter<T> adapter;

    public MyGsonConverterFactory(Gson gson,TypeAdapter<T> adapter){
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {



        JsonReader jsonReader = gson.newJsonReader(value.charStream());
        try {
            return adapter.read(jsonReader);
        } catch (EOFException e){
            return null;
        }
        catch (MalformedJsonException exception){
            return null;
        }
        finally {
            value.close();
        }
    }
}
