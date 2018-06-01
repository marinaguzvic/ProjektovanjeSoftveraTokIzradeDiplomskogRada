package rs.ac.bg.fon.silab.gui.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JOptionPane;
import rs.ac.bg.fon.silab.gui.form.FMain;
import rs.ac.bg.fon.silab.gui.form.listener.main.DiplomskiRadListener;
import rs.ac.bg.fon.silab.gui.form.listener.main.StudentNewListener;
import rs.ac.bg.fon.silab.gui.form.listener.main.StudentSearchListener;
import rs.ac.bg.fon.silab.gui.form.listener.main.TemaNewListener;
import rs.ac.bg.fon.silab.gui.form.listener.main.TemaSearchListener;

/**
 *
 * @author MARINA
 */
public class GUIControllerMain extends GeneralGUIController{
    private FMain fMain;
    private String useCaseMessage;

    public GUIControllerMain() {
        fMain = FMain.getInstance();
        setListeners();
        fMain.setVisible(true);
        
    }

    private void setListeners() {
        fMain.getMenuItemStudentNew().addActionListener(new StudentNewListener(this));
        fMain.getMenuItemStudentSearch().addActionListener(new StudentSearchListener(this));
        fMain.getjMenuItemDiplomskiRad().addActionListener(new DiplomskiRadListener(this));
        fMain.getjMenuItemTemaDiplomskogRadaSearch().addActionListener(new TemaSearchListener(this));
        fMain.getjMenuItemTemaDiplomskogRadaNew().addActionListener(new TemaNewListener(this));
    }

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
    
    
    
}
