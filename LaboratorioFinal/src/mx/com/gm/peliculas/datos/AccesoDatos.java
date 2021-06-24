package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;

import java.io.*;
import java.util.List;

public interface AccesoDatos {
    boolean existe(String nombreArchivo);
    List listar(String nombre);
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    String buscar(String nombreArchivo, String buscar);
    void crear(String nombreArchivo);
    void borrar(String nombreArchivo);

}
