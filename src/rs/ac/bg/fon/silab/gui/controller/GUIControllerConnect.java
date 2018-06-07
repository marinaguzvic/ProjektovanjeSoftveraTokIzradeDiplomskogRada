/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import java.awt.Frame;
import rs.ac.bg.fion.silab.gui.general.FormState;
import rs.ac.bg.fion.silab.gui.general.GeneralGUI;
import rs.ac.bg.fon.silab.gui.form.FConnect;
import rs.ac.bg.fon.silab.gui.form.listener.connect.ConnectToServerListener;
import rs.ac.bg.fon.silab.gui.form.listener.connect.DisconnectFromServerListener;
import rs.ac.bg.fon.silab.gui.form.listener.create.CancelListener;
import rs.ac.bg.fon.silab.session.Session;

/**
 *
 * @author MARINA
 */
public class GUIControllerConnect extends GUIControllerDialog{

    FConnect fConnect;

    public GUIControllerConnect(Frame parent, GUIControllerMain controllerMain,FormState formState) {
        super(controllerMain, parent);
        fConnect = new FConnect(parent, true);
        setListeners();
        prepareFormFor(formState);
        fConnect.setVisible(true);
    }
    
    
    @Override
    public Frame getfParent() {
        return parent;
    }


    @Override
    public void prepareFormFor(FormState formState) {
        switch(formState){
            case CONNECTED:
                fConnect.getjBtnConnect().setEnabled(false);
                fConnect.getjBtnDisconnect().setEnabled(true);
                fConnect.getjTxtAddress().setText(Session.getInstance().getSocket().getInetAddress().toString());
                fConnect.getjTxtPort().setText(Session.getInstance().getSocket().getPort() + "");
                break;
            case DISCONNECTED:
                 fConnect.getjBtnConnect().setEnabled(true);
                fConnect.getjBtnDisconnect().setEnabled(false);
                break;
        }
    }

    @Override
    public void emptyGraphicalObject() {
    }

    @Override
    public GeneralGUI getGeneralGUI() {
        return fConnect;
    }

    @Override
    public void showMessage(String signal) {
        fConnect.setMessage(signal);
    }

    @Override
    public void closeForm() {
        fConnect.close();
    }

    @Override
    public void convertGraphicalIntoDomainObject() {
    }

    @Override
    public void convertDomainIntoGraphicalObject() {
    }

    @Override
    public void createObject() {
    }

    @Override
    public void setListeners() {
        fConnect.getjBtnConnect().addActionListener(new ConnectToServerListener(this));
        fConnect.getjBtnDisconnect().addActionListener(new DisconnectFromServerListener(this));
        fConnect.getjBtnCancel().addActionListener(new CancelListener(this));
    }

    @Override
    public GUIControllerMain getConrollerMain() {
        return controllerMain;
    }
    
    
    
}
