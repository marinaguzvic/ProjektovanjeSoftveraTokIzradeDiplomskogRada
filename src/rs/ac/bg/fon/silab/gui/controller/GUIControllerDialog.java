/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import java.util.List;
import javax.swing.JFrame;
import rs.ac.bg.fon.silab.constants.Constants;
import rs.ac.bg.fon.silab.gui.form.GeneralGUI;
import rs.ac.bg.fon.silab.gui.form.FormState;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public abstract class GUIControllerDialog extends GeneralGUIController {

    protected JFrame parent;

    //System operations
    public GeneralDObject SOSave(GeneralDObject gdo) {
        return SOCall(Constants.SOCall.SO_SAVE, gdo);
    }

    public GeneralDObject SOUpdate(GeneralDObject gdo) {
        return SOCall(Constants.SOCall.SO_UPDATE, gdo);
    }

    public GeneralDObject SOFindByID(GeneralDObject gdo) {
        return SOCall(Constants.SOCall.SO_FIND_BY_ID, gdo);
    }

    public void SOSaveList(List<GeneralDObject> gdo) {
        for (GeneralDObject generalDObject : gdo) {
            SOCall(Constants.SOCall.SO_SAVE, generalDObject);
        }
    }

    public void SOFindAll(GeneralDObject gdo, List<GeneralDObject> list) {
        SOCall(Constants.SOCall.SO_FIND_ALL, list, gdo);
    }

//    public void SOFindWhere(GeneralDObject gdo, List<GeneralDObject> list, String where) {
//        SOCall(Constants.SOCall.SO_FIND_WHERE, list, gdo, where);
//    }

    protected GeneralDObject SOCall(String SOName, GeneralDObject gdo) {
        try {
            switch (SOName) {
                case Constants.SOCall.SO_SAVE:
                    return Controller.getInstance().save(gdo);
                case Constants.SOCall.SO_UPDATE:
                    return Controller.getInstance().update(gdo);
                case Constants.SOCall.SO_GENERATE_BROJ_INDEKSA:
                    return Controller.getInstance().generateNewBrojIndeksa(gdo);
                case Constants.SOCall.SO_FIND_BY_ID:
                    return Controller.getInstance().findByID(gdo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showMessage(e.getMessage());
        }
        return null;
    }



    protected void SOCall(String SOName, List<GeneralDObject> list, GeneralDObject gdo) {
        try {
            switch (SOName) {

                case Constants.SOCall.SO_FIND_ALL:
                    Controller.getInstance().findAll(gdo, list);
                    break;
                case Constants.SOCall.SO_FIND_WHERE:
                    Controller.getInstance().findByWhere(gdo, SOName, list);
                    break;
            }
        } catch (Exception ex) {
            showMessage(ex.getMessage());
        }
    }

    protected void SOCall(String SOName, List<GeneralDObject> list, GeneralDObject gdo, String where) {
        try {
            switch (SOName) {
                case Constants.SOCall.SO_FIND_WHERE:
                    Controller.getInstance().findByWhere(gdo, where, list);
                default:
            }
        } catch (Exception ex) {
            showMessage(ex.getMessage());
        }
    }

    @Override
    public JFrame getfParent() {
        return parent;
    }

    public abstract void emptyGraphicalObject();

    public abstract GeneralGUI getGeneralGUI();

    public abstract void showMessage(String signal);

    public abstract void closeForm();

    public abstract void convertGraphicalIntoDomainObject();

    public abstract void convertDomainIntoGraphicalObject();

    public abstract void createObject();

    public abstract void setListeners();

    public abstract void prepareFormFor(FormState formState);

}
