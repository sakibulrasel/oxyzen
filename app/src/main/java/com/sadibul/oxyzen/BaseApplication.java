package com.sadibul.oxyzen;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

/**
 * Created By sakibul.haque on 14-03-2021
 */
@HiltAndroidApp
public class BaseApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
