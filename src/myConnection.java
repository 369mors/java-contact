
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nec
 */
public class myConnection {
    
    public static Connection getConnection() {
        
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javacontactsapp", "root", "");
            System.out.println("Connection is successful");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return con;
        
    }
}
