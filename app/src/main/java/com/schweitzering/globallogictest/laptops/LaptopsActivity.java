package com.schweitzering.globallogictest.laptops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.schweitzering.globallogictest.R;
import com.schweitzering.globallogictest.BaseApplication;

import javax.inject.Inject;

public class LaptopsActivity extends AppCompatActivity {

    @Inject LaptopsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BaseApplication) getApplicationContext()).appComponent.inject(this);
    }
}
