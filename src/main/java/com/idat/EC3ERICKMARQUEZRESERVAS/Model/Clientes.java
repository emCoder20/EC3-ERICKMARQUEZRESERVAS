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
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nombre;
    private Integer celular;


    @JsonIgnoreProperties({"clientes","hospitales"})
    @ManyToMany(mappedBy = "clientes", cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Hospitales>hospitales = new ArrayList<>();
}
