package com.example.kangbaibai.rxjavatest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kangbaibai.rxjavatest.R;
import com.example.kangbaibai.rxjavatest.rxoperator.function.RxJavaDelay;
import com.example.kangbaibai.rxjavatest.rxoperator.function.RxJavaDoAfterNext;
import com.example.kangbaibai.rxjavatest.rxoperator.function.RxJavaDoFinally;
import com.example.kangbaibai.rxjavatest.rxoperator.function.RxJavaDoOnComplete;
import com.example.kangbaibai.rxjavatest.rxoperator.function.RxJavaDoOnDispose;
import com.example.kangbaibai.rxjavatest.rxoperator.function.RxJavaDoOnEach;
import com.example.kangbaibai.rxjavatest.rxoperator.function.RxJavaDoOnError;
import com.example.kangbaibai.rxjavatest.rxoperator.function.RxJavaDoOnLifecycle;
import com.example.kangbaibai.rxjavatest.rxoperator.function.RxJavaDoOnNext;
import com.example.kangbaibai.rxjavatest.rxoperator.function.RxJavaDoOnSubscribe;
import com.example.kangbaibai.rxjavatest.rxoperator.function.RxJavaDoOnTerminate;

public class FunctionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        findViewById(R.id.tv_observable_delay).setOnClickListener(this);

        findViewById(R.id.tv_observable_doOnEach).setOnClickListener(this);

        findViewById(R.id.tv_observable_doOnNext).setOnClickListener(this);

        findViewById(R.id.tv_observable_doAfterNext).setOnClickListener(this);

        findViewById(R.id.tv_observable_doOnComplete).setOnClickListener(this);

        findViewById(R.id.tv_observable_doOnError).setOnClickListener(this);

        findViewById(R.id.tv_observable_doOnSubscribe).setOnClickListener(this);

        findViewById(R.id.tv_observable_doOnDispose).setOnClickListener(this);

        findViewById(R.id.tv_observable_doOnLifecycle).setOnClickListener(this);

        findViewById(R.id.tv_observable_doOnTerminate).setOnClickListener(this);

        findViewById(R.id.tv_observable_doAfterTerminate).setOnClickListener(this);

        findViewById(R.id.tv_observable_doFinally).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_observable_delay:
                RxJavaDelay.delayObservable();
                break;

            case R.id.tv_observable_doOnEach:
                RxJavaDoOnEach.doOnEachObservable();
                break;

            case R.id.tv_observable_doOnNext:
                RxJavaDoOnNext.doOnNextObservable();
                break;

            case R.id.tv_observable_doAfterNext:
                RxJavaDoAfterNext.doAfterNextObservable();
                break;

            case R.id.tv_observable_doOnComplete:
                RxJavaDoOnComplete.doOnCompleteObservable();
                break;

            case R.id.tv_observable_doOnError:
                RxJavaDoOnError.doOnErrorObservable();
                break;

            case R.id.tv_observable_doOnSubscribe:
                RxJavaDoOnSubscribe.doOnSubscribeObservable();
                break;

            case R.id.tv_observable_doOnDispose:
                RxJavaDoOnDispose.doOnDispose();
                break;

            case R.id.tv_observable_doOnLifecycle:
                RxJavaDoOnLifecycle.doOnLifecycleObservable();
                break;

            case R.id.tv_observable_doOnTerminate:
                RxJavaDoOnTerminate.doOnTerminateObservable();
                break;

            case R.id.tv_observable_doAfterTerminate:
                RxJavaDoOnTerminate.doAfterTerminateObservable();
                break;

            case R.id.tv_observable_doFinally:
                RxJavaDoFinally.doFinally();
                break;

            default:
                break;
        }
    }
}
