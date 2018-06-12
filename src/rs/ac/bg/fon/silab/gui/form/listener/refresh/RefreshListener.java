/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.refresh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GeneralControllerSearch;

/**
 *
 * @author MARINA
 */
public class RefreshListener implements ActionListener{
    GeneralControllerSearch gcs;

    public RefreshListener(GeneralControllerSearch gcs) {
        this.gcs = gcs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gcs.createObject();
        gcs.populateTable();
    }
    
    
}
