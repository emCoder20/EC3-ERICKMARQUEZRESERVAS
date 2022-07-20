package com.idat.EC3ERICKMARQUEZRESERVAS.Service;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.Clientes;
import com.idat.EC3ERICKMARQUEZRESERVAS.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService implements ClientesServiceImpl{

    @Autowired
    private ClientesRepository repository;

    @Override
    public Clientes guardar(Clientes clientes) {

        return repository.save(clientes);
    }

    @Override
    public void actualizar(Clientes clientes) {
        repository.saveAndFlush(clientes);
    }

    @Override
    public void eliminar(int idCliente) {
        repository.deleteById(idCliente);
    }

    @Override
    public List<Clientes> listar() {

        return repository.findAll();
    }

    @Override
    public Clientes obtenerPorId(int idCliente) {

        return repository.findById(idCliente).orElse(null);
    }

}
