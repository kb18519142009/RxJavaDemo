package com.example.kangbaibai.rxjavatest.rxoperator.combination;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by kangbaibai on 2018/6/7.
 */

public class RxJavaMerge {
    private static final String TAG = "RxJavaMerge";

    /**
     * merge()
     * <p>
     * public static <T> Observable<T> merge(ObservableSource<? extends T> source1, ObservableSource<? extends T> source2, ObservableSource<? extends T> source3, ObservableSource<? extends T> source4)
     * <p>
     * 这个方法月 concat() 作用基本一样，知识 concat() 是串行发送事件，而 merge() 并行发送事件。
     */
    public static void mergeObservable() {
        Observable.merge/*concat*/( //可换作concat对比
                Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return "A-" + aLong;
                    }
                }),
                Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return "B-" + aLong;
                    }
                })
        ).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "--------------------onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * mergeArrayDelayError()
     * <p>
     * public static <T> Observable<T> mergeArrayDelayError(ObservableSource<? extends T>... sources)
     * <p>
     * 在 mergeArray()方法当中，如果其中有一个被观察者发送了一个 Error 事件，那么就会停止发送事件，
     * 如果你想 onError() 事件延迟到所有被观察者都发送完事件后再执行的话，就可以使用mergeArrayDelayError()
     */
    public static void mergeArrayDelayErrorObservable() {
        Observable.mergeArrayDelayError/*mergeArray*/( //可换作mergeArray进行对比
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        emitter.onNext(1);
                        emitter.onError(new NullPointerException());
                    }
                }), Observable.just(2, 3, 4)
        ).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

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

            }
        });
    }
}