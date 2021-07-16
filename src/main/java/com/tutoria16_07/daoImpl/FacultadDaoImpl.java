/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutoria16_07.daoImpl;

import com.tutoria16_07.config.Conexion;
import com.tutoria16_07.dao.Metodos;
import com.tutoria16_07.entity.Facultad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dreyna
 */
public class FacultadDaoImpl implements Metodos<Facultad>{
private PreparedStatement ps;
private ResultSet rs;
private Connection cx ;
    @Override
    public int create(Facultad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Facultad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Facultad read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Facultad> readAll() {
        List<Facultad> lista = new ArrayList<>();
        String SQL = "select *from facultad";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Facultad f = new Facultad();
                f.setIdfacultad(rs.getInt("idfacultad"));
                f.setNombre(rs.getString("nombre"));
                lista.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return lista;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
