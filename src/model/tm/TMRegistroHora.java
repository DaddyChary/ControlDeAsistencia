/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package model.tm;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.RegistroHora;

/**
 *
 * @author DaddyChary
 */
public class TMRegistroHora extends AbstractTableModel {

    private List<RegistroHora> registrosHoraList;

    public TMRegistroHora(List<RegistroHora> registrosHoraList) {
        this.registrosHoraList = registrosHoraList;
    }

    @Override
    public int getRowCount() {
        return registrosHoraList.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RegistroHora registroHora = registrosHoraList.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                registroHora.getNombre();
            case 1 ->
                registroHora.getApellido();
            case 2 ->
                registroHora.getRut();
            case 3 ->
                registroHora.getDia();
            case 4 ->
                registroHora.getHora();
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
            case 4 ->
                "Hora";
            default ->
                "";
        };
    }
}
