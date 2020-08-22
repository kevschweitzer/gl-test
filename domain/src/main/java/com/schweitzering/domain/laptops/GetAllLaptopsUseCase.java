package com.schweitzering.domain.laptops;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class GetAllLaptopsUseCase {

    private LaptopsRepository repository;

    public GetAllLaptopsUseCase(LaptopsRepository repository) {
        this.repository = repository;
    }

    public Observable<List<Laptop>> execute() {
        return repository.getAllLaptops();
    }
}
