/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.TipoPersona;
import com.upeu.demo.entity.tipodocumento;
import com.upeu.demo.service.TipoPersonaService;
import com.upeu.demo.service.tipodocservice;
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
@RequestMapping("/api/tipo-docuemnto")
@Api(value = "Microservicios de gestion de tipo documento", description ="Microservicio de tipo documento")
public class tipodocumentoController {
     @Autowired
    private tipodocservice tipodocservice;

    @ApiOperation(value="Lista de tipo documento")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de tipo documento");
        result.put("data", tipodocservice.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Obtiene datos de tipo documento")
    @GetMapping("/{id}")
    public ResponseEntity<tipodocumento> findById(@PathVariable Long id) {
        tipodocumento tipodocumento = tipodocservice.findById(id);
        return ResponseEntity.ok(tipodocumento);
    }

    @ApiOperation(value="Elimina un tipo documento")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        tipodocumento data = tipodocservice.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe tipo documento con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            tipodocservice.deleteById(id);
            result.put("success", true);
            result.put("message", "Tipo documento eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value="Crea un tipo documento")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody tipodocumento tipodocumento) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Tipo persona registrado correctamente");
        result.put("data", tipodocservice.save(tipodocumento));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica un tipo documento")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody tipodocumento tipodocumento) {
        HashMap<String, Object> result = new HashMap<>();
        tipodocumento data = tipodocservice.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            tipodocumento.setTidocId(id);
            tipodocservice.save(tipodocumento);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", tipodocumento);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
