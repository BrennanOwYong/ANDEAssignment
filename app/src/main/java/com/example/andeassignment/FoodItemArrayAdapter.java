package com.example.andeassignment;

import android.graphics.Color;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodItemArrayAdapter  extends RecyclerView.Adapter<FoodItemArrayAdapter.MyViewHolder>  {
    private ArrayList<FoodItem> mFoods;
    private FoodItemClickListener mItemClickListener;

    public FoodItemArrayAdapter(ArrayList<FoodItem> foods, FoodItemClickListener itemClickListener)
    {
        this.mFoods = foods;
        this.mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //Inflate RecyclerView row
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);

        //Create View Holder
        final MyViewHolder myViewHolder = new MyViewHolder(view);

        //Item Clicks
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mItemClickListener.onItemClicked(mFoods.get(myViewHolder.getLayoutPosition()));

            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.textViewCategory.setText(mFoods.get(position).getCategory());
        holder.textViewName.setText(mFoods.get(position).getName());
        String price = "$" + mFoods.get(position).getPrice();
        holder.textViewPrice.setText(price);
        holder.FoodImage.setImageDrawable(mFoods.get(position).getImage());
        if (position ==1) {
            holder.textViewCategory.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount()
    {
        return mFoods.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    //RecyclerView View Holder
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView FoodImage;
        private TextView textViewName;
        private TextView textViewPrice;
        private TextView textViewCategory;
        private Button AddCart;
        private boolean buttonclicked = false;

        MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textViewCategory = itemView.findViewById(R.id.FoodCategory);
            FoodImage = itemView.findViewById(R.id.FoodImage);
            textViewName = itemView.findViewById(R.id.FoodName);
            textViewPrice = itemView.findViewById(R.id.FoodPrice);
            AddCart = itemView.findViewById(R.id.AddToCartButton);

            AddCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonclicked = !buttonclicked;
                    if (buttonclicked) {
                        AddCart.setText("Added");
                        AddCart.setBackgroundColor(Color.WHITE);
                        AddCart.setTextColor(Color.parseColor("#CF9FFF"));
                        Restaurant.setCartcount(Restaurant.getCartcount() + 1);
                        Restaurant.setBadge(Restaurant.getCartcount());
                    } else {
                        AddCart.setText("Add to Cart");
                        AddCart.setBackgroundColor(Color.parseColor("#CF9FFF"));
                        AddCart.setTextColor(Color.WHITE);
                        Restaurant.setCartcount(Restaurant.getCartcount() - 1);
                        Restaurant.setBadge(Restaurant.getCartcount());
                    }
                }
            });
        }
    }

    public interface FoodItemClickListener
    {
        void onItemClicked(FoodItem food);
    }
}
