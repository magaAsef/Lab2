package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    public CatalogoPeliculasImpl(){

    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula nuevaPelicula = new Pelicula(nombrePelicula);


    }

    @Override
    public void listarPeliculas(String nombreArchivo) {

    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {

    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {

    }
}
