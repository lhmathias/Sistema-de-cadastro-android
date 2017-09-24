package com.example.rodrigosipriano.trabalhopdm;

import android.content.ActivityNotFoundException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {
    private BancoController crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btncad = (Button) findViewById(R.id.btncad);
        btncad.setOnClickListener (oncli);

        crud = new BancoController(getBaseContext());
    }

    private OnClickListener oncli = new OnClickListener(){
        @Override
        public void onClick(View view){
            try{

                EditText nome = (EditText)findViewById(R.id.nomecad);
                EditText senha = (EditText)findViewById((R.id.senhacad));
                EditText tipo = (EditText) findViewById(R.id.tipo);
                EditText status = (EditText) findViewById(R.id.status);
                String nomeString = nome.getText().toString();
                String senhaString = senha.getText().toString();
                String tipoString = tipo.getText().toString();
                String statusString = status.getText().toString();
                Usuario user = new Usuario();
                user.setNome(nomeString);
                user.setSenha(senhaString);
                user.setTipo(tipoString);
                user.setStatus(statusString);
                String resultado;

                resultado = crud.insereDado(user);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
            catch(ClassCastException | ActivityNotFoundException e){
                Toast.makeText(CadastroActivity.this, "Falha ao cadastrar", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
