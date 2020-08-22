package com.schweitzering.data.laptops;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LaptopsService {

    @GET("/list")
    Call<List<LaptopServerResponse>> getAllLaptops();
}
