package com.edu.epn.jisicv01;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

import Modelos.usuario;

public class perfil extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private usuario mParam2;

    private TextView nombres,email,celular,CI;
    private Button updateData;
    private Button acerca;

    private OnFragmentInteractionListener mListener;

    public perfil() {}

    public static perfil newInstance(String param1, usuario param2) {
        perfil fragment = new perfil();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putSerializable(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = (usuario) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        nombres = view.findViewById(R.id.txtNombres);
        nombres.setText(mParam2.getNombre_1()+" "+mParam2.getApellido_1());
        email = view.findViewById(R.id.txtEmail);
        email.setText(mParam2.getEmail());
        celular = view.findViewById(R.id.txtCelular);
        celular.setText(mParam2.getNumeroDeTelefono());
        CI = view.findViewById(R.id.txtCedula);
        CI.setText(mParam2.getNumeroDeCedula());




        updateData = view.findViewById(R.id.btnActualizarDatos);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo();
            }
        });

        acerca = view.findViewById(R.id.btnAcerca);
        acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Acerca.class);
                startActivity(intent);
            }
        });
        new perfil.imagenPerfil((ImageView) view.findViewById(R.id.imageView)).execute(mParam1);

        return view;
    }

    public void dialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialogo_salida,null));
        builder.setTitle("Seguro ?");
        builder.setMessage("Desea continuar...");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"diste si",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(),ActualizarDatos.class);
                intent.putExtra("imgPerfil",mParam1);
                Log.e("3",mParam1);
                startActivity(intent);

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"diste ni",Toast.LENGTH_LONG).show();
            }
        });


        builder.setCancelable(true);
        builder.create();
        builder.show();

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {}
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public static class imagenPerfil extends AsyncTask<String, Void, Bitmap> {
        ImageView urlImagen;

        public imagenPerfil(ImageView urlImagen){
            this.urlImagen = urlImagen;
        }

        protected Bitmap doInBackground(String... urls){
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try{
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            }catch (Exception e){
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result){
            urlImagen.setImageBitmap(result);
        }

    }
}
