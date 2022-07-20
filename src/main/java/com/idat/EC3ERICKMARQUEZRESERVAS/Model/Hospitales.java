package com.idat.EC3ERICKMARQUEZRESERVAS.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "hospitales")
public class Hospitales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHospital;
    private String nombre;
    private String descripcion;
    private String distrito;

    @JsonIgnoreProperties({"hospital"})
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "hospitales_clientes",
            joinColumns = @JoinColumn(
                    name = "id_hospital",
                    nullable = false,
                    unique = true

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_cliente",
                    nullable = false,
                    unique = true
            )

    )
    private List<Clientes>clientes = new ArrayList<>();
}
