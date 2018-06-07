/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import java.awt.Frame;
import java.util.Arrays;
import rs.ac.bg.fion.silab.gui.general.FormState;
import rs.ac.bg.fion.silab.gui.general.GeneralGUI;
import rs.ac.bg.fon.silab.gui.form.FLogin;
import rs.ac.bg.fon.silab.gui.form.listener.create.CancelListener;
import rs.ac.bg.fon.silab.gui.form.listener.login.LoginListener;
import rs.ac.bg.fon.silab.gui.form.listener.login.LogoutListener;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCKorisnik;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;
import rs.ac.bg.fon.silab.session.Session;

/**
 *
 * @author MARINA
 */
public class GUIControllerLogin extends GeneralControllerNew {

    DCKorisnik korisnik;
    FLogin fLogin;

    public GUIControllerLogin(Frame parent, GUIControllerMain controllerMain,FormState formState) {
        super(controllerMain, parent);
        createObject();
        fLogin = new FLogin(parent, true);
        convertDomainIntoGraphicalObject();
        prepareFormFor(formState);
        setListeners();
        fLogin.setVisible(true);
    }

    @Override
    public void emptyGraphicalObject() {
        fLogin.getjTxtUsername().setText("");
        fLogin.getjPassword().setText("");
    }

    @Override
    public GeneralGUI getGeneralGUI() {
        return fLogin; 
    }

    @Override
    public void showMessage(String signal) {
        fLogin.setMessage(signal);
    }

    @Override
    public void closeForm() {
        fLogin.close();
    }

    @Override
    public void convertGraphicalIntoDomainObject() {
        korisnik.setUsername(fLogin.getjTxtUsername().getText().trim());
        korisnik.setPassword(fLogin.getjPassword().getPassword());
    }

    @Override
    public void convertDomainIntoGraphicalObject() {
        fLogin.getjTxtUsername().setText(korisnik.getUsername());
        fLogin.getjPassword().setText(Arrays.toString(korisnik.getPassword()));
    }

    @Override
    public void createObject() {
        if(Session.getInstance().getKorisnik() != null) korisnik = Session.getInstance().getKorisnik();
        else korisnik = new DCKorisnik();
    }

    @Override
    public void setListeners() {
        fLogin.getjBtnLogin().addActionListener(new LoginListener(this));
        fLogin.getjBtnLogout().addActionListener(new LogoutListener(this));
        fLogin.getjBtnCancel().addActionListener(new CancelListener(this));
    }

    @Override
    public void prepareFormFor(FormState formState) {
        switch(formState){
            case LOGGED_IN:
                fLogin.getjBtnLogin().setEnabled(false);
                fLogin.getjBtnLogout().setEnabled(true);
                break;
            case LOGGED_OUT:
                fLogin.getjBtnLogin().setEnabled(true);
                fLogin.getjBtnLogout().setEnabled(false);
                break;
        }
    }

    @Override
    public GeneralDObject getGdo() {
        return korisnik;
    }
    
        @Override
    public GUIControllerMain getConrollerMain() {
        return controllerMain;
    }

}
