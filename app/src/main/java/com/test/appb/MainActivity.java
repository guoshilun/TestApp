package com.test.appb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //appb 打印时间
        System.currentTimeMillis();
    }
}
