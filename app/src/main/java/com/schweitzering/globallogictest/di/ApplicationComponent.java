package com.schweitzering.globallogictest.di;

import com.schweitzering.di.DataModule;
import com.schweitzering.globallogictest.laptops.LaptopsActivity;

import dagger.Component;

@Component(modules = {AppModule.class, DataModule.class})
public interface ApplicationComponent {

    void inject(LaptopsActivity laptopsActivity);
}
