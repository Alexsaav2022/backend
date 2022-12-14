/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.service.impl;

import com.upeu.demo.entity.Taller;
import com.upeu.demo.repository.TallerRepository;
import com.upeu.demo.service.TallerService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TallerServiceImpl implements TallerService{
    
    @Autowired
    private TallerRepository tallerRepository;

    @Transactional
    @Override
    public List<Taller> findAll() {
        return (List<Taller>) tallerRepository.findAll();
    }

    @Override
    public Taller findById(Long id) {
        return tallerRepository.findById(id).orElse(null);
    }

    @Override
    public Taller save(Taller taller) {
        return tallerRepository.save(taller);
    }

    @Override
    public void delete(Taller taller) {
        tallerRepository.delete(taller);
    }

    @Override
    public void deleteById(Long id) {
        tallerRepository.deleteById(id);
    }
}
