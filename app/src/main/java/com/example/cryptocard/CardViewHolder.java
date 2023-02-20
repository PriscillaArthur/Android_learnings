package com.example.cryptocard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CardViewHolder extends RecyclerView.ViewHolder {
    public ImageView ImageViewIcon;
    public CardView CardViewIconState;
    public TextView TextViewTitle;
    public TextView TextViewSubstitle;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        ImageViewIcon=itemView.findViewById(R.id.imageViewInCard);
        CardViewIconState=itemView.findViewById(R.id.cardViewState);
        TextViewTitle=itemView.findViewById(R.id.cardName1);
        TextViewSubstitle=itemView.findViewById(R.id.cardName2);

    }



}
