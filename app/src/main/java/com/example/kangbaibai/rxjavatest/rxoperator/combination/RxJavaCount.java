package com.example.kangbaibai.rxjavatest.rxoperator.combination;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by kangbaibai on 2018/6/8.
 */

public class RxJavaCount {
    private static final String TAG = "RxJavaCount";

    /**
     * count()
     * <p>
     * public final Single<Long> count()
     * <p>
     * 返回被观察者发送事件的数量。
     */
    public static void countObservable() {
        Observable.just(1, 2, 3, 4)
                .count()
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "--------------------accept " + aLong);
                    }
                });
    }
}
