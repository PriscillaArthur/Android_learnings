package com.example.cryptocard;

import com.google.gson.JsonObject;

import java.util.Objects;

public class CoinItem {

    private final String id;
    private final String name;
    private final String symbol;
    private final int rank;
    private final boolean isNew;
    private final boolean isActive;
    private final String type;

   public CoinItem(JsonObject jsonObject){
       this.id= jsonObject.get("id").getAsString();
       this.name= jsonObject.get("name").getAsString();
       this.rank= jsonObject.get("rank").getAsInt();
       this.type= jsonObject.get("type").getAsString();
       this.symbol= jsonObject.get("symbol").getAsString();
       this.isActive=jsonObject.get("isActive").getAsBoolean();
       this.isNew=jsonObject.get("isNew").getAsBoolean();
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public String getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }


    public boolean isActive() {
       return isActive;
    }

    public boolean isNew() {
        return isNew;
    }

    public int getCoinStatusColor(){
       if (isActive){
           return R.color.green;
       }else {
           return  R.color.red;
       }
   }

    public int getIconImageResource() {
       if(Objects.equals(type, "coin")){
           return R.mipmap.bitcoin;
       } else if(Objects.equals(type, "token")){
           return R.mipmap.bitcoin;
       } else {
           return R.mipmap.bitcoin;
       }
    }
}

