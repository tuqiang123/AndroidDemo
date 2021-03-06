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
    private String[] activitys = {"Intent Service  Test", "Service Test", "Extends Binder"
            , "Service Messenger", "PagerTabStrip", "PagerTitleStrip", "FragmentPagerAdapter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.activity_main_list, activitys);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                switch (position) {
                    case 0:
                        intent.setClass(mContext,
                                com.tu_qi.androiddemo.service.IntentServiceTestActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.setClass(mContext, com.tu_qi.androiddemo.service.HelloActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.setClass(mContext, com.tu_qi.androiddemo.service.BindingActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.setClass(mContext, com.tu_qi.androiddemo.service.ActivityMessenger.class);
                        startActivity(intent);
                    case 4:
                        intent.setClass(mContext, com.tu_qi.androiddemo.pagertabstrip.PagerTabStripActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent.setClass(mContext, com.tu_qi.androiddemo.pagertitlestrip.PagerTitleStripActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent.setClass(mContext,
                                com.tu_qi.androiddemo.fragmentpageradapter.FragmentPagerSupportActivity.class);
                        startActivity(intent);
                        break;
                    default:

                }
            }
        });
    }
}
