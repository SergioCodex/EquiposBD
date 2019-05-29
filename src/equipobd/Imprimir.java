/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

/**CLASE IMPRIMIR EQUIPOS/JUGADORES DE LA BASE DE DATOS.
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class Imprimir {

    static void imprimirEquipo(int team_id, String eq_nombre, String estadio, String poblacion, String provincia, String cod_postal, int cont) {

        System.out.println("\n\n+------------------------------------+");
        System.out.println("           \u001B[36mRegistro nº" + cont + "\u001B[0m");
        System.out.println("+----------------+-------------------+");
        System.out.println("     TEAM_ID\t |  " + team_id);
        System.out.println("     EQ_NOMBRE\t |  " + eq_nombre);
        System.out.println("     ESTADIO\t |  " + estadio);
        System.out.println("     POBLACION\t |  " + poblacion);
        System.out.println("     PROVINCIA\t |  " + provincia);
        System.out.println("     COD_POSTAL\t |  " + cod_postal);
        System.out.println("+----------------+-------------------+");
        System.out.println();

    }

    static void imprimirJugadores(int player_id, int team_id, String nombre, int dorsal, int edad, int cont) {

        System.out.println("\n\n+------------------------------------+");
        System.out.println("           \u001B[36mRegistro nº" + cont + "\u001B[0m");
        System.out.println("+----------------+-------------------+");
        System.out.println("     PLAYER_ID\t |  " + player_id);
        System.out.println("     TEAM_ID\t |  " + team_id);
        System.out.println("     NOMBRE\t |  " + nombre);
        System.out.println("     DORSAL\t |  " + dorsal);
        System.out.println("     EDAD\t |  " + edad);
        System.out.println("+----------------+-------------------+");
        System.out.println();

    }

    static void imprimirResumen(int nEquipos, int nJugadores) {

        System.out.println("\n+-----------------------------------------------+"
                + "\n|\t    Número de equipos: " + nEquipos + " \t\t|"
                + "\n|\t    Número de jugadores: " + nJugadores + " \t\t|"
                + "\n+-----------------------------------------------+");

    }

}
