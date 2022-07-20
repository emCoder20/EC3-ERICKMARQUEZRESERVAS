package com.idat.EC3ERICKMARQUEZRESERVAS.DTO;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.Clientes;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class UsuarioClienteRequest {

    private Integer idUsuario;
    private String usuario;
    private String password;
    private String rol;

    private Clientes clientes;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
}
