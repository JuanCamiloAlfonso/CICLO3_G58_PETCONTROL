package beans;

public class Mascota {

    private String username;
    private String contrasena;
    private String nombre_mascota;
    private String raza;
    private String sexo;
    private String edad;
    private String peso;
    private String propietario;
    private Double saldo;
    private boolean premium;

    public Mascota(String username, String contrasena, String nombre_mascota, String raza, String sexo, String edad, String peso, String propietario, Double saldo, boolean premium) {
        this.username = username;
        this.contrasena = contrasena;
        this.nombre_mascota = nombre_mascota;
        this.raza = raza;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
        this.propietario = propietario;
        this.saldo = saldo;
        this.premium = premium;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "Mascota{" + "username=" + username + ", contrasena=" + contrasena + ", nombre_mascota=" + nombre_mascota + ", raza=" + raza + ", sexo=" + sexo + ", edad=" + edad + ", peso=" + peso + ", propietario=" + propietario + ", saldo=" + saldo + ", premium=" + premium + '}';
    }

    
}
