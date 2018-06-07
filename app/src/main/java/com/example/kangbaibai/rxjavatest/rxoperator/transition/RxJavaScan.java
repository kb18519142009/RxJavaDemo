package com.example.kangbaibai.rxjavatest.rxoperator.transition;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * Created by kangbaibai on 2018/6/7.
 * scan()
 * <p>
 * public final Observable<T> scan(BiFunction<T, T, T> accumulator)
 * <p>
 * 将数据以一定的逻辑聚合起来。
 */

public class RxJavaScan {
    private static final String TAG = "RxJavaScan";

    public static void scanObservable() {
        Observable.just(1, 2, 3, 4, 5)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        Log.e(TAG, "--------------------apply--------------------");
                        Log.e(TAG, "--------------------apply---integer: " + integer);
                        Log.e(TAG, "--------------------apply---integer2: " + integer2);
                        return integer + integer2;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "--------------------accept---integer: " + integer);
                    }
                });
    }
}
