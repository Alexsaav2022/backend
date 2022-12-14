/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.demo.service;

import com.upeu.demo.entity.facultad;
import com.upeu.demo.entity.tipodocumento;
import java.util.List;

/**
 *
 * @author AlexSaav
 */
public interface facultadService {
     public List<facultad> findAll();
 
    public facultad findById(Long id);

    public facultad save(facultad facultad);

    public void delete(facultad facultad);

    public void deleteById(Long id);
}
