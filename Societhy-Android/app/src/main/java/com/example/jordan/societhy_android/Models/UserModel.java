package com.example.jordan.societhy_android.Models;

/**
 * Created by jordan on 24/02/2016.
 */
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @JsonProperty("addresses")
    private List<String> addresses = new ArrayList<String>();
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("mail")
    private String mail;
    @JsonProperty("profilePic")
    private String profilePic;
    @JsonProperty("listOrga")
    private List<String> listOrga = new ArrayList<String>();
    @JsonProperty("transactionHistoric")
    private List<Object> transactionHistoric = new ArrayList<Object>();
    @JsonProperty("contacts")
    private List<String> contacts = new ArrayList<String>();
    /**
     *
     * @return
     * The addresses
     */
    public List<String> getAddresses() {
        return addresses;
    }

    /**
     *
     * @param addresses
     * The addresses
     */
    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    /**
     *
     * @return
     * The firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
     * The firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return
     * The lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     * The lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     * The nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname
     * The nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     *
     * @return
     * The mail
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @param mail
     * The mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     *
     * @return
     * The profilePic
     */
    public String getProfilePic() {
        return profilePic;
    }

    /**
     *
     * @param profilePic
     * The profilePic
     */
    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    /**
     *
     * @return
     * The listOrga
     */
    public List<String> getListOrga() {
        return listOrga;
    }

    /**
     *
     * @param listOrga
     * The listOrga
     */
    public void setListOrga(List<String> listOrga) {
        this.listOrga = listOrga;
    }

    /**
     *
     * @return
     * The transactionHistoric
     */
    public List<Object> getTransactionHistoric() {
        return transactionHistoric;
    }

    /**
     *
     * @param transactionHistoric
     * The transactionHistoric
     */
    public void setTransactionHistoric(List<Object> transactionHistoric) {
        this.transactionHistoric = transactionHistoric;
    }

    /**
     *
     * @return
     * The contacts
     */
    public List<String> getContacts() {
        return contacts;
    }

    /**
     *
     * @param contacts
     * The contacts
     */
    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }
}
