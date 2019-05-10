package com.example.mygraph;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Bienvenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(dam.proven.org.myapplication.R.layout.activity_bienvenido);
        final TextView mensaje = (TextView)findViewById(dam.proven.org.myapplication.R.id.mensaje);
        Intent i = this.getIntent();
        String nombre =  i.getStringExtra("nombre");
        mensaje.setText(mensaje.getText()+ ""+nombre);
    }
}
