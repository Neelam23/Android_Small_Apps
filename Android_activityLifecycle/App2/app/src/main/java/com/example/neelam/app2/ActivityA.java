package com.example.neelam.app2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.os.Handler;



public class ActivityA extends Activity {

    TextView setv;
    private long counter;
    private long diffTime;
    private final Handler handler = new Handler();


    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        setv=(TextView)findViewById(R.id.textViewCounter);
    }



    public void start_counter(){

        counter = System.currentTimeMillis();
        handler.post(new Runnable() {

            @Override
            public void run() {

                diffTime = System.currentTimeMillis() - counter;
                setv.setText(Long.toString(diffTime / 1000));
                handler.postDelayed(this, 1000);
            }

        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putLong("counter", counter);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");

    }
    @Override
    protected void onStart() {
        super.onStart();
        start_counter();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        start_counter();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //pause the timer
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityA.this, ActivityDialog.class);
        startActivity(intent);

    }

    public void finishActivityA(View v) {
        ActivityA.this.finish();

    }



}
