package com.example.heavenmeeting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CardItem> data = new ArrayList<>();
    CardAdapter cardAdapter=new CardAdapter(data);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView=findViewById(R.id.recyclerViewHeavenMeeting);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cardAdapter);


      getRemoteData();
}

    private void getRemoteData(){
        String urls="https://quotable.io/quotes";
        Ion.with(this)
                .load(urls)
                .asJsonObject()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonObject>>() {


                    @Override
                    public void onCompleted(Exception e, Response<JsonObject> response) {



                        if (e != null || response.getHeaders().code() != 200) {
                            return;
                        }


                        // do stuff with the result or error

                        JsonArray jsonArray = response.getResult().getAsJsonObject().get("results").getAsJsonArray();

                        for (int i = 0; i < jsonArray.size(); i++) {
                            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                            CardItem carditem = new CardItem(jsonObject);
                            data.add(carditem);
                        }
                        cardAdapter.notifyDataSetChanged();
                    }
                });

}
}