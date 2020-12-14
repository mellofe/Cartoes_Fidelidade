package com.example.loyalty.Controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.loyalty.Model.Cliente;
import com.example.loyalty.Model.CodigoPontos;
import com.example.loyalty.Model.Empresa;
import com.example.loyalty.Model.Ponto;
import com.example.loyalty.R;
import com.example.loyalty.Util.BancoDadosSingleton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GerarCodigoActivity extends AppCompatActivity {
    private Empresa empresa = new Empresa(2,"acai@email.com", 0, 10);
    private List<CodigoPontos> codigos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_codigo_empresa);

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

        }
        c.close();
    }

    public void Gerar(View v){
        EditText edtValorCompra = findViewById(R.id.editTextValorCompra);
        TextView codigo = findViewById(R.id.textViewCodigoGerado);

        Double valorCompra = Double.parseDouble(edtValorCompra.getText().toString());
        double resultado = valorCompra/empresa.getPrecoPonto();

        int numeroDePontos = (int)resultado;

        ContentValues valores = new ContentValues();
        valores.put("texto","COD" + numeroDePontos + empresa.getIdEmpresa() + (codigos.size()+1));
        valores.put("idEmpresa",empresa.getIdEmpresa());
        valores.put("validado",0);
        valores.put("numeroDePontos",numeroDePontos);
        valores.put("valorDaCompra",valorCompra);

        BancoDadosSingleton.getInstance().inserir("codigo", valores);

        codigo.setText("COD" + numeroDePontos + empresa.getIdEmpresa() + (codigos.size()+1));

        CodigoPontos cod = new CodigoPontos();
        //cod.setIdCodigo((codigos.size()+1));
        cod.setTexto("COD" + numeroDePontos + empresa.getIdEmpresa() + (codigos.size()+1));
        cod.setIdEmpresa(empresa.getIdEmpresa());
        cod.setValidado(0);
        cod.setNumeroPontos(numeroDePontos);
        cod.setValorCompra(valorCompra);

        codigos.add(cod);
    }
}