package com.example.loyalty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loyalty.Controller.LoginActivity;

public class onboarding3 extends AppCompatActivity {
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