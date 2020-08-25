package com.schweitzering.globallogictest.laptops;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.schweitzering.domain.laptops.Laptop;
import com.schweitzering.globallogictest.R;
import com.schweitzering.globallogictest.databinding.ItemLaptopBinding;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAdapter extends RecyclerView.Adapter<LaptopsAdapter.LaptopViewHolder> {

    public interface LaptopClickedCallback{
        void onLaptopSelected(Laptop laptop);
    }

    private List<Laptop> laptops = new ArrayList<Laptop>();
    private LaptopClickedCallback callback;

    public LaptopsAdapter(LaptopClickedCallback callback) {
        this.callback = callback;
    }

    public void setList(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @NonNull
    @Override
    public LaptopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemLaptopBinding itemBinding  =
                DataBindingUtil.inflate(inflater, R.layout.item_laptop, parent, false);
        return new LaptopViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopViewHolder holder, int position) {
        holder.bind(laptops.get(position));
    }

    @Override
    public int getItemCount() {
        return laptops.size();
    }

    class LaptopViewHolder extends RecyclerView.ViewHolder {

        private ItemLaptopBinding itemBinding;

        public LaptopViewHolder(ItemLaptopBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        void bind(Laptop laptop) {
            itemBinding.setCallback(callback);
            itemBinding.setLaptop(laptop);
        }
    }
}
