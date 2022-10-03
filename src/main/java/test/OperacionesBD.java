package test;
import beans.Services;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {
    public static void main(String[] args) {
        actualizarServicio(1, "*****PRUEBA 22****");
        listarServicio();
        
    }
    public static void actualizarServicio(int id_servicio, String servicios){
    DBConnection con = new DBConnection();
    String sql = "UPDATE servicio SET servicios = '"+ servicios + " ' WHERE id_servicio = " + id_servicio;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
    }


    public static void listarServicio(){
    DBConnection con = new DBConnection();
    String sql = "SELECT * FROM servicio";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id_servicio = rs.getInt("id_servicio");
                String servicios =rs.getString("servicios");
                String descripcion = rs.getString("descripcion");
                int precio = rs.getInt("precio");
                int cantidad =rs.getInt("cantidad");
                boolean invasividad =rs.getBoolean("invasividad");
                boolean medicacion = rs.getBoolean("medicacion");
                
                Services service = new Services(id_servicio, servicios, descripcion, precio, cantidad, invasividad, medicacion); 
                System.out.println(service.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
    }    
    
}
