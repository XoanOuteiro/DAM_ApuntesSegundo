package controller;

import java.sql.*;

/**
 *
 * @author XoanOuteiro
 *
 */
public class QueryHandler {

    //Connection Atributes
    private Connection con;

    //Query Strings
    private String queryAll = "select * from empleado;";
    private String queryByNif = "select * from empleado where NIF = ?";
    private String queryByGreaterThanSalary = "select * from empleado where Salario > ?";
    private String queryByLesserThanSalary = "select * from empleado where Salario <= ?";

    //Prepared Statements
    private PreparedStatement qAll;
    private PreparedStatement qByNif;
    private PreparedStatement qByGTSalary;
    private PreparedStatement qByLTSalary;

    //Employee tampering strings
    private String insertEmployee = "insert into empleado (NSS,Nombre,NIF) values (?,?,?)";
    private PreparedStatement iEmployee;

    private String deleteEmmployee = "delete from empleado where nif = ?";
    private PreparedStatement dEmployee;

    //Department tampering methods
    private String insertDepartment = "insert into departamento (Nombredep, Numdep) values (?,?)";
    private PreparedStatement iDepartment;

    private String queryAllDerpartments = "select * from departamento";
    private PreparedStatement qAllDeps;

    private String deleteDepartment = "delete from departamento where Numdep = ?";
    private PreparedStatement dDepartment;

    private String getDepartmentByName = "select * from departamento where Nombredep = ?";
    private PreparedStatement qDepartmentByName;

    private String getDepartmentByNum = "select * from departamento where Numdep = ?";
    private PreparedStatement qDepartmentByNum;


    //Builder methods
    public QueryHandler() throws SQLException {

        this.con = DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","root");

        //Statements
        this.qAll = con.prepareStatement(this.queryAll);
        this.qByNif = con.prepareStatement(this.queryByNif);
        this.qByGTSalary = con.prepareStatement(this.queryByGreaterThanSalary);
        this.qByLTSalary = con.prepareStatement(this.queryByLesserThanSalary);
        this.iEmployee = con.prepareStatement(this.insertEmployee);
        this.dEmployee = con.prepareStatement(this.deleteEmmployee);
        this.iDepartment = con.prepareStatement(this.insertDepartment);
        this.qAllDeps = con.prepareStatement(this.queryAllDerpartments);
        this.dDepartment = con.prepareStatement(this.deleteDepartment);
        this.qDepartmentByName  = con.prepareStatement(this.getDepartmentByName);
        this.qDepartmentByNum = con.prepareStatement(this.getDepartmentByNum);

    }

    //Query methods

    public String getQueryAll() throws SQLException {

        String returnable = "";
        ResultSet r = this.qAll.executeQuery();

        while(r.next()){

            returnable = returnable + r.getString("NIF") + "\t\t\t" +r.getString("Nombre") + "\t\t\t" + r.getString("apel1") + "\t\t\t" + r.getString("apel2") + "\n";

        }

        return returnable;

    }

    public String getQueryByNif(String nif) throws SQLException {

        String returnable = "";

        this.qByNif.setString(1,nif);

        ResultSet r = this.qByNif.executeQuery();

        while(r.next()){

            returnable = r.getString("Nombre") + "\t\t\t" + r.getString("apel1") + "\t\t\t" + r.getString("apel2");

        }

        return returnable;

    }

    public String getQueryByGreaterThanSalary(int n) throws SQLException {

        String returnable = "";

        this.qByGTSalary.setInt(1,n);

        ResultSet r = this.qByGTSalary.executeQuery();

        while(r.next()){

            returnable = returnable + r.getString("Nombre") + "\t\t\t" + r.getString("apel1") + "\t\t\t" + r.getString("apel2") + "\t\t\t" + r.getInt("Salario") + "\n";

        }

        return returnable;

    }

    public String getQueryByLesserThanSalary(int n) throws SQLException {

        String returnable = "";

        this.qByLTSalary.setInt(1,n);

        ResultSet r = this.qByLTSalary.executeQuery();

        while(r.next()){

            returnable = returnable + r.getString("Nombre") + "\t\t\t" + r.getString("apel1") + "\t\t\t" + r.getString("apel2") + "\t\t\t" + r.getInt("Salario") + "\n";

        }

        return returnable;

    }

    /*

        ---Employee tampering---

     */
    public void insertNewEmployee( String nss,  String nombre, String nif) throws SQLException {

        try {

            this.iEmployee.setString(1, nss);
            this.iEmployee.setString(2,nombre);
            this.iEmployee.setString(3,nif);

            this.iEmployee.execute();

        }catch(Exception e){

            throw new SQLException("[ERROR][@insertNewEmployee()] Insert failed: " + e.getLocalizedMessage());

        }
    }

    public void modifyEmployee(){
        //TBD
    }

    public void deleteEmployee(String nif) throws SQLException {

        try{

            this.dEmployee.setString(1,nif);
            this.dEmployee.execute();

        }catch(Exception e){

            throw new SQLException("[ERROR][@deleteEmployee()] Delete failed: " + e.getLocalizedMessage());

        }

    }

    /*

        ---Department tampering---

     */
    public void insertNewDepartment(String name, int num) throws SQLException{

        try{

            this.iDepartment.setString(1,name);
            this.iDepartment.setInt(2,num);
            this.iDepartment.execute();

        }catch(SQLException e){

            throw new SQLException("[ERROR][@insertNewDepartment] Insert failed " + e.getLocalizedMessage());

        }

    }

    public String getQueryAllDepartments() throws SQLException {

        String returnable = "";
        ResultSet r = this.qAllDeps.executeQuery();

        while(r.next()){

            returnable = returnable + r.getString("Numdep") + "\t\t\t" +r.getString("Nombredep") + "\n";

        }

        return returnable;

    }

    public void deleteDepartment(int num) throws SQLException{

        try{

            this.dDepartment.setInt(1,num);
            this.dDepartment.execute();

        }catch(Exception e){

            throw new SQLException(e.getLocalizedMessage());

        }

    }

    public String getDepartmentByName(String name) throws SQLException{

        String returnable = "";

        try{

            this.qDepartmentByName.setString(1,name);
            ResultSet r = this.qDepartmentByName.executeQuery();

            while(r.next()){

                returnable = r.getString("Numdep") + "\t\t\t" + r.getString("Nombredep") + "\t\t\t" + r.getString("Numempdep");

            }

            return returnable;

        }catch(Exception e){

            throw new SQLException(e.getLocalizedMessage());

        }

    }

    public String getDepartmentByNum(int n)throws SQLException{

        String returnable = "";

        try{

            this.qDepartmentByNum.setInt(1,n);
            ResultSet r = this.qDepartmentByNum.executeQuery();

            while(r.next()){

                returnable = r.getString("Numdep") + "\t\t\t" + r.getString("Nombredep") + "\t\t\t" + r.getString("Numempdep");

            }

            return returnable;

        }catch(SQLException e){

            throw new SQLException(e.getLocalizedMessage());

        }


    }
}
