/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.create;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerStudentNew;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerStudentSearch;
import rs.ac.bg.fon.silab.gui.controller.GeneralControllerSearch;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCStudent;

/**
 *
 * @author MARINA
 */
public class ViewListener implements ActionListener{
    GeneralControllerSearch gcs;

    public ViewListener(GeneralControllerSearch gcs) {
        this.gcs = gcs;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        GUIControllerStudentNew gcsn = new GUIControllerStudentNew((GUIControllerStudentSearch) gcs,gcs.getfParent(), (DCStudent) gcs.getSelectedObject());
        
    }
    
}
