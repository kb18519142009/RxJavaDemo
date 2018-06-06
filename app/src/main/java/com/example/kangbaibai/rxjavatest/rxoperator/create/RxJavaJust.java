package com.example.kangbaibai.rxjavatest.rxoperator.create;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by kangbaibai on 2018/6/4.
 * <p>
 * just()
 * 创建一个被观察者，并发送事件，发送的事件不可以超过10个以上
 */

public class RxJavaJust {
    private static final String TAG = "RxJavaJust";

    public static void justObservable() {
        Observable.just(1, 2, 3, 4)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------被观察者的subscribe--------------------");
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
                        Log.e(TAG, "观察者的onComplete: ");
                    }
                });
    }
}
