package beans;

public class Services {

    private int id_servicio;
    private String servicios;
    private String descripcion;
    private int precio;
    private int cantidad;
    private boolean invasividad;
    private boolean medicacion;

    public Services(int id_servicio, String servicios, String descripcion, int precio, int cantidad, boolean invasividad, boolean medicacion) {
        this.id_servicio = id_servicio;
        this.servicios = servicios;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.invasividad = invasividad;
        this.medicacion = medicacion;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isInvasividad() {
        return invasividad;
    }

    public void setInvasividad(boolean invasividad) {
        this.invasividad = invasividad;
    }

    public boolean isMedicacion() {
        return medicacion;
    }

    public void setMedicacion(boolean medicacion) {
        this.medicacion = medicacion;
    }

    @Override
    public String toString() {
        return "Services{" + "id_servicio=" + id_servicio + ", servicios=" + servicios + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad + ", invasividad=" + invasividad + ", medicacion=" + medicacion + '}';
    }

}
