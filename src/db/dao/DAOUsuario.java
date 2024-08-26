/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.dao;

import db.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author black
 */
public class DAOUsuario implements DAO<Usuario> {

    private Conexion conn;

    public DAOUsuario(Conexion conn) {
        this.conn = conn;
    }

    @Override
    public void create(Usuario t) throws SQLException {

        String sql = "INSERT INTO usuarios (nombre, apellido, rut, clave, email, rol)"
                + " VALUES ('" + t.getNombre() + "', '" + t.getApellido() + "', '" + t.getRut() + "', '" + t.getClave() + "', '" + t.getEmail() + "', '" + t.getRol() + "')";
        conn.execute(sql);
    }

    @Override
    public void update(Usuario t) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = '" + t.getNombre() + "', apellido = '" + t.getApellido() + "', rut = '" + t.getRut() + "', clave = '" + t.getClave() + "', email = '" + t.getClave() + "', email = '" + t.getEmail() + "', rol = '" + t.getRol() + "' WHERE id = '" + t.getId() + "' ";
        conn.execute(sql);
    }

    @Override
    public void delete(Usuario t) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = " + t.getId() + " ";
        conn.execute(sql);
    }

    @Override
    public Usuario getOne(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = " + id;
        ResultSet rs = conn.execute(sql);
        Usuario usuario = new Usuario();
        if (rs.next()) {
            usuario.setId(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setRut(rs.getString("rut"));
            usuario.setClave(rs.getString("clave"));
            usuario.setEmail(rs.getString("email"));
            usuario.setRol(rs.getString("rol"));
        }
        conn.close();
        return usuario;
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        String sql = "SELECT * FROM usuarios";
        ResultSet rs = conn.execute(sql);
        List<Usuario> listaUsuarios = new ArrayList<>();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setRut(rs.getString("rut"));
            usuario.setClave(rs.getString("clave"));
            usuario.setEmail(rs.getString("email"));
            usuario.setRol(rs.getString("rol"));
            listaUsuarios.add(usuario);
        }
        conn.close();
        return listaUsuarios;
    }
    
    public Usuario getOne(String email) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE email = "+ "'" +email+ "'";
//        System.out.println(sql);
        ResultSet rs = conn.execute(sql);
        Usuario usuario = new Usuario();
        if (rs.next()) {
            usuario.setId(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setRut(rs.getString("rut"));
            usuario.setClave(rs.getString("clave"));
            usuario.setEmail(rs.getString("email"));
            usuario.setRol(rs.getString("rol"));
        }
        conn.close();
        return usuario;
    }

    
}
