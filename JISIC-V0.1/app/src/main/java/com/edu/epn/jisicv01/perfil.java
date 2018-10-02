package com.edu.epn.jisicv01;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

import Modelos.usuario;

public class perfil extends Fragment {

    private static final String ARG_PARAM1 = "imgPerfil";
    private static final String ARG_PARAM2 = "miUsuario";

    private String imgPerfil;
    private usuario miUsuario;

    private TextView nombres,email,celular,CI;
    private Button acerca;

    private OnFragmentInteractionListener mListener;

    public perfil() {}

    public static perfil newInstance(String imgPerfil, usuario miUsuario) {
        perfil fragment = new perfil();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, imgPerfil);
        args.putSerializable(ARG_PARAM2, miUsuario);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imgPerfil = getArguments().getString(ARG_PARAM1);
            miUsuario = (usuario) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        // datos en los text view
        nombres = view.findViewById(R.id.txtNombres);
        nombres.setText("Nombres y Apellidos: "+miUsuario.getNombre_1()+" "+ miUsuario.getApellido_1());
        email = view.findViewById(R.id.txtEmail);
        email.setText("E-mail: "+miUsuario.getEmail());
        celular = view.findViewById(R.id.txtCelular);
        celular.setText("Celular: "+miUsuario.getNumeroDeTelefono());
        CI = view.findViewById(R.id.txtCedula);
        CI.setText("CI: "+miUsuario.getNumeroDeCedula());

        // btn ACERCA
//        acerca = view.findViewById(R.id.btnAcerca);
//        acerca.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(),Acerca.class);
//                startActivity(intent);
//            }
//        });
        // seteo de la imagen de FB o Google
        new perfil.imagenPerfil((ImageView) view.findViewById(R.id.imageView)).execute(imgPerfil);
        return view;
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
        void onFragmentInteraction(Uri uri);
    }
// tarea asincrona para cargar la imagen
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
