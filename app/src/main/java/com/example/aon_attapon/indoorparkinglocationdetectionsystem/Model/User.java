package com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {
    @SerializedName("user_id")
    @Expose
    int user_id;

    @SerializedName("username")
    @Expose
    String username;

    @SerializedName("password")
    @Expose
    String password;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("surname")
    @Expose
    String surname;

    @SerializedName("tel")
    @Expose
    String tel;

    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("register_date")
    @Expose
    Date register_date;

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegister_date() {
        return register_date;
    }
}
