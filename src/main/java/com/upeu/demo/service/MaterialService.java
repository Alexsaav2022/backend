/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.demo.service;

import com.upeu.demo.entity.Material;
import java.util.List;

public interface MaterialService {

    public List<Material> findAll();

    public Material findById(Long id);

    public Material save(Material material);

    public void delete(Material material);

    public void deleteById(Long id);
}
