package com.schweitzering.globallogictest.laptops;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.schweitzering.domain.laptops.Laptop;
import com.schweitzering.globallogictest.BaseApplication;
import com.schweitzering.globallogictest.R;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LaptopsActivity extends AppCompatActivity {

    @Inject LaptopsViewModel viewModel;
    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BaseApplication) getApplicationContext()).appComponent.inject(this);
        getLaptops();
    }

    private void getLaptops() {
        Disposable disposable = viewModel.getAllLaptops()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(laptops -> {
                    RecyclerView laptopsList = findViewById(R.id.laptops_list);
                    LaptopsAdapter adapter = new LaptopsAdapter();
                    adapter.setList(laptops);
                    laptopsList.setAdapter(adapter);
                    laptopsList.setLayoutManager(new LinearLayoutManager(this));
                    for(Laptop lap: laptops) {
                        Log.i("laptops in activity", lap.getTitle());
                    }
                }, Throwable::printStackTrace);
        disposables.add(disposable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }
}
