package com.example.bluepetshop.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.bluepetshop.fragment.ItemFragment;

public class TabAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public TabAdapter(@NonNull FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ItemFragment.addfrag(position);
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
