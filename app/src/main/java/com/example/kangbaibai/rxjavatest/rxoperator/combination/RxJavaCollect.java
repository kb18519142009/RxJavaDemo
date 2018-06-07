package com.example.kangbaibai.rxjavatest.rxoperator.combination;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

/**
 * Created by kangbaibai on 2018/6/7.
 */

public class RxJavaCollect {
    private static final String TAG = "RxJavaCollect";

    /**
     * collect()
     *
     * public final <U> Single<U> collect(Callable<? extends U> initialValueSupplier, BiConsumer<? super U, ? super T> collector)
     *
     * 将数据收集到数据结构当中。
     */
    public static void collectObservable(){
        Observable.just(1, 2, 3, 4)
                .collect(new Callable<ArrayList< Integer >>() {
                             @Override
                             public ArrayList < Integer > call() throws Exception {
                                 return new ArrayList < > ();
                             }
                         },
                        new BiConsumer< ArrayList < Integer > , Integer >() {
                            @Override
                            public void accept(ArrayList < Integer > integers, Integer integer) throws Exception {
                                integers.add(integer);
                            }
                        })
                .subscribe(new Consumer< ArrayList < Integer >>() {
                    @Override
                    public void accept(ArrayList < Integer > integers) throws Exception {
                        Log.e(TAG, "--------------------accept " + integers);
                    }
                });
    }
}
