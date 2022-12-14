/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.demo.service;

import com.upeu.demo.entity.tipodocumento;
import java.util.List;


public interface tipodocservice {
    public List<tipodocumento> findAll();
 
    public tipodocumento findById(Long id);

    public tipodocumento save(tipodocumento tipodocumento);

    public void delete(tipodocumento tipodocumento);

    public void deleteById(Long id);
}
