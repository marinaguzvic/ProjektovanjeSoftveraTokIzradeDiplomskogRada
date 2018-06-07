/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.connect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerConnect;
import rs.ac.bg.fon.silab.gui.form.FConnect;

/**
 *
 * @author MARINA
 */
public class DisconnectFromServerListener implements ActionListener{
    GUIControllerConnect controllerDialog;

    public DisconnectFromServerListener(GUIControllerConnect controllerDialog) {
        this.controllerDialog = controllerDialog;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            controllerDialog.SOLogout();
            controllerDialog.SODisconnect();
            controllerDialog.closeForm();
        } catch (Exception ex) {
            ex.printStackTrace();
            controllerDialog.showMessage("Disconnect unsuccesful: " + ex.getMessage());
        }
    }
}
