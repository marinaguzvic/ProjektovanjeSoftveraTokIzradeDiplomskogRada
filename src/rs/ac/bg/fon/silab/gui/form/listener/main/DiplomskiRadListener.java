/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.main;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerDiplomskiRad;
import rs.ac.bg.fon.silab.gui.controller.GeneralGUIController;
import rs.ac.bg.fon.silab.gui.form.FMain;

/**
 *
 * @author MARINA
 */
public class DiplomskiRadListener implements ActionListener{
    GeneralGUIController ggc;

    public DiplomskiRadListener(GeneralGUIController ggc) {
        this.ggc = ggc;
    }



    
    @Override
    public void actionPerformed(ActionEvent e) {
        GUIControllerDiplomskiRad controllerDiplomskiRad = new GUIControllerDiplomskiRad((FMain) ggc.getfParent());
    }
    
    
}
