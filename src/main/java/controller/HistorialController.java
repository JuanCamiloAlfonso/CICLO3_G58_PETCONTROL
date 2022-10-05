package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Historial;
import connection.DBConnection;

public class HistorialController implements IHistorialController {

    @Override
    public String listarHistoriales(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select l.id_servicio, l.nombre_mascota, l.servicios, l.precio, l.cantidad, a.fecha from services l "
                + "inner join historial a on l.id_servicio = a.id_servicio inner join mascota u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> historiales = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id_servicio = rs.getInt("id_servicio");
                String nombre_mascota = rs.getString("nombre_mascota");
                String servicios = rs.getString("servicios");
                int precio = rs.getInt("precio");
                int cantidad = rs.getInt("cantidad");
                Date fecha = rs.getDate("fecha");

                Historial historial = new Historial(id_servicio, nombre_mascota, servicios, precio, cantidad, fecha);

                historiales.add(gson.toJson(historial));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(historiales);
    }}