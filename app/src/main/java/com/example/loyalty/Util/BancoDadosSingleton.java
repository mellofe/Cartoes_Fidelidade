package com.example.loyalty.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public final class BancoDadosSingleton {

    protected SQLiteDatabase db;
    private static BancoDadosSingleton INSTANCE = new BancoDadosSingleton();
    private final String NOME_BANCO = "loyalty_bd";

    private final String[] SCRIPT_DATABASE_CREATE = new String[] {
            "CREATE TABLE empresa (" +
                    "  idEmpresa INTEGER PRIMARY KEY," +
                    "  login TEXT NOT NULL," +
                    "  senha TEXT NOT NULL," +
                    "  inadimplente INTEGER NOT NULL," +
                    "  precoPonto INTEGER NOT NULL" +
                    ");",
            "INSERT INTO empresa (idEmpresa, login, senha, inadimplente, precoPonto) VALUES" +
                    "(1, 'acai@email.com', '123', 0, 10);",

            "CREATE TABLE cliente (" +
                    "  login TEXT PRIMARY KEY," +
                    "  senha TEXT NOT NULL," +
                    "  nome TEXT NOT NULL" +
                    ");",
            "INSERT INTO cliente (login, senha, nome) VALUES" +
                    "('cliente@email.com', '123','Jose');",

            "CREATE TABLE codigo (" +
                    "  idCodigo TEXT PRIMARY KEY," +
                    "  idEmpresa INTEGER NOT NULL," +
                    "  validado INTEGER NOT NULL," +
                    "  numeroDePontos INTEGER NOT NULL," +
                    "  valorDaCompra DOUBLE NOT NULL," +
                    "  CONSTRAINT fk_codigo_empresa FOREIGN KEY (idEmpresa) REFERENCES empresa (idEmpresa)" +
                    ");",
            "INSERT INTO codigo (idCodigo,idEmpresa, validado, numeroDePontos, valorDaCompra) VALUES" +
                    "('COD1', 1, 0, 5, 50);",
            "CREATE TABLE pontos (" +
                    "  idCliente TEXT PRIMARY KEY," +
                    "  idEmpresa INTEGER NOT NULL," +
                    "  numeroTotalPontos INTEGER NOT NULL," +
                    "  CONSTRAINT fk_pontos_cliente FOREIGN KEY (idCliente) REFERENCES cliente (login)," +
                    "  CONSTRAINT fk_pontos_empresa FOREIGN KEY (idEmpresa) REFERENCES empresa (idEmpresa)" +
                    ");",
    };

    private BancoDadosSingleton() {
        Context ctx = MyApp.getAppContext();
        // Abre o banco de dados já existente ou então cria um banco novo
        db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);

        //busca por tabelas existentes no banco = "show tables" do MySQL
        //SELECT * FROM sqlite_master WHERE type = "table"
        Cursor c = buscar("sqlite_master", null, "type = 'table'", "");

        //Cria tabelas do banco de dados caso o mesmo estiver vazio.
        //Sempre os bancos criados pelo método openOrCreateDatabase() possuem uma tabela padrão "android_metadata"
        if(c.getCount() == 1){
            for(int i = 0; i < SCRIPT_DATABASE_CREATE.length; i++){
                db.execSQL(SCRIPT_DATABASE_CREATE[i]);
            }
            Log.i("BANCO_DADOS", "Criou tabelas do banco e as populou.");
        }

        c.close();
        Log.i("BANCO_DADOS", "Abriu conexão com o banco.");
    }

    public static BancoDadosSingleton getInstance(){
        if (BancoDadosSingleton.INSTANCE == null){
            BancoDadosSingleton.INSTANCE = new BancoDadosSingleton();
        }
        //abre conexão caso esteja fechada
        BancoDadosSingleton.INSTANCE.abrir();

        return BancoDadosSingleton.INSTANCE;
    }

    // Insere um novo registro
    public long inserir(String tabela, ContentValues valores) {
        long id = db.insert(tabela, null, valores);

        Log.i("BANCO_DADOS", "Cadastrou registro com o id [" + id + "]");
        return id;
    }

    // Atualiza registros
    public int atualizar(String tabela, ContentValues valores, String where) {
        int count = db.update(tabela, valores, where, null);

        Log.i("BANCO_DADOS", "Atualizou [" + count + "] registros");
        return count;
    }

    // Deleta registros
    public int deletar(String tabela, String where) {
        int count = db.delete(tabela, where, null);

        Log.i("BANCO_DADOS", "Deletou [" + count + "] registros");
        return count;
    }

    // Busca registros
    public Cursor buscar(String tabela, String colunas[], String where, String orderBy) {
        Cursor c;
        if(!where.equals(""))
            c = db.query(tabela, colunas, where, null, null, null, orderBy);
        else
            c = db.query(tabela, colunas, null, null, null, null, orderBy);

        Log.i("BANCO_DADOS", "Realizou uma busca e retornou [" + c.getCount() + "] registros.");
        return c;
    }

    // Abre conexão com o banco
    public void abrir() {
        Context ctx = MyApp.getAppContext();
        // Abre o banco de dados já existente
        db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
        Log.i("BANCO_DADOS", "Abriu conexão com o banco.");
    }

    // Fecha o banco
    public void fechar() {
        // fecha o banco de dados
        if (db != null) {
            db.close();
            Log.i("BANCO_DADOS", "Fechou conexão com o Banco.");
        }
    }
}

