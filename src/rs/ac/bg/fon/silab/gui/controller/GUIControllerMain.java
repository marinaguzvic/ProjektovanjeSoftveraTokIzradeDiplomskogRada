package rs.ac.bg.fon.silab.gui.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import rs.ac.bg.fion.silab.gui.general.FormState;
import rs.ac.bg.fon.silab.gui.form.FMain;
import rs.ac.bg.fon.silab.gui.form.listener.main.ConnectListener;
import rs.ac.bg.fon.silab.gui.form.listener.main.DiplomskiRadListener;
import rs.ac.bg.fon.silab.gui.form.listener.main.LoginUserListener;
import rs.ac.bg.fon.silab.gui.form.listener.main.StudentNewListener;
import rs.ac.bg.fon.silab.gui.form.listener.main.StudentSearchListener;
import rs.ac.bg.fon.silab.gui.form.listener.main.TemaNewListener;
import rs.ac.bg.fon.silab.gui.form.listener.main.TemaSearchListener;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCKorisnik;
import rs.ac.bg.fon.silab.session.Session;

/**
 *
 * @author MARINA
 */
public class GUIControllerMain extends GeneralGUIController{
    private FMain fMain;
    private String useCaseMessage;

    public GUIControllerMain() {
        fMain = new FMain();
        setListeners();
        fMain.setVisible(true);
        
    }

    private void setListeners() {
        fMain.getMenuItemStudentNew().addActionListener(new StudentNewListener(this));
        fMain.getMenuItemStudentSearch().addActionListener(new StudentSearchListener(this));
        fMain.getjMenuItemDiplomskiRad().addActionListener(new DiplomskiRadListener(this));
        fMain.getjMenuItemTemaDiplomskogRadaSearch().addActionListener(new TemaSearchListener(this));
        fMain.getjMenuItemTemaDiplomskogRadaNew().addActionListener(new TemaNewListener(this));
        fMain.getjMenuItemLogIn().addActionListener(new LoginUserListener(this));
        fMain.getjMenuItemConnect().addActionListener(new ConnectListener(this));
    }

    @Override
    public FMain getfParent() {
        return fMain;
    }

    public void setfMain(FMain fMain) {
        this.fMain = fMain;
    }

    public String getUseCaseMessage() {
        return useCaseMessage;
    }

    public void setUseCaseMessage(String useCaseMessage) {
        this.useCaseMessage = useCaseMessage;
    }



    public void setMessage(String message) {
        JOptionPane.showMessageDialog(fMain, message);
    }

    void logout() {
        prepareFormFor(FormState.CONNECTED);
        setLoggedInUser();
    }

    void login() {
        prepareFormFor(FormState.LOGGED_IN);
        setLoggedInUser();
    }
    
   void connect(){
       prepareFormFor(FormState.CONNECTED);
   }
   
   void disconnect(){
       prepareFormFor(FormState.DISCONNECTED);
       setLoggedInUser();
   }


    
    void prepareFormFor(FormState formState){
        switch(formState){
            case DISCONNECTED:
                fMain.getjMenuConnect().setEnabled(true);
                fMain.getjMenuAccount().setEnabled(false);
                fMain.getjMenuDiplomskiRad().setEnabled(false);
                fMain.getjMenuStudent().setEnabled(false);
                fMain.getjMenuTemaDiplomskogRada().setEnabled(false);
                break;
            case CONNECTED:
                fMain.getjMenuConnect().setEnabled(true);
                fMain.getjMenuAccount().setEnabled(true);
                fMain.getjMenuDiplomskiRad().setEnabled(false);
                fMain.getjMenuStudent().setEnabled(false);
                fMain.getjMenuTemaDiplomskogRada().setEnabled(false);
                break;
            case LOGGED_IN:
                fMain.getjMenuConnect().setEnabled(true);
                fMain.getjMenuAccount().setEnabled(true);
                fMain.getjMenuDiplomskiRad().setEnabled(true);
                fMain.getjMenuStudent().setEnabled(true);
                fMain.getjMenuTemaDiplomskogRada().setEnabled(true);
                break;
        }
    }    

    private void setLoggedInUser() {
        DCKorisnik korisnik = Session.getInstance().getKorisnik();
        if(korisnik == null){
            fMain.getjLblUser().setText("No user is logged in");
        }else{
            fMain.getjLblUser().setText(korisnik.getIme() + " " + korisnik.getPrezime());
        }
    }

    public FormState isLoggedIn() {
        DCKorisnik korisnik = Session.getInstance().getKorisnik();
        if(korisnik == null){
            return FormState.LOGGED_OUT;
        }else{
            return FormState.LOGGED_IN;
        }
    }

    public FormState isConnected() {
        Socket socket = Session.getInstance().getSocket();
        if(socket == null){
            return FormState.LOGGED_OUT;
        }else{
            return FormState.LOGGED_IN;
        }
    }

    @Override
    public GUIControllerMain getConrollerMain() {
        return this;
    }
}
