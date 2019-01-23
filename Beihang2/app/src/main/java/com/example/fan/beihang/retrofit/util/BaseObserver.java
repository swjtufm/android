package com.example.fan.beihang.retrofit.util;

import android.content.Context;



import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;



public abstract class BaseObserver<T> implements Observer<T> {

    private Context context;
    private boolean isNeedCahe;

    public BaseObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        // todo some common as show loadding  and check netWork is NetworkAvailable

        // if  NetworkAvailable no !   must to call onCompleted
        if (!NetworkUtil.isNetworkAvailable(context)) {
//            Toast.makeText(context, "无网络，读取缓存数据", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onComplete() {
//        Toast.makeText(context, "http is Complete", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(Throwable throwable) {

//        Log.e("Tamic", throwable.getMessage());
        // todo error somthing
//            Toast.makeText(context,"加载失败",Toast.LENGTH_SHORT).show();
        if(throwable instanceof Exception){
            onError((ExceptionHandle.handleException(throwable)));
        } else {
            onError(new ExceptionHandle.ResponeThrowable(throwable, ExceptionHandle.ERROR.UNKNOWN));
        }
    }




    public abstract void onError(ExceptionHandle.ResponeThrowable e);


}
