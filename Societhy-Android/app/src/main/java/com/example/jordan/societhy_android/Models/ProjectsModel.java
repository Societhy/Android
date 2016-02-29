package com.example.jordan.societhy_android.Models;

/**
 * Created by aureliengiudici on 29/02/2016.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class ProjectsModel {
    @JsonProperty("addresses")
    private String address;
    @JsonProperty("name")
    private String name;
    @JsonProperty("orgaAddress")
    private String orgaAddress;
    @JsonProperty("description")
    private String description;
    @JsonProperty("memberList")
    private List<Object> memberList = new ArrayList<Object>();
    //Todo add FuncRaising : obj -> {int amount, bool isAccept}
    //private FundRaising fundRaising
    @JsonProperty("review")
    private List<Object> review = new ArrayList<Object>();
    @JsonProperty("files")
    private List<Object> files = new ArrayList<Object>();
    @JsonProperty("Id")
    private String Id;


    public ProjectsModel() {}
    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The orgaAddress
     */
    public String getOrgaAddress() {
        return orgaAddress;
    }

    /**
     *
     * @param orgaAddress
     * The orgaAddress
     */
    public void setOrgaAddress(String orgaAddress) {
        this.orgaAddress = orgaAddress;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The memberList
     */
    public List<Object> getMemberList() {
        return memberList;
    }

    /**
     *
     * @param memberList
     * The memberList
     */
    public void setMemberList(List<Object> memberList) {
        this.memberList = memberList;
    }



    /**
     *
     * @return
     * The review
     */
    public List<Object> getReview() {
        return review;
    }

    /**
     *
     * @param review
     * The review
     */
    public void setReview(List<Object> review) {
        this.review = review;
    }

    /**
     *
     * @return
     * The files
     */
    public List<Object> getFiles() {
        return files;
    }

    /**
     *
     * @param files
     * The files
     */
    public void setFiles(List<Object> files) {
        this.files = files;
    }

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

}