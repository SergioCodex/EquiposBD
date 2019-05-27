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
        
        System.out.println("\n+-----------------------------------------------+"
                + "\n|\t         MENÚ BDEQUIPOS\t\t\t|"
                + "\n+-----------------------------------------------+"
                + "\n|\t\t\t\t\t\t|"
                + "\n|\t[1] - Crear y conectar BD\t\t|"
                + "\n|\t[2] - Eliminar BD\t\t\t|"
                + "\n|\t[3] - Crear tablas\t\t\t|"
                + "\n|\t[4] - Eliminar tablas\t\t\t|"
                + "\n|\t[5] - Cargar datos en tablas\t\t|"
                + "\n|\t[6] - Vaciar datos en tablas\t\t|"
                + "\n|\t[7] - Añadir jugador\t\t\t|"
                + "\n|\t[8] - Modificar jugador\t\t\t|"
                + "\n|\t[9] - Eliminar jugador\t\t\t|"
                + "\n|\t[10] - Ver todos los jugadores\t\t|"
                + "\n|\t[11] - Ver jugadores de un equipo\t|"
                + "\n|\t[12] - Añadir equipo\t\t\t|"
                + "\n|\t[13] - Modificar equipo\t\t\t|"
                + "\n|\t[14] - Eliminar equipo\t\t\t|"
                + "\n|\t[15] - Ver equipos\t\t\t|"
                + "\n|\t[16] - Salir del programa\t\t|"
                + "\n|\t\t\t\t\t\t|"
                + "\n+-----------------------------------------------+");
        
        return pideNumero();
        
    }
}
