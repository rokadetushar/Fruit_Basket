package com.example.s.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.s.R;
import com.example.s.models.FruitModel;

import java.util.ArrayList;


public class FruitListAdapter extends RecyclerView.Adapter<FruitListAdapter.ViewHolder> {

    Context context;
    ArrayList<FruitModel> fruitsList;

    public FruitListAdapter(Context context,ArrayList<FruitModel> fruitsList){
        this.context=context;
        this.fruitsList=fruitsList;
    }
    @NonNull
    @Override
    public FruitListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitListAdapter.ViewHolder holder, int position) {
        FruitModel fruit = fruitsList.get(position);
        holder.fruitBrand.setText(fruit.getBrand());
        holder.fruitPrice.setText(fruit.getPrice_per_kg());
        holder.fruitType.setText(fruit.getFruit_type());
        holder.fruitQuality.setText(fruit.getQuality());
        holder.fruitOrganic.setText(fruit.getOrganic());
        holder.fruitProduction.setText(fruit.getProduct_type());
        Glide.with(context).applyDefaultRequestOptions(new RequestOptions().override(70,70)).load(fruit.getUrl()).into(holder.imagView);
    }

    @Override
    public int getItemCount() {
        return fruitsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagView;
        public TextView fruitBrand, fruitType, fruitPrice, fruitQuality, fruitOrganic, fruitProduction;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagView = itemView.findViewById(R.id.imgView);
            fruitBrand = itemView.findViewById(R.id.brand);
            fruitType = itemView.findViewById(R.id.fruit_type);
            fruitPrice = itemView.findViewById(R.id.price);
            fruitQuality = itemView.findViewById(R.id.quality);
            fruitOrganic = itemView.findViewById(R.id.organic);
            fruitProduction = itemView.findViewById(R.id.production);
        }
    }
}

