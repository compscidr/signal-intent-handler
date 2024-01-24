package com.jasonernst.sampleintentreceiver;

import static com.jasonernst.sampleintentreceiver.InstrumentedTestReceiver.XHIST_INTENT;

import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //this need to be added to RightMeshMainActivity
    InstrumentedTestReceiver instrumentedTestReceiver = new InstrumentedTestReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this should be stuck into the main activity of the RightMeshController
        //ie: right after the onCreate in RightMeshMainActivity
        getApplicationContext().registerReceiver(instrumentedTestReceiver,
                new IntentFilter(XHIST_INTENT));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //this need to be added to RightMeshMainActivity
        getApplicationContext().unregisterReceiver(instrumentedTestReceiver);
    }
}
