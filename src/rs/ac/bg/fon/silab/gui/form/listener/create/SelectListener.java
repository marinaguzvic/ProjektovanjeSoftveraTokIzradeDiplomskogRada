/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.create;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GeneralControllerSearch;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;
import rs.ac.bg.fon.silab.session.Session;

/**
 *
 * @author MARINA
 */
public class SelectListener implements ActionListener{
    GeneralControllerSearch ggc;

    public SelectListener(GeneralControllerSearch ggc) {
        this.ggc = ggc;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        GeneralDObject gdo = ggc.getSelectedObject();
        Session.getInstance().getMap().remove("selected_" + gdo.getClassName());
        Session.getInstance().getMap().put("selected_" + gdo.getClassName(), gdo);
        ggc.closeForm();
    }
    
}
