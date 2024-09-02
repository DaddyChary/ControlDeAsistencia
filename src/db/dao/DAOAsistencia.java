/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.dao;

import db.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Asistencia;
import model.RegistroHora;
import model.RegistroInasistencia;

/**
 *
 * @author black
 */
public class DAOAsistencia implements DAO<Asistencia> {

    private Conexion conn;

    public DAOAsistencia(Conexion conn) {
        this.conn = conn;
    }

    @Override
    public void create(Asistencia t) throws SQLException {
        String sql = "INSERT INTO asistencias (id_usuario_fk, fecha, hora_entrada)"
                + " VALUES ('" + t.getId_usuario_fk() + "', now(), '" + t.getHora_entrada() + "')";
        System.out.println(sql);
        conn.execute(sql);
    }

    @Override
    public void update(Asistencia t) throws SQLException {
        String sql = "UPDATE asistencias SET hora_salida = '" + t.getHora_salida() + "' WHERE id = " + t.getId() + "";
        conn.execute(sql);
    }

    @Override
    public void delete(Asistencia t) throws SQLException {
        String sql = "DELETE FROM asistencias WHERE id = " + t.getId() + "";
        conn.execute(sql);
    }

    @Override
    public Asistencia getOne(int id) throws SQLException {
        String sql = "SELECT * FROM asistencias WHERE id = " + id;
        ResultSet rs = conn.execute(sql);
        Asistencia asistencia = new Asistencia();
        if (rs.next()) {
            asistencia.setId(rs.getInt("id"));
            asistencia.setId_usuario_fk(rs.getInt("id_usuario_fk"));
            asistencia.setFecha(rs.getDate("fecha"));
            asistencia.setHora_entrada(rs.getString("hora_entrada"));
            asistencia.setHora_salida(rs.getString("hora_salida"));
        }
        conn.close();
        return asistencia;
    }

    @Override
    public List<Asistencia> getAll() throws SQLException {
        String sql = "SELECT * FROM asistencias";
        ResultSet rs = conn.execute(sql);
        List<Asistencia> listaAsistencias = new ArrayList<>();
        while (rs.next()) {
            Asistencia asistencia = new Asistencia();
            asistencia.setId(rs.getInt("id"));
            asistencia.setId_usuario_fk(rs.getInt("id_usuario_fk"));
            asistencia.setFecha(rs.getDate("fecha"));
            asistencia.setHora_entrada(rs.getString("hora_entrada"));
            asistencia.setHora_salida(rs.getString("hora_salida"));
            listaAsistencias.add(asistencia);
        }
        conn.close();
        return listaAsistencias;
    }

    public List<RegistroHora> getSalidasAnticipadas() throws SQLException {
        String sql = "SELECT a.id, u.nombre, u.apellido, u.rut, a.fecha, a.hora_salida "
                + "FROM asistencias a "
                + "INNER JOIN usuarios u ON a.id_usuario_fk = u.id "
                + "WHERE a.hora_entrada < '17:30:00'";
        System.out.println(sql);
        ResultSet rs = conn.execute(sql);
        List<RegistroHora> listaAnticipada = new ArrayList<>();
        while (rs.next()) {
            RegistroHora registroHora = new RegistroHora();
            registroHora.setId(rs.getInt("id"));
            registroHora.setNombre(rs.getString("nombre"));
            registroHora.setApellido(rs.getString("apellido"));
            registroHora.setRut(rs.getString("rut"));
            registroHora.setDia(rs.getDate("fecha"));
            registroHora.setHora(rs.getString("hora_salida"));
            listaAnticipada.add(registroHora);
        }
        conn.close();
        return listaAnticipada;
    }

    public List<RegistroHora> getAtrasos() throws SQLException {
        String sql = "SELECT a.id, u.nombre, u.apellido, u.rut, a.fecha, a.hora_entrada "
                + "FROM asistencias a "
                + "INNER JOIN usuarios u ON a.id_usuario_fk = u.id "
                + "WHERE a.hora_entrada > '09:30:00'";

        ResultSet rs = conn.execute(sql);
        List<RegistroHora> listaAtraso = new ArrayList<>();

        while (rs.next()) {
            RegistroHora registroHora = new RegistroHora();
            registroHora.setId(rs.getInt("id"));
            registroHora.setNombre(rs.getString("nombre"));
            registroHora.setApellido(rs.getString("apellido"));
            registroHora.setRut(rs.getString("rut"));
            registroHora.setDia(rs.getDate("fecha"));
            registroHora.setHora(rs.getString("hora_entrada"));
            listaAtraso.add(registroHora);
        }

        conn.close();
        return listaAtraso;
    }

