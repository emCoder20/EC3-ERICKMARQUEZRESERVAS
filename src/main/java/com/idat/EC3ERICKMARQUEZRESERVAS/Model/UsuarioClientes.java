package com.idat.EC3ERICKMARQUEZRESERVAS.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
    @JoinColumn(name = "id_cliente",
            nullable = false,
            unique = true)
    private Clientes clientes;

}
