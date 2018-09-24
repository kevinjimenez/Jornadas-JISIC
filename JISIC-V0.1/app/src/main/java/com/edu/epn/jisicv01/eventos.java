package com.edu.epn.jisicv01;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Modelos.Evento;


public class eventos extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ArrayAdapter<String> adapter;
    private String eventos[];
    private Evento misEventos = new Evento();
    private ListView listaEventos;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public eventos() {}

    public static eventos newInstance(String param1, String param2) {
        eventos fragment = new eventos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eventos, container, false);
        // seteo de la lista con sus datos por default
        listaEventos = view.findViewById(R.id.listEvents);
        // lista personalizada
        CustomAdarpter customAdarpter = new CustomAdarpter();
        listaEventos.setAdapter(customAdarpter);
        listaEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),misEventos.MisEventos().get(position).getNombreDelEvento(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),DescripcionEvento.class);
                intent.putExtra("Evento",misEventos.MisEventos().get(position));
                intent.putExtra("imgPerfil",mParam1);
                startActivity(intent);
            }
        });
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

    // clase para la lista personalixada
    class CustomAdarpter extends BaseAdapter{

        @Override
        public int getCount() {
            return misEventos.MisEventos().size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.mi_lista_personalizada,null);
            TextView diaEvento = view.findViewById(R.id.dia);
            TextView horaEvento = view.findViewById(R.id.hora);
            TextView nombreEvento = view.findViewById(R.id.evento);

            diaEvento.setText(misEventos.MisEventos().get(i).getDia());
            horaEvento.setText(misEventos.MisEventos().get(i).getHora());
            nombreEvento.setText(misEventos.MisEventos().get(i).getNombreDelEvento());
            return view;
        }
    }
}
