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
@Table(name = "persona_taller")
public class PersonaTaller implements Serializable{

    @Id
    @Column(name = "peta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petaId;

    @Column(name = "peta_asistencia")
    private char petaAsistencia = 'F';

    // tabla  personaTaller se relaciona a taller
    //          carga de tipo pereza              cascada a todo
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //De muchos a muchos
    @ManyToOne
    @JoinColumn(name = "tall_id")
    private Taller taller;

    // tabla  personaTaller se relaciona a persona
    @ManyToOne //De muchos a uno
    @JoinColumn(name = "pers_id")
    private Persona persona;


}
