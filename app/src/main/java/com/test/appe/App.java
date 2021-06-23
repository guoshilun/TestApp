package com.test.appe;

import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DensityUtils.init(this);
        //
    }
}