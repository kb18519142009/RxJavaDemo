package com.example.kangbaibai.rxjavatest.rxoperator.function;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/**
 * Created by kangbaibai on 2018/6/8.
 */

public class RxJavaDoFinally {
    private static final String TAG = "RxJavaDoFinally";

    /**
     * doFinally()
     * <p>
     * public final Observable<T> doFinally(Action onFinally)
     * <p>
     * 在所有事件发送完毕之后回调该方法。
     * doFinally() 和 doAfterTerminate() 到底有什么区别？区别就是在于取消订阅，如果取消订阅之后
     * doAfterTerminate() 就不会被回调，而 doFinally() 无论怎么样都会被回调，且都会在事件序列的最后
     */
    public static void doFinally() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e(TAG, "--------------------doFinally");
                    }
                })
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e(TAG, "--------------------doOnDispose");
                    }
                })
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e(TAG, "--------------------doAfterTerminate");
                    }
                })
                .subscribe(new Observer<Integer>() {
                    private Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------onSubscribe");
                        disposable = d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "--------------------onNext: " + integer);
                        disposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "--------------------onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "--------------------onComplete");
                    }
                });
    }
}
