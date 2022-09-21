package com.example.s.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.s.R;
import com.example.s.adapters.FruitListAdapter;
import com.example.s.adapters.HomeHorAdapter;
import com.example.s.adapters.HomeVerAdapter;
import com.example.s.adapters.UpdateVerticalRec;
import com.example.s.models.FruitModel;
import com.example.s.models.HomeHorModel;
import com.example.s.models.HomeVerModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView fruit_list;
    ArrayList<FruitModel> fruitList;
    FruitListAdapter fruitListAdapter;
    DatabaseReference firebaseDatabase;

    //////////////////////////Vertical
    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container,false);

        fruit_list = root.findViewById(R.id.fruit_list);
        fruit_list.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        fruit_list.setHasFixedSize(true);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("fruits");
      //  homeVerticalRec = root.findViewById(R.id.home_Ver_rec);
        //////////////////////////////////Horizontal RecyclerView
      /*  homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.fig,"Fig"));
        homeHorModelList.add(new HomeHorModel(R.drawable.bananas,"Bananas"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pomegranate,"Pomegranate"));
        homeHorModelList.add(new HomeHorModel(R.drawable.dragon_fruits,"Dragon Fruits"));
        homeHorModelList.add(new HomeHorModel(R.drawable.grapes,"Grapes"));
        homeHorModelList.add(new HomeHorModel(R.drawable.guava_fruit,"Guava_Fruit"));*/
        fruitList = new ArrayList<>();
     //   FruitModel model = new FruitModel("abc","abc","100Rs","");
      //  fruitList.add(model);




        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    FruitModel fruitModel = dataSnapshot.getValue(FruitModel.class);
                    fruitList.add(fruitModel);
                }
                fruitListAdapter = new FruitListAdapter(getActivity(),fruitList);
                fruit_list.setAdapter(fruitListAdapter);
                fruitListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
       /* //////////////////////////////////Vertical RecyclerView
        homeVerModelList = new ArrayList<>();


        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
*/
        return root;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {

        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
       // homeVerticalRec.setAdapter(homeVerAdapter);

    }
}