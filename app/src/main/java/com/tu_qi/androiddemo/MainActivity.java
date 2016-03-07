package com.tu_qi.androiddemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private Context mContext;
    private  String[] activitys = {"Intent Service  Test"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.activity_main_list, activitys);
        mListView = (ListView)findViewById(R.id.listView);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                switch (position){
                    case 0:
                        intent.setClass(mContext,
                                com.tu_qi.androiddemo.service.IntentServiceTestActivity.class);
                        startActivity(intent);
                        break;
                    default:


                }
            }
        });
    }
}
