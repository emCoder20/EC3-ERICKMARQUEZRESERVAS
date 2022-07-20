package com.idat.EC3ERICKMARQUEZRESERVAS.Service;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.UsuarioClientes;
import com.idat.EC3ERICKMARQUEZRESERVAS.Repository.UsuariosClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosClientesService implements UsuariosClientesServiceImpl {

    @Autowired
    private UsuariosClientesRepository repository;

    @Override
    public UsuarioClientes guardar(UsuarioClientes usuario) {

        return repository.save(usuario);
    }

    @Override
    public void actualizar(UsuarioClientes usuario) {
        repository.saveAndFlush(usuario);
    }

    @Override
    public void eliminar(int idUsuario) {
        repository.deleteById(idUsuario);
    }

    @Override
    public List<UsuarioClientes> listar() {

        return repository.findAll();
    }

    @Override
    public UsuarioClientes obtenerPorId(int idUsuario) {

        return repository.findById(idUsuario).orElse(null);
    }

}
