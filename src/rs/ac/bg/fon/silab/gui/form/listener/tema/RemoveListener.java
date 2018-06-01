/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.tema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerTableNew;

/**
 *
 * @author MARINA
 */
public class RemoveListener implements ActionListener{
    
    GUIControllerTableNew controllerTemaNew;

    public RemoveListener(GUIControllerTableNew controllerTemaNew) {
        this.controllerTemaNew = controllerTemaNew;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        controllerTemaNew.remove();
    }
    
}
