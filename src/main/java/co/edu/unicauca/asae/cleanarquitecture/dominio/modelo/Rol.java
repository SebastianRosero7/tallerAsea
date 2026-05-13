package co.edu.unicauca.asae.cleanarquitecture.dominio.modelo;


public class Rol {
    private int idRol;

    private String roleAsignado;

    public Rol() {
    }

    public Rol(int idRol, String roleAsignado) {
        this.idRol = idRol;
        this.roleAsignado = roleAsignado;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRoleAsignado() {
        return roleAsignado;
    }

    public void setRoleAsignado(String roleAsignado) {
        this.roleAsignado = roleAsignado;
    }

}
