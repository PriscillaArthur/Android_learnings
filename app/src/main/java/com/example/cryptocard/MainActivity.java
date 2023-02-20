package com.example.cryptocard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CoinItem> list = new ArrayList<>();
    private CoinAdapter coinAdapter = new CoinAdapter(list);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        Toolbar toolbar =findViewById(R.id.RecyclerView);
        setSupportActionBar(toolbar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        recyclerView.setAdapter(coinAdapter);


//        ImageView ImageView;
//        TextView TextView;
//
//        ImageView= (ImageView) findViewById(R.id.ImageView1);
//        TextView=(TextView) findViewById(R.id.TextView1);





        getRemoteData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)  {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_refresh){
            list.clear();
            coinAdapter.notifyDataSetChanged();
            getRemoteData();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getRemoteData() {
        String urls = "https://api.coinpaprika.com/v1/coins";
        Ion.with(this)
                .load(urls)
                .asJsonArray()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonArray>>() {

                    @Override
                    public void onCompleted(Exception e, Response<JsonArray> result) {
                        if (e != null || result.getHeaders().code() != 200) {
                            return;
                        }
                        // do stuff with the result or error

                        JsonArray jsonArray = result.getResult();

                        for (int i = 0; i < jsonArray.size(); i++) {
                            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                            CoinItem coinitem = new CoinItem(jsonObject);


                            list.add(coinitem);

                        }
                        coinAdapter.notifyDataSetChanged();
                    }
                });


    }

}


