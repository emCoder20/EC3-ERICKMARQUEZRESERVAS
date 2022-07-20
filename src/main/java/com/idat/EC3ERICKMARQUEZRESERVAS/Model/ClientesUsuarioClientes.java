package com.idat.EC3ERICKMARQUEZRESERVAS.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="clientes_usuarioclientes")
public class ClientesUsuarioClientes {

    @Id
    private ClientesUsuarioClientesPK fk = new ClientesUsuarioClientesPK();

    private Integer idCliente;

    public ClientesUsuarioClientesPK getFk() {
        return fk;
    }

    public void setFk(ClientesUsuarioClientesPK fk) {
        this.fk = fk;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}

@Embeddable
class ClientesUsuarioClientesPK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "id_cliente", nullable = false, unique = true)
    private Integer idCliente;

    @Column(name = "id_cliente", nullable = false, unique = true)
    private Integer idUsuarioCliente;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdUsuarioCliente() {
        return idUsuarioCliente;
    }

    public void setIdUsuarioCliente(Integer idUsuarioCliente) {
        this.idUsuarioCliente = idUsuarioCliente;
    }
}

