
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbonoDAO {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarAbonos(Abono abo){
        String sql = "INSERT INTO abonos(producto, cantidad, precio, cliente, abono) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, abo.getProducto());
            ps.setInt(2, abo.getCantidad());
            ps.setDouble(3, abo.getPrecio());
            ps.setString(4, abo.getCliente());
            ps.setDouble(5, abo.getAbono());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List ListarAbonos(){
      List<Abono>ListaAb = new ArrayList();
      String sql = "SELECT * FROM abonos";
      try {
          con = cn.getConnection();
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          while (rs.next()) {
              Abono ab = new Abono();
              ab.setId(rs.getInt("id"));
              ab.setProducto(rs.getString("producto"));
              ab.setCantidad(rs.getInt("cantidad"));
              ab.setPrecio(rs.getDouble("precio"));
              ab.setCliente(rs.getString("cliente"));
              ab.setAbono(rs.getDouble("abono"));
              ListaAb.add(ab);
              
          }
      } catch (SQLException e) {
          System.out.println(e.toString());
      }
      return ListaAb;
  }
    
    public boolean EliminarAbonos(int id){
      String sql = "DELETE FROM abonos WHERE id = ?";
      try {
          ps = con.prepareStatement(sql);
          ps.setInt(1, id);
          ps.execute();
          return true;
      } catch (SQLException e) {
          System.err.println(e.toString());
          return false;
      }finally{
          try {
              con.close();
          } catch (SQLException ex) {
              System.out.println(ex.toString());
          }
      }
  }
    
    public boolean ActualizarAbono(Abono abon){
        String sql = "UPDATE abonos SET producto=?, cantidad=?, precio=?, cliente=?, abono=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, abon.getProducto());
            ps.setInt(2, abon.getCantidad());
            ps.setDouble(3, abon.getPrecio());
            ps.setString(4, abon.getCliente());
            ps.setDouble(5, abon.getAbono());
            ps.setInt(6, abon.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
}
