package com.example.jordan.societhy_android.Models;

/**
 * Created by jordan on 29/02/2016.
 */
public class ProjectModel {
    private String name;
    private String addr;

    public ProjectModel(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() { return addr;}

    public void setAddr(String addr) { this.addr = addr; }
}
