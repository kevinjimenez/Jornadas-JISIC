package com.edu.epn.jisicv01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DescripcionEvento extends AppCompatActivity {
    private String dato,imagenPerfilUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dato = getIntent().getExtras().getString("dato");
        imagenPerfilUsuario = getIntent().getExtras().getString("imgPerfil");
        Log.e("kheeeee",imagenPerfilUsuario);
        Log.e("TGA::::",dato);
//        ((TextView)findViewById(R.id.txtNumeroEvento)).setText("sadsad");
        setContentView(R.layout.activity_descripcion_evento);



    }
}
