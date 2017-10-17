package com.prebigdata.uma.master.bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {
    
    public static Connection getConnection() throws Exception {
        StringBuilder connectionString;
        Connection connectionReference;
        
        String databaseHost;
        String databasePort;
        String databaseName;
        String databaseUser;
        String databasePassword;
       
        try
        {
            connectionString = new StringBuilder();
            
            databaseHost = "<IP>";
            databasePort = "<PORT>";
            databaseName = "<DATABASE_NAME>";
            databaseUser = "<DATABASE_USER>";
            databasePassword = "<DATABASE_PASSWORD>"; 
            
            
            Class.forName("com.mysql.jdbc.Driver");
            connectionString.append("jdbc:mysql://");
            connectionString.append(databaseHost);
            connectionString.append(":");
            connectionString.append(databasePort);
            connectionString.append("/");
            connectionString.append(databaseName);
            connectionString.append("?");
            connectionString.append("user=");
            connectionString.append(databaseUser);
            connectionString.append("&");
            connectionString.append("password=");
            connectionString.append(databasePassword);

            connectionReference = DriverManager.getConnection(connectionString.toString());
            
            return connectionReference;
        } catch(ClassNotFoundException | SQLException exception) {
            throw exception;
        }
    }
    
    public static void closeConnection(Connection connectionReference) throws SQLException {
        if (connectionReference != null) {
            connectionReference.close();
        }
    }
}
