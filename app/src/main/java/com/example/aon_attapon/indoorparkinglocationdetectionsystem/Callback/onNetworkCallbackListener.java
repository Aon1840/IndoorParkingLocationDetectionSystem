package com.example.aon_attapon.indoorparkinglocationdetectionsystem.Callback;

import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model.CarPosition;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public interface onNetworkCallbackListener {
    public void onResponse(CarPosition carPosition, Retrofit retrofit);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
