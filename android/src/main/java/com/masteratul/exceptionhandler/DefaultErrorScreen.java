package com.masteratul.exceptionhandler;

import android.app.Activity;
import android.os.Bundle;

public class DefaultErrorScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }
}