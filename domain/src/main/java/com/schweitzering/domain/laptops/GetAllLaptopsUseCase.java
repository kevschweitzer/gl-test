package com.schweitzering.domain.laptops;

public class GetAllLaptopsUseCase {

    private LaptopsRepository repository;

    public GetAllLaptopsUseCase(LaptopsRepository repository) {
        this.repository = repository;
    }

    public void execute() {
        repository.getAllLaptops();
    }
}
