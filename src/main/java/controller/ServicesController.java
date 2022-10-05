package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Services;
import connection.DBConnection;

public abstract class ServicesController implements IServicesController {

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from services";

        if (ordenar == true) {
            sql += " order by id_servicio " + orden;
        }

        List<String> serviciosveterin = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id_servicio = rs.getInt("id_servicio");
                String servicios = rs.getString("servicios");
                String descripcion = rs.getString("descripcion");
                int precio = rs.getInt("precio");
                int cantidad = rs.getInt("cantidad");
                boolean invasividad = rs.getBoolean("invasividad");
                boolean medicacion = rs.getBoolean("medicacion");

                Services serviciovet = new Services(id_servicio, servicios, descripcion, precio, cantidad, invasividad, medicacion);

                serviciosveterin.add(gson.toJson(serviciovet));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(serviciosveterin);

    }

    public String Solicitar(int id_servicio, String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}