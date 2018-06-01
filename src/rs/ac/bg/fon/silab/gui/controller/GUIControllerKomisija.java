/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import rs.ac.bg.fon.silab.gui.form.listener.create.SaveListListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import rs.ac.bg.fon.silab.form.components.table.model.KomisijaTableModel;
import rs.ac.bg.fon.silab.form.components.table.model.TemaTableModel;
import rs.ac.bg.fon.silab.gui.form.FKomisija;
import rs.ac.bg.fon.silab.gui.form.FTemaDiplomskogRadaNew;
import rs.ac.bg.fon.silab.gui.form.FormState;
import rs.ac.bg.fon.silab.gui.form.GeneralGUI;
import rs.ac.bg.fon.silab.gui.form.listener.create.CancelListener;
import rs.ac.bg.fon.silab.gui.form.listener.create.SaveListener;
import rs.ac.bg.fon.silab.gui.form.listener.diplomskirad.NastavnikTableModelListener;
import rs.ac.bg.fon.silab.gui.form.listener.tema.AddListener;
import rs.ac.bg.fon.silab.gui.form.listener.tema.RemoveListener;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCClanKomisije;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCKomisija;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCNastavnik;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCPredmet;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCTemaDiplomskogRada;
import rs.ac.bg.fon.silab.jpa.example1.domain.EUlogaClanaKomisije;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;
import rs.ac.bg.fon.silab.session.Session;

/**
 *
 * @author MARINA
 */
public class GUIControllerKomisija extends GeneralControllerNew implements GUIListNew, GUIControllerTableNew {

    FKomisija fKomisija;
    DCKomisija komisija;
    JComboBox<DCNastavnik> comboBoxNastavnici;
    List<DCNastavnik> nastavnici;

    public GUIControllerKomisija(JFrame parent) {
        this.parent = parent;
        findAllNastavnici();
        createObject();
        fKomisija = new FKomisija(parent, true);
        populateTableKomsija();
        setColumnNastavnici();
        setColumnUloga();
        prepareFormFor(FormState.INSERT);
        setListeners();
        fKomisija.setVisible(true);

    }

    @Override
    public void convertGraphicalIntoDomainObject() {
        komisija = ((KomisijaTableModel) fKomisija.getjTableKomisija().getModel()).getKomisija();
    }

    @Override
    public void convertDomainIntoGraphicalObject() {
        ((KomisijaTableModel) fKomisija.getjTableKomisija().getModel()).setKomisija(komisija);
    }

    @Override
    public void createObject() {
        komisija = new DCKomisija();
    }

    @Override
    public void prepareFormFor(FormState formState) {
        switch (formState) {
            case INSERT:
                fKomisija.getSave().setVisible(true);
                fKomisija.getUpdate().setVisible(false);
                fKomisija.getEdit().setVisible(false);
                break;
            case VIEW:
                fKomisija.getSave().setVisible(false);
                fKomisija.getUpdate().setVisible(true);
                fKomisija.getUpdate().setEnabled(false);
                fKomisija.getEdit().setVisible(true);
                fKomisija.getEdit().setEnabled(true);

                fKomisija.getjTableKomisija().setEnabled(false);
                break;
            case EDIT:
                fKomisija.getSave().setVisible(false);
                fKomisija.getUpdate().setVisible(true);
                fKomisija.getUpdate().setEnabled(true);
                fKomisija.getEdit().setVisible(true);
                fKomisija.getEdit().setEnabled(false);

                fKomisija.getjTableKomisija().setEnabled(true);
                break;
        }
    }

    @Override
    public void emptyGraphicalObject() {
        Session.getInstance().getMap().put("selected_" + komisija.getClassName(), komisija);
        fKomisija.close();

    }

    @Override
    public void setListeners() {

        fKomisija.getSave().addActionListener(new SaveListener(this));
        fKomisija.getCancel().addActionListener(new CancelListener(this));
        fKomisija.getjBtnAdd().addActionListener(new AddListener(this));
        fKomisija.getjBtnRemove().addActionListener(new RemoveListener(this));
        fKomisija.getjTableKomisija().getModel().addTableModelListener(new NastavnikTableModelListener(this));
    }

    @Override
    public GeneralGUI getGeneralGUI() {
        return fKomisija;
    }

    @Override
    public void showMessage(String signal) {
        fKomisija.setMessage(signal);
    }

    @Override
    public void closeForm() {
        fKomisija.close();
    }

    private void populateTableKomsija() {
        fKomisija.getjTableKomisija().setModel(new KomisijaTableModel(komisija));
    }

    private void setColumnUloga() {
        List<EUlogaClanaKomisije> uloge = new ArrayList<>();
        uloge.add(EUlogaClanaKomisije.CLAN);
        uloge.add(EUlogaClanaKomisije.MENTOR);
        JComboBox<EUlogaClanaKomisije> comboBox = new JComboBox(new DefaultComboBoxModel(uloge.toArray()));
        TableColumn columnProduct = fKomisija.getjTableKomisija().getColumnModel().getColumn(1);
        columnProduct.setCellEditor(new DefaultCellEditor(comboBox));
    }

    public void setColumnNastavnici() {
        comboBoxNastavnici = new JComboBox(new DefaultComboBoxModel(nastavnici.toArray()));
        TableColumn columnProduct = fKomisija.getjTableKomisija().getColumnModel().getColumn(2);
        columnProduct.setCellEditor(new DefaultCellEditor(comboBoxNastavnici));

    }

    private void findAllNastavnici() {
        List<GeneralDObject> gdos = new ArrayList<>();
        SOFindAll(new DCNastavnik(), gdos);
        nastavnici = new ArrayList<>();
        gdos.forEach((gdo) -> {
            nastavnici.add((DCNastavnik) gdo);
        });

    }

    @Override
    public void add() {
        try {
            ((KomisijaTableModel) fKomisija.getjTableKomisija().getModel()).add();
        } catch (Exception ex) {
            ex.printStackTrace();
            fKomisija.setMessage("The last komisija added is not filled out correctly.");
        }
    }

    @Override
    public void remove() {
        int row = fKomisija.getjTableKomisija().getSelectedRow();
        if (row < 0) {
            fKomisija.setMessage("Row is not selected!");
        }
        ((KomisijaTableModel) fKomisija.getjTableKomisija().getModel()).remove(row);
    }

    @Override
    public GeneralDObject getGdo() {
        return komisija;
    }

    @Override
    public List<GeneralDObject> getList() {
        return new ArrayList<>(komisija.getClanovi());
    }

    public void editColumnNastavnici() {
        comboBoxNastavnici.setModel(new DefaultComboBoxModel(nastavnici.toArray()));
        for (DCClanKomisije dCClanKomisije : komisija.getClanovi()) {
            comboBoxNastavnici.removeItem(dCClanKomisije.getNastavnik());
        }
    }

}
