/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.main;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fion.silab.gui.general.FormState;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerStudentSearch;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerDialog;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerMain;
import rs.ac.bg.fon.silab.gui.controller.GeneralGUIController;

/**
 *
 * @author MARINA
 */
public class StudentSearchListener implements ActionListener{
        GeneralGUIController ggc;

    public StudentSearchListener(GeneralGUIController ggc) {
        this.ggc = ggc;
    }


        
        

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                FormState formState = ggc instanceof GUIControllerMain ? FormState.VIEW:FormState.SELECT;
                GUIControllerDialog gcd = new GUIControllerStudentSearch(ggc.getfParent(),ggc.getConrollerMain(), formState);
                
            } catch (Exception ex) {
                //Obraditi gresku, prikazati poruku
            }

        }
}
