/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.tm;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Usuario;

/**
 *
 * @author DaddyChary
 */
public class TMUsuario extends AbstractTableModel {

    private List<Usuario> usuariosList;

    public TMUsuario(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int getRowCount() {
        return usuariosList.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuariosList.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                usuario.getId();
            case 1 ->
                usuario.getNombre();
            case 2 ->
                usuario.getApellido();
            case 3 ->
                usuario.getRut();
            case 4 ->
                usuario.getEmail();
            case 5 ->
                usuario.getRol();
            default ->
                "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "ID";
            case 1 ->
                "Nombre";
            case 2 ->
                "Apellido";
            case 3 ->
                "Rut";
            case 4 ->
                "Email";
            case 5 ->
                "Rol";
            default ->
                "";
        };
    }
}
