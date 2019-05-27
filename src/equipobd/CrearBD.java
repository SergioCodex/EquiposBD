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
public class CrearBD {

    static void crearBaseDatos(Connection con) {

        String createDB = "create database if not exists " + EquipoBD.BASE_DATOS;

        Statement stmt = null;

        try {

            stmt = con.createStatement();
            stmt.executeUpdate(createDB);

            stmt.close();

        } catch (SQLException ex) {
            EquipoBD.printSQLException(ex);
        }

    }

}
