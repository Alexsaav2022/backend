
package com.upeu.demo.controller;

import com.upeu.demo.entity.facultad;
import com.upeu.demo.service.facultadService;
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
@RequestMapping("/api/facultad")
@Api(value = "Facultades", description ="facultades")

    public class facultadController {
    
    @Autowired
    private facultadService facultadService;

    @ApiOperation(value="Lista de facultades")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de facultades");
        result.put("data", facultadService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Obtiene datos de facultades")
    @GetMapping("/{id}")
    public ResponseEntity<facultad> findById(@PathVariable Long id) {
        facultad facultad = facultadService.findById(id);
        return ResponseEntity.ok(facultad);
    }

    @ApiOperation(value="Elimina un facultad")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        facultad data = facultadService.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe tipo persona con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            facultadService.deleteById(id);
            result.put("success", true);
            result.put("message", "Tipo persona eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value="Crea una facultad")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody facultad facultad) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "facultad registrada correctamente");
        result.put("data", facultadService.save(facultad));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica una facultad")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody facultad facultad) {
        HashMap<String, Object> result = new HashMap<>();
        facultad data = facultadService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            facultad.setFacId(id);
            facultadService.save(facultad);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", facultad);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
