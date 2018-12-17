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


public class WelcomeActivity extends AppCompatActivity implements FoodListAdapter.OnQuantityChange {

    TextView welcomeTW, emailTv, totalTextView;

    RecyclerView recyclerView;

    LinearLayoutManager layoutManager;
    FoodListAdapter adapter;

    int total = 0;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_welcome);

        welcomeTW = findViewById(R.id.welcome_tv);
        emailTv = findViewById(R.id.email_tv);
        totalTextView = findViewById(R.id.total_tv);

        recyclerView = findViewById(R.id.food_rv);

        layoutManager = new LinearLayoutManager(this);

        adapter = new FoodListAdapter(this,getProducts());
        adapter.setOnQuantityChange(this);



        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }



    private ArrayList<Food> getProducts(){
        ArrayList<Food> foodList = new ArrayList<>();

        foodList.add(new Food("Pizza",2.00f));
        foodList.add(new Food("Latte",2.00f));
        foodList.add(new Food("Carne",2.00f));
        foodList.add(new Food("Acqua",2.00f));

        return foodList;

    }

    @Override
    public void onItemAdded(float price) {

        total+= price;
        totalTextView.setText("Total :" + total);



    }

    @Override
    public void onItemRemoved(float price) {
        if(total == 0) return;
        total -= price;
        totalTextView.setText("Total :" + total);

    }
}
