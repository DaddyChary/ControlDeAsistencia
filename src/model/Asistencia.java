/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author DaddyChary
 */
public class Asistencia {
    
    private int id;
    private int id_usuario_fk;
    private Date fecha;
    private String hora_entrada;
    private String hora_salida;

    public Asistencia() {
    }

    public Asistencia(int id, int id_usuario_fk, Date fecha, String hora_entrada, String hora_salida) {
        this.id = id;
        this.id_usuario_fk = id_usuario_fk;
        this.fecha = fecha;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(int id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "id=" + id + ", id_usuario_fk=" + id_usuario_fk + ", fecha=" + fecha + ", hora_entrada=" + hora_entrada + ", hora_salida=" + hora_salida + '}';
    }
   
}
