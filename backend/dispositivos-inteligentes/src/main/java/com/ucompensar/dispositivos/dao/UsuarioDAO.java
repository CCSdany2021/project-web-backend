package com.ucompensar.dispositivos.dao;

import com.ucompensar.dispositivos.util.Conexion;
import com.ucompensar.dispositivos.model.Usuario;
import java.sql.*;

public class UsuarioDAO {
    
    // BUSCAR USUARIO POR EMAIL
    public Usuario buscarPorEmail(String email) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEsAdmin(rs.getBoolean("es_admin"));
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuario;
    }
    
    // CREAR USUARIO
    public boolean crearUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (email, password, nombre, es_admin) VALUES (?, ?, ?, ?)";
        
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario.getEmail());
            pstmt.setString(2, usuario.getPassword());
            pstmt.setString(3, usuario.getNombre());
            pstmt.setBoolean(4, usuario.isEsAdmin());
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}