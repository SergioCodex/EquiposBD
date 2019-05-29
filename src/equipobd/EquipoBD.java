/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**PROYECTO JAVA DE LA BASE DE DATOS BDEQUIPOS - MAIN.
 *
 * @author Sergio Granero García
 * @version v1.1
 */
public class EquipoBD {

    //Variables.
    static Connection con;
    static final String CONNECTION = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASSWORD = "sergio";
    static final String BASE_DATOS = "bdequipos";

    /**Imprime en bloque las excepciones sql.
     * 
     * @param ex Excepcion sql
     */
    static void printSQLException(SQLException ex) {

        ex.printStackTrace(System.err);
        System.err.println("SQLState: " + ex.getSQLState());
        System.err.println("Error Code: " + ex.getErrorCode());
        System.err.println("Message: " + ex.getMessage());
        Throwable t = ex.getCause();
        while (t != null) {
            System.out.println("Causa: " + t);
            t = t.getCause();
        }
    }

    /**Introduce saltos de línea para "limpiar" la pantalla.
     * 
     */
    static void cls() {

        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            //Conexión inicial.
            con = DriverManager.getConnection(CONNECTION, USER, PASSWORD);

            ConectarBD.conectarBD(con);

            //Resumen
            int nEquipos = CuantosEquipos.numeroEquipos(con);
            int nJugadores = CuantosJugadores.numeroJugadores(con);

            Imprimir.imprimirResumen(nEquipos, nJugadores);

            //Menú.
            int opcion = Menu.menuBD();

            while (opcion != 16) {

                switch (opcion) {
                    case 1: ConectarBD.conectarBD(con); break;
                    case 2: EliminarBD.eliminarBD(con); break;
                    case 3: CrearTablas.crearTablas(con); break;
                    case 4: EliminarTablas.eliminarTablas(con); break;
                    case 5: CargarTablas.cargaTablas(con); break;
                    case 6: VaciarTablas.vaciarTablas(con); break;
                    case 7: AñadirRegistro.insertarJugador(con); break;
                    case 8: ModificarRegistro.modificarJugador(con); break;
                    case 9: EliminarRegistro.eliminarJugador(con); break;
                    case 10: VerTablas.verJugadores(con); break;
                    case 11: VerTablas.verJugadoresEquipo(con); break;
                    case 12: AñadirRegistro.insertarEquipo(con); break;
                    case 13: ModificarRegistro.modificarEquipo(con); break;
                    case 14: EliminarRegistro.eliminarEquipo(con); break;
                    case 15: VerTablas.verEquipos(con); break;
                }
                
                cls();

                //Resumen
                nEquipos = CuantosEquipos.numeroEquipos(con);
                nJugadores = CuantosJugadores.numeroJugadores(con);

                Imprimir.imprimirResumen(nEquipos, nJugadores);

                opcion = Menu.menuBD();

            }

            System.out.println("\n\n\u001B[34m¡Hasta luego Lucas!\u001B[0m\n");

        } catch (SQLException ex) {
            printSQLException(ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    printSQLException(ex);
                }
            }
        }

    }

}
