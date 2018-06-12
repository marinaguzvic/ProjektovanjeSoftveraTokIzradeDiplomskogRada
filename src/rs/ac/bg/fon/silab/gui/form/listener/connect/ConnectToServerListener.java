/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.connect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import rs.ac.bg.fion.silab.gui.controller.general.ConfigController;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerConnect;
import rs.ac.bg.fon.silab.gui.form.FConnect;

/**
 *
 * @author MARINA
 */
public class ConnectToServerListener implements ActionListener{

    GUIControllerConnect controllerDialog;

    public ConnectToServerListener(GUIControllerConnect controllerDialog) {
        this.controllerDialog = controllerDialog;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            controllerDialog.SOConnect(((FConnect)controllerDialog.getGeneralGUI()).getjTxtAddress().getText().trim(), Integer.parseInt(((FConnect)controllerDialog.getGeneralGUI()).getjTxtPort().getText().trim()));
            ((ConfigController)controllerDialog).createConfigFile();
            controllerDialog.closeForm();
        } catch (IOException ex) {
            ex.printStackTrace();
            controllerDialog.showMessage("Connect to server unsuccesful: " + ex.getMessage());
        }
    }
    
}
