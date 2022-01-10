package com.example.andeassignment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Restaurant extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<FoodItem> mFoods = new ArrayList<>();
    public static BadgeDrawable badge;
    public static int cartcount = 0;

    public static int getCartcount() {
        return cartcount;
    }

    public static void setCartcount(int count) {
        cartcount = count;
    }

    public static BadgeDrawable getBadge() {
        return badge;
    }

    public static void setBadge(int badgecount) {
        badge.setNumber(badgecount);
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);;
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        View view = getSupportActionBar().getCustomView();
        bindFoodData();
        setUIRef();
        BottomNavigationView bottomNav = findViewById(R.id.BottomNavigationMenu);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        int menuItemId = bottomNav.getMenu().getItem(1).getItemId();
        badge = bottomNav.getOrCreateBadge(menuItemId);
        //badge.setNumber(2);
    }

    private void setUIRef()
    {
        //Reference of RecyclerView
        mRecyclerView = findViewById(R.id.FoodList);
        //Linear Layout Manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Restaurant.this, RecyclerView.VERTICAL, false);
        //Set Layout Manager to RecyclerView
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //Create adapter
        FoodItemArrayAdapter myRecyclerViewAdapter = new FoodItemArrayAdapter(mFoods, new FoodItemArrayAdapter.FoodItemClickListener()
        {
            //Handling clicks
            @Override
            public void onItemClicked(FoodItem food)
            {
                Toast.makeText(Restaurant.this, food.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        //Set adapter to RecyclerView
        mRecyclerView.setAdapter(myRecyclerViewAdapter);
    }

    private void bindFoodData()
    {
        mFoods.add(new FoodItem("Pizzas","Veggie Lover's",  "19.90", getResources().getDrawable(R.drawable.vegpizza)));
        mFoods.add(new FoodItem("Pizzas","Pepperoni","19.90", getResources().getDrawable(R.drawable.peppizza)));
        mFoods.add(new FoodItem("Drinks","Pepsi Regular","4.29", getResources().getDrawable(R.drawable.pepsi)));

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // By using switch we can easily get
            // the selected fragment
            // by using there id.
            switch (item.getItemId()) {
                case R.id.Orders:
                    Toast.makeText(getApplicationContext(),"Orders...", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.Cart:
                    Toast.makeText(getApplicationContext(),"Cart...", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.Home:
                    Toast.makeText(getApplicationContext(),"Home...",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.Payments:
                    Toast.makeText(getApplicationContext(),"Payments...",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.Account:
                    Toast.makeText(getApplicationContext(),"Account...",Toast.LENGTH_SHORT).show();
                    return true;
            }
            // It will help to replace the
            // one fragment to other.
            return true;
        }
    };


}
