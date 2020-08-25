/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riki subagja
 */
public class databaseutilities {
     private static Connection connection;

    public static Connection getConnection() {
        
        if(connection  == null){
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbf1","root","");
            } catch (SQLException ex) {
                Logger.getLogger(databaseutilities.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return connection;
        
}
}