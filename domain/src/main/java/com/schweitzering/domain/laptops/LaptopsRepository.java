package com.schweitzering.domain.laptops;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface LaptopsRepository {

     Observable<List<Laptop>> getAllLaptops();
}
