
package Modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedioPagoDAO {
    
    Connection con;
    Conexion cn = new Conexion();
    Statement ps;
    ResultSet rs;
    
    public ArrayList<Mediop> getmedio(){

        con = cn.getConnection();
        ArrayList<Mediop> ListaMedio = new ArrayList<>();
        
        try {
            ps = con.createStatement();
            rs = ps.executeQuery("SELECT * FROM mediop");
            
            while (rs.next()) {                
                
                Mediop metodo = new Mediop();
                metodo.setId(rs.getInt("id"));
                metodo.setPago(rs.getString("pago"));
                ListaMedio.add(metodo);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MedioPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListaMedio;
    }
}
