package com.idat.EC3ERICKMARQUEZRESERVAS.Controller;

import com.idat.EC3ERICKMARQUEZRESERVAS.Model.UsuarioClientes;
import com.idat.EC3ERICKMARQUEZRESERVAS.Service.UsuariosClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/api/usuarios_clientes")
public class UsuariosClientesController {

    @Autowired
    private UsuariosClientesService service;

    @GetMapping("/listar")
    public List<UsuarioClientes> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody UsuarioClientes usuarioClientes){
        Map<String, Object> response = new HashMap<>();
        service.guardar(usuarioClientes);
        response.put("usuario", usuarioClientes);
        response.put("mensaje", "el usuario".concat(usuarioClientes.getUsuario()).concat("se ha creado con exito"));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id_usuario}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer id_usuario) {
        UsuarioClientes uc =service.obtenerPorId(id_usuario);
        if(uc != null) {
            return  new ResponseEntity<UsuarioClientes>(service.obtenerPorId(id_usuario),HttpStatus.OK);
        }
        return  new ResponseEntity<UsuarioClientes>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/eliminar/{id_usuario}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer id_usuario) {
        UsuarioClientes uc =service.obtenerPorId(id_usuario);
        Map<String, Object> response = new HashMap<>();
        if(uc != null) {
            service.eliminar(id_usuario);
            response.put("mensaje", "UsuarioClientes '" .concat(uc.getUsuario()).concat("Se ha eliminado con éxito!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/actualizar") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody UsuarioClientes usuarioClientes) {
        UsuarioClientes uc = service.obtenerPorId(usuarioClientes.getIdUsuario());
        Map<String, Object> response = new HashMap<>();
        if(uc != null) {
            service.actualizar(usuarioClientes);
            response.put("UsuarioCliente: ", usuarioClientes);
            response.put("mensaje", "UsuarioClientes " + usuarioClientes.getUsuario() + " se ha actualizado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
