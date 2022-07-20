package com.idat.EC3ERICKMARQUEZRESERVAS.Model;


import javax.persistence.*;

@Entity
@Table(name = "usuarioclientes")
public class UsuarioClientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String usuario;
    private String password;
    private String rol;


    @OneToOne
    @JoinColumn(name="id_cliente", nullable = false, unique = true,
    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references clientes(id_cliente)"))

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

}
