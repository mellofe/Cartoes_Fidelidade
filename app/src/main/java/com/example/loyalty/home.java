package com.example.loyalty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    public void ButtonCodigo(View view) {
        Intent it = new Intent(getBaseContext(), codigo_empresa.class);
        startActivity(it);
    }
}
