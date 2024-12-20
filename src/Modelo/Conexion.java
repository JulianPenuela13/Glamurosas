
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    public Connection getConnection(){
        
        try {
            String myBD = "jdbc:mysql://localhost:3306/glamurosas?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD, "root", "");
            return con;
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        
        return null;
    }
    
    public void ShowData(String d1, String d2){
    
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            
            if (d1.equals("") || d2.equals(""))
            {
                ps = con.prepareStatement("SELECT * FROM `ventas`");
                
            }else
            {
                ps = con.prepareStatement("SELECT * FROM `ventas` WHERE `fecha` BETWEEN ? AND ?");
                ps.setString(1, d1);
                ps.setString(2, d2);
            }
            
            rs = ps.executeQuery();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }
    

    
    
    
    
    
    
    

}
