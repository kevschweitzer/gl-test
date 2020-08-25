package com.schweitzering.globallogictest.laptops;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.schweitzering.domain.laptops.Laptop;
import com.schweitzering.globallogictest.R;
import com.schweitzering.globallogictest.databinding.ActivityLaptopDetailBinding;

public class LaptopDetailActivity extends AppCompatActivity {

    private static final String LAPTOP_KEY = "laptop";
    public static Intent getStartIntent(Context context, Laptop laptop) {
        Intent intent =  new Intent(context, LaptopDetailActivity.class);
        intent.putExtra(LAPTOP_KEY, laptop);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLaptopDetailBinding itemBinding = DataBindingUtil.setContentView(this, R.layout.activity_laptop_detail);
        Laptop laptop = (Laptop) getIntent().getSerializableExtra(LAPTOP_KEY);
        itemBinding.setLaptop(laptop);
        setLaptopImage(laptop);
    }

    private void setLaptopImage(Laptop laptop) {
        ImageView imageView = findViewById(R.id.image);
        Glide.with(this).load(laptop.getImageUrl()).into(imageView);
    }

}