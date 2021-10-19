package pl.my.studentsys.model.db;

import java.sql.*;

public class JdbcDao {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/studentsys?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "mysqlpassword";

    public Connection getConnection()  {
        Connection conn;
        try{
            conn= DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
            return conn;
        }
        catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }


}
