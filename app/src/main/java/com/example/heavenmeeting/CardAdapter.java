package com.example.heavenmeeting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private ArrayList<CardItem> data;

    public CardAdapter(ArrayList<CardItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
       CardItem cardItem = data.get(position);
       holder.getTextViewTitle().setText(cardItem.getAuthor());
       holder.getTextViewTimeCard().setText(cardItem.getDate());
       holder.getTextViewDiscussionText().setText(cardItem.getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
