/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutoria16_07.config;

import com.google.gson.Gson;
import com.tutoria16_07.daoImpl.EscuelaDaoImpl;
import com.tutoria16_07.daoImpl.FacultadDaoImpl;

/**
 *
 * @author dreyna
 */
public class Test {
static EscuelaDaoImpl esc = new EscuelaDaoImpl();
static FacultadDaoImpl facu = new FacultadDaoImpl();
static Gson gson= new Gson();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(Conexion.getConexion()!=null){
            System.out.println("si");
        }
     System.out.println(gson.toJson(esc.readAll2()));
    }
    
}
