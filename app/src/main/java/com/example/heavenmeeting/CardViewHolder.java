package com.example.heavenmeeting;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import org.w3c.dom.Text;

public class CardViewHolder extends RecyclerView.ViewHolder {


    private TextView textViewTitle;
    private TextView textViewTimeCard;
    private TextView textViewDiscussionText;


//    private CardView cardViewBackground1;
//    private CardView cardViewBackground2;



    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        this.textViewTitle=itemView.findViewById(R.id.textViewTitle);
        this.textViewTimeCard=itemView.findViewById(R.id.textViewTimeCard);
        this.textViewDiscussionText=itemView.findViewById(R.id.textViewDiscussionText);

    }

    public TextView getTextViewDiscussionText() {
        return textViewDiscussionText;
    }

    public TextView getTextViewTimeCard() {
        return textViewTimeCard;
    }

    public TextView getTextViewTitle() {
        return textViewTitle;
    }
}
