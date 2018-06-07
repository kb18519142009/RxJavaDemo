package com.example.kangbaibai.rxjavatest.rxoperator.transition;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by kangbaibai on 2018/6/7.
 * window()
 * <p>
 * public final Observable<Observable<T>> window(long count)
 * <p>
 * 发送指定数量的事件时，就将这些事件分为一组。window 中的 count 的参数就是代表指定的数量，
 * 例如将 count 指定为2，那么每发2个数据就会将这2个数据分成一组。
 */

public class RxJavaWindow {
    private static final String TAG = "RxJavaWindow";

    public static void windowObservable() {
        Observable.just(1, 2, 3, 4, 5)
                .window(2)
                .subscribe(new Observer<Observable<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------onSubscribe--------------------");
                    }

                    @Override
                    public void onNext(Observable<Integer> integerObservable) {
                        Log.e(TAG, "--------------------onNext--------------------");
                        integerObservable.subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.e(TAG, "--------------------integerObservable-->onSubscribe");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.e(TAG, "--------------------integerObservable-->onNext：" + integer);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "--------------------integerObservable-->onError");
                            }

                            @Override
                            public void onComplete() {
                                Log.e(TAG, "--------------------integerObservable-->onComplete");
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "--------------------onError--------------------");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "--------------------onComplete--------------------");
                    }
                });
    }
}
