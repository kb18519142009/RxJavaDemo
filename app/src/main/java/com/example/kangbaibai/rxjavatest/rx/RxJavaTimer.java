package com.example.kangbaibai.rxjavatest.rx;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by kangbaibai on 2018/6/5.
 * <p>
 * timer()
 * <p>
 * public static Observable<Long> timer(long delay, TimeUnit unit)
 * <p>
 * 当到指定时间后就会发送一个 0L 的值给观察者。
 */

public class RxJavaTimer {
    private static final String TAG = "RxJavaTimer";

    public static void timerObservable() {
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e(TAG, "观察者的onNext: " + aLong);
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
