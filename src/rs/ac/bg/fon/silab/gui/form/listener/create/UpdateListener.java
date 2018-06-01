/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.create;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GeneralControllerNew;
import rs.ac.bg.fon.silab.gui.form.FormState;

/**
 *
 * @author MARINA
 */
public class UpdateListener implements ActionListener {

        GeneralControllerNew ggc;

        public UpdateListener(GeneralControllerNew ggc) {
            this.ggc = ggc;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ggc.convertGraphicalIntoDomainObject();
            ggc.SOUpdate(ggc.getGdo());
            ggc.prepareFormFor(FormState.VIEW);
            
        }

    }