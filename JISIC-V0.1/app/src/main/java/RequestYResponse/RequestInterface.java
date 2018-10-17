package RequestYResponse;

import java.util.List;

import Modelos.usuario;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RequestInterface {
    // se obtine una lista de objetos
    @GET("usuarios")
    Call<List<usuario>> getJSON(@Query("email") String correo);

    // busca un usuario y retorna en un arreglo
    @GET("usuarios")
    Call<List<usuario>> getUsuarioPorNombre(@Query("nombre_1") String nombre);

    @GET("usuarios")
    Call<List<usuario>> getUsuarioPorEmail(@Query("email") String email);

    @GET("usuarios/{id}")
    Call<usuario> getUsuario(@Path("id") int id);







}
