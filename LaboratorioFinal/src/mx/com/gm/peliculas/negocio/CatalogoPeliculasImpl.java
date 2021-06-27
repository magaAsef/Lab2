package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.io.File;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{

    public CatalogoPeliculasImpl(){
    }
    AccesoDatosImpl datos = new AccesoDatosImpl();

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        try {
            datos.escribir(pelicula, nombreArchivo,true);
        } catch (EscrituraDatosEx escrituraDatosEx) {
            escrituraDatosEx.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try {
            datos.listar(nombreArchivo);
        } catch (LecturaDatosEx lecturaDatosEx) {
            lecturaDatosEx.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        try {
            datos.buscar(nombreArchivo,buscar);
        } catch (LecturaDatosEx lecturaDatosEx) {
            lecturaDatosEx.printStackTrace();
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if (datos.existe(nombreArchivo))
            {
                try {
                    datos.borrar(nombreArchivo);
                } catch (AccesoDatosEx accesoDatosEx) {
                    accesoDatosEx.printStackTrace();
                }
                try {
                    datos.crear(nombreArchivo);
                } catch (AccesoDatosEx accesoDatosEx) {
                    accesoDatosEx.printStackTrace();
                }
            }
            else
            {
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx accesoDatosEx) {
            accesoDatosEx.printStackTrace();
        }
    }
}
