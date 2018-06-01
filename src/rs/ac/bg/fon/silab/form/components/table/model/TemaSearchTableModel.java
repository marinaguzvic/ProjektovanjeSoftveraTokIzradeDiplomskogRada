/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.form.components.table.model;

import java.util.List;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCTemaDiplomskogRada;

/**
 *
 * @author MARINA
 */
public class TemaSearchTableModel extends TemaTableModel{
    
    public TemaSearchTableModel(List<DCTemaDiplomskogRada> teme) {
        super(teme);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    
    
}
