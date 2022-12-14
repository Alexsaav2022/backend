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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "escuela")
public class escuela {
    
    @Id
    @Column(name = "escuela_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long escId;
     @Column(name = "esc_nombre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long escnombre;

    @ManyToOne
    @JoinColumn(name = "fac_id")
    private facultad facultad;

}
