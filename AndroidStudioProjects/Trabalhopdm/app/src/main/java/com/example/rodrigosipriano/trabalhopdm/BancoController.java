package com.example.rodrigosipriano.trabalhopdm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

/**
 * Created by rodrigo.sipriano on 11/09/2017.
 */

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);

    }


    public String insereDado(Usuario usuario){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.Usuario.NOME, usuario.getNome());
        valores.put(CriaBanco.Usuario.SENHA, usuario.getSenha());

        resultado = db.insert(CriaBanco.Usuario.TABELA , null, valores);
        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }
}
