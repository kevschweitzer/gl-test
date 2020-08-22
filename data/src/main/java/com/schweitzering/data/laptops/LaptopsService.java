package com.schweitzering.data.laptops;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;;
import retrofit2.http.GET;

public interface LaptopsService {

    @GET("/list")
    Observable<List<LaptopServerResponse>> getAllLaptops();
}
