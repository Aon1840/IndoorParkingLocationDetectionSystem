package com.example.aon_attapon.indoorparkinglocationdetectionsystem.API;

import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model.CarPosition;
import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ParkingService {
    @GET("/users/{user_id}")
    Call<User> getUser(@Path("user_id") int user_id);

    @GET("/users/{user_id}")
    Call<Map<String, String>> getUser2(@Path("user_id") int user_id);
}
