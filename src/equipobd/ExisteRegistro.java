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

/**CLASE EXISTE REGISTRO EN TABLAS.
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class ExisteRegistro {

    /**Comprueba si existe un JUGADOR dependiendo de su clave primaria.
     * 
     * @param con Conexión con la BD
     * @param PLAYER_ID clave primaria de JUGADORES.
     * @return true si existe, false si no.
     */
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

    /**Comprueba si existe un EQUIPO dependiendo de su clave primaria.
     * 
     * @param con Conexión con la BD
     * @param TEAM_ID clave primaria de EQUIPOS
     * @return true si existe, false si no.
     */
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
