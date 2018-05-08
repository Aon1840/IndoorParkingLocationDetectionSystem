package com.example.aon_attapon.indoorparkinglocationdetectionsystem.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Callback.onNetworkCallbackListener;
import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Connections.NetworkConnectionManager;
import com.example.aon_attapon.indoorparkinglocationdetectionsystem.Model.CarPosition;
import com.example.aon_attapon.indoorparkinglocationdetectionsystem.R;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

//    public static final String EXTRA_MESSAGE = ;

    private EditText edId;
    private Button btSend;
    private TextView tvResultPosiitonID,tvResultParkingTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstance();
    }

    private void initInstance() {
        edId = (EditText) findViewById(R.id.edId);
        btSend = (Button) findViewById(R.id.btSend);
        tvResultParkingTime = (TextView) findViewById(R.id.tvResultParkingTime);

        btSend.setOnClickListener(onBtSendClickListener);
    }

    View.OnClickListener onBtSendClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new NetworkConnectionManager().callServer(networkCallbackListener, edId.getId());
        }
    };

    onNetworkCallbackListener networkCallbackListener = new onNetworkCallbackListener() {
        @Override
        public void onResponse(CarPosition carPosition, Retrofit retrofit) {
            String data = "Parking Time : "+ carPosition.getTime_created();
            tvResultParkingTime.setText(data);
        }

        @Override
        public void onBodyError(ResponseBody responseBodyError) {

        }

        @Override
        public void onBodyErrorIsNull() {

        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

}
