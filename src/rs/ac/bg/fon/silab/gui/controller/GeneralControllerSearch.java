/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import java.awt.Frame;
import javax.swing.JButton;
import rs.ac.bg.fion.silab.gui.general.GeneralGUISearch;
import rs.ac.bg.fon.silab.gui.form.listener.create.SelectListener;
import rs.ac.bg.fon.silab.gui.form.listener.search.AdvancedSearchListener;
import rs.ac.bg.fon.silab.gui.form.listener.search.BasicSearchListener;
import rs.ac.bg.fon.silab.gui.form.listener.create.ViewListener;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public abstract class GeneralControllerSearch extends GUIControllerDialog{

    public GeneralControllerSearch(GUIControllerMain controllerMain, Frame parent) {
        super(controllerMain, parent);
    }

    public GUIControllerMain getControllerMain() {
        return controllerMain;
    }
    
    

    @Override
    public void setListeners() {
        GeneralGUISearch ggn = (GeneralGUISearch) getGeneralGUI();
        ggn.getBasicSearchCheckbox().addActionListener(new BasicSearchListener(this));
        ggn.getAdvancedSearchCheckbox().addActionListener(new AdvancedSearchListener(this));
        ggn.getView().addActionListener(new ViewListener(this));
        ggn.getSelect().addActionListener(new SelectListener(this));
    }

    public boolean getBasicSearchChecked() {
        GeneralGUISearch ggn = (GeneralGUISearch) getGeneralGUI();
        return ggn.getBasicSearchCheckbox().isSelected();
    }

    public void addBasicSearchPanel() {
        GeneralGUISearch ggn = (GeneralGUISearch) getGeneralGUI();
        ggn.addBasicSearchPanel();
    }

    public void removeBasicSearchPanel() {
        GeneralGUISearch ggn = (GeneralGUISearch) getGeneralGUI();
        ggn.removeBasicSearchPanel();
    }

    public boolean getAdvancedSearchChecked() {
        GeneralGUISearch ggn = (GeneralGUISearch) getGeneralGUI();
        return ggn.getAdvancedSearchCheckbox().isSelected();
    }

    public void addAdvancedSearchPanel() {
        GeneralGUISearch ggn = (GeneralGUISearch) getGeneralGUI();
        ggn.addAdvancedSearchPanel();
    }

    public void removeAdvancedSearchPanel() {
        GeneralGUISearch ggn = (GeneralGUISearch) getGeneralGUI();
        ggn.removeAdvancedSearchPanel();
    }


    public JButton getView(){
        GeneralGUISearch ggn = (GeneralGUISearch) getGeneralGUI();
        return ggn.getView();
    }

    public JButton getSelect(){
        GeneralGUISearch ggn = (GeneralGUISearch) getGeneralGUI();
        return ggn.getSelect();
    }

    public GeneralDObject getSelectedObject(GeneralDObject gdo){
        try {
            
            SOFindByID(gdo);
            return gdo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void createObjectWithFilter() throws Exception{
        filter();
        populateTable();
    }
    public abstract void filter();
    public abstract void populateTable();
    public abstract  GeneralDObject getSelectedObject();
}
