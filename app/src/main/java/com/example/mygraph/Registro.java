package com.example.mygraph;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(dam.proven.org.myapplication.R.layout.activity_registro);
        final EditText nombreT = (EditText)findViewById(dam.proven.org.myapplication.R.id.nombreRegistro);
        final EditText usuarioT = (EditText)findViewById(dam.proven.org.myapplication.R.id.userRegistro);
        final EditText passwordT = (EditText)findViewById(dam.proven.org.myapplication.R.id.passRegistro);
        Button btnRegistro = (Button)findViewById(dam.proven.org.myapplication.R.id.bnt_Registro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = nombreT.getText().toString();
                String usuario = usuarioT.getText().toString();
                String password = passwordT.getText().toString();

                Response.Listener<String> respuesta  = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if(ok == true){
                                Intent i = new Intent(Registro.this,Login.class);
                                Registro.this.startActivity(i);
                                Registro.this.finish();
                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(Registro.this);
                                alerta.setMessage("Error en el Registro").setNegativeButton("Reintentar",null).create().show();
                            }

                        }catch (JSONException e){
                            e.getMessage();
                        }

                    }
                };

                RegistroRequest r = new RegistroRequest(nombre,usuario,password,respuesta);
                RequestQueue cola = Volley.newRequestQueue(Registro.this);
                cola.add(r);
            }
        });
    }
}
