package com.example.kangbaibai.rxjavatest.rxoperator.function;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by kangbaibai on 2018/6/8.
 */

public class RxJavaDoAfterNext {
    private static final String TAG = "RxJavaDoAfterNext";

    /**
     * doAfterNext()
     * <p>
     * public final Observable<T> doAfterNext(Consumer<? super T> onAfterNext)
     * <p>
     * Observable 每发送 onNext() 之后都会回调这个方法。
     */
    public static void doAfterNextObservable() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
//                emitter.onError(new NullPointerException());
                emitter.onComplete();
            }
        })
                .doAfterNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "--------------------doOnNext: " + integer);
                    }
                })
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
