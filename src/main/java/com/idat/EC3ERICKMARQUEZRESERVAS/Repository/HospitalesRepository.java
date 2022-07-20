package com.idat.EC3ERICKMARQUEZRESERVAS.Repository;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.Hospitales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalesRepository extends JpaRepository<Hospitales, Integer> {

}
