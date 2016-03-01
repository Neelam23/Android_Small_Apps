package com.example.neelam.app3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    EditText et;
    static TextView textView;
    static String dollar_amount;
    String conversion_ccy;
    Double converted_amount;
    private Spinner spinner;
    private static final String[]paths = {"Euro", "Indian Rupee", "British Pound"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    //   spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        textView=(TextView)findViewById(R.id.response);
    }


    //convert
    public void convert(View V){
        Log.d("print", "in convert function");
        et=(EditText)findViewById(R.id.amount);
        String amountString= et.getText().toString();
        dollar_amount=amountString;
        double amount= Double.parseDouble(amountString);
        conversion_ccy = String.valueOf(spinner.getSelectedItem());
        Log.d("print", conversion_ccy);
        if(conversion_ccy=="Euro")
            converted_amount= amount/1.087;

        else if(conversion_ccy=="British Pound")
            converted_amount=amount/1.391;

            else
            converted_amount=amount*68.20;

        testSendBroadcast(converted_amount, conversion_ccy);
    }


    //broadcast method to send broadcast to app4
    public void testSendBroadcast(double converted_amount, String conversion_ccy){

        String actionString= "com.example.neelam.intents.TestReceiver";
        Intent broadcastIntent = new Intent(actionString);
        broadcastIntent.putExtra("message","Hello i have info");
        broadcastIntent.putExtra("conversion_ccy",conversion_ccy);
        broadcastIntent.putExtra("converted_amount",converted_amount);
        sendBroadcast(broadcastIntent);
        this.sendBroadcast(broadcastIntent);
    }

    //Receive broadcast and show message
    public static void showValues(Context context,String amtStr,String ccy){
        textView.setText("Dollar amount $" + dollar_amount + " converted to " + amtStr + " " + ccy);
    }

    //finish main activity
    public void finishActivity(View v) {
        MainActivity.this.finish();

    }


}
