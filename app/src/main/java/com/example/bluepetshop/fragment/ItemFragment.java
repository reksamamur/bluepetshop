package com.example.bluepetshop.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bluepetshop.R;
import com.example.bluepetshop.activities.DetailActivity;
import com.example.bluepetshop.activities.MainActivity;
import com.example.bluepetshop.adapter.AdapterPetCat;
import com.example.bluepetshop.adapter.AdapterPetDog;
import com.example.bluepetshop.adapter.AdapterPetReptile;
import com.example.bluepetshop.adapter.AdapterPetSugar;
import com.example.bluepetshop.addition.OnItemClickListener;
import com.example.bluepetshop.data.DataPets;
import com.example.bluepetshop.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class ItemFragment extends Fragment {

    private View view;
    private int val;
    private RecyclerView recyclerView;
    private DataPets dataPets;

    public static ItemFragment addfrag(int val) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", val);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_item, container, false);
        val = getArguments().getInt("someInt", 0);

        switch (val){
            case 0:
                setupRecyclerItemCats();
                break;
            case 1:
                setupRecyclerItemDogs();
                break;
            case 2:
                setupRecyclerItemReptiles();
                break;
            case 3:
                setupRecyclerItemSugars();
                break;
        }

        return view;
    }

    private void setupRecyclerItemCats(){
        dataPets = new DataPets();
        recyclerView = view.findViewById(R.id.rvItems);
        AdapterPetCat adapterPetCat = new AdapterPetCat(getActivity(), new OnItemClickListener() {
            @Override
            public void onItemCLick(DataItem item) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("namaItem", item.getItemName());
                intent.putExtra("imageItem", item.getItemImage());
                intent.putExtra("ageItem", item.getItemAge());
                intent.putExtra("genderItem", item.getItemGender());
                intent.putExtra("raceItem", item.getItemRace());
                startActivity(intent);
            }
        }, dataPets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.smoothScrollToPosition(0);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterPetCat);
    }

    private void setupRecyclerItemDogs(){
        dataPets = new DataPets();
        recyclerView = view.findViewById(R.id.rvItems);
        AdapterPetDog adapterPetDog = new AdapterPetDog(getActivity(), new OnItemClickListener() {
            @Override
            public void onItemCLick(DataItem item) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("namaItem", item.getItemName());
                intent.putExtra("imageItem", item.getItemImage());
                intent.putExtra("ageItem", item.getItemAge());
                intent.putExtra("genderItem", item.getItemGender());
                intent.putExtra("raceItem", item.getItemRace());
                startActivity(intent);
            }
        }, dataPets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.smoothScrollToPosition(0);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterPetDog);
    }

    private void setupRecyclerItemReptiles(){
        dataPets = new DataPets();
        recyclerView = view.findViewById(R.id.rvItems);
        AdapterPetReptile adapterPetReptile = new AdapterPetReptile(getActivity(), new OnItemClickListener() {
            @Override
            public void onItemCLick(DataItem item) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("namaItem", item.getItemName());
                intent.putExtra("imageItem", item.getItemImage());
                intent.putExtra("ageItem", item.getItemAge());
                intent.putExtra("genderItem", item.getItemGender());
                intent.putExtra("raceItem", item.getItemRace());
                startActivity(intent);
            }
        }, dataPets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.smoothScrollToPosition(0);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterPetReptile);
    }

    private void setupRecyclerItemSugars(){
        dataPets = new DataPets();
        recyclerView = view.findViewById(R.id.rvItems);
        AdapterPetSugar adapterPetSugar = new AdapterPetSugar(getActivity(), new OnItemClickListener() {
            @Override
            public void onItemCLick(DataItem item) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("namaItem", item.getItemName());
                intent.putExtra("imageItem", item.getItemImage());
                intent.putExtra("ageItem", item.getItemAge());
                intent.putExtra("genderItem", item.getItemGender());
                intent.putExtra("raceItem", item.getItemRace());
                startActivity(intent);
            }
        }, dataPets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.smoothScrollToPosition(0);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterPetSugar);
    }
}
