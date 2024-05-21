package crudBase;

import java.sql.*;


public class CrudUtil {
    private static String url= "jdbc:postgresql://localhost:5432/HM1-base";
    private static String dbName= "postgres";
    private static String dbPass= "postgres";

    public static Connection getConnection(){
        Connection connection =null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, dbName, dbPass);

        }catch (Exception e){  throw new RuntimeException(e);}

        return connection;
    }
}
