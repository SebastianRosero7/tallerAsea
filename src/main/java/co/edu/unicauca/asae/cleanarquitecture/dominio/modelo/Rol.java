package co.edu.unicauca.asae.cleanarquitecture.dominio.modelo;

import java.util.List;

public class Rol {
    private int idRol;

    private String roleAsignado;

    private List<Historico> historicos;

    public Rol() {
    }

    public Rol(int idRol, String roleAsignado,List<Historico> historicos) {
        this.idRol = idRol;
        this.roleAsignado = roleAsignado;
        this.historicos = historicos;
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

    public List<Historico> getHistoricos() {
        return this.historicos;
    }
}
