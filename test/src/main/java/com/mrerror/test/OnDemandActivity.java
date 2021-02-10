package com.mrerror.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.play.core.splitcompat.SplitCompat;


public class OnDemandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_demand);
        SplitCompat.install(this);
        Toast.makeText(this, "OnDemand", Toast.LENGTH_SHORT).show();
        // START aar
       // startActivity(new Intent(this, MainActivity.class));
    }
}