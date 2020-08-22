package com.schweitzering.globallogictest.di;

import com.schweitzering.domain.laptops.GetAllLaptopsUseCase;
import com.schweitzering.domain.laptops.LaptopsRepository;
import com.schweitzering.globallogictest.laptops.LaptopsViewModel;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    @Provides
    LaptopsViewModel provideLaptopsViewModel(GetAllLaptopsUseCase useCase) {
        return new LaptopsViewModel(useCase);
    }

    @Provides
    GetAllLaptopsUseCase providesGetAllLaptopsUseCase(LaptopsRepository repository) {
        return new GetAllLaptopsUseCase(repository);
    }
}
