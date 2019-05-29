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

/**CLASE MODIFICA REGISTROS DE LAS TABLAS EQUIPOS Y JUGADORES 
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class ModificarRegistro {

    static void modificarEquipo(Connection con) {

        int team_id;
        String eq_nombre, estadio, poblacion, provincia, cod_postal, campo, continuar;
        String valor = "";
        boolean correcto = true;

        do {

            team_id = Entrada.pideTeam_idUpdate(con);

            SLeer2.limpiar();

            System.out.println("\n\nLos datos del equipo a editar son: ");
            ConsultarJugadorEquipo.mostrarEquipo(con, team_id);

            do {

                campo = SLeer2.datoString("¿Qué campo desea editar?: ").toUpperCase();

                /*} while (!(campo.equals("EQ_NOMBRE")) && !(campo.equals("ESTADIO")) && !(campo.equals("POBLACION"))
                && !(campo.equals("PROVINCIA")) && !(campo.equals("COD_POSTAL")));*/
                switch (campo) {
                    case "EQ_NOMBRE":
                        valor = Entrada.pideEq_nombre();
                        break;
                    case "ESTADIO":
                        valor = Entrada.pideEstadio();
                        break;
                    case "POBLACION":
                        valor = Entrada.pidePoblacion();
                        break;
                    case "PROVINCIA":
                        valor = Entrada.pideProvincia();
                        break;
                    case "COD_POSTAL":
                        valor = Entrada.pideCod_postal();
                        break;
                    default:
                        System.err.println("\n\nImposible editar ese campo.");
                        correcto = false;
                        break;
                }

            } while (!correcto);

            Statement stmt;

            try {
                stmt = con.createStatement();
                stmt.executeUpdate("UPDATE " + EquipoBD.BASE_DATOS + ".EQUIPOS SET " + campo + " = '" + valor
                        + "' WHERE TEAM_ID = " + team_id + ";");

                System.out.println("\n\u001B[32mEquipo modificado con éxito.\u001B[0m \nLos datos del equipo editado son: ");
                ConsultarJugadorEquipo.mostrarEquipo(con, team_id);
                Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con), CuantosJugadores.numeroJugadores(con));

                stmt.close();
            } catch (SQLException ex) {
                EquipoBD.printSQLException(ex);
            }

            continuar = SLeer2.datoString("¿Desea continuar editando equipos? [s/n]: ").toLowerCase();

        } while (continuar.equals("s"));

    }

    static void modificarJugador(Connection con) {

        int player_id, team_id, dorsal, edad;
        int numero = 0;
        String nombre, campo, continuar;
        String valor = "";
        boolean esNumero = false;
        boolean correcto = true;

        do {

            player_id = Entrada.pidePlayer_idUpdate(con);

            SLeer2.limpiar();

            System.out.println("\n\nLos datos del jugador a editar son: ");
            ConsultarJugadorEquipo.mostrarJugador(con, player_id);

            do {

                campo = SLeer2.datoString("¿Qué campo desea editar?: ").toUpperCase();

                switch (campo) {
                    case "TEAM_ID":
                        numero = Entrada.pideTeam_idUpdate(con);
                        esNumero = true;
                        break;
                    case "NOMBRE":
                        valor = Entrada.pideNombreJug();
                        break;
                    case "DORSAL":
                        numero = Entrada.pideDorsal();
                        esNumero = true;
                        break;
                    case "EDAD":
                        numero = Entrada.pideEdad();
                        esNumero = true;
                        break;
                    default:
                        System.err.println("\n\nImposible editar ese campo.");
                        correcto = false;
                        break;
                }

            } while (!correcto);

            Statement stmt;

            try {

                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                if (esNumero) {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM " + EquipoBD.BASE_DATOS + ".JUGADORES "
                            + "WHERE PLAYER_ID = " + player_id + ";");

                    while (rs.next()) {

                        rs.updateInt(campo, numero);
                        rs.updateRow();

                    }

                    System.out.println("\n\u001B[32mJugador modificado con éxito.\u001B[0m \nLos datos del jugador editado son: ");
                    ConsultarJugadorEquipo.mostrarJugador(con, player_id);
                    Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con), CuantosJugadores.numeroJugadores(con));
                    
                } else {

                    ResultSet rs = stmt.executeQuery("SELECT * FROM " + EquipoBD.BASE_DATOS + ".JUGADORES "
                            + "WHERE PLAYER_ID = " + player_id + ";");

                    while (rs.next()) {

                        rs.updateString(campo, valor);
                        rs.updateRow();

                    }

                    System.out.println("\nJugador modificado con éxito. \nLos datos del jugador editado son: ");
                    ConsultarJugadorEquipo.mostrarJugador(con, player_id);
                    Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con), CuantosJugadores.numeroJugadores(con));

                }
                
                stmt.close();
                
                SLeer2.limpiar();

            } catch (SQLException ex) {

                EquipoBD.printSQLException(ex);
            }

            continuar = SLeer2.datoString("¿Desea continuar editando jugadores? [s/n]: ").toLowerCase();

        } while (continuar.equals("s"));

    }
    
    /*static void modificarJugador(Connection con) {

        int player_id, team_id, dorsal, edad;
        int numero = 0;
        String nombre, campo, continuar;
        String valor = "";
        boolean esNumero = false;
        boolean correcto = true;

        do {

            player_id = Entrada.pidePlayer_idUpdate(con);

            SLeer2.limpiar();

            System.out.println("\n\nLos datos del jugador a editar son: ");
            ConsultarJugadorEquipo.mostrarJugador(con, player_id);

            do {

                campo = SLeer2.datoString("¿Qué campo desea editar?: ").toUpperCase();

                switch (campo) {
                    case "TEAM_ID":
                        numero = Entrada.pideTeam_idUpdate(con);
                        esNumero = true;
                        break;
                    case "NOMBRE":
                        valor = Entrada.pideNombreJug();
                        break;
                    case "DORSAL":
                        numero = Entrada.pideDorsal();
                        esNumero = true;
                        break;
                    case "EDAD":
                        numero = Entrada.pideEdad();
                        esNumero = true;
                        break;
                    default:
                        System.err.println("\n\nImposible editar ese campo.");
                        correcto = false;
                        break;
                }

            } while (!correcto);

            Statement stmt;

            try {

                stmt = con.createStatement();

                if (esNumero) {
                    stmt.executeUpdate("UPDATE " + EquipoBD.BASE_DATOS + ".JUGADORES " +
                            "SET " + campo + " = " + numero + ";");

                    System.out.println("\nJugador modificado con éxito. \nLos datos del jugador editado son: ");
                    ConsultarJugadorEquipo.mostrarJugador(con, player_id);
                    Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con), CuantosJugadores.numeroJugadores(con));
                    
                } else {

                    stmt.executeUpdate("UPDATE " + EquipoBD.BASE_DATOS + ".JUGADORES " +
                            "SET " + campo + " = '" + valor + "';");

                    System.out.println("\nJugador modificado con éxito. \nLos datos del jugador editado son: ");
                    ConsultarJugadorEquipo.mostrarJugador(con, player_id);
                    Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con), CuantosJugadores.numeroJugadores(con));

                }
                
                stmt.close();
                
                SLeer2.limpiar();

            } catch (SQLException ex) {

                EquipoBD.printSQLException(ex);
            }

            continuar = SLeer2.datoString("¿Desea continuar editando jugadores? [s/n]: ").toLowerCase();

        } while (continuar.equals("s"));

    }*/
    
}
