/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerDiplomskiRad;
import rs.ac.bg.fon.silab.gui.diplomskirad.command.AbstractAction;
import rs.ac.bg.fon.silab.gui.diplomskirad.command.ActionFactory;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCDiplomskiRad;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCStudent;
import rs.ac.bg.fon.silab.session.Session;

/**
 *
 * @author MARINA
 */
public class DiplomskiRadWindowListener extends WindowAdapter {

    GUIControllerDiplomskiRad controllerDiplomskiRad;
    boolean executed = false;

    public DiplomskiRadWindowListener(GUIControllerDiplomskiRad controllerDiplomskiRad) {
        this.controllerDiplomskiRad = controllerDiplomskiRad;
    }

    @Override
    public void windowActivated(WindowEvent e) {
        controllerDiplomskiRad.convertGraphicalIntoDomainObject();
        if(controllerDiplomskiRad.getDiplomskiRad() == null)return;
        if(controllerDiplomskiRad.getDiplomskiRad().getStudent() == null)return;
        if (!executed) {
            DCDiplomskiRad diplomskiRad = (DCDiplomskiRad) controllerDiplomskiRad.SOFindByID(controllerDiplomskiRad.getDiplomskiRad());
            if(diplomskiRad != null){
                controllerDiplomskiRad.setDiplomskiRad(diplomskiRad);
            }
            AbstractAction action = ActionFactory.createAction(controllerDiplomskiRad.getDiplomskiRad());
            if (action == null) {
                return;
            }
            action.execute(controllerDiplomskiRad);
            executed = true;
        }
        controllerDiplomskiRad.convertDomainIntoGraphicalObject();

    }

}
