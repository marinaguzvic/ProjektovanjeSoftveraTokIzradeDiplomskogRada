/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import java.awt.Frame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fion.silab.gui.controller.general.ConfigController;
import rs.ac.bg.fion.silab.gui.general.FormState;
import rs.ac.bg.fion.silab.gui.general.GeneralGUI;
import rs.ac.bg.fon.silab.constants.Constants;
import rs.ac.bg.fon.silab.gui.form.FConnect;
import rs.ac.bg.fon.silab.gui.form.listener.connect.ConnectToServerListener;
import rs.ac.bg.fon.silab.gui.form.listener.connect.DisconnectFromServerListener;
import rs.ac.bg.fon.silab.gui.form.listener.create.CancelListener;
import rs.ac.bg.fon.silab.session.Session;

/**
 *
 * @author MARINA
 */
public class GUIControllerConnect extends GUIControllerDialog implements ConfigController{

    FConnect fConnect;

    public GUIControllerConnect(Frame parent, GUIControllerMain controllerMain, FormState formState) {
        super(controllerMain, parent);
        fConnect = new FConnect(parent, true);
        setListeners();
        prepareFormFor(formState);
        readProperties();
        fConnect.setVisible(true);
    }

    @Override
    public Frame getfParent() {
        return parent;
    }

    @Override
    public void prepareFormFor(FormState formState) {
        switch (formState) {
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

    @Override
    public Properties getProperties() {
        FileInputStream file = null;
        try {
            file = new FileInputStream(Constants.PATH_TO_CONFIG_FILE);
            Properties prop = new Properties();
            prop.load(file);
            file.close();
            prop.setProperty(Constants.SERVER + "_" + Constants.PORT, fConnect.getjTxtPort().getText().trim());
            prop.setProperty(Constants.SERVER + "_" + Constants.ADDRESS, fConnect.getjTxtAddress().getText().trim());
            return prop;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
            }
        }
        return null;
    }

    @Override
    public void readProperties() {
        try (FileInputStream file = new FileInputStream(Constants.PATH_TO_CONFIG_FILE_FOR_CLIENT)) {
            Properties prop = new Properties();
            prop.load(file);
            fConnect.getjTxtPort().setText(prop.getProperty(Constants.SERVER + "_" + Constants.PORT));
            fConnect.getjTxtAddress().setText(prop.getProperty(Constants.SERVER + "_" + Constants.ADDRESS));
        } catch (FileNotFoundException ex) {
            fConnect.setMessage("File with address not found");

            ex.printStackTrace();
        } catch (IOException ex) {

        }
    }
    
    @Override
        public void createConfigFile() {
        try {

            OutputStream out = new FileOutputStream(Constants.PATH_TO_CONFIG_FILE_FOR_CLIENT);
            getProperties().store(out, null);
            out.close();
        } catch (FileNotFoundException ex) {
            fConnect.setMessage("File not found");

            ex.printStackTrace();
        } catch (IOException ex) {

        }
    }

}
