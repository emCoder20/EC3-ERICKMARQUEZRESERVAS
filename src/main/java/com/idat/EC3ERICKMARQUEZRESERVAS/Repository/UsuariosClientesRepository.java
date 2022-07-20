package com.idat.EC3ERICKMARQUEZRESERVAS.Repository;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.UsuarioClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosClientesRepository extends JpaRepository<UsuarioClientes, Integer>{

    UsuarioClientes findByUsuario(String usuario);

}
