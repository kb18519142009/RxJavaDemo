package com.example.kangbaibai.rxjavatest.rxoperator.create;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by kangbaibai on 2018/6/4.
 */

public class RxJavaFrom {
    private static final String TAG = "RxJavaFrom";

    /**
     * fromArray()
     * <p>
     * public static <T> Observable<T> fromArray(T... items)
     * <p>
     * 这个方法和 just() 类似，只不过 fromArray 可以传入多于10个的变量，并且可以传入一个数组。
     */
    public static void fromArrayObservable() {
        Integer array[] = {1, 2, 3, 4};
        Observable.fromArray(array)
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

    /**
     * fromCallable()
     * <p>
     * public static <T> Observable<T> fromCallable(Callable<? extends T> supplier)
     * <p>
     * 这里的 Callable 是 java.util.concurrent 中的 Callable，Callable 和 Runnable 的用法基本一致，
     * 只是它会返回一个结果值，这个结果值就是发给观察者的。
     */
    public static void fromCallableObservable() {
        Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Log.e(TAG, "--------------------Callable运行--------------------");
                return 1;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "观察者的accept: " + integer);
            }
        });
    }

    /**
     * fromFuture()
     * <p>
     * public static <T> Observable<T> fromFuture(Future<? extends T> future)
     * <p>
     * 参数中的 Future 是 java.util.concurrent 中的 Future，Future 的作用是增加了 cancel() 等方法操作 Callable，
     * 它可以通过 get() 方法来获取 Callable 返回的值。
     */
    public static void fromFutureObservable() {
        final FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Log.e(TAG, "--------------------Callable运行--------------------");
                return "返回结果";
            }
        });
        Observable.fromFuture(futureTask)
                .doOnSubscribe(new Consumer<Disposable>() { //doOnSubscribe() 的作用就是只有订阅时才会发送事件
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        futureTask.run();
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, "观察者的accept: " + s);
                    }
                });
    }

    /**
     * fromIterable()
     * <p>
     * public static <T> Observable<T> fromIterable(Iterable<? extends T> source)
     * <p>
     * 直接发送一个 List 集合数据给观察者
     */
    public static void fromIterableObservable() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Observable.fromIterable(list)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "观察者的onNext：" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "观察者的onError：" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "观察者的onComplete：");
                    }
                });
    }
}
