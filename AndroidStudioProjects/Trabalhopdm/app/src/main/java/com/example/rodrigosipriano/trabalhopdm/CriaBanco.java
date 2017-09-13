package com.example.rodrigosipriano.trabalhopdm;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
/**
 * Created by rodrigo.sipriano on 11/09/2017.
 */

public class CriaBanco extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String NOME_BANCO = "Usuarios";

    public static class Usuario {
        private static final String NOME_BANCO = "banco.db";
        public static final String TABELA = "usuarios";
        private static final String ID = "_id";
        public static final String NOME = "nome";
        public static final String SENHA = "senha";
    }

    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE usuarios (_id integer primary key autoincrement, login TEXT, nome TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
