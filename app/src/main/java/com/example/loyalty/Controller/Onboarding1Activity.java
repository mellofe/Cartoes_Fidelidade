package com.example.loyalty.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.loyalty.R;

public class Onboarding1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButtonNext(View view) {
        Intent it = new Intent(getBaseContext(), Onboarding2Activity.class);
        startActivity(it);
    }
}