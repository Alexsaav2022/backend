/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.service.impl;

import com.upeu.demo.entity.escuela;
import com.upeu.demo.repository.escuelaRepository;
import com.upeu.demo.service.escuelaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class escuelaServiceImpl implements escuelaService{
         @Autowired
    private escuelaRepository escuelaRepository;
@Transactional
    
    @Override
        public List<escuela> findAll() {
        return (List<escuela>) escuelaRepository.findAll();
    }

    @Override
        public escuela findById(Long id) {
        return escuelaRepository.findById(id).orElse(null);
    }

    @Override
    public escuela save(escuela escuela) {
        return escuelaRepository.save(escuela);
   }
    @Override
    public void delete(escuela escuela) {
        escuelaRepository.delete(escuela);
    }

    @Override
    public void deleteById(Long id) {
        escuelaRepository.deleteById(id);
    }
}
