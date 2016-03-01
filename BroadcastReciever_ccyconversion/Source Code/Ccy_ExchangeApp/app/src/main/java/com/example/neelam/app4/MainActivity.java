package com.example.neelam.app4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {

    private static final String tag = "TestReceiver";
    static TextView ccytextview;
    static TextView amttextview;
    TextView tv;
    TextView tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amttextview=(TextView)findViewById(R.id.coverter_amt);
        ccytextview=(TextView)findViewById(R.id.ccy_choice);

    }

    //sending broadcast back to app3
    public void sendBroadcast(View v){
        String actionString= "com.example.neelam.intents.TestResponse";
        Intent broadcastIntent = new Intent(actionString);
        String amtStr=amttextview.getText().toString();
        String ccy= ccytextview.getText().toString();
        broadcastIntent.putExtra("message","sending back from app4 to show converted amount");
        broadcastIntent.putExtra("amtStr",amtStr);
        broadcastIntent.putExtra("ccy",ccy);
        sendBroadcast(broadcastIntent);
        this.sendBroadcast(broadcastIntent);

    }

   //called to set TextView values
    public static void setValues(Context context,String string,String string2){

        ccytextview.setText(string);
        amttextview.setText(string2);
    }
   //called on click of cancel
    public void finishActivity(View v) {
        MainActivity.this.finish();

    }
}
