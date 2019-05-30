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

/**CLASE EXISTE BASE DE DATOS O TABLAS.
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class ExisteData {

    /**Comprueba si existe en el servidor la base de datos proporcionada en la 
     * constante BASE_DATOS 
     * 
     * @param con Conexión con el servidor MYSQL
     * @return boolean false si no existe, true si existe.
     */
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

    /**Comprueba si existe la tabla EQUIPOS en la base de datos.
     * 
     * @param con Conexión con la BD
     * @return false si no existe, true si existe.
     */
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
    
    /**Comprueba si existe la tabla JUGADORES.
     * 
     * @param con Conexión con la BD.
     * @return false si no existe, true si existe.
     */
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
