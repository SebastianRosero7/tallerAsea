package co.edu.unicauca.asae.cleanarquitecture.dominio.modelo;

import java.util.Date;

public class Estado {
    private int idEstado;

    private String estadoActual;;

    private Date fechaRegistroEstado;


    public Estado(int idEstado, String estadoActual, Date fechaRegistroEstado) {
    this.idEstado = idEstado;
    this.estadoActual = estadoActual;
    this.fechaRegistroEstado = fechaRegistroEstado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Date getFechaRegistroEstado() {
        return fechaRegistroEstado;
    }

    public void setFechaRegistroEstado(Date fechaRegistroEstado) {
        this.fechaRegistroEstado = fechaRegistroEstado;
    }

}
