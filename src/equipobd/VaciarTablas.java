/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import Sleer2.SLeer2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**CLASE VACIAR TABLAS EQUIPOS/JUGADORES.
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class VaciarTablas {

    /*static void vaciarTablas(Connection con){
        
        String deleteJugadores = "DELETE FROM " + EquipoBD.BASE_DATOS + ".JUGADORES";
        String deleteEquipos = "DELETE FROM " + EquipoBD.BASE_DATOS + ".EQUIPOS";

        Statement stmt = null;

        try {

            stmt = con.createStatement();
            stmt.executeUpdate(deleteJugadores);
            stmt.executeUpdate(deleteEquipos);
            stmt.close();

            System.out.println("\n[Las tablas JUGADORES y EQUIPOS han sido vaciadas]");

        } catch (SQLException ex) {
            EquipoBD.printSQLException(ex);
        }
        
    }*/
    static void vaciarTablas(Connection con) {

        vaciarJugadores(con);

        vaciarEquipos(con);

    }

    static void vaciarJugadores(Connection con) {

        String resp;
        SLeer2.limpiar();

        if (ExisteData.existeTablaJugadores(con)) {

            do {

                resp = SLeer2.datoString("¿Estás seguro que desea eliminar la tabla JUGADORES?[s/n]: ").toLowerCase();

            } while (!resp.equals("s") && !resp.equals("n"));

            if (resp.equals("s")) {

                try {

                    String deleteJugadores = "DELETE FROM " + EquipoBD.BASE_DATOS + ".JUGADORES";
                    Statement stmt = null;

                    stmt = con.createStatement();
                    stmt.executeUpdate(deleteJugadores);

                    stmt.close();

                    System.out.println("\n[Tabla JUGADORES vaciada con éxito]");

                } catch (SQLException ex) {
                    EquipoBD.printSQLException(ex);
                }

            } else {

                System.out.println("\n\n[Vaciado de JUGADORES abortado]");

            }

        } else {
            System.err.println("\n\n\t¡La tabla JUGADORES no existe!");
        }

    }

    /*static void vaciarJugadores(Connection con) {

        String resp;
        SLeer2.limpiar();

        do {

            resp = SLeer2.datoString("¿Estás seguro que desea vaciar la tabla JUGADORES?[s/n]: ").toLowerCase();

        } while (!resp.equals("s") && !resp.equals("n"));

        if (resp.equals("s")) {
            try {
                String select = "SELECT * FROM " + EquipoBD.BASE_DATOS + ".JUGADORES";
                Statement stmt = null;

                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery(select);

                while (rs.next()) {

                    rs.deleteRow();

                }

                System.out.println("\n[Tabla JUGADORES vaciada con éxito]");

                stmt.close();

            } catch (SQLException ex) {
                EquipoBD.printSQLException(ex);
            }

        } else {

            System.out.println("\n\n[Acción abortada]");

        }

    }*/
    static void vaciarEquipos(Connection con) {

        String resp;

        if (CuantosJugadores.numeroJugadores(con) == 0) {

            if (ExisteData.existeTablaEquipo(con)) {

                do {

                    resp = SLeer2.datoString("¿Estás seguro que desea vaciar la tabla EQUIPOS?[s/n]: ").toLowerCase();

                } while (!resp.equals("s") && !resp.equals("n"));

                if (resp.equals("s")) {

                    try {

                        String select = "SELECT * FROM " + EquipoBD.BASE_DATOS + ".EQUIPOS";

                        Statement stmt = null;

                        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery(select);

                        while (rs.next()) {

                            rs.deleteRow();

                        }

                        System.out.println("\n[Tabla EQUIPOS vaciada con éxito]");

                        stmt.close();

                    } catch (SQLException ex) {
                        EquipoBD.printSQLException(ex);
                    }

                } else {

                    System.out.println("\n\n[Vaciado de EQUIPOS abortado]");

                }

            } else {

                System.err.println("\n\n\t¡La tabla EQUIPOS no existe!");

            }

        } else {

            System.err.println("\n\t¡No se puede borrar la tabla EQUIPOS porque todavía hay jugadores!");

        }

    }

    /*
    
    static void vaciarEquipos(Connection con) {

        String resp;
        SLeer2.limpiar();

        if (ExisteData.existeTablaEquipo(con)) {

            do {

                resp = SLeer2.datoString("¿Estás seguro que desea vaciar la tabla EQUIPO?[s/n]: ").toLowerCase();

            } while (!resp.equals("s") && !resp.equals("n"));

            if (resp.equals("s")) {

                try {

                    String deleteEquipos = "DELETE FROM " + EquipoBD.BASE_DATOS + ".EQUIPO";
                    Statement stmt = null;

                    stmt = con.createStatement();
                    stmt.executeUpdate(deleteEquipos);

                    stmt.close();

                    System.out.println("\n[Tabla EQUIPOS vaciada con éxito]");

                } catch (SQLException ex) {
                    EquipoBD.printSQLException(ex);
                }

            } else {

                System.out.println("\n\n[Acción abortada]");

            }

        } else {
            System.err.println("\n\n\t¡La tabla EQUIPOS no existe!");
        }

    }
    
     */
}
