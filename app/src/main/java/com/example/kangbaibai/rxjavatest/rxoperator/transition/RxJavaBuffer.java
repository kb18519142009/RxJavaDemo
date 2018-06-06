package com.example.kangbaibai.rxjavatest.rxoperator.transition;

import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by kangbaibai on 2018/6/6.
 */

public class RxJavaBuffer {
    private static final String TAG = "RxJavaBuffer";

    /**
     * buffer()
     * <p>
     * public final Observable<List<T>> buffer(int count, int skip)
     * <p>
     * 从需要发送的事件当中获取一定数量的事件，并将这些事件放到缓冲区当中一并发出。
     * buffer 有两个参数，一个是 count，另一个 skip。count 缓冲区元素的数量，skip 就代表缓冲区满了之后，发送下一次事件序列的时候要跳过多少元素
     * 每次发送事件，指针都会往后移动一个元素再取值，直到指针移动到没有元素的时候就会停止取值
     */
    public static void bufferObservable() {
        Observable.just(1, 2, 3, 4, 5)
                .buffer(2, 1)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        Log.e(TAG, "观察者的onNext " + integers);
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
