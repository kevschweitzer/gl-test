package com.schweitzering.data.laptops;

import android.util.Log;

import com.schweitzering.domain.laptops.Laptop;
import com.schweitzering.domain.laptops.LaptopsRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LaptopsRepositoryImpl implements LaptopsRepository {

    private LaptopsService laptopsService;

    public LaptopsRepositoryImpl(LaptopsService service) {
        laptopsService = service;
    }

    @Override
    public Observable<List<Laptop>> getAllLaptops() {
        return laptopsService.getAllLaptops()
                .subscribeOn(Schedulers.io())
                .map(this::convertToLaptop);
    }

    private List<Laptop> convertToLaptop(List<LaptopServerResponse> laptopServerResponse) {
        List<Laptop> laptops = new ArrayList<Laptop>();
        for (LaptopServerResponse laptopResponse: laptopServerResponse) {
            Laptop newLaptop = new Laptop(
                    laptopResponse.getTitle(),
                    laptopResponse.getDescription(),
                    laptopResponse.getImageUrl()
            );
            laptops.add(newLaptop);
            Log.e("Laptop", newLaptop.toString());
        }
        return laptops;
    }
}
