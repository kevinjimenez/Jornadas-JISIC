package Modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Evento implements Serializable{
    private String Dia;
    private String Hora;
    private String NombreDelEvento;
    private String Descripcion;
    private String Expositores;
    private String Ubicacion;
    private String Auditorio;


    public Evento() {}

    public Evento(String dia, String hora, String nombreDelEvento, String descripcion, String expositores, String ubucacion, String auditorio) {
        Dia = dia;
        Hora = hora;
        NombreDelEvento = nombreDelEvento;
        Descripcion = descripcion;
        Expositores = expositores;
        Ubicacion = ubucacion;
        Auditorio = auditorio;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String dia) {
        Dia = dia;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getNombreDelEvento() {
        return NombreDelEvento;
    }

    public void setNombreDelEvento(String nombreDelEvento) {
        NombreDelEvento = nombreDelEvento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getExpositores() {
        return Expositores;
    }

    public void setExpositores(String expositores) {
        Expositores = expositores;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getAuditorio() {
        return Auditorio;
    }

    public void setAuditorio(String auditorio) {
        Auditorio = auditorio;
    }

    public ArrayList<Evento> MisEventos(){
        ArrayList <Evento> eventos = new ArrayList<>();
        eventos.add(new Evento("Lunes 17","9:00 - 11:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        eventos.add(new Evento("martes 18","13:00 - 14:00","Jornadas","evento 1","cualqiera 2","cec","200"));
        eventos.add(new Evento("miercoles 19","8:00 - 11:00","Jornadas","evento 2","cualqiera 3","cec","200"));
        eventos.add(new Evento("coffee break","11:00 - 11:30","refiegerio","evento 3","cualqiera 4","cec","200"));
//        eventos.add(new Evento("Lunes 17","9:00 - 11:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
//        eventos.add(new Evento("Lunes 17","9:00 - 11:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
//        eventos.add(new Evento("Lunes 17","9:00 - 11:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
//        eventos.add(new Evento("Lunes 17","9:00 - 11:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
//        eventos.add(new Evento("Lunes 17","9:00 - 11:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
//        eventos.add(new Evento("Lunes 17","9:00 - 11:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
//        eventos.add(new Evento("Lunes 17","9:00 - 11:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
//        eventos.add(new Evento("Lunes 17","9:00 - 11:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
//        eventos.add(new Evento("Lunes 17","9:00 - 11:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));



        return eventos;
    }
}
