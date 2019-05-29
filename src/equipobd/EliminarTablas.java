/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**CLASE ELIMINA TABLAS EQUIPOS/JUGADORES.
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class EliminarTablas {

    /**Elimina las tablas de EQUIPOS y JUGADORES de la base de datos.
     * 
     * @param con Conexion con la BD. 
     */
    static void eliminarTablas(Connection con) {

        String dropJugadores = "DROP TABLE IF EXISTS " + EquipoBD.BASE_DATOS + ".JUGADORES";
        String dropEquipos = "DROP TABLE IF EXISTS " + EquipoBD.BASE_DATOS + ".EQUIPOS";

        Statement stmt = null;

        try {

            stmt = con.createStatement();
            stmt.executeUpdate(dropJugadores);
            stmt.executeUpdate(dropEquipos);
            stmt.close();

            System.out.println("\n\u001B[32m[Las tablas JUGADORES y EQUIPOS han sido eliminadas]\u001B[0m");

        } catch (SQLException ex) {
            EquipoBD.printSQLException(ex);
        }

    }

}
