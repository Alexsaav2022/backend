/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.service.impl;

import com.upeu.demo.entity.Encuesta;
import com.upeu.demo.repository.EncuestaRepository;
import com.upeu.demo.service.EncuestaService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncuestaServiceImpl implements EncuestaService{
    
    @Autowired
    private EncuestaRepository encuestaRepository;

    @Transactional
    @Override
    public List<Encuesta> findAll() {
        return (List<Encuesta>) encuestaRepository.findAll();
    }

    @Override
    public Encuesta findById(Long id) {
        return encuestaRepository.findById(id).orElse(null);
    }

    @Override
    public Encuesta save(Encuesta encuesta) {
        return encuestaRepository.save(encuesta);
    }

    @Override
    public void delete(Encuesta encuesta) {
        encuestaRepository.delete(encuesta);
    }

    @Override
    public void deleteById(Long id) {
        encuestaRepository.deleteById(id);
    }
}
