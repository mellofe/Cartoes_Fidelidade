package com.example.loyalty.Controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loyalty.Model.Cliente;
import com.example.loyalty.Model.CodigoPontos;
import com.example.loyalty.Model.Empresa;
import com.example.loyalty.R;
import com.example.loyalty.Util.BancoDadosSingleton;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class CadastrarCodigoActivity extends AppCompatActivity {
    private Cliente c;  //inicializa manualmente
    //private Pontos p;
    private List<Empresa> empresa;
    private List<CodigoPontos> codigos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_codigo_cliente);

        Cursor c = BancoDadosSingleton.getInstance().buscar("codigo", new String[]{"idCodigo","idEmpresa","validado","numeroDePontos","valorDaCompra"}, "","");
        while(c.moveToNext()) {
            int idC = c.getColumnIndex("idCodigo");
            int val = c.getColumnIndex("validado");
            int numDePontos = c.getColumnIndex("numeroDePontos");
            int idEmpresa = c.getColumnIndex("idEmpresa");
            int valorCompra = c.getColumnIndex("valorDaCompra");

            CodigoPontos cod = new CodigoPontos();
            cod.setIdCodigo(c.getString(idC));
            cod.setIdEmpresa(c.getInt(idEmpresa));
            cod.setValidado(c.getInt(val));
            cod.setNumeroPontos(c.getInt(numDePontos));
            cod.setValorCompra(c.getDouble(valorCompra));

            codigos.add(cod);

        }
        c.close();

        Cursor c1 = BancoDadosSingleton.getInstance().buscar("empresa", new String[]{"idEmpresa","login","inadimplente","precoPonto"}, "","");

        while(c1.moveToNext()) {
            int idEmp = c1.getColumnIndex("idEmpresa");
            int login = c1.getColumnIndex("login");
            int inadimplemte = c1.getColumnIndex("inadimplente");
            int precoPonto = c1.getColumnIndex("precoPonto");

            Empresa e = new Empresa();
            e.setIdEmpresa(c1.getString(idEmp));
            e.setLogin(c1.getString(login));
            e.setInadimplente(c1.getInt(inadimplemte));
            e.setPrecoPonto(c1.getInt(precoPonto));

            empresa.add(e);
        }
        c1.close();
    }

    public void Cadastrar(View v){
        EditText edtCodigo = (EditText) findViewById(R.id.editTextCodigo);
        String Codigo = edtCodigo.getText().toString();

        for(int i = 0; i < codigos.size(); i++){
            if((codigos.get(i).getIdCodigo()).equals(Codigo)){
                if((codigos.get(i).getValidado().equals(0))) {
                    //adiciona na classe Pontos
                    ContentValues valores = new ContentValues();
                    valores.put("validado",1);

                    BancoDadosSingleton.getInstance().atualizar("codigo", valores, "idCodigo = '"+codigos.get(i).getIdCodigo()+"'");
                    if(codigos.get(i).getNumeroPontos() == 1)
                        Toast.makeText(this,"Você ganhou" + String.valueOf(codigos.get(i).getNumeroPontos()) + "pontos",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(this,"Você ganhou" + String.valueOf(codigos.get(i).getNumeroPontos()) + "ponto",Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this,"Código de Pontos já validado" ,Toast.LENGTH_LONG).show();
            }
        }
        //quando clicar vai pegar o valor do edit text(valor da compra) transformar pra double,
        //ir na tabela codigo, vê se existe e se validado = 0
        //buscar na pelo codigo a empresa e o valorPonto dela
        //dividir valorCompra por valorPonto
        //vai ser o número de Pontos do cliente


    }
}