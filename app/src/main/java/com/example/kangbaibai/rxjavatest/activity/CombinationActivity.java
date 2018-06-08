package com.example.kangbaibai.rxjavatest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kangbaibai.rxjavatest.R;
import com.example.kangbaibai.rxjavatest.rxoperator.combination.RxJavaCollect;
import com.example.kangbaibai.rxjavatest.rxoperator.combination.RxJavaCombineLatest;
import com.example.kangbaibai.rxjavatest.rxoperator.combination.RxJavaConcat;
import com.example.kangbaibai.rxjavatest.rxoperator.combination.RxJavaMerge;
import com.example.kangbaibai.rxjavatest.rxoperator.combination.RxJavaReduce;
import com.example.kangbaibai.rxjavatest.rxoperator.combination.RxJavaZip;

public class CombinationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination);

        findViewById(R.id.tv_observable_concat).setOnClickListener(this);
        findViewById(R.id.tv_observable_concatArray).setOnClickListener(this);
        findViewById(R.id.tv_observable_merge).setOnClickListener(this);
        findViewById(R.id.tv_observable_concatArrayDelayError).setOnClickListener(this);
        findViewById(R.id.tv_observable_mergeArrayDelayError).setOnClickListener(this);
        findViewById(R.id.tv_observable_zip).setOnClickListener(this);
        findViewById(R.id.tv_observable_combineLatest).setOnClickListener(this);
        findViewById(R.id.tv_observable_reduce).setOnClickListener(this);
        findViewById(R.id.tv_observable_collect).setOnClickListener(this);
        findViewById(R.id.tv_observable_startWith).setOnClickListener(this);
        findViewById(R.id.tv_observable_startWithArray).setOnClickListener(this);
        findViewById(R.id.tv_observable_count).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_observable_concat:
                RxJavaConcat.concatObservable();
                break;

            case R.id.tv_observable_concatArray:
                RxJavaConcat.concatArrayObservable();
                break;

            case R.id.tv_observable_merge:
                RxJavaMerge.mergeObservable();
                break;

            case R.id.tv_observable_concatArrayDelayError:
                RxJavaConcat.concatArrayDelayErrorObservable();
                break;

            case R.id.tv_observable_mergeArrayDelayError:
                RxJavaMerge.mergeArrayDelayErrorObservable();
                break;

            case R.id.tv_observable_zip:
                RxJavaZip.zipObservable();
                break;

            case R.id.tv_observable_combineLatest:
                RxJavaCombineLatest.combinelatestObservable();
                break;

            case R.id.tv_observable_reduce:
                RxJavaReduce.reduceObservable();
                break;

            case R.id.tv_observable_collect:
                RxJavaCollect.collectObservable();
                break;

            case R.id.tv_observable_startWith:
                RxJavaConcat.concatArrayObservable();
                break;

            case R.id.tv_observable_startWithArray:
                RxJavaConcat.concatArrayObservable();
                break;

            case R.id.tv_observable_count:
                RxJavaConcat.concatArrayObservable();
                break;

            default:
                break;
        }
    }
}
