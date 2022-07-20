package com.idat.EC3ERICKMARQUEZRESERVAS.Controller;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.Clientes;

import com.idat.EC3ERICKMARQUEZRESERVAS.Service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/clientes")

public class ClientesController {

    @Autowired
    private ClientesService service;

    @GetMapping("/listar")
    public List<Clientes> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Clientes clientes){
        Map<String, Object> response = new HashMap<>();
        service.guardar(clientes);
        response.put("cliente", clientes);
        response.put("mensaje", "el cliente".concat(clientes.getNombre()).concat("se ha creado con exito"));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id_cliente}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer id_cliente) {
        Clientes c =service.obtenerPorId(id_cliente);
        if(c != null) {
            return  new ResponseEntity<Clientes>(service.obtenerPorId(id_cliente),HttpStatus.OK);
        }
        return  new ResponseEntity<Clientes>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/eliminar/{id_cliente}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer id_cliente) {
        Clientes c =service.obtenerPorId(id_cliente);
        Map<String, Object> response = new HashMap<>();
        if(c != null) {
            service.eliminar(id_cliente);
            response.put("mensaje", "Cliente '" .concat(c.getNombre()).concat("' eliminado con éxito!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/actualizar") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody Clientes clientes) {
        Clientes c = service.obtenerPorId(clientes.getIdCliente());
        Map<String, Object> response = new HashMap<>();
        if(c != null) {
            service.actualizar(clientes);
            response.put("producto: ", clientes);
            response.put("mensaje", "Cliente " + clientes.getNombre() + " actualizado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
