package com.schweitzering.di;

import com.schweitzering.data.LaptopsRepositoryImpl;
import com.schweitzering.domain.laptops.LaptopsRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    public LaptopsRepository providesLaptopsRepository() {
        return new LaptopsRepositoryImpl();
    }
}
