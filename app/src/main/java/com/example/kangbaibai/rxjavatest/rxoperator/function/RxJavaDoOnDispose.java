package com.example.kangbaibai.rxjavatest.rxoperator.function;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/**
 * Created by kangbaibai on 2018/6/8.
 */

public class RxJavaDoOnDispose {
    private static final String TAG = "RxJavaDoOnDispose";

    /**
     * doOnDispose()
     * <p>
     * public final Observable<T> doOnDispose(Action onDispose)
     * <p>
     * 当调用 Disposable 的 dispose() 之后回调该方法。
     */
    public static void doOnDispose() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        })
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e(TAG, "--------------------doOnDispose");
                    }
                })
                .subscribe(new Observer<Integer>() {
                    private Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------subscribe--------------------");
                        disposable = d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "--------------------onNext: " + integer);
                        disposable.dispose();
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
