package com.example.loyalty.Controller;

import android.os.Bundle;

import com.example.loyalty.R;

import androidx.appcompat.app.AppCompatActivity;

public class GerarCodigoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_codigo_empresa);
    }
}