package com.example.kangbaibai.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.kangbaibai.rxjavatest.rx.RxJavaCreate;
import com.example.kangbaibai.rxjavatest.rx.RxJavaDefer;
import com.example.kangbaibai.rxjavatest.rx.RxJavaFrom;
import com.example.kangbaibai.rxjavatest.rx.RxJavaJust;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_observable_create;
    private TextView tv_observable_just;
    private TextView tv_observable_fromArray;
    private TextView tv_observable_fromCallable;
    private TextView tv_observable_fromFuture;
    private TextView tv_observable_fromIterable;
    private TextView tv_observable_defer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_observable_create = findViewById(R.id.tv_observable_create);
        tv_observable_create.setOnClickListener(this);

        tv_observable_just = findViewById(R.id.tv_observable_just);
        tv_observable_just.setOnClickListener(this);

        tv_observable_fromArray = findViewById(R.id.tv_observable_fromArray);
        tv_observable_fromArray.setOnClickListener(this);

        tv_observable_fromCallable = findViewById(R.id.tv_observable_fromCallable);
        tv_observable_fromCallable.setOnClickListener(this);

        tv_observable_fromFuture = findViewById(R.id.tv_observable_fromFuture);
        tv_observable_fromFuture.setOnClickListener(this);

        tv_observable_fromIterable = findViewById(R.id.tv_observable_fromIterable);
        tv_observable_fromIterable.setOnClickListener(this);

        tv_observable_defer = findViewById(R.id.tv_observable_defer);
        tv_observable_defer.setOnClickListener(this);
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

            default:
                break;
        }
    }
}
