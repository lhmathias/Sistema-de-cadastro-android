package com.example.rodrigosipriano.trabalhopdm;

import android.content.DialogInterface;
import android.net.sip.SipAudioCall;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rodrigo.sipriano on 29/08/2017.
 */

public class DisplayMessageActivity extends AppCompatActivity{
    String txt;
    String txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        txt = bundle.getString("txt");
        txt2 = bundle.getString("txt2");

        TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
        txtResultado.setText("Você logou com o usuário " + txt2 + " e senha " + txt);

        /*Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);*/


    }

    public void naPressaum(View v){
        Intent intent = new Intent(DisplayMessageActivity.this, ListarActivity.class);
        startActivity(intent);

    }

    public void onDel(View v){
        Usuario user = new Usuario();
        TextView textNome = (TextView) findViewById(R.id.editnome);
        TextView textSenha = (TextView) findViewById(R.id.editsenha);
        String nome = textNome.getText().toString();
        String senha = textSenha.getText().toString();
        user.setNome(nome);
        user.setSenha(senha);
        BancoController crud = new BancoController(getBaseContext());

        boolean valid = crud.deletar(user);
        if(valid){
            Toast.makeText(DisplayMessageActivity.this, "Deletado", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(DisplayMessageActivity.this, "Erro ao deletar", Toast.LENGTH_SHORT).show();
        }
    }

    public void onAlt(View v){
        Intent intent = new Intent(DisplayMessageActivity.this, AlterarActivity.class);

        startActivity(intent);
    }
}
