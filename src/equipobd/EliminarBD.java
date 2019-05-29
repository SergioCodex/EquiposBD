/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import Sleer2.SLeer2;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**CLASE ELIMINA LA BASE DE DATOS
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class EliminarBD {

    /**Elimina la base de datos.
     * 
     * @param con Conexión con el servidor mysql.
     */
    static void eliminarBD(Connection con) {
        String resp;
        SLeer2.limpiar();

        do {

            resp = SLeer2.datoString("¿Estás seguro que desea eliminar la base de datos " + EquipoBD.BASE_DATOS + "?[s/n]: ").toLowerCase();

        } while (!resp.equals("s") && !resp.equals("n"));

        if (resp.equals("s")) {

            String dropBD = "drop database if exists " + EquipoBD.BASE_DATOS;
            Statement stmt = null;

            try {
                stmt = con.createStatement();
                stmt.executeUpdate(dropBD);
                
                System.out.println("\n[Se ha eliminado la base de datos " + EquipoBD.BASE_DATOS + "]");
                
                stmt.close();

            } catch (SQLException ex) {
                EquipoBD.printSQLException(ex);
            }
        }

    }

}
