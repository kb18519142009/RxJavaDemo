package com.example.kangbaibai.rxjavatest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kangbaibai.rxjavatest.activity.CreateOperatorActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_create_operator).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_create_operator:
                startActivity(new Intent(this, CreateOperatorActivity.class));
                break;

            default:
                break;
        }
    }
}
