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
public class CuantosJugadores {
    
    static int numeroJugadores(Connection con) {
        
        int num_jug = 0;
        
        if (ExisteData.existeBaseDatos(con)) {
            
            try {
                
                if (ExisteData.existeTablaJugadores(con)) {
                    
                    String count = "SELECT COUNT(*) FROM " + EquipoBD.BASE_DATOS + ".JUGADORES";
                    
                    Statement stmt = null;
                    
                    stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(count);
                    
                    while (rs.next()) {
                        
                        num_jug = rs.getInt(1);
                        
                    }
                    
                    stmt.close();
                }
                
            } catch (SQLException ex) {
                EquipoBD.printSQLException(ex);
                
            }
        }
        
        return num_jug;
        
    }
    
    static int numeroJugadoresEquipo(Connection con, int team_id) {
        
        int num_jug = 0;
        Statement stmt;
        
        try {
            
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM " + EquipoBD.BASE_DATOS + ".JUGADORES "
                    + "WHERE TEAM_ID = " + team_id + ";");
            
            while (rs.next()) {
                
                num_jug = rs.getInt(1);
                
            }
            
            stmt.close();
            
        } catch (SQLException ex) {
            EquipoBD.printSQLException(ex);
        }
        
        return num_jug;
        
    }
    
}
