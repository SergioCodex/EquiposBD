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
 * CLASE CONECTAR A LA BASE DE DATOS.
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class ConectarBD {

    /**
     * Método que se encarga de comprobar si existe la base de datos a la que se
     * desea conectar, si no es así, la crea y se conecta.
     *
     * @param con
     */
    static void conectarBD(Connection con) {

        try {

            ResultSet rs = con.getMetaData().getCatalogs();
            boolean noexistebd = true;

            while (rs.next()) {
                if (rs.getString("TABLE_CAT").equals(EquipoBD.BASE_DATOS)) {
                    noexistebd = false;
                }
            }

            //Crea BD si no existe.
            if (noexistebd) {
                CrearBD.crearBaseDatos(con);
                System.out.println("\n\t[Base de datos " + EquipoBD.BASE_DATOS + " creada]\n");
            }

            //Conexión.
            con = DriverManager.getConnection(EquipoBD.CONNECTION + EquipoBD.BASE_DATOS, EquipoBD.USER, EquipoBD.PASSWORD);
            System.out.println("\n\u001B[32m¡CONEXIÓN REALIZADA CON ÉXITO!\u001B[0m");

            //Cargar tablas con datos.
            CrearTablas.crearTablas(con);
            CargarTablas.cargaTablas(con);

        } catch (SQLException e) {
            EquipoBD.printSQLException(e);
        }

    }

}
