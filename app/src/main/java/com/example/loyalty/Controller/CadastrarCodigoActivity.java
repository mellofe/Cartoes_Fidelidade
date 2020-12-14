package com.example.loyalty.Controller;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loyalty.Model.Cliente;
import com.example.loyalty.Model.CodigoPontos;
import com.example.loyalty.Model.Empresa;
import com.example.loyalty.Model.Ponto;
import com.example.loyalty.R;
import com.example.loyalty.Util.BancoDadosSingleton;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class CadastrarCodigoActivity extends AppCompatActivity {
    private Cliente cliente = new Cliente("Cliente","cliente@email.com");
    private List<Ponto> pontos = new ArrayList<>();
    private List<Empresa> empresa = new ArrayList<>();
    private List<CodigoPontos> codigos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_codigo_cliente);

        Cursor c = BancoDadosSingleton.getInstance().buscar("codigo", new String[]{"idCodigo","texto","idEmpresa","validado","numeroDePontos","valorDaCompra"}, "","");
        while(c.moveToNext()) {
            int idC = c.getColumnIndex("idCodigo");
            int texto = c.getColumnIndex("texto");
            int val = c.getColumnIndex("validado");
            int numDePontos = c.getColumnIndex("numeroDePontos");
            int idEmpresa = c.getColumnIndex("idEmpresa");
            int valorCompra = c.getColumnIndex("valorDaCompra");

            CodigoPontos cod = new CodigoPontos();
            cod.setIdCodigo(c.getInt(idC));
            cod.setTexto(c.getString(texto));
            cod.setIdEmpresa(c.getInt(idEmpresa));
            cod.setValidado(c.getInt(val));
            cod.setNumeroPontos(c.getInt(numDePontos));
            cod.setValorCompra(c.getDouble(valorCompra));

            codigos.add(cod);

            Log.i("CODIGO: ", cod.getIdCodigo() + " " + cod.getTexto());

        }
        c.close();

    }

    public void Cadastrar(View v){
        EditText edtCodigo = findViewById(R.id.editTextCodigo);
        String Codigo = edtCodigo.getText().toString();

        for(int i = 0; i < codigos.size(); i++){
            if((codigos.get(i).getTexto()).equals(Codigo)){
                Log.i("CODIGO_FOR: ", codigos.get(i).getTexto());
                if((codigos.get(i).getValidado().equals(0))) {
                    //adiciona na classe Pontos
                    Ponto p = new Ponto();
                    p.setIdCliente(cliente.getIdCliente());
                    p.setIdEmpresa(codigos.get(i).getIdEmpresa());
                    p.setNumeroTotalPontos(codigos.get(i).getNumeroPontos());
                    pontos.add(p);

                    ContentValues valores = new ContentValues();
                    valores.put("validado",1);

                    BancoDadosSingleton.getInstance().atualizar("codigo", valores, "texto = '"+codigos.get(i).getTexto()+"'");
                    if(codigos.get(i).getNumeroPontos() == 1)
                        Toast.makeText(this,"Você ganhou " + String.valueOf(codigos.get(i).getNumeroPontos()) + " ponto",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(this,"Você ganhou " + String.valueOf(codigos.get(i).getNumeroPontos()) + " pontos",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this,"Código de Pontos já validado" ,Toast.LENGTH_LONG).show();
                }
                break;
            } else {
                Toast.makeText(this,"Código inválidado!" ,Toast.LENGTH_LONG).show();
            }
        }
       // finish();
    }
    public void ButtonHome(View view) {
        Intent it = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(it);
    }
}