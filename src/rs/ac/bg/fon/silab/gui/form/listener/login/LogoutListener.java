/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GeneralControllerNew;

/**
 *
 * @author MARINA
 */
public class LogoutListener implements ActionListener{
    GeneralControllerNew controller;

    public LogoutListener(GeneralControllerNew controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            controller.SOLogout();
            controller.closeForm();
        } catch (Exception ex) {
            
        }
    }
}
