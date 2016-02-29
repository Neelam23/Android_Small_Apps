package com.example.neelam.app2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
/**
 * Created by Neelam on 2/21/2016.
 */
public class ActivityB extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    public void finishActivityB(View v) {
        ActivityB.this.finish();

    }
}
