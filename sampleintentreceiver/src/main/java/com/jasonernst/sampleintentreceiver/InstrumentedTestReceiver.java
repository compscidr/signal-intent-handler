package com.jasonernst.sampleintentreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * This entire class must be compiled into the library
 */
public class InstrumentedTestReceiver extends BroadcastReceiver {

    public static final String XHIST_INTENT = "io.rightmesh.intent.XHIST";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("IR", "Received the intent");

        /// insert code here to call xhist.write ///
    }
}
