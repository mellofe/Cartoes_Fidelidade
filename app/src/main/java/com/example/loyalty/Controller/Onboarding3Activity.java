package com.example.loyalty.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.loyalty.R;

public class Onboarding3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding3);
    }

    public void ButtonNext(View view) {
        Intent it = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(it);
    }
}