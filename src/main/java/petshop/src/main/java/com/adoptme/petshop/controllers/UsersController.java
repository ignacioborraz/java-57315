package com.adoptme.petshop.controllers;

import com.adoptme.petshop.entities.User;
import com.adoptme.petshop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {

    @Autowired private UsersService service;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User data) {
        try {
            User user = service.save(data);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
            //la respuesta por defecto de spring
            //va a devolver al usuario recien creado
            //y va a tener el codigo de estado correspondiente a la creacion ()
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> read() {
        try {
            List<User> users = service.read();
            return ResponseEntity.ok(users);
            //forma correcta de responder una lectura (200)
            //condicionar que pasa si users NO TIENE USUARIOS
            //método isEmpty()
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<> destroy(@PathVariable Long id) {
        try {
            service.deleteOne(id);
            //forma correcta de responder una lectura (200)
            //condicionar que pasa si no existe ese usuario con ese id
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
