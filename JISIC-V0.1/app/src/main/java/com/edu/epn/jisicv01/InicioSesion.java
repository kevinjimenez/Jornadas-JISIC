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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;


public class InicioSesion extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private GoogleApiClient googleApiClient;
    Bundle mBundle = new Bundle();
    int CODERC=9001;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button ingreso;
    EditText inputEmail,inputPassword;


    private OnFragmentInteractionListener mListener;

    public InicioSesion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioSesion.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioSesion newInstance(String param1, String param2) {
        InicioSesion fragment = new InicioSesion();
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
        View view = inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
        /**********************************/
        // obteniendo datos
        inputEmail = view.findViewById(R.id.inputEmail);
        inputPassword = view.findViewById(R.id.inputPassword);


            ingreso = view.findViewById(R.id.btnIngresar);
            ingreso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(),Ingresado.class);
                    if(inputEmail.getText().toString().isEmpty() && inputPassword.getText().toString().isEmpty()){
                        Toast.makeText(getContext(),"falta",Toast.LENGTH_LONG).show();
                    }else {
                        Log.e("TAG email:::::", "1" + inputEmail.getText().toString());
                        Log.e("TAG pass:::::", "2" + inputPassword.getText().toString());

                        intent.putExtra("email", inputEmail.getText().toString());
                        intent.putExtra("password", inputPassword.getText().toString());
                        startActivity(intent);
                    }
                }
            });
            // logeo con google
            SignInButton btnGoogle = view.findViewById(R.id.btnGoogle);
            btnGoogle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    logeoConGoogle();
                }
            });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
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
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
        }
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

    public void logeoConGoogle(){
        if (googleApiClient != null)
            googleApiClient.disconnect();

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient
                .Builder(getContext())
                .addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions)
                .build();

        Intent intentGoogle = Auth
                .GoogleSignInApi
                .getSignInIntent(googleApiClient);
        // se usa el start activity for result
        startActivityForResult(intentGoogle,CODERC);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODERC) {
            GoogleSignInResult result = Auth //resultado de la cesion
                    .GoogleSignInApi
                    .getSignInResultFromIntent(data);
            if (result.isSuccess()){

                GoogleSignInAccount acc=result.getSignInAccount();
                String token = acc.getIdToken();
                Log.e("correo",acc.getEmail());
                Log.e("nombre",acc.getDisplayName());
                Log.e("id",acc.getId());
                Log.e("foto",acc.getPhotoUrl().toString());
                if (token != null){
                    Toast.makeText(getContext(),token,Toast.LENGTH_LONG).show();
                }
                // ingresadon ...
                Intent intent = new Intent(getContext(),Ingresado.class);
                intent.putExtra("email",acc.getEmail().toString());
                intent.putExtra("password",acc.getId().toString());
                intent.putExtra("imgGoogle",acc.getPhotoUrl().toString());
                startActivity(intent);
                Toast.makeText(getContext(),"Correcto",Toast.LENGTH_LONG).show();
            }
        }
    }

}
