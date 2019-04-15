package com.e.gastosv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Persistencia.Campos;
import Persistencia.MetodosDB;

public class Registracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button btnAtras = (Button) findViewById(R.id.action_atras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btnConfir = (Button) findViewById(R.id.action_confirmar);
        btnConfir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView nombre = findViewById(R.id.txt_nombre);
                TextView apellido = findViewById(R.id.txt_apellido);
                TextView mail = findViewById(R.id.txt_mail);

                String nom = nombre.getText().toString();
                String ape = apellido.getText().toString();
                String mai = mail.getText().toString();

                Usuario usu = new Usuario(nom, ape, mai);


                Campos campos = new Campos(usu);

                MetodosDB contexto = new MetodosDB(getApplicationContext());

                //contexto.onCreate(contexto.getWritableDatabase());


                try {
                    contexto.saveLawyer(campos);
                }catch (Exception e){

                    Log.e("Regitracion", e.getMessage());
                }

                Intent intent = new Intent(v.getContext(), MainActivity.class);
                Toast mensaje = Toast.makeText(getApplicationContext(), "Registrado correctamente", Toast.LENGTH_LONG);
                mensaje.setGravity(Gravity.CENTER, 0, 0);
                mensaje.show();
                startActivityForResult(intent, 0);
            }
        });


    }

    public void verValor(View v){
           EditText campo = (EditText) findViewById(R.id.txt_nombre);
           Log.d("Valor", campo.getText().toString());

    };

}
