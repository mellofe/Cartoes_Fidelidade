package com.example.loyalty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loyalty.Controller.CadastrarCodigoActivity;
import com.example.loyalty.Controller.GerarCodigoActivity;

public class home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    public void ButtonCodigo(View view) {
        Intent it = new Intent(getBaseContext(), GerarCodigoActivity.class);
        startActivity(it);
    }
}
