package com.idat.EC3ERICKMARQUEZRESERVAS.Repository;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
}
