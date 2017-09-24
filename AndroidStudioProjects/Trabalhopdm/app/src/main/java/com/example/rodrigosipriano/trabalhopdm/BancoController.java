package com.example.rodrigosipriano.trabalhopdm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

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
        valores.put("tipo", usuario.getTipo());
        valores.put("status", usuario.getStatus());
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

            item.put(CriaBanco.ID, "ID: "+ _id);
            //item.put(CriaBanco.SENHA, "Senha: "+ senha);
            item.put(CriaBanco.NOME, "Nome: "+ nome);

            usuarios.add(item);

            cursor.moveToNext();
        }
        db.close();
        return usuarios;
    }

    public boolean deletar(Usuario user){
        db = banco.getWritableDatabase();
        long resul = db.delete("usuarios", "nome = ?", new String[]{user.getNome()});
        db.close();
        if(resul != 0){
            return true;
        }
        return false;
    }

    public boolean validarUsuario(Usuario usuario){
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE nome = ? AND senha = ?", new String[]{usuario.getNome(),usuario.getSenha()});
        if(cursor.moveToNext()){
            cursor.close();
            db.close();
            return true;
        }
        else {
            return true;
        }
    }

    public boolean alterarUsuario(Usuario user, String nome){
        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("senha",nome);
        values.put("nome",user.getNome());
        values.put("status",user.getStatus());
        values.put("tipo",user.getTipo());
        long resul = db.update("usuarios",values,"nome = ?",new String[]{nome});
        db.close();
        if(resul != -1 ){
            return true;
        }
        return false;
    }

}
