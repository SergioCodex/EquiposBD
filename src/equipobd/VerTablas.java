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
public class VerTablas {

    static void verEquipos(Connection con) {

        String verEquipos = "SELECT * FROM " + EquipoBD.BASE_DATOS + ".EQUIPOS";
        int cont = 1;

        Statement stmt = null;

        try {

            if (ExisteData.existeTablaEquipo(con)) {

                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(verEquipos);

                while (rs.next()) {
                    //Versión acortada.
                    Imprimir.imprimirEquipo(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getString(5), rs.getString(6), cont);

                    cont++;

                }

                stmt.close();

            } else {

                System.err.println("\n\t¡La tabla EQUIPOS no existe!");

            }

        } catch (SQLException ex) {

            EquipoBD.printSQLException(ex);

        }

    }

    static void verJugadores(Connection con) {

        String verJugadores = "SELECT * FROM " + EquipoBD.BASE_DATOS + ".JUGADORES";
        int cont = 0;

        Statement stmt = null;

        try {

            if (ExisteData.existeTablaJugadores(con)) {

                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(verJugadores);

                while (rs.next()) {
                    //Mi versión.
                    int player_id = rs.getInt(1);
                    int team_id = rs.getInt(2);
                    String nombre = rs.getString(3);
                    int dorsal = rs.getInt(4);
                    int edad = rs.getInt(5);
                    cont++;

                    Imprimir.imprimirJugadores(player_id, team_id, nombre, dorsal, edad, cont);

                }

                stmt.close();

            } else {
                System.err.println("\n\t¡La tabla JUGADORES no existe!");
            }

        } catch (SQLException ex) {

            EquipoBD.printSQLException(ex);

        }

    }

    static void verJugadoresEquipo(Connection con) {

        int num_equipos = CuantosEquipos.numeroEquipos(con);
        int opcion;
        int cont = 1;

        try {

            if (ExisteData.existeBaseDatos(con)) {

                if (ExisteData.existeTablaEquipo(con)) {

                    do {

                        opcion = SLeer2.datoInt("¿De qué equipo quieres mostrar sus jugadores? [1-" + num_equipos + "]: ");

                        if (opcion < 1 || opcion > num_equipos) {

                            System.err.println("\n\n\t¡No existe ese equipo en la base de datos!\n");

                        }

                    } while (opcion < 1 || opcion > num_equipos);

                    String select = "SELECT * FROM " + EquipoBD.BASE_DATOS + ".JUGADORES WHERE TEAM_ID=" + opcion;

                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(select);

                    while (rs.next()) {

                        Imprimir.imprimirJugadores(rs.getInt(1), rs.getInt(2), rs.getString(3),
                                rs.getInt(4), rs.getInt(5), cont);

                        cont++;

                    }

                    stmt.close();

                } else {

                    System.err.println("\n\n\t¡La tabla EQUIPOS no existe!");

                }

            } else {

                System.err.println("\n\n\t¡La base de datos no existe!");

            }

        } catch (SQLException ex) {

            EquipoBD.printSQLException(ex);

        }

    }
}
