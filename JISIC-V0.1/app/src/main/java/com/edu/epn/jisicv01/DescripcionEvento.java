package com.edu.epn.jisicv01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import Modelos.Evento;

public class DescripcionEvento extends AppCompatActivity {
    private String imagenPerfilUsuario;
    private Evento evento = new Evento();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // obtencion de datos
        evento =(Evento) getIntent().getExtras().getSerializable("Evento");
        imagenPerfilUsuario = getIntent().getExtras().getString("imgPerfil");
        setContentView(R.layout.activity_descripcion_evento);

        // seteo de la info de cada evento seleccionado
        ((TextView)findViewById(R.id.eventoNombre)).setText(evento.getNombreDelEvento());
        ((TextView)findViewById(R.id.nombreEspositores)).setText(evento.getExpositores());
        ((TextView)findViewById(R.id.descripcionDelEvento)).setText(evento.getDescripcion());
        ((TextView)findViewById(R.id.ubucacionDelEvento)).setText(evento.getUbicacion());

    }
}
