/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutoria16_07.daoImpl;

import com.tutoria16_07.config.Conexion;
import com.tutoria16_07.dao.Metodos;
import com.tutoria16_07.entity.Escuela;
import com.tutoria16_07.entity.Facultad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dreyna
 */
public class EscuelaDaoImpl implements Metodos<Escuela>{
private PreparedStatement ps;
private ResultSet rs;
private Connection cx ;
    @Override
    public int create(Escuela t) {
        int x = 0;
        String SQL = "INSERT INTO escuela (nombre, idfacultad) VALUES(?, ?)";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getIdfacultad());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return x;
        
    }

    @Override
    public int update(Escuela t) {
        int x = 0;
        String SQL = "UPDATE escuela SET nombre = ?,  idfacultad = ? WHERE idescuela = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getIdfacultad());
            ps.setInt(3, t.getIdescuela());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return x;     
    }

    @Override
    public int delete(int id) {
        int x = 0;
        String SQL = "DELETE FROM escuela WHERE idescuela = ?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return x;            
    }

    @Override
    public Escuela read(int id) {
        Escuela escuela = new Escuela();
        String SQL = "SELECT *from escuela WHERE idescuela =?";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                escuela.setIdescuela(rs.getInt("idescuela"));
                escuela.setNombre(rs.getString("nombre"));
                escuela.setIdfacultad(rs.getInt("idfacultad"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return escuela;
    }

    @Override
    public List<Escuela> readAll() {
                 return null;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
       List<Map<String, Object>> lista = new ArrayList<>();
        String SQL = "SELECT e.idescuela, e.nombre as escuela, f.idfacultad, f.nombre as facultad from escuela as e " +
                                "inner join facultad as f on e.idfacultad =f.idfacultad";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Map<String, Object> map = new HashMap<>();
                map.put("idescuela", rs.getInt("idescuela"));
                map.put("escuela", rs.getString("escuela"));
                map.put("idfacultad", rs.getInt("idfacultad"));
                map.put("facultad", rs.getString("facultad"));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return lista;
    }
    
}
