package com.example.loyalty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class onboarding2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_onboarding2);

    }
    public void ButtonNext(View view) {
        Intent it = new Intent(getBaseContext(), onboarding3.class);
        startActivity(it);
    }
}
