package DAO;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author randr
 */

import java.sql.*;

public class ConnectionBase {
    Connection connection;

    public final void CONNECT_BDD_ORACLE(String username,String password){
        connect_to_database_ORACLE(username, password);
    }
    
    public final Connection CONNECT_BDD_POSTGRES(String database,String Username,String password){
        return connect_to_database_PostGRES(database,Username, password);
    }

    private void connect_to_database_ORACLE(String username,String password){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:BDDOracle", username, password);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private Connection connect_to_database_PostGRES(String database,String username,String password){
         try {
            Class.forName("org.postgresql.Driver");
            //Add Database Name to end of String
            connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+database, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
         return connection;
    }

    public Connection get_Connection(){
        return this.connection;
    }
    
    public static Connection getconnectedPOSTGRES(String database,String username,String password) throws SQLException{
        Connection connection = null;
        //            Class.forName("org.pgsql.Driver");
        //Add Database Name to end of String
        connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+database, username, password);
        return connection;
    }
    
    public static void closeConnection(Connection c) throws SQLException{
        c.close();
    }
        
}
