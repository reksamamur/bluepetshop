package com.example.bluepetshop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bluepetshop.R;
import com.example.bluepetshop.adapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class ItemActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabAdapter tabAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        toolbar = findViewById(R.id.toolbar_item);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        tabLayout = findViewById(R.id.tabLayout_item);
        viewPager = findViewById(R.id.viepager_item);

        String[] categoryItem = {
                "Cat", "Dog", "Reptile", "Sugar Glider"
        };

        for (int i = 0; i < categoryItem.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(categoryItem[i]));
        }

        tabAdapter = new TabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabAdapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
