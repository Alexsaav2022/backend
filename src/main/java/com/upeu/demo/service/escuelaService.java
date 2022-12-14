/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.demo.service;

import com.upeu.demo.entity.escuela;
import java.util.List;

/**
 *
 * @author AlexSaav
 */
public interface escuelaService {
         public List<escuela> findAll();
 
    public escuela findById(Long id);

    public escuela save(escuela escuela);

    public void delete(escuela escuela);

    public void deleteById(Long id);
}
