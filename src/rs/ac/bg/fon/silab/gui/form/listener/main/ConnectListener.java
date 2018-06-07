/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerConnect;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerMain;

/**
 *
 * @author MARINA
 */
public class ConnectListener implements ActionListener{
    
    GUIControllerMain controllerMain;

    public ConnectListener(GUIControllerMain controllerMain) {
        this.controllerMain = controllerMain;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        GUIControllerConnect controllerConnect = new GUIControllerConnect(controllerMain.getfParent(), controllerMain, controllerMain.isConnected());
    }
    
}
