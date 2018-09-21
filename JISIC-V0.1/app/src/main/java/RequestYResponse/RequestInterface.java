package RequestYResponse;

import java.util.List;

import Modelos.usuario;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RequestInterface {
    // se obtine una lista de objetos
    @GET("Usuario")
    Call<List<usuario>> getJSON();
    //Call<JSONResponse> getJSON();




}
