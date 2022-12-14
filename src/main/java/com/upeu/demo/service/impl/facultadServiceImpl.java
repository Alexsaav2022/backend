/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.service.impl;

import com.upeu.demo.entity.facultad;
import com.upeu.demo.entity.tipodocumento;
import com.upeu.demo.repository.facultadRepository;
import com.upeu.demo.service.facultadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class facultadServiceImpl implements facultadService {
     @Autowired
    private facultadRepository facultadRepository;
@Transactional
    
    @Override
        public List<facultad> findAll() {
        return (List<facultad>) facultadRepository.findAll();
    }

    @Override
        public facultad findById(Long id) {
        return facultadRepository.findById(id).orElse(null);
    }

    @Override
    public facultad save(facultad facultad) {
        return facultadRepository.save(facultad);
   }
    @Override
    public void delete(facultad facultad) {
        facultadRepository.delete(facultad);
    }

    @Override
    public void deleteById(Long id) {
        facultadRepository.deleteById(id);
    }
}
