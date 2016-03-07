package com.tu_qi.androiddemo.service;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tu_qi.androiddemo.R;

public class IntentServiceTestActivity extends AppCompatActivity {
    Handler mAddHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            IntentServiceTestService.startActionAdd(getApplicationContext(), 10, 10);
            return true;
        }
    });

    Handler mMinusHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            IntentServiceTestService.startActionMinus(getApplicationContext(), 2, -10);
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service_test);
        mAddHandler.sendEmptyMessageDelayed(0, 1000);
        mMinusHandler.sendEmptyMessageDelayed(0, 1500);
    }

}
