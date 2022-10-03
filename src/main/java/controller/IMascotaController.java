package controller;

import java.util.Map;

public interface IMascotaController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena,
            String nombre_mascota, String raza, String sexo, String edad, String peso, String propietario, double saldo, boolean premium);

    public String pedir(String username);
    
}
