/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.PersonaTaller;
import com.upeu.demo.service.PersonaTallerService;
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
@RequestMapping("/api/persona-taller")
@Api(value = "Microservicios de gestion de persona taller", description ="Microservicio de persona taller")
public class PersonaTallerController {
    @Autowired
    private PersonaTallerService personaTallerService;

    @ApiOperation(value="Lista de persona taller")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de persona taller");
        result.put("data", personaTallerService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Obtiene datos de persona taller")
    @GetMapping("/{id}")
    public ResponseEntity<PersonaTaller> findById(@PathVariable Long id) {
        PersonaTaller personaTaller = personaTallerService.findById(id);
        return ResponseEntity.ok(personaTaller);
    }

    @ApiOperation(value="Elimina una persona taller")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        PersonaTaller data = personaTallerService.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe persona taller con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            personaTallerService.deleteById(id);
            result.put("success", true);
            result.put("message", "Persona taller eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value="Crea una persona taller")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PersonaTaller personaTaller) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Persona taller registrado correctamente");
        result.put("data", personaTallerService.save(personaTaller));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica una persona taller")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PersonaTaller personaTaller) {
        HashMap<String, Object> result = new HashMap<>();
        PersonaTaller data = personaTallerService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe persona taller con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            personaTaller.setPetaId(id);
            personaTallerService.save(personaTaller);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", personaTaller);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
