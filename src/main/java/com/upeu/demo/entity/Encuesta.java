/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "encuesta")
public class Encuesta implements Serializable{

    @Id
    @Column(name = "encu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long encuId;

    @Column(name = "encu_respuesta_uno")
    private String encuRespuestaUno;

    @Column(name = "encu_respuesta_dos")
    private String encuRespuestaDos;

    @Column(name = "encu_respuesta_tres")
    private String encuRespuestaTres;

    @ManyToOne
    @JoinColumn(name = "tall_id")
    private Taller taller;
    @ManyToOne
    @JoinColumn(name = "persId")
     private Persona persona;

}