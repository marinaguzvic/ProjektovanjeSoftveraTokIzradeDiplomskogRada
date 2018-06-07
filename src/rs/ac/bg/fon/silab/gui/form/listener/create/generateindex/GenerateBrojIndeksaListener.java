/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.create.generateindex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerStudentNew;
import rs.ac.bg.fon.silab.gui.controller.GeneralControllerNew;
import rs.ac.bg.fion.silab.gui.general.FormState;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCStudent;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public class GenerateBrojIndeksaListener implements ActionListener{
        GUIControllerStudentNew gcsn;

        public GenerateBrojIndeksaListener(GUIControllerStudentNew gcsn) {
            this.gcsn = gcsn;
        }
        
        

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                GeneralDObject gdo = gcsn.SOGenerateBrojIndeksa(gcsn.getGdo());
                gcsn.setStudent(gdo);
                gcsn.showMessage("Index number generated");
                gcsn.convertDomainIntoGraphicalObject();
                gcsn.prepareFormFor(FormState.EDIT);
            } catch (Exception ex) {
                gcsn.showMessage("Unable to generate index number");
                ex.printStackTrace();
                Logger.getLogger(GUIControllerStudentNew.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }