package com.test.appe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String REGEX_PWD = "^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)([a-z]|[A-Z]|[0-9]){8,16}$";
    String password = "12345678";
    String password1 = "1234qwer87654321";
    String password2 = "1234QWER";
    String password3 = "1234....";
    String password4 = "QQQQQQQQ";
    String password5 = "qqqqqqqq";
    String password6 = "!@#$$qqqq";
    String password7 = "!@#$$1234";
    String password8 = "!@#$$!@#$$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("tag1---->", password.matches(REGEX_PWD) + "");
        Log.e("tag2---->", password1.matches(REGEX_PWD) + "");
        Log.e("tag3---->", password2.matches(REGEX_PWD) + "");
        Log.e("tag4---->", password3.matches(REGEX_PWD) + "");
        Log.e("tag5---->", password4.matches(REGEX_PWD) + "");
        Log.e("tag6---->", password5.matches(REGEX_PWD) + "");
        Log.e("tag7---->", password6.matches(REGEX_PWD) + "");
        Log.e("tag8---->", password7.matches(REGEX_PWD) + "");
        Log.e("tag9---->", password8.matches(REGEX_PWD) + "");
    }
}
