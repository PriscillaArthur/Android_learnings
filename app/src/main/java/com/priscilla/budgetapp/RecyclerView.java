package com.priscilla.budgetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.priscilla.budgetapp.adapter.HomeFeedAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recyclerview);

        androidx.recyclerview.widget.RecyclerView recyclerviewHomeFeed=findViewById(R.id.recyclerViewHomeFeed);
        LinearLayoutManager linearlayoutmanager=new LinearLayoutManager(RecyclerView.this,LinearLayoutManager.VERTICAL,false);
        recyclerviewHomeFeed.setLayoutManager(linearlayoutmanager);

        List<String> data=new ArrayList<>();
        data.add("Hello");
        data.add("Hello");
        data.add("Hello");
        data.add("Hello");
        data.add("Hello");
        data.add("Hello");
        data.add("Hello");
        data.add("Hello");
        HomeFeedAdapter homeFeedAdapter=new HomeFeedAdapter(RecyclerView.this,data);

        recyclerviewHomeFeed.setAdapter(homeFeedAdapter);

    }
    }
