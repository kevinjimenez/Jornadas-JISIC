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
    @GET("Usuario")
    Call<List<usuario>> getJSON();

    // busca un usuario y retorna en un arreglo
    @GET("Usuario")
    Call<List<usuario>> getUsuarioPorNombre(@Query("nombre_1") String nombre);

    @GET("Usuario")
    Call<List<usuario>> getUsuarioPorEmailYPassword(@Query("email") String email,
                                           @Query("password") String password);

    @GET("Usuario/{id}")
    Call<usuario> getUsuario(@Path("id") int id);







}
