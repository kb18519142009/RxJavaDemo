package com.example.kangbaibai.rxjavatest.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by kangbaibai on 2018/6/5.
 */

public class RxJavaRange {
    private static final String TAG = "RxJavaRange";

    /**
     * range()
     * <p>
     * public static Observable<Integer> range(final int start, final int count)
     * <p>
     * 同时发送一定范围的事件序列。
     */
    public static void rangeObservable() {
        Observable.range(2, 5)
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

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
