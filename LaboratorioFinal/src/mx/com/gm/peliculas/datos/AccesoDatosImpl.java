package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;

import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements AccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) {

        return false;
    }

    @Override
    public List listar(String nombre) {
        List<Pelicula> listaPeliculas = new ArrayList<>();
        listaPeliculas.add(new Pelicula(nombre));
        return listaPeliculas;
    }
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar)throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        throw new EscrituraDatosEx("No se puede escribir el archivo");


    }




    @Override
    public String buscar(String nombreArchivo, String buscar) {
        File archivo = new File(nombreArchivo);
        String disp = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null){
                if(lectura.equals(buscar)){
                    disp =  buscar;
                }

            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return disp;

    }

    @Override
    public void crear(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo.");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }
    @Override
    public void borrar(String nombreArchivo) {

    }
}
