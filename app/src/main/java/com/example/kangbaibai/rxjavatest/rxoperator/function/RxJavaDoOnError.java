package com.example.kangbaibai.rxjavatest.rxoperator.function;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by kangbaibai on 2018/6/8.
 */

public class RxJavaDoOnError {
    private static final String TAG = "RxJavaDoOnError";

    /**
     * doOnError()
     * <p>
     * public final Observable<T> doOnError(Consumer<? super Throwable> onError)
     * <p>
     * Observable 每发送 onError() 之前都会回调这个方法。
     */
    public static void doOnErrorObservable() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "--------------------doOnError: " + throwable);
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------subscribe--------------------");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "--------------------onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "--------------------onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "--------------------onComplete");
                    }
                });
    }
}
