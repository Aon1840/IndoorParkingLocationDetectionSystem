package com.example.aon_attapon.indoorparkinglocationdetectionsystem.API;

import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model.CarPosition;
import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ParkingService {
    @GET("/username/{user_id}")
    Call<CarPosition> getCarPositon(@Path("user_id") int user_id);

    @GET("/users/{user_id}")
    Call<User> getUser(@Path("user_id") int user_id);
}
