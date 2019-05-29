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
import java.sql.Statement;

/**CLASE DEVUELVE CUANTOS EQUIPOS EXISTEN.
 *
 * @author Sergio Granero García.
 * @version v1.1
 */
public class CuantosEquipos {

    /**Devuelve el número de equipos que existen en la tabla EQUIPOS, comprobando
     * antes si existe la base de datos y la tabla para evitar excepciones sql.
     * 
     * @param con Conexión con la BD.
     * @return int número de equipos.
     */
    static int numeroEquipos(Connection con) {

        int num_equipos = 0;

        if (ExisteData.existeBaseDatos(con)) {

            try {

                if (ExisteData.existeTablaEquipo(con)) {

                    String count = "SELECT COUNT(*) FROM " + EquipoBD.BASE_DATOS + ".EQUIPOS";

                    Statement stmt = null;

                    stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(count);

                    while (rs.next()) {

                        num_equipos = rs.getInt(1);

                    }

                    stmt.close();
                }

            } catch (SQLException ex) {
                EquipoBD.printSQLException(ex);
            }

        }

        return num_equipos;

    }

}
