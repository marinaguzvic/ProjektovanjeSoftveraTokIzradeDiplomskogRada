/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.diplomskirad.command;

import rs.ac.bg.fon.silab.jpa.example1.domain.DCDiplomskiRad;

/**
 *
 * @author MARINA
 */
public class ActionFactory {

    public static AbstractAction createAction(DCDiplomskiRad diplomskiRad) {
        AbstractAction command = null;

        if (diplomskiRad == null) {
            return null;
        }
        if (diplomskiRad.getStatus() == null) {
            command = new PrijaviAction();
        } else {
            switch (diplomskiRad.getStatus()) {
                case PRIJAVLJEN:
                    command = new OdobriAction();
                    break;
                case ODOBREN:
                    command = new OdbraniAction();
                    break;
                case ODBRANJEN:
                    command = new ViewAction();
                    break;
            }
        }
        return command;
    }
}
