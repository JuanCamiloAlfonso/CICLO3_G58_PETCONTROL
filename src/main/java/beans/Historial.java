package beans;

import java.sql.Date;

public class Historial {

    private String username;
    private int id_servicio;
    private Date fecha;
    private boolean novedad;
    private String genero;

    public Historial(String username, int id_servicio, Date fecha, boolean novedad, String genero) {
        this.username = username;
        this.id_servicio = id_servicio;
        this.fecha = fecha;
        this.novedad = novedad;
        this.genero = genero;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Historial{" + "username=" + username + ", id_servicio=" + id_servicio + ", fecha=" + fecha + ", novedad=" + novedad + ", genero=" + genero + '}';
    }

}
