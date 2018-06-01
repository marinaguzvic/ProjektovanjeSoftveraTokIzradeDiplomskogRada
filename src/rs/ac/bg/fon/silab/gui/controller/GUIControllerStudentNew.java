/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import javax.swing.JFrame;
import rs.ac.bg.fon.silab.constants.Constants;
import rs.ac.bg.fon.silab.gui.form.FStudentNew;
import rs.ac.bg.fon.silab.gui.form.FormState;
import rs.ac.bg.fon.silab.gui.form.GeneralGUI;
import rs.ac.bg.fon.silab.gui.form.listener.create.generateindex.GenerateBrojIndeksaListener;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCStudent;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public class GUIControllerStudentNew extends GeneralControllerNew {

    DCStudent student;
    FStudentNew fStudentNew;
    GUIControllerStudentSearch controllerStudentSearch;

    public GUIControllerStudentNew(JFrame parent) {
        this.parent = parent;
        createObject();
        fStudentNew = new FStudentNew(parent, true);
        setListeners();
        prepareFormFor(FormState.INSERT);
        fStudentNew.setVisible(true);

    }

    public GUIControllerStudentNew(GUIControllerStudentSearch gcs,JFrame parent, DCStudent student) {
        controllerStudentSearch = gcs;
        this.parent = parent;
        this.student = student;
        fStudentNew = new FStudentNew(parent, true);
        convertDomainIntoGraphicalObject();
        setListeners();
        prepareFormFor(FormState.VIEW);
        fStudentNew.setVisible(true);
    }

    @Override
    public void convertGraphicalIntoDomainObject() {
        student.setBrojIndeksa(fStudentNew.getBrojIndeksa());
        student.setJmbg(fStudentNew.getJMBG());
        student.setIme(fStudentNew.getIme());
        student.setPrezime(fStudentNew.getPrezime());
        student.setBudzet(fStudentNew.getBudzet());
        student.setGodinaStudija(fStudentNew.getGodinaStudija());
        student.setDatumRodjenja(fStudentNew.getDatumRodjenja());
        student.setPrviPutUpisao(fStudentNew.getPrviPutUpisao());
    }

    @Override
    public void convertDomainIntoGraphicalObject() {
        fStudentNew.setBrojIndeksa(student.getBrojIndeksa());
        fStudentNew.setJMBG(student.getJmbg());
        fStudentNew.setIme(student.getIme());
        fStudentNew.setPrezime(student.getPrezime());
        fStudentNew.setBudzet(student.isBudzet());
        fStudentNew.setGodinaStudija(student.getGodinaStudija());
        fStudentNew.setDatumRodjenja(student.getDatumRodjenja());
        fStudentNew.setPrviPutUpisao(student.isPrviPutUpisao());
    }

    @Override
    public void createObject() {
        student = new DCStudent();
    }

    @Override
    public void emptyGraphicalObject() {
        createObject();
        convertDomainIntoGraphicalObject();
    }

    @Override
    public void setListeners() {
        super.setListeners();
        fStudentNew.getGenerisiBrojIndeksa().addActionListener(new GenerateBrojIndeksaListener(this));
        
    }
    

    @Override
    public void prepareFormFor(FormState formState) {
        switch (formState) {
            case INSERT:
                fStudentNew.getGenerisiBrojIndeksa().setEnabled(true);
                fStudentNew.getSave().setVisible(true);
                fStudentNew.getUpdate().setVisible(false);
                fStudentNew.getEdit().setVisible(false);
                break;
            case VIEW:
                fStudentNew.getGenerisiBrojIndeksa().setEnabled(false);
                fStudentNew.getSave().setVisible(false);
                fStudentNew.getUpdate().setVisible(true);
                fStudentNew.getUpdate().setEnabled(false);
                fStudentNew.getEdit().setVisible(true);
                fStudentNew.getEdit().setEnabled(true);

                fStudentNew.getjTxtJMBG().setEditable(false);
                fStudentNew.getjTxtIme().setEditable(false);
                fStudentNew.getjTxtPrezime().setEditable(false);
                fStudentNew.getjCheckBoxBudzet().setEnabled(false);
                fStudentNew.getjCheckBoxPrviPutUpisao().setEnabled(false);
                fStudentNew.getjDateRodjenja().setEditable(false);
                fStudentNew.getjSpinnerGodinaStudija().setEnabled(false);
                if(controllerStudentSearch != null)controllerStudentSearch.refreshTable();
                break;
            case EDIT:
                fStudentNew.getGenerisiBrojIndeksa().setEnabled(false);
                fStudentNew.getSave().setVisible(false);
                fStudentNew.getUpdate().setVisible(true);
                fStudentNew.getUpdate().setEnabled(true);
                fStudentNew.getEdit().setVisible(true);
                fStudentNew.getEdit().setEnabled(false);

                fStudentNew.getjTxtJMBG().setEditable(true);
                fStudentNew.getjTxtIme().setEditable(true);
                fStudentNew.getjTxtPrezime().setEditable(true);
                fStudentNew.getjCheckBoxBudzet().setEnabled(true);
                fStudentNew.getjCheckBoxPrviPutUpisao().setEnabled(true);
                fStudentNew.getjDateRodjenja().setEditable(true);
                fStudentNew.getjSpinnerGodinaStudija().setEnabled(true);
                break;
        }
    }

    @Override
    public GeneralGUI getGeneralGUI() {
        return fStudentNew;
    }

    @Override
    public void showMessage(String signal) {
        fStudentNew.setMessage(signal);
    }

    @Override
    public void closeForm() {
        fStudentNew.close();
    }

    @Override
    public GeneralDObject getGdo() {
        return student;
    }

    public GeneralDObject SOGenerateBrojIndeksa() {
        return SOCall(Constants.SOCall.SO_GENERATE_BROJ_INDEKSA, student);
    }

    public void setStudent(GeneralDObject gdo) {
        student = (DCStudent) gdo;
    }

}
