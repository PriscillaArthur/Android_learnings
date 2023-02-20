package com.example.cryptocard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private Context context;
    private List<CoinItem> data;


    public CoinAdapter(List<CoinItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_coinitem, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CoinItem coinItem = data.get(position);

        holder.TextViewTitle.setText(coinItem.getName());
        holder.TextViewSubstitle.setText(coinItem.getSymbol());
        holder.CardViewIconState.setCardBackgroundColor(coinItem.getCoinStatusColor());
        holder.ImageViewIcon.setImageResource(coinItem.getIconImageResource());


        if (coinItem.isActive()) {
            //TODO:set small card background
        } else {

        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}