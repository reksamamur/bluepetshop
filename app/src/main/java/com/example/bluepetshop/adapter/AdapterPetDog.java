package com.example.bluepetshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepetshop.R;
import com.example.bluepetshop.addition.OnItemClickListener;
import com.example.bluepetshop.data.DataPets;
import com.example.bluepetshop.model.DataItem;
import com.google.android.material.card.MaterialCardView;

public class AdapterPetDog extends RecyclerView.Adapter<AdapterPetDog.AdapterPetsViewHolder> {

    String TAG = getClass().getSimpleName();
    private Context context;
    private OnItemClickListener listener;
    private DataPets dataPets;

    public AdapterPetDog(Context context, OnItemClickListener listener, DataPets dataPets) {
        this.context = context;
        this.listener = listener;
        this.dataPets = dataPets;
    }

    @NonNull
    @Override
    public AdapterPetsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.card_item, parent, false);
        return new AdapterPetsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPetsViewHolder holder, int position) {
        DataItem dataItem = dataPets.dataDogPet(context).get(position);
        holder.bind(dataItem, listener);
    }

    @Override
    public int getItemCount() {
        return dataPets.dataDogPet(context).size();
    }

    class AdapterPetsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvItemName, tvItemRace, tvItemAgeGender;
        MaterialCardView materialCardView;

        AdapterPetsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgItem);
            tvItemName = itemView.findViewById(R.id.tvNamaHewan);
            tvItemRace = itemView.findViewById(R.id.tvRace);
            tvItemAgeGender = itemView.findViewById(R.id.tvAgeGender);
            materialCardView = itemView.findViewById(R.id.cardItem);
        }

        void bind(final DataItem dataItem, final OnItemClickListener listener){
            tvItemName.setText(dataItem.getItemName());
            tvItemRace.setText(dataItem.getItemRace());
            imageView.setImageResource(dataItem.getItemImage());
            String combine = dataItem.getItemAge() + " " + dataItem.getItemGender();
            tvItemAgeGender.setText(combine);
            materialCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemCLick(dataItem);
                }
            });
        }
    }
}
