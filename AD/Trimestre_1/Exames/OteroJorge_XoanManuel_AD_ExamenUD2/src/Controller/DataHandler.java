package Controller;

import java.sql.*;

/**
 *
 * @author a22xoanmoj
 */
public class DataHandler {

    //Connection Atributes
    private Connection con;

    //Strings
    private String queryAll = "select * from empleados";
    private String queryByNIF = "select * from empleados where NIF = ?";
    private String queryByLessThan = "select * from empleados where Salario < ? ";

    private String inserNewEmployee = "insert into empleados (NIF,Nombre,Apellidos,Salario) values (?,?,?,?)";

    private String updateSalary = "update empleados set salario = ? where nif = ? ";

    //Prepared statements
    private PreparedStatement qAll;
    private PreparedStatement qByLT;
    private PreparedStatement iEmployee;
    private PreparedStatement uEmployee;
    private PreparedStatement qByNIF;

    public DataHandler() throws SQLException {

        try {

            this.con = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "root");

            //Statements
            this.qAll = con.prepareStatement(this.queryAll);
            this.qByLT = con.prepareStatement(this.queryByLessThan);
            this.iEmployee = con.prepareStatement(this.inserNewEmployee);
            this.uEmployee = con.prepareStatement(this.updateSalary);
            this.qByNIF = con.prepareStatement(this.queryByNIF);

        } catch (Exception e) {

            throw new SQLException(e.getLocalizedMessage());

        }

    }

    //Queries
    public String listarEmpleados() throws SQLException {

        String returnable = "";
        ResultSet r = this.qAll.executeQuery();

        while (r.next()) {

            returnable = returnable + r.getString("NIF") + "\t\t\t" + r.getString("Nombre") + "\t\t\t" + r.getString("Apellidos") + "\n";

        }

        return returnable;

    }

    public String datosEmpleadoNIF(String nif) throws SQLException {

        String returnable = "";
        this.qByNIF.setString(1, nif);
        ResultSet r = this.qByNIF.executeQuery();

        while (r.next()) {

            returnable = returnable + r.getString("NIF") + "\t\t\t" + r.getString("Nombre") + "\t\t\t" + r.getString("Apellidos") + "\t\t\t" + r.getString("salario") + "\n";

        }

        return returnable;

    }

    public String empleadosSalarioMenor(float n) throws SQLException {

        String returnable = "";
        this.qByLT.setFloat(1, n);
        ResultSet r = this.qByLT.executeQuery();

        while (r.next()) {

            returnable = returnable + r.getString("NIF") + "\t\t\t" + r.getString("Nombre") + "\t\t\t" + r.getString("Apellidos") + "\t\t\t" + r.getString("salario") + "\n";

        }

        return returnable;

    }
    
    //Inserts and updates
    public String insertarEmpleados(String NIF, String Nombre, String Apellidos, float salario){
        
        try{
            
            this.iEmployee.setString(1, NIF);
            this.iEmployee.setString(2, Nombre);
            this.iEmployee.setString(3, Apellidos);
            this.iEmployee.setFloat(4, salario);
            this.iEmployee.execute();
            return "Employee succesfuly inserted.";
            
        }catch(Exception e){
            
            return "Error when inserting employee: " + e.getLocalizedMessage();
            
        }
        
    }
    
    public String modificarSalarioEmpleado(String nif, float salario){
        
        try{
            
            this.uEmployee.setFloat(1, salario);
            this.uEmployee.setString(2, nif);
            this.uEmployee.execute();
            return "Employee succesfully modified.";
            
        }catch(Exception e){
            
            return "Error when modifying salary: " + e.getLocalizedMessage();
              
        }
   
    }
}
