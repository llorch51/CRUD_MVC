
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Consultas_producto extends Conexion{
    //Producto pro = null;
    
    
    public boolean registrar(Producto pro){
        //this.pro = pro;
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "insert into producto(codigo, nombre, precio, cantidad) values(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public boolean modificar(Producto pro){
        //this.pro = pro;
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "update producto set codigo=?, nombre=?, precio=?, cantidad=? where idproducto = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.setInt(5, pro.getId());
            
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public boolean eliminar(Producto pro){
        //this.pro = pro;
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "delete from producto where idproducto = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public boolean buscar(Producto pro){
        //this.pro = pro;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String sql = "select * from producto where codigo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            rs = ps.executeQuery();
            if(rs.next()){
                pro.setId(Integer.parseInt(rs.getString("idproducto")));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
