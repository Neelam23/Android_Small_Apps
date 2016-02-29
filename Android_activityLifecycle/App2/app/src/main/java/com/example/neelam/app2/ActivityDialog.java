package com.example.neelam.app2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.View;

/**
 * Created by Neelam on 2/21/2016.
 */
public class ActivityDialog extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
    }

    public void finishDialog(View v) {

        ActivityDialog.this.finish();
    }


}
