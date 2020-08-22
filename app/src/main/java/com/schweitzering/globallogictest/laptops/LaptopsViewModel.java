package com.schweitzering.globallogictest.laptops;

import com.schweitzering.domain.laptops.LaptopsRepository;

public class LaptopsViewModel {

    private LaptopsRepository laptopsRepository;

    public LaptopsViewModel(LaptopsRepository repository){
        laptopsRepository = repository;
    }
}
