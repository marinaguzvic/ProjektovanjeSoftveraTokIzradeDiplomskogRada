/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.diplomskirad.command;


import rs.ac.bg.fon.silab.gui.controller.GUIControllerDiplomskiRad;
import rs.ac.bg.fon.silab.gui.form.FDiplomskiRad;
import rs.ac.bg.fon.silab.gui.form.PKomisija;
import rs.ac.bg.fon.silab.gui.form.POdobravanjeDiplomskogRada;
import rs.ac.bg.fon.silab.gui.form.PPrijavaDiplomskogRada;
import rs.ac.bg.fon.silab.jpa.example1.domain.EStatus;


/**
 *
 * @author MARINA
 */
public class OdobriAction extends AbstractAction {





    @Override
    public void execute(GUIControllerDiplomskiRad controller) {
        controller.odobri();
                
    }


    
}
