package com.example.loyalty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void ButtonEntrar(View view) {
        Intent it = new Intent(getBaseContext(), home.class);
        startActivity(it);
    }
}