/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import Sleer2.SLeer2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author root-admin
 */
public class EliminarRegistro {

    static void eliminarEquipo(Connection con) {

        String resp = "";
        String continua = "";
        int team_id;

        do {

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

            SLeer2.limpiar();

            if (CuantosJugadores.numeroJugadoresEquipo(con, team_id) == 0) {

                System.out.println("\n Los datos del equipo a eliminar son: ");
                ConsultarJugadorEquipo.mostrarEquipo(con, team_id);

                do {
                    resp = SLeer2.datoString("¿Estás seguro de que desea eliminar ese equipo? [s/n]: ").toLowerCase();
                } while (!resp.equals("s") && !resp.equals("n"));

                if (resp.equals("s")) {

                    Statement stmt;

                    try {
                        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("SELECT * FROM " + EquipoBD.BASE_DATOS + ".EQUIPOS "
                                + "WHERE TEAM_ID = " + team_id + ";");

                        rs.first();
                        rs.deleteRow();

                        stmt.close();

                        System.out.println("\nEquipo eliminado con éxito.");

                    } catch (SQLException ex) {
                        EquipoBD.printSQLException(ex);
                    }

                } else {
                    System.err.println("\n\nSe ha cancelado la eliminación del equipo.");
                }

            } else {
                System.err.println("\n\n\n¡Todavía existen jugadores en ese equipo! - Imposible borrar.");
            }
            
            continua = SLeer2.datoString("¿Desea seguir eliminando equipos? [s/n]: ").toLowerCase();

        } while (continua.equals("s"));
    }

    static void eliminarJugador(Connection con) {

        String resp = "";
        String continua = "";
        int player_id;

        do {

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

            SLeer2.limpiar();

            System.out.println("\n Los datos del jugador a eliminar son: ");
            ConsultarJugadorEquipo.mostrarJugador(con, player_id);

            do {
                resp = SLeer2.datoString("¿Estás seguro de que desea eliminar a ese jugador? [s/n]: ").toLowerCase();
            } while (!resp.equals("s") && !resp.equals("n"));

            if (resp.equals("s")) {

                Statement stmt;

                try {
                    stmt = con.createStatement();
                    stmt.executeUpdate("DELETE FROM " + EquipoBD.BASE_DATOS + ".JUGADORES WHERE PLAYER_ID = " + player_id);

                    System.out.println("\nJugador eliminado con éxito.");

                    stmt.close();
                } catch (SQLException ex) {
                    EquipoBD.printSQLException(ex);
                }

            } else {
                System.out.println("\nSe ha cancelado la eliminación del jugador.");
            }

            continua = SLeer2.datoString("¿Desea seguir eliminando jugadores? [s/n]: ").toLowerCase();

        } while (continua.equals("s"));

    }

}
