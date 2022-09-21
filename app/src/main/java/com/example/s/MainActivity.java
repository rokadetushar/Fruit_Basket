package com.example.s;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.s.activities.LoginActivity;
import com.example.s.activities.WelcomeActivity;
import com.example.s.activities.fruitdb;
import com.example.s.models.FruitModel;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.s.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Widgets

    RecyclerView recyView;

    // Firebase
    private DatabaseReference myRef;
    //private Storage

    //Variables
    private ArrayList<FruitModel> fruitList;

    private AppBarConfiguration mAppBarConfiguration;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyView = findViewById(R.id.recyView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyView.setLayoutManager(layoutManager);
        recyView.setHasFixedSize(true);

        //Firebase
        myRef = FirebaseDatabase.getInstance().getReference();

        //ArrayList
        fruitList = new ArrayList<>();

        //Clear Array List
        ClearAll();

        //Get Data Method
        GetDataFromFirebase();



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_my_order, R.id.nav_favourite, R.id.nav_my_cart)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        mAuth = FirebaseAuth.getInstance();
    }

    private void GetDataFromFirebase() {


    }

    private void ClearAll(){
        if(fruitList != null)
        {
            fruitList.clear();
        }

        fruitList = new ArrayList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void Welcome(View view) {
        startActivity(new Intent(MainActivity.this, WelcomeActivity.class));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user == null)
        {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }


    }


