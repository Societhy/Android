package com.example.jordan.societhy_android.Models;

/**
 * Created by jordan on 17/02/2016.
 */
public class NewsModel {
    private String organizationName;
    private String newsContent;
    private String date;

    public NewsModel() {

    }

    public NewsModel(String organizationName, String newsContent, String date) {
        this.organizationName = organizationName;
        this.newsContent = newsContent;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "organizationName='" + organizationName + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
