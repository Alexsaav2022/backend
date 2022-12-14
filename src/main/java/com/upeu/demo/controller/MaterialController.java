package com.upeu.demo.controller;

import com.upeu.demo.entity.Material;
import com.upeu.demo.service.MaterialService;
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
@RequestMapping("/api/material")
@Api(value = "Microservicios de gestion de material", description ="Microservicio de material")
public class MaterialController {
    
    @Autowired
    private MaterialService materialService;

    @ApiOperation(value="Lista de material")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de programas");
        result.put("data", materialService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Obtiene datos de material")
    @GetMapping("/{id}")
    public ResponseEntity<Material> findById(@PathVariable Long id) {
        Material material = materialService.findById(id);
        return ResponseEntity.ok(material);
    }

    @ApiOperation(value="Elimina un material")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        Material data = materialService.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe material con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            materialService.deleteById(id);
            result.put("success", true);
            result.put("message", "Material eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value="Crea un material")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Material material) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Material registrado correctamente");
        result.put("data", materialService.save(material));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica un material")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Material material) {
        HashMap<String, Object> result = new HashMap<>();
        Material data = materialService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            material.setMateId(id);
            materialService.save(material);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", material);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
