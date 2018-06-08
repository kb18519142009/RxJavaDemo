package com.example.kangbaibai.rxjavatest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kangbaibai.rxjavatest.R;

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
                break;

            default:
                break;
        }
    }
}
