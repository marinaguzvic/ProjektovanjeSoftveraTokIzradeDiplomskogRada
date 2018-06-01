/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerTemaNew;
import rs.ac.bg.fon.silab.gui.controller.GeneralGUIController;

/**
 *
 * @author MARINA
 */
public class TemaNewListener implements ActionListener{
    GeneralGUIController ggc;

    public TemaNewListener(GeneralGUIController ggc) {
        this.ggc = ggc;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        GUIControllerTemaNew controllerTemaNew = new GUIControllerTemaNew(ggc.getfParent());
    }
    
}
