package com.example.jordan.societhy_android.Models;

/**
 * Created by aureliengiudici on 18/02/2016.
 */
public class OrganisationModel {
    private String name;
    private String dateC;
    private String addr;

    public OrganisationModel() {

    }

    public OrganisationModel(String name, String dateC, String addr) {
        this.name = name;
        this.dateC = dateC;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateC() {
        return dateC;
    }

    public void setDateC(String dateC) {
        this.dateC = dateC;
    }

    public String getAddr() { return this.addr; }

    public void setAddr(String add) { this.addr = addr; }
}
