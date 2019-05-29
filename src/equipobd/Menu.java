/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import Sleer2.SLeer2;

/**
 *
 * @author root-admin
 */
public class Menu {
    
    /**
     * Método que pide por pantalla un número, asegurándose que esté entre 1 y
     * 16.
     *
     * @return int número introducido por teclado.
     */
    public static int pideNumero() {

        int num;

        do {

            num = SLeer2.datoInt("Introduce una opción: ");

            if (num < 1 || num > 16) {

                System.err.println("\n¡Opción no disponible!\n");

            }

        } while (num < 1 || num > 16);

        return num;

    }
    
    static int menuBD(){
        
        System.out.println("\n\033[0;91m+-----------------------------------------------+"
                + "\n|\t         \u001B[36mMENÚ BDEQUIPOS\u001B[0m\t\t\t|"
                + "\n+-----------------------------------------------+"
                + "\n|\t\t\t\t\t\t|"
                + "\n|\t\u001B[36m[1]\u001B[0m - Crear y conectar BD\t\t|"
                + "\n|\t\u001B[36m[2]\u001B[0m - Eliminar BD\t\t\t|"
                + "\n|\t\u001B[36m[3]\u001B[0m - Crear tablas\t\t\t|"
                + "\n|\t\u001B[36m[4]\u001B[0m - Eliminar tablas\t\t\t|"
                + "\n|\t\u001B[36m[5]\u001B[0m - Cargar datos en tablas\t\t|"
                + "\n|\t\u001B[36m[6]\u001B[0m - Vaciar datos en tablas\t\t|"
                + "\n|\t\u001B[36m[7]\u001B[0m - Añadir jugador\t\t\t|"
                + "\n|\t\u001B[36m[8]\u001B[0m - Modificar jugador\t\t\t|"
                + "\n|\t\u001B[36m[9]\u001B[0m - Eliminar jugador\t\t\t|"
                + "\n|\t\u001B[36m[10]\u001B[0m - Ver todos los jugadores\t\t|"
                + "\n|\t\u001B[36m[11]\u001B[0m - Ver jugadores de un equipo\t|"
                + "\n|\t\u001B[36m[12]\u001B[0m - Añadir equipo\t\t\t|"
                + "\n|\t\u001B[36m[13]\u001B[0m - Modificar equipo\t\t\t|"
                + "\n|\t\u001B[36m[14]\u001B[0m - Eliminar equipo\t\t\t|"
                + "\n|\t\u001B[36m[15]\u001B[0m - Ver equipos\t\t\t|"
                + "\n|\t\u001B[36m[16]\u001B[0m - Salir del programa\t\t|"
                + "\n|\t\t\t\t\t\t|"
                + "\n+-----------------------------------------------+\033[0m");
        
        return pideNumero();
        
    }
}
