
package pruebasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XoanOuteiro
 */
public class PruebaSQL {
    public static void main(String[] args) {
        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","root");
            
            Statement sentencia = con.createStatement();
            String sql = "Select * from proyecto";
            ResultSet res = sentencia.executeQuery(sql);
            
            while(res.next()){
                
                int cod = res.getInt("Numproy");
                String nombre = res.getString("Nombreproy");
                String lugar = res.getString("Lugarproy");
                
                System.out.println("CODIGO: " + cod + "\tNOMBRE: " + nombre + "\tLUGAR: " + lugar);
                
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(PruebaSQL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
