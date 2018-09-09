package com.edu.epn.jisicv01;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActualizarDatos extends AppCompatActivity {
    private EditText cedulaUsuario,nombresUsuario,apellidosUsuario;
    String imagenUsuarioPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos);

        cedulaUsuario = findViewById(R.id.editCedula);
        nombresUsuario = findViewById(R.id.editNombres);
        apellidosUsuario = findViewById(R.id.editApellidos);

        Log.e("TAG","2"+cedulaUsuario.getText().toString());
        Log.e("TAG","2"+nombresUsuario.getText().toString());
        imagenUsuarioPerfil = getIntent().getExtras().getString("imgPerfil");

        Log.e("2",imagenUsuarioPerfil);
    }

    public void acceptar(View view){
        dialogo();
    }

    public void dialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialogo_salida,null));
        builder.setTitle("Seguro ?");
        builder.setMessage("Desea continuar...");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(!cedulaUsuario.getText().toString().isEmpty()&&!nombresUsuario.getText().toString().isEmpty()){
                    Intent intent = new Intent(getApplicationContext(),Ingresado.class);
                    intent.putExtra("email",cedulaUsuario.getText().toString());
                    intent.putExtra("password",nombresUsuario.getText().toString());
                    intent.putExtra("imgPerfil",imagenUsuarioPerfil);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Faltas por llenar campos",Toast.LENGTH_SHORT).show();
                }


            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"diste no",Toast.LENGTH_LONG).show();
            }
        });


        builder.setCancelable(true);
        builder.create();
        builder.show();

    }
}
