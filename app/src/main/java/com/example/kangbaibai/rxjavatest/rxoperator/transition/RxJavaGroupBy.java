package com.example.kangbaibai.rxjavatest.rxoperator.transition;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

/**
 * Created by kangbaibai on 2018/6/6.
 */

public class RxJavaGroupBy {
    private static final String TAG = "RxJavaGroupBy";

    /**
     * groupBy()
     * <p>
     * public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> keySelector)
     * <p>
     * 将发送的数据进行分组，每个分组都会返回一个被观察者
     * 在 groupBy() 方法返回的参数是分组的名字，每返回一个值，那就代表会创建一个组
     */
    public static void groupByObservable() {
        Observable.just(9, 3, 8, 4, 10, 6, 2, 5, 7, 1)
                .groupBy(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer % 3;
                    }
                })
                .subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
                    }

                    @Override
                    public void onNext(final GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
                        Log.e(TAG, "观察者的onNext--------------------");
                        integerIntegerGroupedObservable.subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.e(TAG, "--------------------GroupedObservable观察者的onSubscribe--------------------");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.e(TAG, "GroupedObservable观察者的onNext groupName: " + integerIntegerGroupedObservable.getKey() + " --> value: " + integer);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "GroupedObservable观察者的onError--------------------" + e.toString());
                            }

                            @Override
                            public void onComplete() {
                                Log.e(TAG, "GroupedObservable观察者的onComplete--------------------");
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "观察者的onError--------------------" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "观察者的onComplete--------------------");
                    }
                });
    }
}
