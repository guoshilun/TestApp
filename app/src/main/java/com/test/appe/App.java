package com.test.appe;

import android.app.Application;

import com.test.appe.utils.L;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DensityUtils.init(this);
        L.init(BuildConfig.DEBUG, "Gsl");
    }
}