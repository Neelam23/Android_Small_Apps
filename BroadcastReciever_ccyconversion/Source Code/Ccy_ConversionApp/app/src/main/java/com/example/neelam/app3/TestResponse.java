package com.example.neelam.app3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Neelam on 3/1/2016.
 */
public class TestResponse extends BroadcastReceiver {


    private static final String tag = "TestResponse";
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d(tag, "intent=" + intent);
        String message = intent.getStringExtra("message");  //getting extra string message
        String amtStr = intent.getStringExtra("amtStr");                  //getting amount  string value
        String ccy =intent.getStringExtra("ccy");     //getting ccy string value
       //Displaying values in debug messages on console
        Log.d(tag, message);
        Log.d(tag, amtStr);
        Log.d(tag, ccy);
        //calling static method of MainActivity calss to set these amount and ccy vlue in the UI TextViews
        MainActivity.showValues(context, amtStr, ccy);

    }
}
