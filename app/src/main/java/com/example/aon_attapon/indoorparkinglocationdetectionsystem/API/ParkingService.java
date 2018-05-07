package com.example.aon_attapon.indoorparkinglocationdetectionsystem.API;

import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model.CarPosition;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ParkingService {
    @GET("/carPosition/{user_id}")
    Call<CarPosition> getCarPositon(@Path("user_id") int user_id);
}
