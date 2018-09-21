package RequestYResponse;

import java.util.List;

import Modelos.usuario;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RequestInterfaceDeBusquedaUsuario {


    @GET("Usuario")
    Call<List<usuario>> getUno(@Query("nombre_1") String nombre);
//    @FormUrlEncoded
//    @POST("users")
//    Call<testApi> registerUser(@Field("login") String loginValue);

}
