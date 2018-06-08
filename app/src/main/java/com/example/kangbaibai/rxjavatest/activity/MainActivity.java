package com.example.kangbaibai.rxjavatest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kangbaibai.rxjavatest.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_create_operator).setOnClickListener(this);
        findViewById(R.id.tv_transition_operator).setOnClickListener(this);
        findViewById(R.id.tv_combination_operator).setOnClickListener(this);
        findViewById(R.id.tv_function_operator).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_create_operator:
                startActivity(new Intent(this, CreateOperatorActivity.class));
                break;

            case R.id.tv_transition_operator:
                startActivity(new Intent(this, TransitionOperatorActivity.class));
                break;

            case R.id.tv_combination_operator:
                startActivity(new Intent(this, CombinationActivity.class));
                break;

            case R.id.tv_function_operator:
                startActivity(new Intent(this, FunctionActivity.class));
                break;

            default:
                break;
        }
    }
}
