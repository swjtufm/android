package com.example.fan.beihang;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.fan.beihang.retrofit.main.Constants;
import com.example.fan.beihang.retrofit.util.BaseObserver;
import com.example.fan.beihang.retrofit.util.ExceptionHandle;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenterImpl implements SearchPresenter{

    private String TAG = "SearchPresenterImpl";
    private Context context;
    private SearchDataSource dataSource;
    private MainView mainView;

    public SearchPresenterImpl(Context context,MainView mainView) {
        this.context = context;

        this.mainView = mainView;
    }

    @Override
    public void searh(String keyword) {
        dataSource = new SearchDataSource();
        dataSource.search(keyword).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).
        subscribe(new BaseObserver<JsonsRootBean>(context) {
            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(JsonsRootBean jsonsRootBean) {
                Log.e(TAG,"onNext");
                //Toast.makeText(context,jsonsRootBean.toString(),Toast.LENGTH_SHORT).show();
                mainView.searchList(jsonsRootBean);
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
                super.onComplete();
            }

            @Override
            public void onError(ExceptionHandle.ResponeThrowable throwable) {
                Log.e(TAG,"onError");
            }
        });
    }
}
