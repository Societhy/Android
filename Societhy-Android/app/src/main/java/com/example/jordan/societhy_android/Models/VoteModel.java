package com.example.jordan.societhy_android.Models;

/**
 * Created by jordan on 01/03/2016.
 */
public class VoteModel {
    private int likes;
    private int dislikes;
    private String VoteContent;

    public VoteModel(int likes, int dislikes, String voteContent) {
        this.likes = likes;
        this.dislikes = dislikes;
        VoteContent = voteContent;
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

    public String getVoteContent() {
        return VoteContent;
    }

    public void setVoteContent(String voteContent) {
        VoteContent = voteContent;
    }
}
