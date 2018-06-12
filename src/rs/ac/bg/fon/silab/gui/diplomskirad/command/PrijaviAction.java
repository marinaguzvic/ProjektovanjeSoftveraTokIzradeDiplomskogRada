/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.diplomskirad.command;

import rs.ac.bg.fon.silab.gui.controller.GUIControllerDiplomskiRadGeneral;

/**
 *
 * @author MARINA
 */
public class PrijaviAction extends AbstractAction {



    @Override
    public void execute(GUIControllerDiplomskiRadGeneral controller) {
        controller.prijavi();
    }



    
}
