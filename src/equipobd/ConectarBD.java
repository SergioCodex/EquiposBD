/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root-admin
 */
public class ConectarBD {

    static void conectarBD(Connection con) {

        try {

            ResultSet rs = con.getMetaData().getCatalogs();
            boolean noexistebd = true;

            while (rs.next()) {
                if (rs.getString("TABLE_CAT").equals(EquipoBD.BASE_DATOS)) {
                    noexistebd = false;
                }

            }

            if (noexistebd) {
                CrearBD.crearBaseDatos(con);
                System.out.println("\n\t[Base de datos " + EquipoBD.BASE_DATOS + " creada]\n");
            }
            
            con = DriverManager.getConnection(EquipoBD.CONNECTION + EquipoBD.BASE_DATOS, EquipoBD.USER, EquipoBD.PASSWORD);
            System.out.println("\n¡CONEXIÓN REALIZADA CON ÉXITO!");

            CrearTablas.crearTablas(con);
            CargarTablas.cargaTablas(con);

        } catch (SQLException e) {
            EquipoBD.printSQLException(e);
        }

    }

}
