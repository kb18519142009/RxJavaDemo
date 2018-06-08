package com.example.kangbaibai.rxjavatest.rxoperator.combination;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by kangbaibai on 2018/6/8.
 */

public class RxJavaStartWith {
    private static final String TAG = "RxJavaStartWith";

    /**
     * startWith()
     * <p>
     * public final Observable<T> startWith(T item)
     * <p>
     * 在发送事件之前追加事件，startWith() 追加一个事件，追加的事件会先发出
     */
    public static void startWithObservable() {
        Observable.just(2, 3, 4)
                .startWith(1)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "--------------------accept " + integer);
                    }
                });
    }

    /**
     * startWithArray()
     * <p>
     * public final Observable<T> startWithArray(T... items)
     * <p>
     * 在发送事件之前追加事件，startWithArray() 可以追加多个事件。追加的事件会先发出
     */
    public static void startWithArrayObservable() {
        Observable.just(4, 5, 6)
                .startWithArray(1, 2, 3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "--------------------accept " + integer);
                    }
                });
    }
}
