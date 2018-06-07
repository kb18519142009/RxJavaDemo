package com.example.kangbaibai.rxjavatest.rxoperator.combination;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * Created by kangbaibai on 2018/6/7.
 */

public class RxJavaReduce {
    private static final String TAG = "RxJavaReduce";

    /**
     * reduce()
     * <p>
     * public final Maybe<T> reduce(BiFunction<T, T, T> reducer)
     * <p>
     * 与 scan() 操作符的作用也是将发送数据以一定逻辑聚合起来，这两个的区别在于 scan() 每处理一次数据就会将事件发送给观察者，
     * 而 reduce() 会将所有数据聚合在一起才会发送事件给观察者。
     * 前两个数据聚合后，再与下一个数据聚合，直到没有数据，最终发生给观察者
     */
    public static void reduceObservable() {
        Observable.just(0, 1, 2, 3)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        int res = integer + integer2;
                        Log.e(TAG, "--------------------integer " + integer);
                        Log.e(TAG, "--------------------integer2 " + integer2);
                        Log.e(TAG, "--------------------res " + res);

                        return res;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "--------------------accept " + integer);
                    }
                });
    }
}
