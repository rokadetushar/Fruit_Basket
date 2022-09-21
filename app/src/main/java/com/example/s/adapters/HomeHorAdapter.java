package com.example.s.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.s.R;
import com.example.s.models.HomeHorModel;
import com.example.s.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {


    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.fig1, "Fig 1", "6:00 - 23:00", "4.9", "Min - $45"));
            homeVerModels.add(new HomeVerModel(R.drawable.fig2, "Fig 2", "6:00 - 23:00", "4.9", "Min - $45"));
            homeVerModels.add(new HomeVerModel(R.drawable.fig3, "Fig 3", "6:00 - 23:00", "4.9", "Min - $45"));
            homeVerModels.add(new HomeVerModel(R.drawable.fig4, "Fig 4", "6:00 - 23:00", "4.9", "Min - $45"));

            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_index = position;
                    notifyDataSetChanged();

                    if (position == 0) {

                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.fig1, "Fig 1", "6:00 - 23:00", "4.9", "Min - Rs.50"));
                        homeVerModels.add(new HomeVerModel(R.drawable.fig2, "Fig 2", "6:00 - 23:00", "4.9", "Min - Rs.50"));
                        homeVerModels.add(new HomeVerModel(R.drawable.fig3, "Fig 3", "6:00 - 23:00", "4.9", "Min - Rs.50"));
                        homeVerModels.add(new HomeVerModel(R.drawable.fig4, "Fig 4", "6:00 - 23:00", "4.9", "Min - Rs.50"));

                        updateVerticalRec.callBack(position, homeVerModels);
                    }

                    else if (position == 1) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.bananas1, "Bananas 1", "6:00 - 23:00", "4.9", "Min - Rs.55"));
                        homeVerModels.add(new HomeVerModel(R.drawable.bananas2, "Bananas 2", "6:00 - 23:00", "4.9", "Min - Rs.55"));
                        homeVerModels.add(new HomeVerModel(R.drawable.bananas3, "Bananas 3", "6:00 - 23:00", "4.9", "Min - Rs.55"));


                        updateVerticalRec.callBack(position, homeVerModels);
                    }

                    else if (position == 2) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.pomegranate1, "Pomegranate 1", "6:00 - 23:00", "4.9", "Min - Rs.70"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pomegranate2, "Pomegranate 2", "6:00 - 23:00", "4.9", "Min - Rs.70"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pomegranate3, "Pomegranate 3", "6:00 - 23:00", "4.9", "Min - Rs.70"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pomegranate4, "Pomegranate 4", "6:00 - 23:00", "4.9", "Min - Rs.70"));

                        updateVerticalRec.callBack(position, homeVerModels);
                    }

                    else if (position == 3) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.dragon_fruits1, "Dragon Fruit 1", "6:00 - 23:00", "4.9", "Min - Rs.75"));
                        homeVerModels.add(new HomeVerModel(R.drawable.dragon_fruits2, "Dragon Fruit 2", "6:00 - 23:00", "4.9", "Min - Rs.75"));
                        homeVerModels.add(new HomeVerModel(R.drawable.dragon_fruits3, "Dragon Fruit 3", "6:00 - 23:00", "4.9", "Min - Rs.75"));
                        homeVerModels.add(new HomeVerModel(R.drawable.dragon_fruits4, "Dragon Fruit 4", "6:00 - 23:00", "4.9", "Min - Rs.75"));

                        updateVerticalRec.callBack(position, homeVerModels);
                    }

                    else if (position == 4) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.grapes1, "Grapes 1", "6:00 - 23:00", "4.9", "Min - Rs.35"));
                        homeVerModels.add(new HomeVerModel(R.drawable.grapes2, "Grapes 2", "6:00 - 23:00", "4.9", "Min - Rs.35"));
                        homeVerModels.add(new HomeVerModel(R.drawable.grapes3, "Grapes 3", "6:00 - 23:00", "4.9", "Min - Rs.35"));


                        updateVerticalRec.callBack(position, homeVerModels);
                    }

                    else if (position == 5) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.guava_fruit1, "Guava Fruits 1", "6:00 - 23:00", "4.9", "Min - Rs.45"));
                        homeVerModels.add(new HomeVerModel(R.drawable.guava_fruit2, "Guava Fruits 2", "6:00 - 23:00", "4.9", "Min - Rs.45"));
                        homeVerModels.add(new HomeVerModel(R.drawable.guava_fruit3, "Guava Fruits 3", "6:00 - 23:00", "4.9", "Min - Rs.45"));
                        homeVerModels.add(new HomeVerModel(R.drawable.guava_fruit4, "Guava Fruits 4", "6:00 - 23:00", "4.9", "Min - Rs.45"));

                        updateVerticalRec.callBack(position, homeVerModels);
                    }
                }
            });

            if (select){
                if (position == 0){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select = false;
                }
            }
            else {
                if (row_index == position){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }else {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }
        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}

