package com.example.loyalty.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.loyalty.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

    }
    public void ButtonCodigo(View view) {
        Intent it = new Intent(getBaseContext(), GerarCodigoActivity.class);
        startActivity(it);
    }
}