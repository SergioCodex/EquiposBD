/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import Sleer2.SLeer2;
import java.sql.Connection;

/**CLASE ENTRADA DE DATOS.
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class Entrada {

    static int pideTeam_idUpdate(Connection con) {

        int team_id;

        do {
            team_id = SLeer2.datoInt("\n- Introduce el ID del equipo: ");

            if (team_id <= 0 || !ExisteRegistro.existeEquipo(con, team_id)) {
                if (team_id <= 0) {
                    System.err.println("\n\nEl número debe ser un entero positivo.");
                } else {
                    System.err.println("\n\nEse equipo no existe.");
                }
            }

        } while (team_id <= 0 || !ExisteRegistro.existeEquipo(con, team_id));

        return team_id;

    }

    static int pideTeam_idAgregar(Connection con) {

        int team_id;

        do {
            team_id = SLeer2.datoInt("\n- Introduce su número de equipo: ");

            if (team_id <= 0 || ExisteRegistro.existeEquipo(con, team_id)) {
                if (team_id <= 0) {
                    System.err.println("\n\nEl campo debe ser un entero positivo.");
                } else {
                    System.err.println("\n\nEse equipo ya existe.");
                }
            }
        } while (team_id <= 0 || ExisteRegistro.existeEquipo(con, team_id));

        return team_id;

    }

    static int pidePlayer_idAgregar(Connection con) {

        int player_id;

        do {
            player_id = SLeer2.datoInt("\n- Introduce su número de jugador: ");

            if (player_id <= 0 || ExisteRegistro.existeJugador(con, player_id)) {
                if (player_id <= 0) {
                    System.err.println("\n\nEl campo debe ser un entero positivo.");
                } else {
                    System.err.println("\n\nEse jugador ya existe.");
                }
            }
        } while (player_id <= 0 || ExisteRegistro.existeJugador(con, player_id));

        return player_id;

    }

    static int pidePlayer_idUpdate(Connection con) {

        int player_id;

        do {
            player_id = SLeer2.datoInt("\n- Introduce el ID del jugador: ");

            if (player_id <= 0 || !ExisteRegistro.existeJugador(con, player_id)) {
                if (player_id <= 0) {
                    System.err.println("\n\nEl número debe ser un entero positivo.");
                } else {
                    System.err.println("\n\nEse jugador no existe.");
                }
            }

        } while (player_id <= 0 || !ExisteRegistro.existeJugador(con, player_id));

        return player_id;

    }

    static String pideEq_nombre() {

        String eq_nombre;

        do {
            eq_nombre = SLeer2.datoString("- Introduce el nombre del equipo: ").toUpperCase();

            if (eq_nombre.length() < 0 || eq_nombre.length() > 40) {
                System.err.println("\n\nImposible introducir un nombre tan largo.");
            }
        } while (eq_nombre.length() < 0 || eq_nombre.length() > 40);

        return eq_nombre;
    }

    static String pideEstadio() {

        String estadio;

        do {
            estadio = SLeer2.datoString("- Introduce el nombre del estadio: ").toUpperCase();

            if (estadio.length() < 0 || estadio.length() > 40) {
                System.err.println("\n\nImposible introducir un nombre tan largo.");
            }
        } while (estadio.length() < 0 || estadio.length() > 40);

        return estadio;

    }

    static String pidePoblacion() {

        String poblacion;

        do {
            poblacion = SLeer2.datoString("- Introduce el nombre de la población: ").toUpperCase();

            if (poblacion.length() < 0 || poblacion.length() > 20) {
                System.err.println("\n\nImposible introducir un nombre tan largo.");
            }
        } while (poblacion.length() < 0 || poblacion.length() > 20);

        return poblacion;
    }

    static String pideProvincia() {

        String provincia;

        do {
            provincia = SLeer2.datoString("- Introduce el nombre de la provincia: ").toUpperCase();

            if (provincia.length() < 0 || provincia.length() > 20) {
                System.err.println("\n\nImposible introducir un nombre tan largo.");
            }
        } while (provincia.length() < 0 || provincia.length() > 20);

        return provincia;
    }

    static String pideCod_postal() {

        String cod_postal;

        do {
            cod_postal = SLeer2.datoString("- Introduce el código postal del equipo: ");

            if (cod_postal.length() != 5) {
                System.err.println("\n\nCódigo postal incorrecto, debe contener 5 cifras.");
            }
        } while (cod_postal.length() != 5);

        return cod_postal;

    }

    static String pideNombreJug() {

        String nombre;

        do {
            nombre = SLeer2.datoString("- Introduce el nombre del jugador: ").toUpperCase();

            if (nombre.length() < 0 || nombre.length() > 40) {
                System.err.println("\n\nImposible introducir un nombre tan largo.");
            }
        } while (nombre.length() < 0 || nombre.length() > 40);

        return nombre;

    }

    static int pideDorsal() {

        int dorsal;

        do {
            dorsal = SLeer2.datoInt("- Introduce el dorsal del jugador: ");

            if (dorsal <= 0) {
                System.err.println("\n\nEl campo debe ser un entero positivo.");
            }
        } while (dorsal <= 0);

        return dorsal;

    }

    static int pideEdad() {

        int edad;

        do {
            edad = SLeer2.datoInt("- Introduce la edad del jugador: ");

            if (edad <= 0) {
                System.err.println("\n\nEl campo debe ser un entero positivo.");
            }
        } while (edad <= 0);

        return edad;

    }

}
