package com.example.loyalty.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loyalty.R;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
    }
    public void ButtonEntrar(View view) {
        EditText edtUsuario = findViewById(R.id.editTextUsuario);
        EditText edtSenha = findViewById(R.id.editTextSenha);

        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        if(usuario.equals("cliente@email.com") && senha.equals("123")){
            Intent it = new Intent(getBaseContext(), CadastrarCodigoActivity.class);
            startActivity(it);
        } else if(usuario.equals("acai@email.com") && senha.equals("123")) {
            Intent it = new Intent(getBaseContext(), GerarCodigoActivity.class);
            startActivity(it);
        }
        else Toast.makeText(this,"Usuário/senha inválidos", Toast.LENGTH_LONG).show();
    }
}