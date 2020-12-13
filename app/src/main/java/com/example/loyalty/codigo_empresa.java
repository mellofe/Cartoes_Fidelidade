package com.example.loyalty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class codigo_empresa extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_empresa);

    }
    public void ButtonHome(View view) {
        Intent it = new Intent(getBaseContext(), home.class);
        startActivity(it);
    }
}
