package com.example.rodrigosipriano.trabalhopdm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rodrigo.sipriano on 23/09/2017.
 */

public class AlterarActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);
    }

    public void atualizar(View v){
        TextView txtnome = (TextView) findViewById(R.id.txtnome);
        TextView txtsenha = (TextView) findViewById(R.id.txtsenha);

        String nome = txtsenha.getText().toString();
        String senha = txtnome.getText().toString();
        String nomeNovo = senha;
        Usuario user = new Usuario();
        user.setNome(nome);
        user.setSenha(senha);

        BancoController crud = new BancoController(getBaseContext());
        boolean valid = crud.alterarUsuario(user, nomeNovo);
        if(valid){
            Toast.makeText(AlterarActivity.this, "Alterado com sucesso", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(AlterarActivity.this, "Falha ao alterar", Toast.LENGTH_SHORT).show();
        }
    }

}
