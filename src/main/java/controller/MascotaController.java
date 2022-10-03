package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Mascota;
import connection.DBConnection;
import java.util.HashMap;
import java.util.Map;

public class MascotaController implements IMascotaController {

    @Override
    public String login(String username, String contrasena) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from mascota where username = '" + username
                + "' and contrasena = '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre_mascota = rs.getString("nombre_mascota");
                String raza = rs.getString("raza");
                String sexo = rs.getString("sexo");
                String edad = rs.getString("edad");
                String peso = rs.getString("peso");
                String propietario = rs.getString("propietario");
                double saldo = rs.getDouble("saldo");
                boolean premium = rs.getBoolean("premium");

                Mascota mascota
                        = new Mascota(username, contrasena, nombre_mascota, raza, sexo, edad, peso, propietario, saldo, premium);
                return gson.toJson(mascota);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String register(String username, String contrasena, String nombre_mascota, String raza, String sexo, String edad, String peso, String propietario, double saldo, boolean premium) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into mascota values('" + username + "', '" + contrasena + "', '" + nombre_mascota + "', '" + raza + "', '" + sexo + "', '" + edad + "', '" + peso + "', '" + propietario + "', " + saldo + ", " + premium + ")";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Mascota mascota = new Mascota(username, contrasena, nombre_mascota, raza, sexo, edad, peso, propietario, saldo, premium);

            st.close();

            return gson.toJson(mascota);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from mascota where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String contrasena = rs.getString("contrasena");
                String nombre_mascota = rs.getString("nombre_mascota");
                String raza = rs.getString("raza");
                String sexo = rs.getString("sexo");
                String edad = rs.getString("edad");
                String peso = rs.getString("peso");
                String propietario = rs.getString("propietario");
                double saldo = rs.getDouble("saldo");
                boolean premium = rs.getBoolean("premium");

                Mascota mascota = new Mascota(username, contrasena,
                        nombre_mascota, raza, sexo, edad, peso, propietario, saldo, premium);

                return gson.toJson(mascota);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

}
