package com.example.jordan.societhy_android.Models;

/**
 * Created by aureliengiudici on 18/02/2016.
 */
public class UserModelTmp {
    private String Login;
    private String FirstName;
    private String LastName;
    private String bithDate;
    private String genre;
    private String presentation;

    public UserModelTmp() {
    }

    public UserModelTmp(String login) {
        Login = login;
    }

    public UserModelTmp(String login, String firstName, String lastName, String bithDate, String genre, String presentation) {
        Login = login;
        FirstName = firstName;
        LastName = lastName;
        this.bithDate = bithDate;
        this.genre = genre;
        this.presentation = presentation;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getBithDate() {
        return bithDate;
    }

    public void setBithDate(String bithDate) {
        this.bithDate = bithDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "Login='" + Login + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", bithDate='" + bithDate + '\'' +
                ", genre='" + genre + '\'' +
                ", presentation='" + presentation + '\'' +
                '}';
    }
}
