/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root-admin
 */
public class ExisteData {

    static boolean existeBaseDatos(Connection con) {

        boolean existebd = false;

        try {
            ResultSet rs = con.getMetaData().getCatalogs();

            while (rs.next()) {

                if (rs.getString("TABLE_CAT").equals(EquipoBD.BASE_DATOS)) {
                    existebd = true;
                }

            }

        } catch (SQLException ex) {
            EquipoBD.printSQLException(ex);
        }

        return existebd;
    }

    static boolean existeTablaEquipo(Connection con) {

        boolean existe = false;
        
        try {
            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(EquipoBD.BASE_DATOS, null, "EQUIPOS", null);

            if (tables.next()) {
                existe = true;
            }
  
        } catch (SQLException ex) {
            EquipoBD.printSQLException(ex);
        }
        
        return existe;
    }
    
    static boolean existeTablaJugadores(Connection con) {

        boolean existe = false;
        
        try {
            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(EquipoBD.BASE_DATOS, null, "JUGADORES", null);

            if (tables.next()) {
                existe = true;
            }
  
        } catch (SQLException ex) {
            EquipoBD.printSQLException(ex);
        }
        
        return existe;
    }

}
