package com.edu.epn.jisicv01;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import Modelos.usuario;
import RequestYResponse.DireccionHttpDelServidor;
import RequestYResponse.RequestInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class InicioSesion extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String imagenPorDefecto ="https://api.adorable.io/avatars/199/abott@adorable.png";
    // servidor
    dialogoAsysc dAsysc;
    private ProgressDialog progressDialog;

    // google
    private final int CODERC=9001;
    private GoogleApiClient googleApiClient;


    // FB
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;


    private String mParam1;
    private String mParam2;


    private Button ingreso;
    EditText inputEmail,inputPassword;




    private OnFragmentInteractionListener mListener;

    public InicioSesion() {
    }

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
        shaDeFacebook();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
        callbackManager = CallbackManager.Factory.create();
        view.getBackground().setAlpha(100);


        loginButton = (LoginButton) view.findViewById(R.id.btnFB);

        //loginButton.setReadPermissions("user_friends");
        loginButton.setFragment(this);
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
            }
        };

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                //nextActivity(newProfile);
                //logeoConFB(newProfile);
            }
        };
        accessTokenTracker.startTracking();
        profileTracker.startTracking();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile profile = Profile.getCurrentProfile();
                //Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_SHORT).show();
                logeoConFB(profile);
            }

            @Override
            public void onCancel() {
                Toast.makeText(getActivity(), "Login canceled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(getActivity(), "Error al logearse con facebook"+exception.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        // obteniendo datos
        inputEmail = view.findViewById(R.id.inputEmail);
        inputPassword = view.findViewById(R.id.inputPassword);


            ingreso = view.findViewById(R.id.btnIngresar);
            ingreso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(inputEmail.getText().toString().isEmpty() && inputPassword.getText().toString().isEmpty()){
                        Toast.makeText(getContext(),"Debes llenar los Campos",Toast.LENGTH_LONG).show();
                    }else {
                        buscarUsuarioPorEmail(inputEmail.getText().toString(),inputPassword.getText().toString(),imagenPorDefecto+inputEmail.getText().toString());
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

    public void buscarUsuarioPorNombre(String nombreUsuario, final String urlImagen){

        String nombreCompleto[] = new String[]{};

        Retrofit retrofits = new Retrofit
                .Builder()
                .baseUrl(new DireccionHttpDelServidor().getAPI_BASE_URL())
                .addConverterFactory(GsonConverterFactory
                        .create())
                .build();

        RequestInterface req = retrofits.create(RequestInterface.class);
        nombreCompleto = nombreUsuario.toLowerCase().split(" ");
        Call<List<usuario>> call = req.getUsuarioPorNombre(nombreCompleto[0]);
        call.enqueue(new Callback<List<usuario>>() {
            @Override

            public void onResponse(Call<List<usuario>> call, Response<List<usuario>> response) {
                if(response.isSuccessful()){
                    if (response.body().size()>0){

                        Intent intent = new Intent(getContext(),Ingresado.class);
                        intent.putExtra("usuario",(usuario)response.body().get(0));
                        intent.putExtra("imgPerfil", urlImagen);
                        Toast.makeText(getContext(),"Bienvenido",Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getContext(),"No te encuentras inspcrito",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    ejecucuinDeProceesDialog();
                }
            }

            @Override
            public void onFailure(Call<List<usuario>> call, Throwable t) {
                Log.e(" mainAction", t.getMessage());
            }
        });
    }

    public void buscarUsuarioPorEmail( final String email, final String password, final String urlImagen){



        Retrofit retrofits = new Retrofit
                .Builder()
                .baseUrl(new DireccionHttpDelServidor().getAPI_BASE_URL())
                .addConverterFactory(GsonConverterFactory
                        .create())
                .build();

        RequestInterface req = retrofits.create(RequestInterface.class);
        Call<List<usuario>> call = req.getUsuarioPorEmailYPassword(email,password);
        call.enqueue(new Callback<List<usuario>>() {
            @Override
            public void onResponse(Call<List<usuario>> call, Response<List<usuario>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getContext(),"lll"+response,Toast.LENGTH_LONG).show();
                    ejecucuinDeProceesDialog();
                    if (response.body().size()>0){
                        Intent intent = new Intent(getContext(),Ingresado.class);
                        intent.putExtra("usuario",(usuario)response.body().get(0));
                        intent.putExtra("imgPerfil", urlImagen);
                        startActivity(intent);
                        Toast.makeText(getContext(),"Bienvenido",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getContext(),"No te encuentras inspcrito",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<usuario>> call, Throwable t) {
                Log.e(" mainAction", t.getMessage());
            }
        });
    }


    ////////////////////// fb

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return (accessToken != null) && (!accessToken.isExpired());
    }

    @Override
    public void onResume() {
        super.onResume();
        //Profile profile = Profile.getCurrentProfile();
        //logeoConFB(profile);
        if(accessTokenTracker.isTracking()&&profileTracker.isTracking()) {
            AppEventsLogger.activateApp(getContext());
            Profile profile = Profile.getCurrentProfile();
            logeoConFB(profile);

        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }

    ///////////////////// fin fb
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

    private void logeoConFB(final Profile profile){
        if(profile != null){
            buscarUsuarioPorNombre(profile.getFirstName(),profile.getProfilePictureUri(250,250).toString());
        }
    }


    // sha

    public void shaDeFacebook(){
        FacebookSdk.sdkInitialize(getContext());

        try {
            PackageInfo info = getActivity().getPackageManager().getPackageInfo(
                    "com.edu.epn.jisicv01",
                    PackageManager.GET_SIGNATURES);
            Log.e("TAG",info.toString());
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TAG", e.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("TAG", e.toString());
        }
    }

    // fin sha

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CODERC) {
                GoogleSignInResult result = Auth //resultado de la cesion
                        .GoogleSignInApi
                        .getSignInResultFromIntent(data);
                if (result.isSuccess()){
                    final GoogleSignInAccount acc=result.getSignInAccount();
                    String token = acc.getIdToken();
                    acc.getDisplayName();


                    /*   buscar en el server   */
                    buscarUsuarioPorNombre(acc.getDisplayName(),acc.getPhotoUrl().toString());
                    /* fin de buqueda*/

                    if (token != null){
                        Toast.makeText(getContext(),token,Toast.LENGTH_LONG).show();
                    }
                }
        }
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void ejecucuinDeProceesDialog(){
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Conectando...");
        dAsysc = new dialogoAsysc();
        dAsysc.execute();
    }



    public void tiempoDeEspera(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public class dialogoAsysc extends AsyncTask<Void,Integer,Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            tiempoDeEspera();
            return true;
        }

        @Override
        protected void onPreExecute() {
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (aBoolean){
                progressDialog.dismiss();
            }
        }
    }
}
