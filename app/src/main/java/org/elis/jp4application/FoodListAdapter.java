package org.elis.jp4application;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class
FoodListAdapter extends RecyclerView.Adapter {


    private LayoutInflater mInflter;
    private ArrayList<String> data;


    public FoodListAdapter(Context context, ArrayList<String> data){

        this.data = data;
        mInflter = LayoutInflater.from(context);


    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = mInflter.inflate(R.layout.row_item,viewGroup,false);
        return new FoodViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            FoodViewHolder foodViewHolder = (FoodViewHolder)viewHolder;
            foodViewHolder.productName.setText(data.get(i));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView productName,productPrice,productQty;
        public Button addBtn,removeBtn;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.item_name);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
