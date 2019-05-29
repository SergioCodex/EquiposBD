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

/**CLASE CONSULTA JUGADORES Y EQUIPOS.
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class ConsultarJugadorEquipo {

    /**Busca y muestra/imprime un equipo dependiendo del team_id proporcionado.
     * 
     * @param con Conexión con la BD.
     * @param team_id Clave primaria de EQUIPOS.
     */
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

    /**Busca y muestra/imprime un jugador dependiendo del player_id proporcionado.
     * 
     * @param con Conexión con la BD
     * @param player_id Clave primaria de JUGADORES.
     */
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
