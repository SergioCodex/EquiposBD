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

/**
 *
 * @author root-admin
 */
public class AñadirRegistro {

    /*static void insertarEquipo(Connection con) {

        String resp = "";
        int team_id;
        String eq_nombre, estadio, poblacion, provincia, cod_postal;

        do {
            Statement stmt = null;

            do {
                team_id = SLeer2.datoInt("\n- Introduce su número de equipo: ");

                if (team_id <= 0 || ExisteRegistro.existeEquipo(con, team_id)) {
                    if (team_id <= 0) {
                        System.err.println("\n\nEl campo debe ser un entero positivo.");
                    } else {
                        System.err.println("\n\nEse equipo ya existe.");
                    }
                }
            } while (team_id <= 0 || ExisteRegistro.existeEquipo(con, team_id));

            SLeer2.limpiar();
            
            do {
                eq_nombre = SLeer2.datoString("- Introduce el nombre del equipo: ").toUpperCase();

                if (eq_nombre.length() < 0 || eq_nombre.length() > 40) {
                    System.err.println("\n\nImposible introducir un nombre tan largo.");
                }
            } while (eq_nombre.length() < 0 || eq_nombre.length() > 40);

            do {
                estadio = SLeer2.datoString("- Introduce el nombre de su estadio: ").toUpperCase();

                if (estadio.length() < 0 || estadio.length() > 40) {
                    System.err.println("\n\nImposible introducir un nombre tan largo.");
                }
            } while (estadio.length() < 0 || estadio.length() > 40);

            do {
                poblacion = SLeer2.datoString("- Introduce el nombre de la población: ").toUpperCase();

                if (poblacion.length() < 0 || poblacion.length() > 20) {
                    System.err.println("\n\nImposible introducir un nombre tan largo.");
                }
            } while (poblacion.length() < 0 || poblacion.length() > 20);

            do {
                provincia = SLeer2.datoString("- Introduce el nombre de la provincia: ").toUpperCase();

                if (provincia.length() < 0 || provincia.length() > 20) {
                    System.err.println("\n\nImposible introducir un nombre tan largo.");
                }
            } while (provincia.length() < 0 || provincia.length() > 20);

            do {
                cod_postal = SLeer2.datoString("- Introduce el código postal del equipo: ");

                if (cod_postal.length() != 5) {
                    System.err.println("\n\nCódigo postal incorrecto, debe contener 5 cifras.");
                }
            } while (cod_postal.length() != 5);


            try {

                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + EquipoBD.BASE_DATOS + ".EQUIPOS");

                rs.moveToInsertRow();
                rs.updateInt("TEAM_ID", team_id);
                rs.updateString("EQ_NOMBRE", eq_nombre);
                rs.updateString("ESTADIO", estadio);
                rs.updateString("POBLACION", poblacion);
                rs.updateString("PROVINCIA", provincia);
                rs.updateString("COD_POSTAL", cod_postal);
                rs.insertRow();
                rs.beforeFirst();
                
                stmt.close();

            } catch (SQLException ex) {
                EquipoBD.printSQLException(ex);
            }
            
            resp = SLeer2.datoString("¿Quieres introducir otro registro más? [s/n]: ").toLowerCase();

        } while (resp.equals("s"));

    }*/
    static void insertarEquipo(Connection con) {

        String resp = "";
        int team_id;
        String eq_nombre, estadio, poblacion, provincia, cod_postal;

        do {
            Statement stmt;

            team_id = Entrada.pideTeam_idAgregar(con);

            SLeer2.limpiar();

            eq_nombre = Entrada.pideEq_nombre();

            estadio = Entrada.pideEstadio();

            poblacion = Entrada.pidePoblacion();

            provincia = Entrada.pideProvincia();

            cod_postal = Entrada.pideCod_postal();

            try {

                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".EQUIPOS VALUES(" + team_id
                        + ", '" + eq_nombre + "' , '" + estadio + "' , '" + poblacion + "' , '"
                        + provincia + "' , '" + cod_postal + "');");

                stmt.close();

            } catch (SQLException ex) {
                EquipoBD.printSQLException(ex);
            }

            resp = SLeer2.datoString("¿Quieres introducir otro registro más? [s/n]: ").toLowerCase();

        } while (resp.equals("s"));

    }

    /*static void insertarJugador(Connection con) {

        String resp = "";
        int player_id;
        int team_id;
        String nombre;
        int dorsal;
        int edad;

        do {
            Statement stmt = null;

            do {
                player_id = SLeer2.datoInt("\n- Introduce su número de jugador: ");

                if (player_id <= 0 || ExisteRegistro.existeJugador(con, player_id)) {
                    if (player_id <= 0) {
                        System.err.println("\n\nEl campo debe ser un entero positivo.");
                    } else {
                        System.err.println("\n\nEse jugador ya existe.");
                    }
                }
            } while (player_id <= 0 || ExisteRegistro.existeJugador(con, player_id));

            SLeer2.limpiar();

            do {
                team_id = SLeer2.datoInt("\n - Introduce su número de equipo: ");

                if (team_id <= 0 || !ExisteRegistro.existeEquipo(con, team_id)) {
                    if (team_id <= 0) {
                        System.err.println("\n\nEl campo debe ser un entero positivo.");
                    } else {
                        System.err.println("\n\nEse equipo no existe.");
                    }
                }

            } while (team_id <= 0 || !ExisteRegistro.existeEquipo(con, team_id));

            SLeer2.limpiar();
            
            do {
                nombre = SLeer2.datoString("- Introduce el nombre del jugador: ").toUpperCase();

                if (nombre.length() < 0 || nombre.length() > 40) {
                    System.err.println("\n\nImposible introducir un nombre tan largo.");
                }
            } while (nombre.length() < 0 || nombre.length() > 40);

            do {
                dorsal = SLeer2.datoInt("- Introduce el dorsal del jugador: ");

                if (dorsal <= 0) {
                    System.err.println("\n\nEl campo debe ser un entero positivo.");
                }
            } while (dorsal <= 0);

            do {
                edad = SLeer2.datoInt("- Introduce la edad del jugador: ");

                if (edad <= 0) {
                    System.err.println("\n\nEl campo debe ser un entero positivo.");
                }
            } while (edad <= 0);

            SLeer2.limpiar();
            
            try {

                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO " + EquipoBD.BASE_DATOS + ".JUGADORES VALUES(" + player_id
                        + ", " + team_id + " , '" + nombre + "' , " + dorsal + " , " + edad + ");");

                stmt.close();

            } catch (SQLException ex) {
                EquipoBD.printSQLException(ex);
            }

            resp = SLeer2.datoString("¿Quieres introducir otro registro más? [s/n]: ").toLowerCase();

        } while (resp.equals("s"));

    }*/
    static void insertarJugador(Connection con) {

        String resp = "";
        int player_id;
        int team_id;
        String nombre;
        int dorsal;
        int edad;

        do {
            Statement stmt = null;

            player_id = Entrada.pidePlayer_idAgregar(con);

            SLeer2.limpiar();

            team_id = Entrada.pideTeam_idUpdate(con);

            SLeer2.limpiar();

            nombre = Entrada.pideNombreJug();

            dorsal = Entrada.pideDorsal();

            edad = Entrada.pideEdad();

            SLeer2.limpiar();

            try {

                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + EquipoBD.BASE_DATOS + ".JUGADORES");

                rs.moveToInsertRow();
                rs.updateInt("PLAYER_ID", player_id);
                rs.updateInt("TEAM_ID", team_id);
                rs.updateString("NOMBRE", nombre);
                rs.updateInt("DORSAL", dorsal);
                rs.updateInt("EDAD", edad);
                rs.insertRow();
                rs.beforeFirst();

                stmt.close();

            } catch (SQLException ex) {
                EquipoBD.printSQLException(ex);
            }

            resp = SLeer2.datoString("¿Quieres introducir otro registro más? [s/n]: ").toLowerCase();

        } while (resp.equals("s"));

    }

}
