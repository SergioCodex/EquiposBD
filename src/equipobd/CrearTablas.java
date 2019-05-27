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
public class CrearTablas {

    static void crearTablas(Connection con) {

        if (ExisteData.existeBaseDatos(con)) {

            String create_equiposString = "create table if not exists " + EquipoBD.BASE_DATOS + ".EQUIPOS "
                    + "(TEAM_ID integer NOT NULL,"
                    + "EQ_NOMBRE varchar(40) NOT NULL,"
                    + "ESTADIO varchar(40) NOT NULL,"
                    + "POBLACION varchar(20) NOT NULL,"
                    + "PROVINCIA varchar(20) NOT NULL,"
                    + "COD_POSTAL char(5),"
                    + "PRIMARY KEY (TEAM_ID))";

            String create_jugadoresString = "create table if not exists " + EquipoBD.BASE_DATOS + ".JUGADORES"
                    + "(PLAYER_ID integer NOT NULL,"
                    + "TEAM_ID integer NOT NULL,"
                    + "NOMBRE varchar(40) NOT NULL,"
                    + "DORSAL integer NOT NULL,"
                    + "EDAD integer NOT NULL,"
                    + "PRIMARY KEY (PLAYER_ID),"
                    + "FOREIGN KEY (TEAM_ID) REFERENCES EQUIPOS (TEAM_ID))";

            Statement stmt = null;
            try {
                stmt = con.createStatement();
                stmt.executeUpdate(create_equiposString);
                stmt.executeUpdate(create_jugadoresString);
                stmt.close();

                System.out.println("\n[Las tablas de EQUIPOS y JUGADORES han sido creadas]");
            } catch (SQLException e) {
                EquipoBD.printSQLException(e);
            }
        } else {
            System.err.println("\n\t¡La base de datos " + EquipoBD.BASE_DATOS + " no existe!");
        }
    }

}
