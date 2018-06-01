/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.create;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerTemaNew;
import rs.ac.bg.fon.silab.gui.controller.GUIListNew;
import rs.ac.bg.fon.silab.gui.controller.GeneralControllerNew;
import rs.ac.bg.fon.silab.gui.form.FormState;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public class SaveListListener implements ActionListener {

    GeneralControllerNew controllerTemaNew;

    public SaveListListener(GeneralControllerNew controllerTemaNew) {
        this.controllerTemaNew = controllerTemaNew;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controllerTemaNew.SOSaveList(((GUIListNew)controllerTemaNew).getList());
        controllerTemaNew.emptyGraphicalObject();
        controllerTemaNew.prepareFormFor(FormState.INSERT);
    }

}
