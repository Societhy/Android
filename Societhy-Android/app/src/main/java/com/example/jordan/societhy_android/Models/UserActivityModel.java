package com.example.jordan.societhy_android.Models;

/**
 * Created by aureliengiudici on 18/02/2016.
 */
public class UserActivityModel {
    private String date;
    private String ActivityContent;

    public UserActivityModel() {

    }

    public UserActivityModel(String date, String activityContent) {
        this.date = date;
        ActivityContent = activityContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivityContent() {
        return ActivityContent;
    }

    public void setActivityContent(String activityContent) {
        ActivityContent = activityContent;
    }

    @Override
    public String toString() {
        return "UserActivityModel{" +
                "date=" + date +
                ", ActivityContent=" + ActivityContent +
                '}';
    }
}
