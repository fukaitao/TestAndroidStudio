package com.example.administrator.test2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup;
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public static String toString() {
    }
}

    private void initView() {
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragmentManager = getSupportFragmentManager();
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new onCheckedChangeListener());
    }

    //单选点击监听
    private class onCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.radioButton1:
                    fragmentManager.beginTransaction().replace(R.id.content, new Fragment1()).addToBackStack(null).commit();
                    break;
                case R.id.radioButton2:
                    fragmentManager.beginTransaction().replace(R.id.content, new Fragment2()).addToBackStack(null).commit();
                    break;
                case R.id.radioButton3:
                    fragmentManager.beginTransaction().replace(R.id.content, new Fragment3()).addToBackStack(null).commit();
                    break;
            }
        }
    }
}