package com.example.kangbaibai.rxjavatest.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by kangbaibai on 2018/6/6.
 */

public class RxJavaEmpty {
    private static final String TAG = "RxJavaEmpty";

    public static void emptyObservable() {
        Observable.empty().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
            }

            @Override
            public void onNext(Object o) {
                Log.e(TAG, "--------------------onNext--------------------");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "--------------------onError--------------------" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "--------------------onComplete--------------------");
            }
        });
    }

    public static void neverObservable() {
        Observable.never().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
            }

            @Override
            public void onNext(Object o) {
                Log.e(TAG, "--------------------onNext--------------------");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "--------------------onError--------------------" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "--------------------onComplete--------------------");
            }
        });
    }


    public static void errorObservable() {
        Observable.error(new NullPointerException()).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
            }

            @Override
            public void onNext(Object o) {
                Log.e(TAG, "--------------------onNext--------------------");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "--------------------onError--------------------" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "--------------------onComplete--------------------");
            }
        });
    }
}
