package com.tu_qi.androiddemo.service;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tu_qi.androiddemo.R;

public class HelloActivity extends AppCompatActivity {
    Button mStartButton;
    Context mContex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        mContex = getApplicationContext();
        mStartButton = (Button)findViewById(R.id.start);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mContex, com.tu_qi.androiddemo.service.HelloService.class);
                mContex.startService(intent);
            }
        });
    }
}
