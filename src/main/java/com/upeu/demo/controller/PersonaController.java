package com.upeu.demo.controller;

import com.upeu.demo.entity.Persona;
import com.upeu.demo.service.PersonaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})/*Hare peticiones a tal ruta externa*/
@RestController
@RequestMapping("/api/persona")
@Api(value = "Microservicios de gestion de personas", description ="Microservicio de Persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @ApiOperation(value="Lista de personas")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de personas");
        result.put("data", personaService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Obtiene datos de una persona")
    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Long id) {
        Persona persona = personaService.findById(id);
        return ResponseEntity.ok(persona);
    }

    @ApiOperation(value="Elimina una persona")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        Persona data = personaService.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe persona con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            personaService.deleteById(id);
            result.put("success", true);
            result.put("message", "Persona eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value="Crea una persona")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Persona persona) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Persona registrado correctamente");
        result.put("data", personaService.save(persona));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica una persona")
    @PutMapping("/update")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Persona persona) {
        HashMap<String, Object> result = new HashMap<>();
        Persona data = personaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            persona.setPersId(id);
            personaService.save(persona);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", persona);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
