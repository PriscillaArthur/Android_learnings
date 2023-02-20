package com.priscilla.budgetapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.priscilla.budgetapp.R;

import java.util.List;

public class HomeFeedAdapter extends RecyclerView.Adapter<HomeFeedHolder> {
    private Context context;
    private List<String> data;

    public HomeFeedAdapter(Context context, List<String> data){
        this.context=context;
        this.data= data;
    }
    @NonNull
    @Override
    public HomeFeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_feed_item,parent);
        return new HomeFeedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFeedHolder holder, int position) {
        String text=data.get(position);
        holder.getTextViewTitle().setText(text);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
