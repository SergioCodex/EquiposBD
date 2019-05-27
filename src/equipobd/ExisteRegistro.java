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
public class ExisteRegistro {

    static boolean existeJugador(Connection con, int PLAYER_ID) {

        boolean existe = false;
        int result = 0;

        Statement stmt = null;

        try {
            String consulta = "SELECT COUNT(*) FROM " + EquipoBD.BASE_DATOS + ".JUGADORES WHERE PLAYER_ID=" + PLAYER_ID;

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            while (rs.next()) {

                result = rs.getInt(1);

            }

            if (result == 0) {
                existe = false;
            } else {
                existe = true;
            }

            stmt.close();

        } catch (SQLException sql) {
            EquipoBD.printSQLException(sql);
        }

        return existe;
    }

    static boolean existeEquipo(Connection con, int TEAM_ID) {

        boolean existe = false;
        int result = 0;

        Statement stmt = null;

        try {

            String consulta = "SELECT COUNT(*) FROM " + EquipoBD.BASE_DATOS + ".EQUIPOS WHERE TEAM_ID=" + TEAM_ID;

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            while (rs.next()) {

                result = rs.getInt(1);

            }

            if (result == 0) {
                existe = false;
            } else if (result == 1) {
                existe = true;
            }

            stmt.close();

        } catch (SQLException sql) {
            EquipoBD.printSQLException(sql);
        }

        return existe;
    }

}
