package com.idat.EC3ERICKMARQUEZRESERVAS.Service;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.UsuarioClientes;
import java.util.List;

public interface UsuariosClientesServiceImpl {

    UsuarioClientes guardar(UsuarioClientes usuario);
    void actualizar(UsuarioClientes usuario);
    void eliminar(int idUsuario);
    List<UsuarioClientes> listar();
    UsuarioClientes obtenerPorId(int idUsuario);

}
