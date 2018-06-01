/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.form.components.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCStudent;

/**
 *
 * @author MARINA
 */
public class StudentTableModel extends AbstractTableModel {

    List<DCStudent> students;
    String[] columnNames = new String[]{"Broj indeksa", "Ime", "Prezime", "Godina studija"};

    public StudentTableModel(List<DCStudent> students) {
        this.students = students;
    }

    public List<DCStudent> getStudents() {
        return students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DCStudent student = students.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getBrojIndeksa();
            case 1:
                return student.getIme();
            case 2:
                return student.getPrezime();
            case 3:
                return student.getGodinaStudija();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }



    public void setData(List<DCStudent> students) {
        this.students = students;
        fireTableDataChanged();
    }

    

    
}
