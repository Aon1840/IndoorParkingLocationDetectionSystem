package com.example.aon_attapon.indoorparkinglocationdetectionsystem.Connections;

import com.example.aon_attapon.indoorparkinglocationdetectionsystem.API.ParkingService;
import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Callback.onNetworkCallbackListener;
import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model.CarPosition;

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
                .baseUrl("http://localhost:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ParkingService parking = retrofit.create(ParkingService.class);
        Call call = parking.getCarPositon(user_id);
        call.enqueue(new Callback<CarPosition>() {
            @Override
            public void onResponse(Call<CarPosition> call, Response<CarPosition> response) {
                CarPosition car = response.body();

                if (car == null){
                    ResponseBody responseBody = response.errorBody();
                    if(responseBody != null){
                        listener.onBodyError(responseBody);
                    }else{
                        listener.onBodyErrorIsNull();
                    }
                }else {
                    listener.onResponse(car, retrofit);
                }
            }

            @Override
            public void onFailure(Call<CarPosition> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }
}
