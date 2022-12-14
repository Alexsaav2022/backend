/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "facultad")
public class facultad {
    @Id
    @Column(name = "fac_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facId;
    @Column(name = "fac_abreviatura")
    private String fabre;
    @Column(name = "fac_nombres")
    private String facNombres;
}
