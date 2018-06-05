package com.example.kangbaibai.rxjavatest.rx;

import android.util.Log;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by kangbaibai on 2018/6/4.
 * defer()
 * <p>
 * public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> supplier)
 * <p>
 * 这个方法的作用就是直到被观察者被订阅后才会创建被观察者。
 */

public class RxJavaDefer {
    private static final String TAG = "RxJavaDefer";
    private static Integer integer = 100;

    public static void deferObservable() {
        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(integer);
            }
        });
        integer = 200;
        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "观察者的onNext：" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "观察者的onError：" + e);
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "观察者的onComplete：");
            }
        };
        observable.subscribe(observer);
        integer = 300;
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "观察者的onNext：" + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
