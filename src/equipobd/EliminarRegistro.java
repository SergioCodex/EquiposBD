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
 * CLASE ELIMINA REGISTROS DE LAS TABLAS EQUIPOS Y JUGADORES.
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class EliminarRegistro {

    /**
     * Método que elimina un equipo de la tabla EQUIPOS, comprueba además si
     * existen jugadores asociados a ese equipo, si es así, no será posible
     * eliminarlo.
     *
     * @param con Conexión con la BD
     */
    static void eliminarEquipo(Connection con) {

        String resp = "";
        String continua = "";
        int team_id;

        do {

            team_id = Entrada.pideTeam_idUpdate(con);

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

            do {
                continua = SLeer2.datoString("¿Desea seguir eliminando equipos? [s/n]: ").toLowerCase();

                if (!continua.equals("s") && !continua.equals("n")) {
                    System.err.println("\n¡Opción no valida!");
                }

            } while (!continua.equals("s") && !continua.equals("n"));

        } while (continua.equals("s"));
    }

    /**
     * Método que elimina de la tabla JUGADORES un registro, elegido por el
     * usuario
     *
     * @param con Conexión con la BD.
     */
    static void eliminarJugador(Connection con) {

        String resp = "";
        String continua = "";
        int player_id;

        do {

            player_id = Entrada.pidePlayer_idUpdate(con);

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

            do {
                continua = SLeer2.datoString("¿Desea seguir eliminando jugadores? [s/n]: ").toLowerCase();

                if (!continua.equals("s") && !continua.equals("n")) {
                    System.err.println("\n¡Opción no valida!");
                }

            } while (!continua.equals("s") && !continua.equals("n"));

        } while (continua.equals("s"));

    }

}
