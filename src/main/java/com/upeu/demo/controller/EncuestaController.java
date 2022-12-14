/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.Encuesta;
import com.upeu.demo.service.EncuestaService;
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
@RequestMapping("/api/encuesta")
@Api(value = "Microservicios de gestion de encuesta", description ="Microservicio de encuesta")
public class EncuestaController {
    
    @Autowired
    private EncuestaService encuestaService;

    @ApiOperation(value="Lista de encuesta")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de encuestas");
        result.put("data", encuestaService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Obtiene datos de la encuesta")
    @GetMapping("/{id}")
    public ResponseEntity<Encuesta> findById(@PathVariable Long id) {
        Encuesta encuesta = encuestaService.findById(id);
        return ResponseEntity.ok(encuesta);
    }

    @ApiOperation(value="Elimina una encuesta")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        Encuesta data = encuestaService.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe encuesta con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            encuestaService.deleteById(id);
            result.put("success", true);
            result.put("message", "Encuesta eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value="Crea una encuesta")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Encuesta encuesta) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Encuesta registrado correctamente");
        result.put("data", encuestaService.save(encuesta));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica una encuesta")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Encuesta encuesta) {
        HashMap<String, Object> result = new HashMap<>();
        Encuesta data = encuestaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            encuesta.setEncuId(id);
            encuestaService.save(encuesta);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", encuesta);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
