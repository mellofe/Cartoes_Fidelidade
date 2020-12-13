package com.example.loyalty.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.loyalty.R;
import com.example.loyalty.home;

import androidx.appcompat.app.AppCompatActivity;

public class GerarCodigoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_codigo_empresa);
    }
    public void ButtonHome(View view) {
        Intent it = new Intent(getBaseContext(), home.class);
        startActivity(it);
    }
}