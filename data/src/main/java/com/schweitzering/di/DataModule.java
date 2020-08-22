package com.schweitzering.di;

import com.schweitzering.data.laptops.LaptopsRepositoryImpl;
import com.schweitzering.data.laptops.LaptopsService;
import com.schweitzering.domain.laptops.LaptopsRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    @Provides
    public LaptopsRepository providesLaptopsRepository(LaptopsService service) {
        return new LaptopsRepositoryImpl(service);
    }

    @Provides LaptopsService provideLaptopsService() {
        return new Retrofit.Builder()
                .baseUrl("http://private-f0eea-mobilegllatam.apiary-mock.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(LaptopsService.class);
    }
}
