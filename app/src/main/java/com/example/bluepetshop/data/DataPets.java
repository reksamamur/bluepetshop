package com.example.bluepetshop.data;

import android.content.Context;
import android.content.res.Resources;

import com.example.bluepetshop.R;
import com.example.bluepetshop.model.DataItem;

import java.util.ArrayList;

public class DataPets {
    public ArrayList<DataItem> mainDataItems(Context context){
        ArrayList<DataItem> dataItems = new ArrayList<>();
        //cat section
        dataItems.add(new DataItem("Birman", context.getResources().getString(R.string.cat), "cat", "2 Month", "Male", R.drawable.birman));
        dataItems.add(new DataItem("Ragdoll", context.getResources().getString(R.string.cat), "cat", "5 Month", "Male", R.drawable.ragdoll));
        dataItems.add(new DataItem("Toyger", context.getResources().getString(R.string.cat), "cat", "1 Year", "Female", R.drawable.toyger));
        dataItems.add(new DataItem("Turkish Van", context.getResources().getString(R.string.cat), "cat", "20 Year", "Male", R.drawable.turkish_van));
        //dog section
        dataItems.add(new DataItem("Corgi", context.getResources().getString(R.string.dog), "dog", "5 Month", "Male", R.drawable.corgi));
        dataItems.add(new DataItem("Golden", context.getResources().getString(R.string.dog), "dog", "1 Year", "Female", R.drawable.golden));
        dataItems.add(new DataItem("Husky", context.getResources().getString(R.string.dog), "dog", "5 Year", "Male", R.drawable.husky));
        dataItems.add(new DataItem("Shih Tzu", context.getResources().getString(R.string.dog), "dog", "10 Year", "Male", R.drawable.shih_tzu));
        //reptile section
        dataItems.add(new DataItem("Karma Bali Python", context.getResources().getString(R.string.reptile), "reptile", "5 Month", "Male", R.drawable.karma_bali));
        dataItems.add(new DataItem("Mexican Black Kingsnack", context.getResources().getString(R.string.reptile), "reptile", "2 Year", "Female", R.drawable.mexican_black));
        dataItems.add(new DataItem("Pled Pectinata", context.getResources().getString(R.string.reptile), "reptile", "10 Year", "Male", R.drawable.pled_pectinata));
        dataItems.add(new DataItem("Verrucosus Charmelon", context.getResources().getString(R.string.reptile), "reptile", "3 Year", "Male", R.drawable.verrucosus_charmelon));
        //sugar section
        dataItems.add(new DataItem("Caramel", context.getResources().getString(R.string.sugar_glider), "sugar", "5 Month", "Male", R.drawable.caramel));
        dataItems.add(new DataItem("Classic", context.getResources().getString(R.string.sugar_glider), "sugar", "2 Month", "Female", R.drawable.classic));
        dataItems.add(new DataItem("Leucistic", context.getResources().getString(R.string.sugar_glider), "sugar", "1 Year", "Male", R.drawable.leucistic));
        dataItems.add(new DataItem("Piebald", context.getResources().getString(R.string.sugar_glider), "sugar", "1 Month", "Female", R.drawable.piebald));
        return dataItems;
    }

    public ArrayList<DataItem> dataCatPet(Context context){
        ArrayList<DataItem> dataItems = new ArrayList<>();
        dataItems.add(new DataItem("Birman", context.getResources().getString(R.string.cat), "cat", "2 Month", "Male", R.drawable.birman));
        dataItems.add(new DataItem("Ragdoll", context.getResources().getString(R.string.cat), "cat", "5 Month", "Male", R.drawable.ragdoll));
        dataItems.add(new DataItem("Toyger", context.getResources().getString(R.string.cat), "cat", "1 Year", "Female", R.drawable.toyger));
        dataItems.add(new DataItem("Turkish Van", context.getResources().getString(R.string.cat), "cat", "20 Year", "Male", R.drawable.turkish_van));
        return dataItems;
    }

    public ArrayList<DataItem> dataDogPet(Context context){
        ArrayList<DataItem> dataItems = new ArrayList<>();
        dataItems.add(new DataItem("Corgi", context.getResources().getString(R.string.dog), "dog", "5 Month", "Male", R.drawable.corgi));
        dataItems.add(new DataItem("Golden", context.getResources().getString(R.string.dog), "dog", "1 Year", "Female", R.drawable.golden));
        dataItems.add(new DataItem("Husky", context.getResources().getString(R.string.dog), "dog", "5 Year", "Male", R.drawable.husky));
        dataItems.add(new DataItem("Shih Tzu", context.getResources().getString(R.string.dog), "dog", "10 Year", "Male", R.drawable.shih_tzu));
        return dataItems;
    }

    public ArrayList<DataItem> dataReptilePet(Context context){
        ArrayList<DataItem> dataItems = new ArrayList<>();
        dataItems.add(new DataItem("Karma Bali Python", context.getResources().getString(R.string.reptile), "reptile", "5 Month", "Male", R.drawable.karma_bali));
        dataItems.add(new DataItem("Mexican Black Kingsnack", context.getResources().getString(R.string.reptile), "reptile", "2 Year", "Female", R.drawable.mexican_black));
        dataItems.add(new DataItem("Pled Pectinata", context.getResources().getString(R.string.reptile), "reptile", "10 Year", "Male", R.drawable.pled_pectinata));
        dataItems.add(new DataItem("Verrucosus Charmelon", context.getResources().getString(R.string.reptile), "reptile", "3 Year", "Male", R.drawable.verrucosus_charmelon));
        return dataItems;
    }

    public ArrayList<DataItem> dataSugarPet(Context context){
        ArrayList<DataItem> dataItems = new ArrayList<>();
        dataItems.add(new DataItem("Caramel", context.getResources().getString(R.string.sugar_glider), "sugar", "5 Month", "Male", R.drawable.caramel));
        dataItems.add(new DataItem("Classic", context.getResources().getString(R.string.sugar_glider), "sugar", "2 Month", "Female", R.drawable.classic));
        dataItems.add(new DataItem("Leucistic", context.getResources().getString(R.string.sugar_glider), "sugar", "1 Year", "Male", R.drawable.leucistic));
        dataItems.add(new DataItem("Piebald", context.getResources().getString(R.string.sugar_glider), "sugar", "1 Month", "Female", R.drawable.piebald));
        return dataItems;
    }
}
