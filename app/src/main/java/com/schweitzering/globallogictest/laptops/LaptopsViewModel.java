package com.schweitzering.globallogictest.laptops;

import com.schweitzering.domain.laptops.GetAllLaptopsUseCase;
import com.schweitzering.domain.laptops.Laptop;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class LaptopsViewModel {

    private GetAllLaptopsUseCase getAllLaptopsUseCase;

    public LaptopsViewModel(GetAllLaptopsUseCase getAllLaptopsUseCase){
        this.getAllLaptopsUseCase = getAllLaptopsUseCase;
    }

    Observable<List<Laptop>> getAllLaptops() {
        return getAllLaptopsUseCase.execute();
    }
}
