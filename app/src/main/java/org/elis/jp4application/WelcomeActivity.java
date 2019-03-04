package org.elis.jp4application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class WelcomeActivity extends AppCompatActivity implements FoodListAdapter.OnQuantityChange {

    TextView welcomeTW, emailTv, totalTextView;
    RecyclerView recyclerView;
    ProgressBar progressBar,loading;
    Button buyBtn;


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
        progressBar = findViewById(R.id.progress);
        buyBtn = findViewById(R.id.buy_btn);
        loading = findViewById(R.id.loading);


        recyclerView = findViewById(R.id.food_rv);

        layoutManager = new LinearLayoutManager(this);


        getProducts();

        adapter = new FoodListAdapter(this);

        adapter.setOnQuantityChange(this);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


    private void getProducts() {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://5ba19290ee710f0014dd764c.mockapi.io/Food";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Success", response);
                        try {
                            JSONArray responseJSON = new JSONArray(response);
                            ArrayList<Food> foodArrayList = new ArrayList<>();

                            for (int i = 0; i < responseJSON.length(); i++) {

                                Food food = new Food(responseJSON.getJSONObject(i));
                                foodArrayList.add(food);
                            }

                            adapter.setData(foodArrayList);

                            loading.setVisibility(View.GONE);


                        } catch (JSONException e) {
                            Log.e("JSONException",e.getMessage());
                            loading.setVisibility(View.GONE);
                            Toast.makeText(WelcomeActivity.this, "Qualcosa è andato storto", Toast.LENGTH_LONG).show();
                        }

                        // Display the first 500 characters of the response string.
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error", error.getMessage());

                        loading.setVisibility(View.GONE);

                        Toast.makeText(WelcomeActivity.this,
                                error.getMessage(),Toast.LENGTH_LONG)
                                .show();

                    }
                });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    private void enableButton() {
        buyBtn.setEnabled(total > 5);
    }


    @Override
    public void onItemAdded(float price) {


        total += price;
        progressBar.setProgress(total);
        enableButton();
        totalTextView.setText("Total :" + total);

    }

    @Override
    public void onItemRemoved(float price) {
        if (total == 0) return;
        total -= price;
        progressBar.setProgress(total);
        enableButton();
        totalTextView.setText("Total :" + total);

    }
}
