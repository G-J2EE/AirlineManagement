/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flyhigh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class Connect {
    public Connect(){
        
    };
    PreparedStatement pst = null;
    public Connection Connect(){
       // Create a variable for the connection string.
        
        Connection con = null;
        // Declare the JDBC objects.
        

            try {
                // Establish the connection.
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","0000");
                System.out.print("connection done");
            }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
            System.out.print("connection error");
        } 
            return con;
    }
}
