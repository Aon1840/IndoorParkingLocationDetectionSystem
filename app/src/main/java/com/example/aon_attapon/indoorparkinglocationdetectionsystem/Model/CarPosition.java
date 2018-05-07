package com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class CarPosition {

    @Expose
    int carPosition_id;
    @Expose
    int position_id;
    @Expose
    int user_id;
    @Expose
    boolean is_driveOut;
    @Expose
    Date time_created;

    public int getCarPosition_id() {
        return carPosition_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public boolean isIs_driveOut() {
        return is_driveOut;
    }

    public Date getTime_created() {
        return time_created;
    }
}
