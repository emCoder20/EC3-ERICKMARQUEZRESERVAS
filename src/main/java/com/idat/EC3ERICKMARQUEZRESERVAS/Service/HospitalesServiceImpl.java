package com.idat.EC3ERICKMARQUEZRESERVAS.Service;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.Hospitales;
import java.util.List;

public interface HospitalesServiceImpl {

    Hospitales guardar(Hospitales hospitales);
    void actualizar(Hospitales hospitales);
    void eliminar(int idHospital);
    List<Hospitales> listar();
    Hospitales obtenerPorId(int idHospital);
}
