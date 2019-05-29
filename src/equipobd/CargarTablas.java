/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**CLASE CARGA TABLAS CON DATOS DE EQUIPOS Y JUGADORES.
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class CargarTablas {

    /**Carga de datos en las tablas de la BD. Se asegura de que no existan claves primarias
     * repetidas, además de que exista la base de datos y la tabla donde volcar los datos.
     * 
     * @param con Conexión con la BD.
     */
    static void cargaTablas(Connection con) {

        Statement stmt = null;

        if (ExisteData.existeBaseDatos(con)) {

            try {

                if (ExisteData.existeTablaEquipo(con)) {

                    stmt = con.createStatement();

                    //Cargar tabla EQUIPOS.
                    if (!ExisteRegistro.existeEquipo(con, 1)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".EQUIPOS VALUES ("
                                + "1,'ESTEPONA','MONTERROSO','ESTEPONA','MALAGA','29680')");
                    }

                    if (!ExisteRegistro.existeEquipo(con, 2)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".EQUIPOS VALUES ("
                                + "2,'ALCORCON','SANTO DOMINGO','ALCORCON','MADRID','28924')");
                    }

                    if (!ExisteRegistro.existeEquipo(con, 3)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".EQUIPOS VALUES ("
                                + "3,'PORCUNA','SAN CRISTOBAL','PORCUNA','JAEN','23790')");
                    }

                    System.out.println("\n\t[Tabla EQUIPOS cargada]");

                } else {

                    System.err.println("\n\n\t¡La tabla EQUIPOS no existe!");

                }

                if (ExisteData.existeTablaJugadores(con)) {

                    //Cargar tabla JUGADORES.
                    if (!ExisteRegistro.existeJugador(con, 1)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".JUGADORES VALUES ("
                                + "1,1,'JOSE ANTONIO',1,42)");
                    }

                    if (!ExisteRegistro.existeJugador(con, 2)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".JUGADORES VALUES ("
                                + "2,1,'IGNACIO',2,62)");
                    }

                    if (!ExisteRegistro.existeJugador(con, 3)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".JUGADORES VALUES ("
                                + "3,1,'DIEGO',3,20)");
                    }
                    //Cargando datos de Alcorcón
                    if (!ExisteRegistro.existeJugador(con, 4)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".JUGADORES VALUES ("
                                + "4,2,'TURRION',1,37)");
                    }

                    if (!ExisteRegistro.existeJugador(con, 5)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".JUGADORES VALUES ("
                                + "5,2,'LUIS ABEL',2,37)");
                    }

                    if (!ExisteRegistro.existeJugador(con, 6)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".JUGADORES VALUES ("
                                + "6,2,'ISAAC',3,40)");
                    }
                    //Cargando datos de Porcuna
                    if (!ExisteRegistro.existeJugador(con, 7)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".JUGADORES VALUES ("
                                + "7,3,'JUAN FRANCISCO',1,33)");
                    }

                    if (!ExisteRegistro.existeJugador(con, 8)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".JUGADORES VALUES ("
                                + "8,3,'PARRA',2,37)");
                    }

                    if (!ExisteRegistro.existeJugador(con, 9)) {
                        stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".JUGADORES VALUES ("
                                + "9,3,'RAUL',3,19)");
                    }

                    System.out.println("\n\t[Tabla JUGADORES cargada]\n");

                } else {

                    System.err.println("\n\t¡La tabla JUGADORES no existe!");

                }

                if (stmt != null) {

                    stmt.close();

                }

            } catch (SQLException e) {
                EquipoBD.printSQLException(e);
            }
        } else {
            System.err.println("\n\t¡La base de datos " + EquipoBD.BASE_DATOS + " no existe!");
        }
    }

}