    public List<RegistroInasistencia> getInasistenciasHoy() throws SQLException {
        String sql = "SELECT u.id AS usuario_id, u.nombre, u.apellido, u.rut, d.fecha "
                + "FROM usuarios u "
                + "CROSS JOIN ("
                + "    SELECT DATE_FORMAT(CURDATE(), '%Y-%m-01') + INTERVAL (a.n - 1) DAY AS fecha "
                + "    FROM ("
                + "        SELECT 1 AS n UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 "
                + "        UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 "
                + "        UNION ALL SELECT 11 UNION ALL SELECT 12 UNION ALL SELECT 13 UNION ALL SELECT 14 UNION ALL SELECT 15 "
                + "        UNION ALL SELECT 16 UNION ALL SELECT 17 UNION ALL SELECT 18 UNION ALL SELECT 19 UNION ALL SELECT 20 "
                + "        UNION ALL SELECT 21 UNION ALL SELECT 22 UNION ALL SELECT 23 UNION ALL SELECT 24 UNION ALL SELECT 25 "
                + "        UNION ALL SELECT 26 UNION ALL SELECT 27 UNION ALL SELECT 28 UNION ALL SELECT 29 UNION ALL SELECT 30 "
                + "        UNION ALL SELECT 31 "
                + "    ) a "
                + "    WHERE DATE_FORMAT(CURDATE(), '%Y-%m-01') + INTERVAL (a.n - 1) DAY <= CURDATE() "
                + ") d "
                + "LEFT JOIN asistencias a ON u.id = a.id_usuario_fk AND a.fecha = d.fecha "
                + "WHERE a.id IS NULL;";

        ResultSet rs = conn.execute(sql);
        List<RegistroInasistencia> listaInasistencias = new ArrayList<>();
        while (rs.next()) {
            RegistroInasistencia registroInasistencia = new RegistroInasistencia();
            registroInasistencia.setId(rs.getInt("usuario_id"));
            registroInasistencia.setNombre(rs.getString("nombre"));
            registroInasistencia.setApellido(rs.getString("apellido"));
            registroInasistencia.setRut(rs.getString("rut"));
            registroInasistencia.setDia(rs.getDate("fecha"));
            listaInasistencias.add(registroInasistencia);
        }
        conn.close();
        return listaInasistencias;
    }

    public Asistencia getOneByDate(String fecha, int id) throws SQLException {
        String sql = "SELECT * FROM asistencias WHERE id_usuario_fk = " + id + " AND fecha = '" + fecha + "'";
        System.out.println(sql);
        ResultSet rs = conn.execute(sql);
        Asistencia asistencia = new Asistencia();
        if (rs.next()) {
            asistencia.setId(rs.getInt("id"));
            asistencia.setId_usuario_fk(rs.getInt("id_usuario_fk"));
            asistencia.setFecha(rs.getDate("fecha"));
            asistencia.setHora_entrada(rs.getString("hora_entrada"));
            asistencia.setHora_salida(rs.getString("hora_salida"));
        }
        conn.close();
        return asistencia;
    }

    public Asistencia getOneByIdUser(String fecha, int id) throws SQLException {
        String sql = "SELECT * FROM asistencias WHERE id_usuario_fk = " + id + " AND fecha = '" + fecha + "'";
        System.out.println(sql);
        ResultSet rs = conn.execute(sql);
        Asistencia asistencia = new Asistencia();
        if (rs.next()) {
            asistencia.setId(rs.getInt("id"));
            asistencia.setId_usuario_fk(rs.getInt("id_usuario_fk"));
            asistencia.setFecha(rs.getDate("fecha"));
            asistencia.setHora_entrada(rs.getString("hora_entrada"));
            asistencia.setHora_salida(rs.getString("hora_salida"));
        }
        conn.close();
        return asistencia;
    }

}

//    public List<Usuario> getInasistencias() throws SQLException {
//        String sql = "SELECT u.* FROM usuarios u "
//                + "LEFT JOIN asistencias a ON u.id = a.id_usuario_fk "
//                + "AND a.fecha = CURDATE() "
//                + "WHERE a.id IS NULL";
//        ResultSet rs = conn.createStatement().executeQuery(sql);
//        List<Usuario> listaUsuarios = new ArrayList<>();
//        while (rs.next()) {
//            Usuario usuario = new Usuario();
//            usuario.setId(rs.getInt("id"));
//            usuario.setNombre(rs.getString("nombre"));
//            usuario.setApellido(rs.getString("apellido"));
//            usuario.setRut(rs.getString("rut"));
//            usuario.setEmail(rs.getString("email"));
//            usuario.setRol(rs.getString("rol"));
//            listaUsuarios.add(usuario);
//        }
//        conn.close();
//        return listaUsuarios;
//    }

