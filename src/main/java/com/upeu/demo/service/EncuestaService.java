/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.demo.service;

import com.upeu.demo.entity.Encuesta;
import java.util.List;

public interface EncuestaService {

    public List<Encuesta> findAll();

    public Encuesta findById(Long id);

    public Encuesta save(Encuesta encuesta);

    public void delete(Encuesta encuesta);

    public void deleteById(Long id);
}
