/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.service.impl;

import com.upeu.demo.entity.tipodocumento;
import com.upeu.demo.repository.tipodocumentorepository;
import com.upeu.demo.service.tipodocservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipodocservImpl implements tipodocservice{
    @Autowired
    private tipodocumentorepository tipodocumentorepository;

     @Transactional
    
    @Override
        public List<tipodocumento> findAll() {
        return (List<tipodocumento>) tipodocumentorepository.findAll();
    }

    @Override
        public tipodocumento findById(Long id) {
        return tipodocumentorepository.findById(id).orElse(null);
    }

    @Override
    public tipodocumento save(tipodocumento tipodocumento) {
        return tipodocumentorepository.save(tipodocumento);
   }
    @Override
    public void delete(tipodocumento tipodocumento) {
        tipodocumentorepository.delete(tipodocumento);
    }

    @Override
    public void deleteById(Long id) {
        tipodocumentorepository.deleteById(id);
    }
}
