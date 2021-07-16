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
public class Facultad {
    private int idfacultad;
    private String nombre;

    public Facultad() {
    }

    public Facultad(String nombre) {
        this.nombre = nombre;
    }

    public int getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(int idfacultad) {
        this.idfacultad = idfacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
