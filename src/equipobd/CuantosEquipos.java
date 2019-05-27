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

/**
 *
 * @author root-admin
 */
public class CuantosEquipos {

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
