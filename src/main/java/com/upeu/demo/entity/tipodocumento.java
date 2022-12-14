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
@Table(name = "tipo_documento")
public class tipodocumento {
     @Id
    @Column(name = "tipodoc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tidocId;

    @Column(name = "tipe_nombre")
    private String tidocNombre;
}
