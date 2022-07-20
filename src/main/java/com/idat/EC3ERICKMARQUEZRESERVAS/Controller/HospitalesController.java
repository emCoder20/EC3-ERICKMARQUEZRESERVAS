package com.idat.EC3ERICKMARQUEZRESERVAS.Controller;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.Hospitales;
import com.idat.EC3ERICKMARQUEZRESERVAS.Service.HospitalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/hospitales")
public class HospitalesController {

    @Autowired
    private HospitalesService service;

    @GetMapping("/listar")
    public List<Hospitales> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Hospitales hospitales){
        Map<String, Object> response = new HashMap<>();
        service.guardar(hospitales);
        response.put("hospítal", hospitales);
        response.put("mensaje", "el hospital".concat(hospitales.getNombre()).concat("se ha creado con exito"));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id_hospital}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer idHospital) {
        Hospitales h =service.obtenerPorId(idHospital);
        if(h != null) {
            return  new ResponseEntity<Hospitales>(service.obtenerPorId(idHospital),HttpStatus.OK);
        }
        return  new ResponseEntity<Hospitales>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/eliminar/{id_hospital}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer idHospital) {
        Hospitales h =service.obtenerPorId(idHospital);
        Map<String, Object> response = new HashMap<>();
        if(h != null) {
            service.eliminar(idHospital);
            response.put("mensaje", "El Hospital '" .concat(h.getNombre()).concat("' se ha eliminado con éxito!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/actualizar") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody Hospitales hospitales) {
        Hospitales h = service.obtenerPorId(hospitales.getIdHospital());
        Map<String, Object> response = new HashMap<>();
        if(h != null) {
            service.actualizar(hospitales);
            response.put("hospital: ", hospitales);
            response.put("mensaje", "Hospital " + hospitales.getNombre() + " actualizado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
