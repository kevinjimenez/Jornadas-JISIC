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
        eventos.add(new Evento("Monday 17","9:00 - 11:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        eventos.add(new Evento("Tuesday 18","13:00 - 14:00","Jornadas","evento 1","cualqiera 2","cec","200"));
        eventos.add(new Evento("Wednesday 19","8:00 - 11:00","Jornadas","evento 2","cualqiera 3","cec","200"));
        eventos.add(new Evento("coffee 4","11:00 - 11:30","refrigerio","evento 3","cualqiera 4","cec","200"));
        eventos.add(new Evento("Monday 17","13:00 - 14:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        eventos.add(new Evento("Monday 17","14:00 - 16:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        eventos.add(new Evento("Monday 17","16:00 - 18:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        eventos.add(new Evento("Lunes 2","20:00 - 21:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        eventos.add(new Evento("Lunes 2","21:00 - 22:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        eventos.add(new Evento("Lunes 3","11:00 - 13:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        eventos.add(new Evento("Lunes 3","14:00 - 16:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        eventos.add(new Evento("Lunes 3","16:00 - 18:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        eventos.add(new Evento("Lunes 3","20:00 - 22:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        eventos.add(new Evento("Lunes 3","20:00 - 22:00","Bienvenida a las Jornadas","evento 1","cualqiera","cec","200"));
        return eventos;
    }
}
