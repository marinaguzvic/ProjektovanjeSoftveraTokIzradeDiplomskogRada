/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.form.components.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCPredmet;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCTemaDiplomskogRada;

/**
 *
 * @author MARINA
 */
public class TemaTableModel extends AbstractTableModel {

    List<DCTemaDiplomskogRada> teme;

    public TemaTableModel(List<DCTemaDiplomskogRada> teme) {
        this.teme = teme;
    }

    @Override
    public int getRowCount() {
        return teme.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DCTemaDiplomskogRada tema = teme.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return tema.getNazivTeme();
            case 1:
                return tema.getOpisTeme();
            case 2:
                return tema.getPredmet() ;
            default:
                return "N/A";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        DCTemaDiplomskogRada tema = teme.get(rowIndex);
        switch (columnIndex) {
            case 0:
                tema.setNazivTeme((String) aValue);
                break;
            case 1:
                tema.setOpisTeme((String) aValue);
                break;
            case 2:
                
                tema.setPredmet((DCPredmet)aValue);
                break;

        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return DCPredmet.class;
                default:
                    return null;
        }
        
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = new String[]{"Naziv", "Opis", "Predmet"};
        return columnNames[column];
    }

    public void setData(List<DCTemaDiplomskogRada> filteredTeme) {
        teme = filteredTeme;
        fireTableDataChanged();
    }

    public List<DCTemaDiplomskogRada> getTeme() {
        return teme;
    }

    public void setTeme(List<DCTemaDiplomskogRada> teme) {
        this.teme = teme;
        fireTableDataChanged();
    }

    public void remove(int row) {
        teme.remove(row);
        fireTableDataChanged();
    }

    public void add() throws Exception {
        if(!teme.isEmpty()) teme.get(teme.size()-1).checkConstraints();
        teme.add(new DCTemaDiplomskogRada());
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
