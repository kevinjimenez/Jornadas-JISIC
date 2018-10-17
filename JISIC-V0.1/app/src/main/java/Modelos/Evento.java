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
        eventos.add(new Evento("MIÉRCOLES 17","8:00 - 9:00","Registro de Asistentes","Registro de Asistentes","ninguno","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("MIÉRCOLES 17","9:00 - 10:40","Ceremonia de Inauguración","Ceremonia de Inauguración","ninguno","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("MIÉRCOLES 17","10:40 - 11:40","Data in perspective - from Business Intelligence to Big Data","Data in perspective - from Business Intelligence to Big Data","Dr. Michel Page","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("MIÉRCOLES 17","11:40 - 12:00","Break","Break","ninguno","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("MIÉRCOLES 17","12:00 - 13:00","Recent trends in Social Networks applications","Recent trends in Social Networks applications","Dr. Hatem Haddad","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("MIÉRCOLES 17","13:00 - 14:30","Almuerzo","Almuerzo","ninguno","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("MIÉRCOLES 17","14:30 - 14:50","Paper: Polaridad de las opiniones sobre un personaje público en el Ecuador","Paper: Polaridad de las opiniones sobre un personaje público en el Ecuador","MSc. Boris Herrera Flores","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("MIÉRCOLES 17","14:50 - 15:30","El Ecosistema de los Datos Abiertos en Ecuador 2014-2018: una revisión de los avances, desafíos y oportunidades","El Ecosistema de los Datos Abiertos en Ecuador 2014-2018: una revisión de los avances, desafíos y oportunidades","MSc. Julio López","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("MIÉRCOLES 17","15:30 - 16:10","Industria 4.0","Industria 4.0","Dr. Sang Guun Yoo","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("MIÉRCOLES 17","16:10 - 16:50","Analítica de Datos en la EPN, experiencias y desafíos","Analítica de Datos en la EPN, experiencias y desafíos","Ing. Tania Gualli","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("MIÉRCOLES 17","16:50 - 17:10","Cata Pacari","Cata Pacari","Pacari","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("MIÉRCOLES 17","17:10 - 20:10","Taller o Curso","Taller o Curso","Ingenieros","Facultad de Ingeniería de Sistemas  N°  20","Laboratorios 3er Piso"));


        eventos.add(new Evento("JUEVES 18","8:00 - 8:20","Paper: Análisis exploratorio de datos geográficos voluntarios: estudio de caso en la administración zonal Manuela Sáenz de Quito","Paper: Análisis exploratorio de datos geográficos voluntarios: estudio de caso en la administración zonal Manuela Sáenz de Quito","Ing. Roger Castro y PhD. Marco Luna","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","8:20 - 9:00","Programación functional con Type Script","Programación functional con Type Script","Ing. Fernanda Andrade","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","9:00 - 9:40","Docker en producción mediante Kubernetes","Docker en producción mediante Kubernetes","MSc. Fausto Castañeda","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","9:40 - 10:20","Fundamentos de computación cuántica con Q#","Fundamentos de computación cuántica con Q#","Ing. Edgar Sánchez","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","10:20 - 11:00","360-Degree Big Data View","360-Degree Big Data View","MSc. Juan Pablo Zaldumbide","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","11:00 - 11:20","Break","Break","ninguno","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","11:20 - 12:00","Self Service BI, ¿realidad o ficción?","Self Service BI, ¿realidad o ficción?","MSc. Ricardo Díaz","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","12:00 - 13:00","Big Data technologies in the space of cybersecurity","Big Data technologies in the space of cybersecurity","MSc. Liviu Valsan","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","13:00 - 14:30","Almuerzo Libre","Almuerzo Libre","Ninguno","Ninguno","Ninguno"));
        eventos.add(new Evento("JUEVES 18","14:30 - 14:50","Paper: Software para Rehabilitación Muscular","Paper: Software para Rehabilitación Muscular","Ing. María Gabriela Poveda, MSc. María Fernanda Trujillo  y PhD. Andrés Rosales","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","14:50 - 15:30","Inclusión Digital. Proyecto de alfabetización informática","Inclusión Digital. Proyecto de alfabetización informática","Dr. Marco Santorum","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","15:30 - 16:10","Programa Profuturo de desarrollo de educación en base a tecnología digital ","Programa Profuturo de desarrollo de educación en base a tecnología digital ","Maria Isabel Miranda y Veronica Maldonado","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","16:10 - 16:50","El b-learning para la formación de capacidades ATRIO en el Curso de Inclusión Educativa y Aprendizaje Sostenible","El b-learning para la formación de capacidades ATRIO en el Curso de Inclusión Educativa y Aprendizaje Sostenible","Dra. Valentina Ramos Ramos","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","16:50 - 17:10","Cata Pacari","Cata Pacari","Pacari","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("JUEVES 18","17:10 - 20:10","Taller o Curso","Taller o Curso","Ingenieros","Facultad de Ingeniería de Sistemas  N°  20","Laboratorios 3er Piso"));



        eventos.add(new Evento("VIERNES 19","8:00 - 8:20","Paper: Design and simulation of a prototype to get a soccer player’s heart rate using a wireless network","Paper: Design and simulation of a prototype to get a soccer player’s heart rate using a wireless network","Ing. Carlos Angamarca y MSc. Vicente Ogoño.","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("VIERNES 19","8:20 - 9:00","Modelado de estudiantes para tutoría inteligente enfocada al entrenamiento procedimental","Modelado de estudiantes para tutoría inteligente enfocada al entrenamiento procedimental","Dr. Diego Riofrío","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("VIERNES 19","9:00 - 9:40","Action Research en Sistemas de Información","Action Research en Sistemas de Información","Dr. Edison Loza-Aguirre","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("VIERNES 19","9:40 - 10:00","Paper: Defining architectures for recommended systems for medical treatment. A Systematic Literature Review","Paper: Defining architectures for recommended systems for medical treatment. A Systematic Literature Review","MSc. María Cristina Jiménez y MSc. Ivan Carrera","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("VIERNES 19","10:00 - 10:40","Introducción a la bio-quimio-informática","Introducción a la bio-quimio-informática","Dr. Eduardo Tejera","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("VIERNES 19","10:40 - 11:00","Break","Break","ninguno","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("VIERNES 19","11:00 - 12:00","Algorithms and Solutions for Health Applications using Big Data","Algorithms and Solutions for Health Applications using Big Data","Dra. Inês Dutra","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("VIERNES 19","12:00 - 13:00","Ceremonia de Clausura","Ceremonia de Clausura","Ninguna","Edificio EARME N° 26","Auditorio 2, 5to Piso"));
        eventos.add(new Evento("VIERNES 19","17:00 - 20:00","Taller o Curso","Taller o Curso","Ingenieros","Facultad de Ingeniería de Sistemas  N°  20","Laboratorios 3er Piso"));


        return eventos;
    }
}
