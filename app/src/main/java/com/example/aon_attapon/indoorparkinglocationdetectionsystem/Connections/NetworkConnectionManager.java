package com.example.aon_attapon.indoorparkinglocationdetectionsystem.Connections;

import android.util.Log;

import com.example.aon_attapon.indoorparkinglocationdetectionsystem.API.ParkingService;
import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Callback.onNetworkCallbackListener;
import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model.CarPosition;
import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model.User;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkConnectionManager {
    public NetworkConnectionManager(){

    }

    public void callServer(final onNetworkCallbackListener listener, int user_id){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://13.251.7.40:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ParkingService parkingService = retrofit.create(ParkingService.class);
        Log.d("user_id", user_id + "");
        Call call = parkingService.getUser(user_id);
//        Call<Map<String, String>> call = parkingService.getUser2(user_id);
        Log.d("user", call + "");
//        call.enqueue(new Callback<Map<String, String>>() {
//            @Override
//            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
//                Log.d("response.body", response.body() + "");
//            }
//
//            @Override
//            public void onFailure(Call<Map<String, String>> call, Throwable t) {
//                Log.d("response error", t.getMessage());
//            }
//        });
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("response", response + "");
                User user = response.body();

                if (user == null){ //error 400
                    ResponseBody responseBody = response.errorBody();
                    if(responseBody != null){
                        listener.onBodyError(responseBody);
                    }else {
                        listener.onBodyErrorIsNull();
                    }
                }else {
                    listener.onResponse(user, retrofit);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.onFailure(t);
            }
        });

//        ParkingService parking = retrofit.create(ParkingService.class);
//        Call call = parking.getCarPositon(user_id);
//        call.enqueue(new Callback<CarPosition>() {
//            @Override
//            public void onResponse(Call<CarPosition> call, Response<CarPosition> response) {
//                CarPosition car = response.body();
//
//                if (car == null){
//                    ResponseBody responseBody = response.errorBody();
//                    if(responseBody != null){
//                        listener.onBodyError(responseBody);
//                    }else{
//                        listener.onBodyErrorIsNull();
//                    }
//                }else {
//                    listener.onResponse(car, retrofit);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CarPosition> call, Throwable t) {
//                listener.onFailure(t);
//            }
//        });
    }
}
