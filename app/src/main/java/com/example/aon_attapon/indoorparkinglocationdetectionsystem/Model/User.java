package com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class User {
    @Expose
    int user_id;
    @Expose
    String username;
    @Expose
    String password;
    @Expose
    String name;
    @Expose
    String surname;
    @Expose
    String tel;
    @Expose
    String email;
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
