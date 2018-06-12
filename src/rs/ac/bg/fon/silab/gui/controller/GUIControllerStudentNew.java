/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import java.awt.Frame;
import java.util.Date;
import javax.swing.JFrame;
import rs.ac.bg.fon.silab.constants.Constants;
import rs.ac.bg.fon.silab.gui.form.FStudentNew;
import rs.ac.bg.fion.silab.gui.general.FormState;
import rs.ac.bg.fion.silab.gui.general.GeneralGUI;
import rs.ac.bg.fon.silab.form.components.table.model.KomisijaTableModel;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerDiplomskiRadGeneral;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerMain;
import rs.ac.bg.fon.silab.gui.controller.GUIControllerStudentSearch;
import rs.ac.bg.fon.silab.gui.controller.GeneralControllerNew;
import rs.ac.bg.fon.silab.gui.diplomskirad.command.AbstractAction;
import rs.ac.bg.fon.silab.gui.diplomskirad.command.ActionFactory;
import rs.ac.bg.fon.silab.gui.form.PKomisija;
import rs.ac.bg.fon.silab.gui.form.POdbraniDiplomskiRad;
import rs.ac.bg.fon.silab.gui.form.POdobravanjeDiplomskogRada;
import rs.ac.bg.fon.silab.gui.form.PPrijavaDiplomskogRada;
import rs.ac.bg.fon.silab.gui.form.listener.create.generateindex.GenerateBrojIndeksaListener;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCClanKomisije;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCDiplomskiRad;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCStudent;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;
import transfer.util.IOperation;

/**
 *
 * @author MARINA
 */
public class GUIControllerStudentNew extends GeneralControllerNew implements GUIControllerDiplomskiRadGeneral {

    DCStudent student;
    DCDiplomskiRad diplomskiRad;
    FStudentNew fStudentNew;
    GUIControllerStudentSearch controllerStudentSearch;

    public GUIControllerStudentNew(Frame parent, GUIControllerMain controllerMain) {
        super(controllerMain, parent);
        createObject();
        fStudentNew = new FStudentNew(parent, true);
        setListeners();
        prepareFormFor(FormState.INSERT);
        fStudentNew.setVisible(true);

    }

    public GUIControllerStudentNew(GUIControllerStudentSearch gcs, Frame parent, GUIControllerMain controllerMain, DCStudent student) {
        super(controllerMain, parent);
        controllerStudentSearch = gcs;
        this.parent = parent;
        this.student = student;
        fStudentNew = new FStudentNew(parent, true);
        convertDomainIntoGraphicalObject();
        setListeners();
        prepareFormFor(FormState.VIEW);
        populateDiplomskiRad();
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
                fStudentNew.getSave().setVisible(false);
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
                if (controllerStudentSearch != null) {
                    controllerStudentSearch.refreshTable();
                }
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

    public void setStudent(GeneralDObject gdo) {
        student = (DCStudent) gdo;
    }

    @Override
    public GUIControllerMain getConrollerMain() {
        return controllerMain;
    }

    private void populateDiplomskiRad() {
        diplomskiRad = (DCDiplomskiRad) SOFindByID(new DCDiplomskiRad(student));
        AbstractAction action = null;
        action = ActionFactory.createAction(diplomskiRad);
        if(action != null)action.execute(this);
    }

    @Override
    public DCDiplomskiRad getDiplomskiRad() {
        return diplomskiRad;
    }

    @Override
    public void odbrani() {
        fStudentNew.setPrijava(initializePrijava());
        fStudentNew.setOdobravanje(initializaOdobravanje());
        fStudentNew.setKomisija(initializeKomisija());

    }

    @Override
    public void odobri() {
        fStudentNew.setPrijava(initializePrijava());
    }

    private PPrijavaDiplomskogRada initializePrijava() {
        PPrijavaDiplomskogRada pPrijavaDiplomskogRada = new PPrijavaDiplomskogRada();
        pPrijavaDiplomskogRada.getjTxtDatumPrijave().setText(diplomskiRad.getDatumPrijave().toString());
        pPrijavaDiplomskogRada.getjTxtTema().setText(diplomskiRad.getTemaDiplomskogRada().toString());
        pPrijavaDiplomskogRada.getjBtnSearch().setVisible(false);
        return pPrijavaDiplomskogRada;
    }

    private POdobravanjeDiplomskogRada initializaOdobravanje() {
        POdobravanjeDiplomskogRada pOdobravanjeDiplomskogRada = new POdobravanjeDiplomskogRada();
        pOdobravanjeDiplomskogRada.getjTxtDatumKadaJeOdobren().setText(diplomskiRad.getDatumKadJeOdobren().toString());
        pOdobravanjeDiplomskogRada.getjBtnEnterKomisija().setVisible(false);
        return pOdobravanjeDiplomskogRada;
    }

    private PKomisija initializeKomisija() {
        PKomisija pKomisija = new PKomisija();
        pKomisija.getјTblKomisija().setModel(new KomisijaTableModel(diplomskiRad.getKomisija()));
        pKomisija.getјTblKomisija().setEnabled(false);
        return pKomisija;
    }

    private POdbraniDiplomskiRad initializeOdbrani() {
        POdbraniDiplomskiRad pOdbraniDiplomskiRad = new POdbraniDiplomskiRad();
        pOdbraniDiplomskiRad.getjDatumOdbrane().setDate(new Date(diplomskiRad.getDatumOdbrane().getYear(), diplomskiRad.getDatumOdbrane().getMonthValue() - 1, diplomskiRad.getDatumOdbrane().getDayOfMonth()));
        pOdbraniDiplomskiRad.getjSpinnerOcena().setValue(diplomskiRad.getOcena());
        pOdbraniDiplomskiRad.getjDatumOdbrane().setEnabled(false);
        pOdbraniDiplomskiRad.getjSpinnerOcena().setEnabled(false);
        return pOdbraniDiplomskiRad;
    }

    @Override
    public void prijavi() {
    }

    @Override
    public void setDiplomskiRad(DCDiplomskiRad diplomskiRad) {
        this.diplomskiRad = diplomskiRad;

    }

    @Override
    public void view() {
        fStudentNew.setPrijava(initializePrijava());
        fStudentNew.setOdobravanje(initializaOdobravanje());
        fStudentNew.setKomisija(initializeKomisija());
        fStudentNew.setOdbrana(initializeOdbrani());
    }

}
