/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.main;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerStudentNew;
import rs.ac.bg.fon.silab.gui.controller.GeneralGUIController;

/**
 *
 * @author MARINA
 */
public class StudentNewListener implements ActionListener{
        GeneralGUIController ggc;

    public StudentNewListener(GeneralGUIController ggc) {
        this.ggc = ggc;
    }


        
        

        @Override
        public void actionPerformed(ActionEvent e) {
            GUIControllerStudentNew gcn = new GUIControllerStudentNew(ggc.getfParent());
            System.out.println("akcija izvrsena");
        }
        
    }