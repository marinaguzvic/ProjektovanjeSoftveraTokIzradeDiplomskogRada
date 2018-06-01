/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.diplomskirad;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerKomisija;

/**
 *
 * @author MARINA
 */
public class NastavnikTableModelListener implements TableModelListener{
    GUIControllerKomisija controllerKomisija;

    public NastavnikTableModelListener(GUIControllerKomisija controllerKomisija) {
        this.controllerKomisija = controllerKomisija;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        controllerKomisija.editColumnNastavnici();
    }
    
    

    
}
