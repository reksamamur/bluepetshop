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

import java.util.ArrayList;

public class AdapterRecommend extends RecyclerView.Adapter<AdapterRecommend.AdapterReacommendViewHolder> {

    private Context context;
    private OnItemClickListener listener;
    private DataPets dataPets;

    public AdapterRecommend(Context context, DataPets dataPets, OnItemClickListener listener) {
        this.context = context;
        this.dataPets = dataPets;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterReacommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.card_item, parent, false);
        return new AdapterReacommendViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterReacommendViewHolder holder, int position) {
        holder.bind(dataPets.mainDataItems(context).get(position), listener);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class AdapterReacommendViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvItemName, tvItemRace, tvItemAgeGender;
        MaterialCardView materialCardView;

        AdapterReacommendViewHolder(@NonNull View itemView) {
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
