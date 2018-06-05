package com.example.kangbaibai.rxjavatest.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by kangbaibai on 2018/6/4.
 *
 * RxJava 有以下三个基本的元素：
 * 被观察者（Observable）
 * 观察者（Observer）
 * 订阅（subscribe）
 *
 * 事件种类	作用
 * onNext()	    发送该事件时，观察者会回调 onNext() 方法
 * onError()	发送该事件时，观察者会回调 onError() 方法，当发送该事件之后，其他事件将不会继续发送
 * onComplete()	发送该事件时，观察者会回调 onComplete() 方法，当发送该事件之后，其他事件将不会继续发送
 *
 * create()
 * 创建一个被观察者
 */

public class RxJavaCreate {
    private static final String TAG = "RxJavaCreate";

    /**
     * 普通调用
     */
    public static void createObservable() {
        //用create创建被观察者
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG, "--------------------被观察者的subscribe--------------------");
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
//                emitter.onError(new NullPointerException());
            }
        });

        //创建观察者
        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "观察者的onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "观察者的onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "观察者的onComplete");
            }
        };

        //订阅后会同时调用Observer（观察者）的onSubscribe和Observable（被观察者）的subscribe
        observable.subscribe(observer);
    }

    /**
     * 链式调用
     */
    public static void createObservableChain() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG, "--------------------被观察者的subscribe--------------------");
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
//                emitter.onError(new NullPointerException());
            }
        })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "观察者的onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "观察者的onError: " + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "观察者的onComplete");
                    }
                });
    }
}
