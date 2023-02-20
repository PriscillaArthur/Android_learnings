package com.example.heavenmeeting;

import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CardItem {
    private String id;
    private String author;
    private String content;
    private ArrayList<String> tags = new ArrayList<>();
    private String date;


    public CardItem(String id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.tags = tags;
        this.date = date;
    }

    public CardItem(JsonObject jsonObject) {
        this.id = jsonObject.get("_id").getAsString();
        this.author = jsonObject.get("author").getAsString();
        this.content = jsonObject.get("content").getAsString();
        this.date = jsonObject.get("dateAdded").getAsString();


        jsonObject.get("tags").getAsJsonArray().forEach(item -> {
            this.tags.add(item.getAsString().substring(0,1).toUpperCase());
        });
    }

    private String formatDate(String responseDate) {

        String outputDateString = "";

        SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormatter = new SimpleDateFormat("dd MMMM yyyy");


        try {
            Date date = inputFormatter.parse(responseDate);
            outputDateString = outputFormatter.format(date);

        } catch (ParseException e) {
            System.out.println("Unable to parse the date: " + e.getMessage());
        }

        return outputDateString;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public ArrayList<String> getTags() {
        return tags;
    }
}
