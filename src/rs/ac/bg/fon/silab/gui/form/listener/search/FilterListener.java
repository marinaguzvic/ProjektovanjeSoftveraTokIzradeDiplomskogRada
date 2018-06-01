/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.search;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import rs.ac.bg.fon.silab.gui.controller.GeneralControllerSearch;

/**
 *
 * @author MARINA
 */
public class FilterListener implements DocumentListener,ActionListener,ChangeListener{
    

    GeneralControllerSearch gcss;
    

    public FilterListener(GeneralControllerSearch gcss) {

        this.gcss = gcss;

    }
    
    
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        try {
            filterTable();
        } catch (Exception ex) {
            Logger.getLogger(FilterListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        try {
            filterTable();
        } catch (Exception ex) {
            Logger.getLogger(FilterListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    protected void filterTable() throws Exception{
        gcss.createObjectWithFilter();
        gcss.convertDomainIntoGraphicalObject();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            filterTable();
        } catch (Exception ex) {
            Logger.getLogger(FilterListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
       try {
            filterTable();
        } catch (Exception ex) {
            Logger.getLogger(FilterListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}
