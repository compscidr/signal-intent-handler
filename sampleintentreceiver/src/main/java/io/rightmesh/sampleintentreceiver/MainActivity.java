package io.rightmesh.sampleintentreceiver;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.PluginStub;

import static io.rightmesh.sampleintentreceiver.InstrumentedTestReceiver.XHIST_INTENT;

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
