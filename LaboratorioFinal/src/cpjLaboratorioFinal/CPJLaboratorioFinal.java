package cpjLaboratorioFinal;

import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

import java.util.Scanner;

public class CPJLaboratorioFinal {
    public static void main(String[] args) {
        var catalogo = new CatalogoPeliculasImpl();
        Scanner consola = new Scanner(System.in);
        String pelicula = null;
        int op;
        do{
            System.out.println("Elige una opcion: \n" +
                    "1. Iniciar catalogo de peliculas. \n" +
                    "2. Agregar pelicula. \n" +
                    "3. Listar peliculas. \n" +
                    "4. Buscar pelicula. \n" +
                    "0. Salir.");

            op = Integer.parseInt(consola.nextLine());
            switch (op)
            {
                case 0:
                    System.out.println("Cerrando...");
                    break;
                case 1:
                    catalogo.iniciarArchivo("peliculas.txt");
                    break;
                case 2:
                    pelicula = consola.nextLine();
                    catalogo.agregarPelicula(pelicula, "peliculas.txt");
                    break;
                case 3:
                    catalogo.listarPeliculas("peliculas.txt");
                    break;
                case 4:
                    pelicula = consola.nextLine();
                    catalogo.buscarPelicula("peliculas.txt", pelicula);
                default:
                    System.out.println("Opción inválida");
            }
        }while(op != 0);
    }
}
