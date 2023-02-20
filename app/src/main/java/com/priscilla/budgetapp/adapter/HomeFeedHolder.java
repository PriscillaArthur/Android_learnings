package com.priscilla.budgetapp.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.priscilla.budgetapp.R;

public class HomeFeedHolder extends RecyclerView.ViewHolder{

    private TextView textViewTitle;
    private ImageView imageView;

    public HomeFeedHolder(@NonNull View itemView) {
        super(itemView);
        textViewTitle=itemView.findViewById(R.id.textViewTitle);
        imageView=itemView.findViewById(R.id.imageViewContent);
    }


    public TextView getTextViewTitle(){
        return textViewTitle;
    }

    public void setTextViewTitle(TextView textViewTitle) {
        this.textViewTitle = textViewTitle;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
