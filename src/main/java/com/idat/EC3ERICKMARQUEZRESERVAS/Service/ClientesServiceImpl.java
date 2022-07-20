package com.idat.EC3ERICKMARQUEZRESERVAS.Service;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.Clientes;

import java.util.List;

public interface ClientesServiceImpl {

    Clientes guardar(Clientes clientes);
    void actualizar(Clientes clientes);
    void eliminar(int idCliente);
    List<Clientes> listar();
    Clientes obtenerPorId(int idCliente);
}
