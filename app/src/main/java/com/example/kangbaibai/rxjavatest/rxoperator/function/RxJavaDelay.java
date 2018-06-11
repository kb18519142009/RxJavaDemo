package com.example.kangbaibai.rxjavatest.rxoperator.function;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by kangbaibai on 2018/6/8.
 */

public class RxJavaDelay {
    private static final String TAG = "RxJavaDelay";

    /**
     * delay()
     * <p>
     * public final Observable<T> delay(long delay, TimeUnit unit)
     * <p>
     * 延迟一段时间发送事件。
     */
    public static void delayObservable() {
        Observable.just(1, 2, 3)
                .delay(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------subscribe--------------------");
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
                        Log.e(TAG, "--------------------onComplete");
                    }
                });
    }
}
