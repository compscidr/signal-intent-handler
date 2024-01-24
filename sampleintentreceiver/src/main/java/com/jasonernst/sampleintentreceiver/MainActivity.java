package com.jasonernst.sampleintentreceiver;

import static com.jasonernst.sampleintentreceiver.InstrumentedTestReceiver.XHIST_INTENT;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //this need to be added to RightMeshMainActivity
    InstrumentedTestReceiver instrumentedTestReceiver = new InstrumentedTestReceiver();

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this should be stuck into the main activity of the RightMeshController
        //ie: right after the onCreate in RightMeshMainActivity
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            getApplicationContext().registerReceiver(instrumentedTestReceiver,
                    new IntentFilter(XHIST_INTENT), Context.RECEIVER_NOT_EXPORTED);
        } else {
            getApplicationContext().registerReceiver(instrumentedTestReceiver,
                    new IntentFilter(XHIST_INTENT));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //this need to be added to RightMeshMainActivity
        getApplicationContext().unregisterReceiver(instrumentedTestReceiver);
    }
}
