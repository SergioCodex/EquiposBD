/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author root-admin
 */
public class ConsultarJugadorEquipo {

    static void mostrarEquipo(Connection con, int team_id) {

        Statement stmt = null;
        int cont = 1;

        try {

            String select = "SELECT * FROM " + EquipoBD.BASE_DATOS + ".EQUIPOS WHERE TEAM_ID = " + team_id + ";";

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()) {
                Imprimir.imprimirEquipo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), cont);

            }

            stmt.close();

        } catch (SQLException ex) {
            EquipoBD.printSQLException(ex);
        }

    }

    static void mostrarJugador(Connection con, int player_id) {

        Statement stmt = null;
        int cont = 1;

        try {

            String select = "SELECT * FROM " + EquipoBD.BASE_DATOS + ".JUGADORES WHERE PLAYER_ID = " + player_id + ";";

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()) {
                Imprimir.imprimirJugadores(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5), cont);

            }

            stmt.close();

        } catch (SQLException ex) {
            EquipoBD.printSQLException(ex);
        }
    }

}
