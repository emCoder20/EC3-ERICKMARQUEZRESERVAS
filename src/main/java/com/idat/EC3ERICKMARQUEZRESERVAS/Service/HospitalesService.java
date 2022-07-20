package com.idat.EC3ERICKMARQUEZRESERVAS.Service;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.Hospitales;
import com.idat.EC3ERICKMARQUEZRESERVAS.Repository.HospitalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalesService implements HospitalesServiceImpl{

    @Autowired
    private HospitalesRepository repository;

    @Override
    public Hospitales guardar(Hospitales hospitales) {

        return repository.save(hospitales);
    }

    @Override
    public void actualizar(Hospitales hospitales) {
        repository.saveAndFlush(hospitales);

    }

    @Override
    public void eliminar(int idHospital) {
        repository.deleteById(idHospital);
    }

    @Override
    public List<Hospitales> listar() {

        return repository.findAll();
    }

    @Override
    public Hospitales obtenerPorId(int idHospital) {

        return repository.findById(idHospital).orElse(null);
    }

}
