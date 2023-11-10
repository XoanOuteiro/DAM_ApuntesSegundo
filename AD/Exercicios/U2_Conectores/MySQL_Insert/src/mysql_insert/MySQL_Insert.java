
package mysql_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author XoanOuteiro
 */
public class MySQL_Insert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        try{
            
            String str = "insert into salarios (categoria) values (\"Programador Junior\"),(\"Programador Senior\"),(\"Analista Junior\"),(\"Analista Senior\");";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","root");
            Statement s = con.createStatement();
            
            int res = s.executeUpdate(str);
            
            System.out.println(res);
            
        }catch(Exception ex){
            
            System.out.println("Error " + ex.getLocalizedMessage());
            
        }
    }
    
}
