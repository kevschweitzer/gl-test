package com.schweitzering.globallogictest.di;

import com.schweitzering.domain.laptops.LaptopsRepository;
import com.schweitzering.globallogictest.laptops.LaptopsViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public LaptopsViewModel provideLaptopsViewModel(LaptopsRepository repository) {
        return new LaptopsViewModel(repository);
    }
}
