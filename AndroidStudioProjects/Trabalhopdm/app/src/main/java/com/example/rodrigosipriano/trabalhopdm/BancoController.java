package com.example.rodrigosipriano.trabalhopdm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rodrigo.sipriano on 11/09/2017.
 */

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;
    private List<Map<String, Object>> usuarios;

    public BancoController(Context context){
        banco = new CriaBanco(context);

    }


    public String insereDado(Usuario usuario){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.SENHA, usuario.getSenha());
        valores.put(CriaBanco.NOME, usuario.getNome());

        resultado = db.insert(CriaBanco.TABELA , null, valores);
        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public List<Map<String, Object>> retornaDados (){
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios", null);
        cursor.moveToFirst();
        usuarios = new ArrayList<>();

        for(int i =0; i < cursor.getCount(); i++){
            Map<String, Object> item = new HashMap<>();
            String _id = cursor.getString(0);
            String senha = cursor.getString(1);
            String nome = cursor.getString(2);

            item.put(CriaBanco.ID, "Login: "+ _id);
            //item.put(CriaBanco.SENHA, "Senha: "+ senha);
            item.put(CriaBanco.NOME, "Nome: "+ nome);

            usuarios.add(item);

            cursor.moveToNext();
        }
        db.close();
        return usuarios;
    }
}
