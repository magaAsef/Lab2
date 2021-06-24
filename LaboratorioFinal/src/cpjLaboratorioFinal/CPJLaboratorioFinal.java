package cpjLaboratorioFinal;

import java.util.Scanner;

public class CPJLaboratorioFinal {
    public static void main(String[] args) {
        int op;
        do{
            System.out.println("Elige una opcion: \n" +
                    "1. Iniciar catalogo de peliculas. \n" +
                    "2. Agregar pelicula. \n" +
                    "3. Listar peliculas. \n" +
                    "4. Buscar pelicula. \n" +
                    "0. Salir.");
            Scanner consola = new Scanner(System.in);
            op = Integer.parseInt(consola.nextLine());
            if(op == 1){

            }else if(op == 2){

            }else if(op == 3){

            }else if(op == 4){

            }
            else if(op < 0 || op > 4){
                System.out.println("Error... elige una opcion entre 0 y 4.");
            }
        }while(op != 0);
    }
}
