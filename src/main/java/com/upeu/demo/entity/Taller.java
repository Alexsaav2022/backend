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
@Table(name = "taller")
public class Taller implements Serializable{

    @Id
    @Column(name = "tall_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tallId;

    @Column(name = "tall_tema")
    private String tallTema;

    @Column(name = "tall_hora")
    private String tallHora;

    @Column(name = "tall_fecha")
    private String tallFecha;

    @Column(name = "tall_direccion")
    private String tallDireccion;

    @Column(name = "tall_lugar")
    private String tallLugar;

    //de taller a programa
    @ManyToOne //De muchos a uno
    //@JsonIgnore - Ignora esta relación para eso sirve
    @JoinColumn(name = "prog_id")
    private Programa programa;

    /*@OneToOne(cascade = CascadeType.ALL) //De muchos a uno
    @JsonIgnore
    @JoinColumn(name = "mate_id", referencedColumnName = "mate_id")
    private Material material;*/

    //de taller a material
//    @ManyToOne //De muchos a uno
//    @JsonIgnore //- Ignora esta relación para eso sirve
//    @JoinColumn(name = "mate_id")
//    private Material material;

//    // tabla  personaTaller se relaciona a taller
//    //          carga de tipo pereza              cascada a todo
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //De muchos a muchos
//    private List<PersonaTaller> personaTaller;
}
