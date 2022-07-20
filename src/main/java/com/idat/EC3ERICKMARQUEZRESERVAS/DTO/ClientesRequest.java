package com.idat.EC3ERICKMARQUEZRESERVAS.DTO;

public class ClientesRequest {

    private Integer idCliente;
    private String nombre;
    private Integer celular;


    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }
}
