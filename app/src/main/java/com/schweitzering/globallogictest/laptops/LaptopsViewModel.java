package com.schweitzering.globallogictest.laptops;

import com.schweitzering.domain.laptops.GetAllLaptopsUseCase;

public class LaptopsViewModel {

    private GetAllLaptopsUseCase getAllLaptopsUseCase;

    public LaptopsViewModel(GetAllLaptopsUseCase getAllLaptopsUseCase){
        this.getAllLaptopsUseCase = getAllLaptopsUseCase;
    }

    public void getAllLaptops() {
        getAllLaptopsUseCase.execute();
    }
}
