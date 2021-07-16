/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutoria16_07.entity;

/**
 *
 * @author dreyna
 */
public class Escuela {
     private int idescuela;
    private String nombre;
    private int idfacultad;

    public Escuela() {
    }

    public Escuela(String nombre, int idfacultad) {
        this.nombre = nombre;
        this.idfacultad = idfacultad;
    }

    public int getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(int idfacultad) {
        this.idfacultad = idfacultad;
    }



    public int getIdescuela() {
        return idescuela;
    }

    public void setIdescuela(int idescuela) {
        this.idescuela = idescuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
