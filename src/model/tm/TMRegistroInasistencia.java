/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package model.tm;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.RegistroInasistencia;

/**
 *
 * @author DaddyChary
 */
public class TMRegistroInasistencia extends AbstractTableModel {

    private List<RegistroInasistencia> registrosInasistenciasList;

    public TMRegistroInasistencia(List<RegistroInasistencia> registrosInasistenciasList) {
        this.registrosInasistenciasList = registrosInasistenciasList;
    }

    @Override
    public int getRowCount() {
        return registrosInasistenciasList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RegistroInasistencia registroInasistencia = registrosInasistenciasList.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                registroInasistencia.getNombre();
            case 1 ->
                registroInasistencia.getApellido();
            case 2 ->
                registroInasistencia.getRut();
            case 3 ->
                registroInasistencia.getDia();
            default ->
                "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "Nombre";
            case 1 ->
                "Apellido";
            case 2 ->
                "Rut";
            case 3 ->
                "Dia";
            default ->
                "";
        };
    }
}
