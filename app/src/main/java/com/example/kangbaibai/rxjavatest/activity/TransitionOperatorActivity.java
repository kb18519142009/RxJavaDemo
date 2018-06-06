package com.example.kangbaibai.rxjavatest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kangbaibai.rxjavatest.R;
import com.example.kangbaibai.rxjavatest.rxoperator.transition.RxJavaMap;

public class TransitionOperatorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_operator);

        findViewById(R.id.tv_observable_map).setOnClickListener(this);

        findViewById(R.id.tv_observable_flatMap).setOnClickListener(this);

        findViewById(R.id.tv_observable_concatMap).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_observable_map:
                RxJavaMap.mapObservable();
                break;

            case R.id.tv_observable_flatMap:
                RxJavaMap.flatMapObservable();
                break;

            case R.id.tv_observable_concatMap:
                RxJavaMap.flatMapObservable();
                break;

            default:
                break;
        }
    }
}
