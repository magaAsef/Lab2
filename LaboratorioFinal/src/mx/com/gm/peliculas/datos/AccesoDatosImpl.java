package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements AccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List listar(String nombreArchivo) throws LecturaDatosEx{
        var archivo = new File(nombreArchivo);
        List<Pelicula> listaPeliculas = new ArrayList<>();
        try  {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while (entrada != null)
            {
                Pelicula pelicula = new Pelicula(linea);
                listaPeliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Error al leer "+ e.getMessage());
        }
        return listaPeliculas;
    }

        public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreArchivo);
            try {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
                salida.println(pelicula);
                salida.close();
                System.out.println("Peli agregada "+ pelicula);
            } catch (IOException e) {
                e.printStackTrace();
                throw new EscrituraDatosEx("Error al escribir "+ e.getMessage());
            }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx{
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while (linea != null)
            {
                if (buscar != null && buscar.equalsIgnoreCase(linea))
                {
                    resultado = buscar;
                    System.out.println("Pelicula "+ buscar+ " encontrada");
                }
                linea = entrada.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx{
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
    public void borrar(String nombreArchivo) throws AccesoDatosEx{
        File archivo = new File(nombreArchivo);
        if (archivo.exists())
            archivo.delete();
        System.out.println("Se ha eliminado el archivo.");
    }
}
