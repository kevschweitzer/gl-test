package com.schweitzering.globallogictest;

import android.app.Application;

import com.schweitzering.globallogictest.di.ApplicationComponent;
import com.schweitzering.globallogictest.di.DaggerApplicationComponent;

public class BaseApplication extends Application {

    public ApplicationComponent appComponent = DaggerApplicationComponent.create();
}