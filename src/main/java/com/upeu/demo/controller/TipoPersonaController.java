/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.TipoPersona;
import com.upeu.demo.service.TipoPersonaService;
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

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/tipo-persona")
@Api(value = "Microservicios de gestion de tipo persona", description ="Microservicio de tipo persona")
public class TipoPersonaController {
    
    @Autowired
    private TipoPersonaService tipoPersonaService;

    @ApiOperation(value="Lista de tipo persona")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de tipo personas");
        result.put("data", tipoPersonaService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Obtiene datos de tipo persona")
    @GetMapping("/{id}")
    public ResponseEntity<TipoPersona> findById(@PathVariable Long id) {
        TipoPersona tipoPersona = tipoPersonaService.findById(id);
        return ResponseEntity.ok(tipoPersona);
    }

    @ApiOperation(value="Elimina un tipo persona")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        TipoPersona data = tipoPersonaService.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe tipo persona con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            tipoPersonaService.deleteById(id);
            result.put("success", true);
            result.put("message", "Tipo persona eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value="Crea un tipo persona")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody TipoPersona tipoPersona) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Tipo persona registrado correctamente");
        result.put("data", tipoPersonaService.save(tipoPersona));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica un tipo persona")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody TipoPersona tipoPersona) {
        HashMap<String, Object> result = new HashMap<>();
        TipoPersona data = tipoPersonaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            tipoPersona.setTipeId(id);
            tipoPersonaService.save(tipoPersona);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", tipoPersona);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
