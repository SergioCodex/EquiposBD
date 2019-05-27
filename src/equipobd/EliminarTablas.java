/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author root-admin
 */
public class EliminarTablas {

    static void eliminarTablas(Connection con) {

        String dropJugadores = "DROP TABLE IF EXISTS " + EquipoBD.BASE_DATOS + ".JUGADORES";
        String dropEquipos = "DROP TABLE IF EXISTS " + EquipoBD.BASE_DATOS + ".EQUIPOS";

        Statement stmt = null;

        try {

            stmt = con.createStatement();
            stmt.executeUpdate(dropJugadores);
            stmt.executeUpdate(dropEquipos);
            stmt.close();

            System.out.println("\n[Las tablas JUGADORES y EQUIPOS han sido eliminadas]");

        } catch (SQLException ex) {
            EquipoBD.printSQLException(ex);
        }

    }

}
