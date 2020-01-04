package com.example.bluepetshop.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bluepetshop.R;
import com.example.bluepetshop.adapter.AdapterRecommend;
import com.example.bluepetshop.addition.OnItemClickListener;
import com.example.bluepetshop.bottomsheet.BottomSheetDialogMenu;
import com.example.bluepetshop.data.DataCarousel;
import com.example.bluepetshop.data.DataPets;
import com.example.bluepetshop.model.DataItem;
import com.google.android.material.button.MaterialButton;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomSheetDialogMenu.BottomSheetListener {

    CarouselView carouselView;
    DataCarousel dataCarousel;

    MaterialButton buttonAdopt, buttonUsername;
    RecyclerView recyclerView;

    DataPets dataPets;
    AdapterRecommend adapterRecommend;
    SharedPreferences sharedPreferences;
    String username;

    void onDeclare(){
        carouselView = findViewById(R.id.carouselView);
        buttonAdopt = findViewById(R.id.btnAdopt);
        recyclerView = findViewById(R.id.rvRecommend);
        buttonUsername = findViewById(R.id.btnUsername);
    }

    void setupSharedPreference(){
        sharedPreferences = this.getSharedPreferences("UsernameBluepet", Context.MODE_PRIVATE);
        username = sharedPreferences.getString("username", "missing");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onDeclare();
        setupCarousel();
        setupRecommend();
        goToItem();
        setupSharedPreference();
        openUsername();
    }

    void openUsername(){
        final BottomSheetDialogMenu bottomSheetDialogMenu = new BottomSheetDialogMenu();
        buttonUsername.setText(username);
        buttonUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialogMenu.show(getSupportFragmentManager(), "bottomSheetDialogFragment");
            }
        });
    }

    void goToItem(){
        buttonAdopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                startActivity(intent);
            }
        });
    }

    void setupCarousel(){
        dataCarousel = new DataCarousel();
        carouselView.setPageCount(dataCarousel.getDataCarousel().length);
        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource((dataCarousel.getDataCarousel()[position]));
            }
        };
        carouselView.setImageListener(imageListener);
    }

    void setupRecommend(){
        dataPets = new DataPets();
        adapterRecommend = new AdapterRecommend(this, dataPets, new OnItemClickListener() {
            @Override
            public void onItemCLick(DataItem item) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("namaItem", item.getItemName());
                intent.putExtra("imageItem", item.getItemImage());
                intent.putExtra("ageItem", item.getItemAge());
                intent.putExtra("genderItem", item.getItemGender());
                intent.putExtra("raceItem", item.getItemRace());
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.smoothScrollToPosition(0);
        recyclerView.setAdapter(adapterRecommend);
        adapterRecommend.notifyDataSetChanged();
    }

    @Override
    public void onBottomSheetClicked() {

    }
}
