package com.example.rodrigosipriano.trabalhopdm;

import android.content.ActivityNotFoundException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btnok;
    Button btncadastro;
    private List<Map<String, Object>> users;
    private SimpleAdapter adapter;
    private BancoController crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = new ArrayList<>();
        Usuario usu = new Usuario();
        Map<String, Object> item = new HashMap();
        item.put("admin", usu);
        //item.put("admin", usu);\
        users.add(item);

        btnok = (Button) findViewById(R.id.btnok);
        btnok.setOnClickListener(oncli);

        btncadastro = (Button) findViewById(R.id.btncadastro);
        btncadastro.setOnClickListener(oncli);



    }

    private OnClickListener oncli = new OnClickListener() {
        @Override
        public void onClick(View view){


                try {

                    TextView edtnome = (TextView) findViewById(R.id.edtnome);
                    TextView edtsenha = (TextView) findViewById(R.id.edtsenha);

                    String nome = edtnome.getText().toString();
                    String senha = edtsenha.getText().toString();

                    if(view == btncadastro){

                        Intent intente = new Intent(MainActivity.this, CadastroActivity.class);
                        startActivity(intente);

                    } else if(view == btnok){
                        Usuario user = new Usuario();
                        user.setNome(nome);
                        user.setSenha(senha);
                        user.setTipo("124");
                        user.setStatus("1234");
                        BancoController crud = new BancoController(getBaseContext());
                        boolean isTrue = crud.validarUsuario(user);
                        if (isTrue) {
                            Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);

                                Bundle bundle = new Bundle();

                                bundle.putString("nome", user.getNome());
                                bundle.putString("senha", user.getSenha());
                                intent.putExtras(bundle);

                                startActivity(intent);

                        }else {
                            Toast.makeText(MainActivity.this, "Inválido", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                catch(ClassCastException | ActivityNotFoundException e){
                     e.printStackTrace();
                }
            }
        };


    /*public void startSecondActivity(View view) {

        Intent secondActivity = new Intent(this, DisplayMessageActivity.class);
        startActivity(secondActivity);
    }*/

}
