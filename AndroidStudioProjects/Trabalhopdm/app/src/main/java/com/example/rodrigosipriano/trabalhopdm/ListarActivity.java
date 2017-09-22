package com.example.rodrigosipriano.trabalhopdm;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import com.example.rodrigosipriano.trabalhopdm.R;

/**
 * Created by rodrigo.sipriano on 22/09/2017.
 */

public class ListarActivity extends ListActivity{

    private SimpleAdapter adapter;
    private BancoController crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crud = new BancoController(getBaseContext());
        String[] origem ={"_id","nome"};
        int[] destino = {R.id.login,R.id.nome};

        adapter = new SimpleAdapter(this,crud.retornaDados(),R.layout.activity_listar,origem,destino);

        setListAdapter(adapter);
    }
}
