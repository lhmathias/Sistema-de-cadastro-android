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

/**
 * Created by rodrigo.sipriano on 29/08/2017.
 */

public class DisplayMessageActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String txt = bundle.getString("txt");
        String txt2 = bundle.getString("txt2");

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
}
