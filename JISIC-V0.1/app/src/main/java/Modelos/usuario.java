package Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class usuario implements Serializable {
    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("nombre_1")
    @Expose
    String nombre_1;
    @SerializedName("nombre_2")
    @Expose
    String nombre_2;
    @SerializedName("apellido_1")
    @Expose
    String apellido_1;
    @SerializedName("apellido_2")
    @Expose
    String apellido_2;
    @SerializedName("password")
    @Expose
    String password;
    @SerializedName("email")
    @Expose
    String email;
    String numeroDeTelefono;
    String numeroDeCedula;


    public usuario(int id, String nombre_1, String nombre_2, String apellido_1, String apellido_2, String password, String email, String numeroDeTelefono, String numeroDeCedula) {
        this.id = id;
        this.nombre_1 = nombre_1;
        this.nombre_2 = nombre_2;
        this.apellido_1 = apellido_1;
        this.apellido_2 = apellido_2;
        this.password = password;
        this.email = email;
        this.numeroDeTelefono = numeroDeTelefono;
        this.numeroDeCedula = numeroDeCedula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_1() {
        return nombre_1;
    }

    public void setNombre_1(String nombre_1) {
        this.nombre_1 = nombre_1;
    }

    public String getNombre_2() {
        return nombre_2;
    }

    public void setNombre_2(String nombre_2) {
        this.nombre_2 = nombre_2;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getApellido_2() {
        return apellido_2;
    }

    public void setApellido_2(String apellido_2) {
        this.apellido_2 = apellido_2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getNumeroDeCedula() {
        return numeroDeCedula;
    }

    public void setNumeroDeCedula(String numeroDeCedula) {
        this.numeroDeCedula = numeroDeCedula;
    }
}
