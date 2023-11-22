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


    //Builder methods
    public QueryHandler() throws SQLException {

        this.con = DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","root");

        //Statements
        this.qAll = con.prepareStatement(this.queryAll);
        this.qByNif = con.prepareStatement(this.queryByNif);
        this.qByGTSalary = con.prepareStatement(this.queryByGreaterThanSalary);
        this.qByLTSalary = con.prepareStatement(this.queryByLesserThanSalary);

    }

    //Query methods

    public String getQueryAll() throws SQLException {

        String returnable = "";
        ResultSet r = this.qAll.executeQuery();

        while(r.next()){

            returnable = returnable + r.getString("Nombre") + "\t" + r.getString("apel1") + "\t" + r.getString("apel2") + "\n";

        }

        return returnable;

    }

    public String getQueryByNif(String nif) throws SQLException {

        String returnable = "";

        this.qByNif.setString(1,nif);

        ResultSet r = this.qByNif.executeQuery();

        while(r.next()){

            returnable = r.getString("Nombre") + "\t" + r.getString("apel1") + "\t" + r.getString("apel2");

        }

        return returnable;

    }

    public String getQueryByGreaterThanSalary(int n) throws SQLException {

        String returnable = "";

        this.qByGTSalary.setInt(1,n);

        ResultSet r = this.qByGTSalary.executeQuery();

        while(r.next()){

            returnable = r.getString("Nombre") + "\t" + r.getString("apel1") + "\t" + r.getString("apel2") + "\t" + r.getInt("Salario") + "\n";

        }

        return returnable;

    }

    public String getQueryByLesserThanSalary(int n) throws SQLException {

        String returnable = "";

        this.qByLTSalary.setInt(1,n);

        ResultSet r = this.qByLTSalary.executeQuery();

        while(r.next()){

            returnable = r.getString("Nombre") + "\t" + r.getString("apel1") + "\t" + r.getString("apel2") + "\t" + r.getInt("Salario") + "\n";

        }

        return returnable;

    }
}
