/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.diplomskirad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerDiplomskiRad;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerKomisija;

/**
 *
 * @author MARINA
 */
public class EnterKomisijaActionListener implements ActionListener {
    GUIControllerDiplomskiRad controllerDiplomskiRad;

    public EnterKomisijaActionListener(GUIControllerDiplomskiRad aThis) {
        controllerDiplomskiRad = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GUIControllerKomisija controllerKomisija = new GUIControllerKomisija(controllerDiplomskiRad.getfParent());
    }
    
}
