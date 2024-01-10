
package mysql_creartabla;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
public class MySQL_CrearTabla {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{    //Apartado creacion tabla
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","root");
            
            String update = "Create table if not exists Salarios(codigo integer primary key auto_increment, categoria varchar(20))";
            Statement s = con.createStatement();
            int result = s.executeUpdate(update);
            
            System.out.println(result);
            
            con.close();
            
        }catch(SQLException ex){
            
            System.out.println(ex.getLocalizedMessage());
            
        }
        
        try{    //Apartado obtencion datos
            
            
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","root");
            
            DatabaseMetaData dbmd = con2.getMetaData();
            String[] tipos = {"TABLE","VIEW"};
            ResultSet tablas = dbmd.getTables(null, null, null, tipos);
            
            while (tablas.next()){
                System.out.println(tablas.getString("TABLE_TYPE") + "\t" + tablas.getString("TABLE_NAME"));
            }
            
            con2.close();
            
        }catch(SQLException ex){
            
            System.out.println(ex.getLocalizedMessage());
            
        }
        
    }
    
}
