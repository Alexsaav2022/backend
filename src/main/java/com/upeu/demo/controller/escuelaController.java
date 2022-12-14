
package com.upeu.demo.controller;

import com.upeu.demo.entity.escuela;
import com.upeu.demo.entity.facultad;
import com.upeu.demo.service.escuelaService;
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
@RequestMapping("/api/escuelas")
@Api(value = "Escuelas", description ="Escuelas")
public class escuelaController {
    @Autowired
    private escuelaService escuelaService;

    @ApiOperation(value="Lista de facultades")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de escuelas");
        result.put("data", escuelaService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Obtiene datos de escuelas")
    @GetMapping("/{id}")
    public ResponseEntity<escuela> findById(@PathVariable Long id) {
        escuela escuela = escuelaService.findById(id);
        return ResponseEntity.ok(escuela);
    }

    @ApiOperation(value="Elimina una escuela")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        escuela data = escuelaService.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe una escuela con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            escuelaService.deleteById(id);
            result.put("success", true);
            result.put("message", "escuela eliminada correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value="Crea una escuela")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody escuela escuela) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "escuela registrada correctamente");
        result.put("data", escuelaService.save(escuela));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica una escuela")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody escuela escuela) {
        HashMap<String, Object> result = new HashMap<>();
        escuela data = escuelaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            escuela.setEscId(id);
            escuelaService.save(escuela);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", escuela);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
