package com.schweitzering.data.laptops;

import android.util.Log;

import com.schweitzering.domain.laptops.LaptopsRepository;

import java.util.List;

public class LaptopsRepositoryImpl implements LaptopsRepository {

    private LaptopsService laptopsService;

    public LaptopsRepositoryImpl(LaptopsService service) {
        laptopsService = service;
    }

    @Override
    public void getAllLaptops() {
        try {
            List<LaptopServerResponse> response = laptopsService.getAllLaptops().execute().body();
            for (LaptopServerResponse laptop: response) {
                Log.e("Laptop", laptop.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
