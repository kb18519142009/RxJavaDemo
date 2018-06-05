package com.example.kangbaibai.rxjavatest.rx;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by kangbaibai on 2018/6/5.
 */

public class RxJavaInterval {
    private static final String TAG = "RxJavaInterval";

    /**
     * * interval()
     * <p>
     * public static Observable<Long> interval(long period, TimeUnit unit)
     * public static Observable<Long> interval(long initialDelay, long period, TimeUnit unit)
     * <p>
     * 每隔一段时间就会发送一个事件，这个事件是从0开始，不断增1的数字。
     * interval() 第三个 initialDelay 参数，这个参数的意思就是 onSubscribe 回调之后，再次回调 onNext 的间隔时间。
     */
    public static void intervalObservable() {
        Observable.interval(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e(TAG, "intervalObservable()-------------观察者的onNext: " + aLong);
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
     * intervalRange()
     *
     * public static Observable<Long> intervalRange(long start, long count, long initialDelay, long period, TimeUnit unit)
     * public static Observable<Long> intervalRange(long start, long count, long initialDelay, long period, TimeUnit unit, Scheduler scheduler)
     *
     * 可以指定发送事件的开始值和数量，其他与 interval() 的功能一样。
     */
    public static void intervalRangeObservable() {
        Observable.intervalRange(2,5,1,1,TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e(TAG, "intervalRangeObservable()-----------观察者的onNext: " + aLong);
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
