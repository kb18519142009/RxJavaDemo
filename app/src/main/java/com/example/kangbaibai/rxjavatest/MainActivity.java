package com.example.kangbaibai.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kangbaibai.rxjavatest.rx.RxJavaCreate;
import com.example.kangbaibai.rxjavatest.rx.RxJavaDefer;
import com.example.kangbaibai.rxjavatest.rx.RxJavaFrom;
import com.example.kangbaibai.rxjavatest.rx.RxJavaJust;
import com.example.kangbaibai.rxjavatest.rx.RxJavaTimer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_observable_create).setOnClickListener(this);

        findViewById(R.id.tv_observable_just).setOnClickListener(this);

        findViewById(R.id.tv_observable_fromArray).setOnClickListener(this);

        findViewById(R.id.tv_observable_fromCallable).setOnClickListener(this);

        findViewById(R.id.tv_observable_fromFuture).setOnClickListener(this);

        findViewById(R.id.tv_observable_fromIterable).setOnClickListener(this);

        findViewById(R.id.tv_observable_defer).setOnClickListener(this);

        findViewById(R.id.tv_observable_timer).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_observable_create:
                RxJavaCreate.createObservable();
                break;

            case R.id.tv_observable_just:
                RxJavaJust.justObservable();
                break;

            case R.id.tv_observable_fromArray:
                RxJavaFrom.fromArrayObservable();
                break;

            case R.id.tv_observable_fromCallable:
                RxJavaFrom.fromCallableObservable();
                break;

            case R.id.tv_observable_fromFuture:
                RxJavaFrom.fromFutureObservable();
                break;

            case R.id.tv_observable_fromIterable:
                RxJavaFrom.fromIterableObservable();
                break;

            case R.id.tv_observable_defer:
                RxJavaDefer.deferObservable();
                break;

            case R.id.tv_observable_timer:
                RxJavaTimer.timerObservable();
                break;

            default:
                break;
        }
    }
}
