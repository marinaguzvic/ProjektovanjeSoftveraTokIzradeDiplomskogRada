/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import rs.ac.bg.fon.silab.form.components.table.model.TemaSearchTableModel;
import rs.ac.bg.fon.silab.gui.form.FTemaDiplomskogRadaSearch;
import rs.ac.bg.fion.silab.gui.general.FormState;
import rs.ac.bg.fion.silab.gui.general.GeneralGUI;
import rs.ac.bg.fon.silab.gui.form.listener.main.TemaNewListener;
import rs.ac.bg.fon.silab.gui.form.listener.refresh.RefreshListener;
import rs.ac.bg.fon.silab.gui.form.listener.search.ComboBoxFilter;
import rs.ac.bg.fon.silab.gui.form.listener.search.FilterListener;
import rs.ac.bg.fon.silab.gui.form.listener.search.TextFilter;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCPredmet;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCTemaDiplomskogRada;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public class GUIControllerTemaSearch extends GeneralControllerSearch {

    List<DCTemaDiplomskogRada> teme;
    List<DCTemaDiplomskogRada> filteredTeme;
    FTemaDiplomskogRadaSearch fTemaDiplomskogRadaSearch;

    public GUIControllerTemaSearch(Frame parent, GUIControllerMain controllerMain) {
        super(controllerMain, parent);
        
        fTemaDiplomskogRadaSearch = new FTemaDiplomskogRadaSearch(parent, true);
        createObject();
        convertDomainIntoGraphicalObject();
        populateComboPredmet();
        fTemaDiplomskogRadaSearch.initButtonsSearch();
        setListeners();
        prepareFormFor(FormState.VIEW);
        fTemaDiplomskogRadaSearch.setVisible(true);
    }

    @Override
    public void emptyGraphicalObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void convertGraphicalIntoDomainObject() {
        teme = ((TemaSearchTableModel) fTemaDiplomskogRadaSearch.getjTableTeme().getModel()).getTeme();
    }

    @Override
    public void convertDomainIntoGraphicalObject() {
        populateTable();
    }

    @Override
    public void createObject() {
        teme = new ArrayList<>();
        List<GeneralDObject> list = SOFindAll(new DCTemaDiplomskogRada());
        convertListToTeme(list);
        filteredTeme = new ArrayList<>(teme);
    }

    @Override
    public void setListeners() {
        super.setListeners();
        fTemaDiplomskogRadaSearch.getjTxtID().getDocument().addDocumentListener(new FilterListener(this));
        fTemaDiplomskogRadaSearch.getBasicSearchPanel().getjTxtNazivTeme().getDocument().addDocumentListener(new FilterListener(this));
        fTemaDiplomskogRadaSearch.getAdvancedSearchPanel().getjComboBoxPredmet().addActionListener(new FilterListener(this));
        fTemaDiplomskogRadaSearch.getAdvancedSearchPanel().getjTxtOpis().getDocument().addDocumentListener(new FilterListener(this));
        
        fTemaDiplomskogRadaSearch.getjBtnAddNew().addActionListener(new TemaNewListener(this));
        fTemaDiplomskogRadaSearch.getjBtnRefresh().addActionListener(new RefreshListener(this));
    }

    @Override
    public void prepareFormFor(FormState formState) {
        switch (formState) {
            case VIEW:
                getView().setVisible(false);
                break;

        }
    }

    @Override
    public void populateTable() {
        try {
            TableModel tm = fTemaDiplomskogRadaSearch.getjTableTeme().getModel();
            if (tm instanceof TemaSearchTableModel) {
                ((TemaSearchTableModel) tm).setData(filteredTeme);
            } else {
                tm = new TemaSearchTableModel(filteredTeme);
                fTemaDiplomskogRadaSearch.getjTableTeme().setModel(tm);

            }
//            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void convertListToTeme(List<GeneralDObject> list) {
        list.forEach((generalDObject) -> {
            teme.add((DCTemaDiplomskogRada) generalDObject);
        });
    }

    @Override
    public void filter() {
        FTemaDiplomskogRadaSearch form = (FTemaDiplomskogRadaSearch) fTemaDiplomskogRadaSearch;
        filteredTeme = new ArrayList<>();
        for (DCTemaDiplomskogRada tema : teme) {
            if (TextFilter.isEqual(form.getjTxtID(), tema.getTemaID() + "")
                    && TextFilter.isEqual(form.getBasicSearchPanel().getjTxtNazivTeme(), tema.getNazivTeme())
                    && TextFilter.isEqual(form.getAdvancedSearchPanel().getjTxtOpis(), tema.getOpisTeme())
                    && ComboBoxFilter.isEqual(form.getAdvancedSearchPanel().getjComboBoxPredmet(), tema.getPredmet())) {
                filteredTeme.add(tema);
            }
        }
    }

    private void populateComboPredmet() {
        List<GeneralDObject> list = SOFindAll(new DCPredmet());
        fTemaDiplomskogRadaSearch.getAdvancedSearchPanel().getjComboBoxPredmet().addItem(new DCPredmet("Svi"));
        for (GeneralDObject generalDObject : list) {
            fTemaDiplomskogRadaSearch.getAdvancedSearchPanel().getjComboBoxPredmet().addItem((DCPredmet) generalDObject);
        }
    }

    @Override
    public GeneralDObject getSelectedObject() {
        TemaSearchTableModel ttm = (TemaSearchTableModel) fTemaDiplomskogRadaSearch.getjTableTeme().getModel();
        return ttm.getTeme().get(fTemaDiplomskogRadaSearch.getjTableTeme().getSelectedRow());
    }

    @Override
    public GeneralGUI getGeneralGUI() {
        return fTemaDiplomskogRadaSearch;
    }

    @Override
    public void showMessage(String signal) {
        fTemaDiplomskogRadaSearch.setMessage(signal);
    }

    @Override
    public void closeForm() {
        fTemaDiplomskogRadaSearch.close();
    }

    @Override
    public GUIControllerMain getConrollerMain() {
        return controllerMain;
    }

}
