package com.example.jordan.societhy_android.Models;

/**
 * Created by jordan on 01/03/2016.
 */
public class VoteModel {
    private int likes;
    private int dislikes;
    private String name;
    private double amount;
    private String description;

    public VoteModel(int likes, int dislikes, String name, double amount, String description) {
        this.likes = likes;
        this.dislikes = dislikes;
        this.description = description;
        this.amount = amount;
        this.description = description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
