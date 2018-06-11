package com.example.kangbaibai.rxjavatest.rxoperator.function;

import android.util.Log;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by kangbaibai on 2018/6/8.
 */

public class RxJavaDoOnEach {
    private static final String TAG = "RxJavaDoEach";

    /**
     * doOnEach()
     * <p>
     * public final Observable<T> doOnEach(final Consumer<? super Notification<T>> onNotification)
     * <p>
     * Observable 每发送一件事件(包括onNext、onError、onComplete)之前都会先回调这个方法。并且可以取出 onNext() 发送的值。
     */
    public static void doOnEachObservable() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
//                emitter.onError(new NullPointerException());
                emitter.onComplete();
            }
        })
                .doOnEach(new Consumer<Notification<Integer>>() {
                    @Override
                    public void accept(Notification<Integer> integerNotification) throws Exception {
                        Log.e(TAG, "--------------------doOnEach: " + integerNotification.getValue());
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
