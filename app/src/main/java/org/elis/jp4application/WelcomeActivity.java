package org.elis.jp4application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class WelcomeActivity extends AppCompatActivity {

    TextView welcomeTW, emailTv;

    RecyclerView recyclerView;

    LinearLayoutManager layoutManager;
    FoodListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_welcome);

        welcomeTW = findViewById(R.id.welcome_tv);
        emailTv = findViewById(R.id.email_tv);

        recyclerView = findViewById(R.id.food_rv);

        layoutManager = new LinearLayoutManager(this);

        ArrayList<String> foodList = new ArrayList<>();

        foodList.add("Milk");
        foodList.add("Bread");
        foodList.add("Bread");
        foodList.add("Bread");
        foodList.add("Bread");
        foodList.add("Bread");
        foodList.add("Bread");
        foodList.add("Bread");
        foodList.add("Bread");
        foodList.add("Bread");
        foodList.add("Bread");
        foodList.add("Bread");
        foodList.add("Bread");


        adapter = new FoodListAdapter(this,foodList);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);




    }
}
