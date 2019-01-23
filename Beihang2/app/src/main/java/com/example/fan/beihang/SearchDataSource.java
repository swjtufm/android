package com.example.fan.beihang;

import com.example.fan.beihang.retrofit.main.BaseDataSource;

import io.reactivex.Observable;

public class SearchDataSource extends BaseDataSource {

    SearchAPI service = retrofit1.create(SearchAPI.class);

    public Observable<JsonsRootBean> search(String keyword){
        return service.search(keyword,"abdd77e8-43a9-48e4-a709-4798a899bacb");
    }

}
