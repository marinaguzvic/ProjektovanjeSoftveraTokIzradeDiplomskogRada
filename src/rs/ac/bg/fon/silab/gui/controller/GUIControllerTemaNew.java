/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import java.awt.Frame;
import rs.ac.bg.fon.silab.gui.form.listener.create.SaveListListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import rs.ac.bg.fon.silab.form.components.table.model.TemaTableModel;
import rs.ac.bg.fon.silab.gui.form.FTemaDiplomskogRadaNew;
import rs.ac.bg.fion.silab.gui.general.FormState;
import rs.ac.bg.fion.silab.gui.general.GeneralGUI;
import rs.ac.bg.fon.silab.gui.form.listener.create.CancelListener;
import rs.ac.bg.fon.silab.gui.form.listener.tema.AddListener;
import rs.ac.bg.fon.silab.gui.form.listener.tema.RemoveListener;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCPredmet;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCTemaDiplomskogRada;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public class GUIControllerTemaNew extends GeneralControllerNew implements GUIListNew, GUIControllerTableNew {

    FTemaDiplomskogRadaNew fTemaDiplomskogRadaNew;
    List<DCTemaDiplomskogRada> teme;

    public GUIControllerTemaNew(Frame parent, GUIControllerMain controllerMain) {
        super(controllerMain, parent);
        createObject();
        fTemaDiplomskogRadaNew = new FTemaDiplomskogRadaNew(parent, true);
        populateTableTeme();
        setColumnPredmeti();
        setListeners();
        fTemaDiplomskogRadaNew.setVisible(true);

    }

    @Override
    public void convertGraphicalIntoDomainObject() {
        teme = ((TemaTableModel) fTemaDiplomskogRadaNew.getjTableTeme().getModel()).getTeme();
    }

    @Override
    public void convertDomainIntoGraphicalObject() {
        ((TemaTableModel) fTemaDiplomskogRadaNew.getjTableTeme().getModel()).setTeme(teme);
    }

    @Override
    public void createObject() {
        teme = new ArrayList<>();
    }

    @Override
    public void prepareFormFor(FormState formState) {
        System.out.println("prepare form for jos nije implementirano");
    }

    @Override
    public void emptyGraphicalObject() {
        createObject();
        populateTableTeme();
        setColumnPredmeti();
    }

    @Override
    public void setListeners() {

        fTemaDiplomskogRadaNew.getSave().addActionListener(new SaveListListener(this));
        fTemaDiplomskogRadaNew.getCancel().addActionListener(new CancelListener(this));
        fTemaDiplomskogRadaNew.getjBtnAdd().addActionListener(new AddListener(this));
        fTemaDiplomskogRadaNew.getjBtnRemove().addActionListener(new RemoveListener(this));
    }

    @Override
    public GeneralGUI getGeneralGUI() {
        return fTemaDiplomskogRadaNew;
    }

    @Override
    public void showMessage(String signal) {
        fTemaDiplomskogRadaNew.setMessage(signal);
    }

    @Override
    public void closeForm() {
        fTemaDiplomskogRadaNew.close();
    }

    private void populateTableTeme() {
        fTemaDiplomskogRadaNew.getjTableTeme().setModel(new TemaTableModel(teme));
    }

    private void setColumnPredmeti() {
        List<GeneralDObject> gdos = SOFindAll(new DCPredmet());
        List<DCPredmet> predmeti = new ArrayList<>();
        gdos.forEach((gdo) -> {
            predmeti.add((DCPredmet) gdo);
        });
        JComboBox<DCPredmet> comboBox = new JComboBox(new DefaultComboBoxModel(predmeti.toArray()));
        TableColumn columnProduct = fTemaDiplomskogRadaNew.getjTableTeme().getColumnModel().getColumn(2);
        columnProduct.setCellEditor(new DefaultCellEditor(comboBox));

    }

    @Override
    public void add() {
        try {
            ((TemaTableModel) fTemaDiplomskogRadaNew.getjTableTeme().getModel()).add();
        } catch (Exception ex) {
            fTemaDiplomskogRadaNew.setMessage("The last tema added is not filled out correctly.");
        }
    }

    @Override
    public void remove() {
        int row = fTemaDiplomskogRadaNew.getjTableTeme().getSelectedRow();
        ((TemaTableModel) fTemaDiplomskogRadaNew.getjTableTeme().getModel()).remove(row);
    }

    @Override
    public GeneralDObject getGdo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GeneralDObject> getList() {
        return new ArrayList<>(teme);
    }

    @Override
    public GUIControllerMain getConrollerMain() {
        return controllerMain;
    }

}
