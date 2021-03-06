package com.example.kangbaibai.rxjavatest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kangbaibai.rxjavatest.R;
import com.example.kangbaibai.rxjavatest.rxoperator.create.RxJavaCreate;
import com.example.kangbaibai.rxjavatest.rxoperator.create.RxJavaDefer;
import com.example.kangbaibai.rxjavatest.rxoperator.create.RxJavaEmpty;
import com.example.kangbaibai.rxjavatest.rxoperator.create.RxJavaFrom;
import com.example.kangbaibai.rxjavatest.rxoperator.create.RxJavaInterval;
import com.example.kangbaibai.rxjavatest.rxoperator.create.RxJavaJust;
import com.example.kangbaibai.rxjavatest.rxoperator.create.RxJavaRange;
import com.example.kangbaibai.rxjavatest.rxoperator.create.RxJavaTimer;

public class CreateOperatorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_operator);

        findViewById(R.id.tv_observable_create).setOnClickListener(this);

        findViewById(R.id.tv_observable_just).setOnClickListener(this);

        findViewById(R.id.tv_observable_fromArray).setOnClickListener(this);

        findViewById(R.id.tv_observable_fromCallable).setOnClickListener(this);

        findViewById(R.id.tv_observable_fromFuture).setOnClickListener(this);

        findViewById(R.id.tv_observable_fromIterable).setOnClickListener(this);

        findViewById(R.id.tv_observable_defer).setOnClickListener(this);

        findViewById(R.id.tv_observable_timer).setOnClickListener(this);

        findViewById(R.id.tv_observable_interval).setOnClickListener(this);

        findViewById(R.id.tv_observable_intervalRange).setOnClickListener(this);

        findViewById(R.id.tv_observable_range).setOnClickListener(this);

        findViewById(R.id.tv_observable_rangeLong).setOnClickListener(this);

        findViewById(R.id.tv_observable_empty).setOnClickListener(this);

        findViewById(R.id.tv_observable_never).setOnClickListener(this);

        findViewById(R.id.tv_observable_error).setOnClickListener(this);
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

            case R.id.tv_observable_interval:
                RxJavaInterval.intervalObservable();
                break;

            case R.id.tv_observable_intervalRange:
                RxJavaInterval.intervalRangeObservable();
                break;

            case R.id.tv_observable_range:
                RxJavaRange.rangeObservable();
                break;

            case R.id.tv_observable_rangeLong:
                RxJavaRange.rangeLongObservable();
                break;

            case R.id.tv_observable_empty:
                RxJavaEmpty.emptyObservable();
                break;

            case R.id.tv_observable_never:
                RxJavaEmpty.neverObservable();
                break;

            case R.id.tv_observable_error:
                RxJavaEmpty.errorObservable();
                break;

            default:
                break;
        }
    }
}
