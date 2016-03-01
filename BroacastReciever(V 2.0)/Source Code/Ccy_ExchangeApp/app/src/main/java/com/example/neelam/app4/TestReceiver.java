package com.example.neelam.app4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Neelam on 2/28/2016.
 */
public class TestReceiver extends BroadcastReceiver {

    MainActivity mActivity;
    private static final String tag = "TestReceiver";

    @Override
    public void onReceive(Context context, Intent intent)
    {


        mActivity = new MainActivity();



        Log.d("TestReceiver", "intent=" + intent);
        String message = intent.getStringExtra("message");  //getting extra string message
        Double amount=intent.getDoubleExtra("converted_amount",-1);//getting extra Double converted amount value
        String amtStr = String.valueOf(amount);                  //typecasting Double amount to String using autoboxing
        String ccy =intent.getStringExtra("conversion_ccy");     //getting ccy string value
        //Displaying values in debug messages on console
        Log.d(tag, message);
        Log.d(tag, amtStr);
        Log.d(tag, ccy);
        //calling static method of MainActivity calss to set these amount and ccy vlue in the UI TextViews
        MainActivity.setValues(context, ccy, amtStr);
//        mActivity.a=amtStr;
//        mActivity.b=ccy;
//        Intent i = new Intent(context, MainActivity.class);
//        context.startActivity(i);
       // context.startActivity();
    }
}
