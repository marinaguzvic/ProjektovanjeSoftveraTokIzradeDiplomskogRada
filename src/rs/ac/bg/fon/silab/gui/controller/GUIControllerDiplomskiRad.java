/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import java.time.Instant;
import rs.ac.bg.fon.silab.gui.form.listener.diplomskirad.EnterKomisijaActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JFrame;
import rs.ac.bg.fon.silab.form.components.table.model.KomisijaTableModel;
import rs.ac.bg.fon.silab.gui.form.FDiplomskiRad;
import rs.ac.bg.fon.silab.gui.form.FMain;
import rs.ac.bg.fon.silab.gui.form.FormState;
import rs.ac.bg.fon.silab.gui.form.GeneralGUI;
import rs.ac.bg.fon.silab.gui.form.PKomisija;
import rs.ac.bg.fon.silab.gui.form.POdbraniDiplomskiRad;
import rs.ac.bg.fon.silab.gui.form.POdobravanjeDiplomskogRada;
import rs.ac.bg.fon.silab.gui.form.PPrijavaDiplomskogRada;
import rs.ac.bg.fon.silab.gui.form.listener.main.StudentSearchListener;
import rs.ac.bg.fon.silab.gui.form.listener.main.TemaSearchListener;
import rs.ac.bg.fon.silab.gui.form.listener.window.DiplomskiRadWindowListener;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCDiplomskiRad;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCKomisija;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCStudent;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCTemaDiplomskogRada;
import rs.ac.bg.fon.silab.jpa.example1.domain.EStatus;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;
import rs.ac.bg.fon.silab.session.Session;

/**
 *
 * @author MARINA
 */
public class GUIControllerDiplomskiRad extends GeneralControllerNew {

    private DCDiplomskiRad diplomskiRad;
    FDiplomskiRad fDiplomskiRad;

    public GUIControllerDiplomskiRad(FMain parent) {
        this.parent = parent;
        initNewForm();
    }

    private void initNewForm() {
        createObject();
        emptySession();
        fDiplomskiRad = new FDiplomskiRad();
        setListeners();
        fDiplomskiRad.setVisible(true);
    }

    @Override
    public void convertGraphicalIntoDomainObject() {
        if(diplomskiRad == null) return;
        if (Session.getInstance().getMap().get("selected_" + new DCStudent().getClassName()) != null) {
            if(diplomskiRad.getStudent() == null)diplomskiRad.setStudent((DCStudent) Session.getInstance().getMap().get("selected_" + new DCStudent().getClassName()));
        }else return;

        if (fDiplomskiRad.getpPrijavaDiplomskogRada() != null && diplomskiRad.getStatus() == EStatus.PRIJAVLJEN) {
            diplomskiRad.setDatumPrijave(LocalDate.parse(fDiplomskiRad.getpPrijavaDiplomskogRada().getjTxtDatumPrijave().getText()));
            diplomskiRad.setTemaDiplomskogRada((DCTemaDiplomskogRada) Session.getInstance().getMap().get("selected_" + new DCTemaDiplomskogRada().getClassName()));
        }
        if (fDiplomskiRad.getpOdobravanjeDiplomskogRada() != null && diplomskiRad.getStatus() == EStatus.ODOBREN) {
            diplomskiRad.setDatumKadJeOdobren(LocalDate.parse(fDiplomskiRad.getpOdobravanjeDiplomskogRada().getjTxtDatumKadaJeOdobren().getText()));
            diplomskiRad.setKomisija((DCKomisija) Session.getInstance().getMap().get("selected_" + new DCKomisija().getClassName()));
        }
        if (fDiplomskiRad.getpOdbraniDiplomskiRad() != null && diplomskiRad.getStatus() == EStatus.ODBRANJEN) {
            
            diplomskiRad.setDatumOdbrane(LocalDateTime.ofInstant(Instant.ofEpochMilli(fDiplomskiRad.getpOdbraniDiplomskiRad().getjDatumOdbrane().getDate().getTime()), ZoneId.systemDefault()).toLocalDate());
            diplomskiRad.setOcena((int) fDiplomskiRad.getpOdbraniDiplomskiRad().getjSpinnerOcena().getValue());
        }
        
    }

    @Override
    public void convertDomainIntoGraphicalObject() {

        if (diplomskiRad.getStudent() != null) {
            fDiplomskiRad.getjTxtBrojIndeksa().setText(diplomskiRad.getStudent().getBrojIndeksa());
            fDiplomskiRad.getjTxtIme().setText(diplomskiRad.getStudent().getIme());
            fDiplomskiRad.getjTxtPrezime().setText(diplomskiRad.getStudent().getPrezime());
        }
        if (fDiplomskiRad.getpPrijavaDiplomskogRada() != null) {
            fDiplomskiRad.getpPrijavaDiplomskogRada().getjTxtDatumPrijave().setText(diplomskiRad.getDatumPrijave().toString());
            fDiplomskiRad.getpPrijavaDiplomskogRada().getjTxtTema().setText(diplomskiRad.getTemaDiplomskogRada() == null ? "" : diplomskiRad.getTemaDiplomskogRada().getNazivTeme());
        }
        if (fDiplomskiRad.getpOdobravanjeDiplomskogRada() != null) {
            fDiplomskiRad.getpOdobravanjeDiplomskogRada().getjTxtDatumKadaJeOdobren().setText(diplomskiRad.getDatumKadJeOdobren().toString());
            fDiplomskiRad.getpKomisija().getјTblKomisija().setModel(new KomisijaTableModel(diplomskiRad.getKomisija() == null ? new DCKomisija() : diplomskiRad.getKomisija()));
        }
        if (fDiplomskiRad.getpOdbraniDiplomskiRad() != null) {
            fDiplomskiRad.getpOdbraniDiplomskiRad().getjDatumOdbrane().setDate(diplomskiRad.getDatumOdbrane() == null ? new Date() : new Date(diplomskiRad.getDatumOdbrane().toEpochDay()));
            fDiplomskiRad.getpOdbraniDiplomskiRad().getjSpinnerOcena().setValue(diplomskiRad.getOcena());
        }
    }

    @Override
    public void createObject() {
        diplomskiRad = new DCDiplomskiRad();
    }

    @Override
    public void setListeners() {
        
        fDiplomskiRad.getjBtnSearchStudent().addActionListener(new StudentSearchListener(this));
        fDiplomskiRad.addWindowListener(new DiplomskiRadWindowListener(this));
    }

    @Override
    public void emptyGraphicalObject() {
        fDiplomskiRad.close();
        initNewForm();
    }

    @Override
    public void prepareFormFor(FormState formState) {
        switch (formState) {
            case INSERT:
                fDiplomskiRad.getUpdate().setVisible(false);
                fDiplomskiRad.getEdit().setVisible(false);
                fDiplomskiRad.getSave().setVisible(true);
                break;
            case EDIT:
                fDiplomskiRad.getUpdate().setVisible(true);
                fDiplomskiRad.getSave().setVisible(false);
                fDiplomskiRad.getEdit().setVisible(false);
                break;
        }
    }

    @Override
    public JFrame getfParent() {
        return fDiplomskiRad;
    }

    public void odbrani() {
        diplomskiRad.setStatus(EStatus.ODBRANJEN);
        PKomisija komisija = new PKomisija();
        komisija.getјTblKomisija().setModel(new KomisijaTableModel(diplomskiRad.getKomisija()));
        komisija.getјTblKomisija().setEnabled(false);
        fDiplomskiRad.odbrani(new PPrijavaDiplomskogRada(), new POdobravanjeDiplomskogRada(), new POdbraniDiplomskiRad(), komisija);
        super.setListeners();
        prepareFormFor(FormState.EDIT);
    }

    public void prijavi() {

        diplomskiRad.setDatumPrijave(LocalDate.now());
        diplomskiRad.setStatus(EStatus.PRIJAVLJEN);
        PPrijavaDiplomskogRada prijava = new PPrijavaDiplomskogRada();
        prijava.getjBtnSearch().addActionListener(new TemaSearchListener(this));
        fDiplomskiRad.prijavi(prijava);
        super.setListeners();
        prepareFormFor(FormState.INSERT);
    }

    public void odobri() {
        diplomskiRad.setDatumKadJeOdobren(LocalDate.now());
        diplomskiRad.setStatus(EStatus.ODOBREN);
        POdobravanjeDiplomskogRada odobravanjeDiplomskogRada = new POdobravanjeDiplomskogRada();
        odobravanjeDiplomskogRada.getjBtnEnterKomisija().addActionListener(new EnterKomisijaActionListener(this));
        PKomisija komisija = new PKomisija();
        komisija.getјTblKomisija().setModel(new KomisijaTableModel(new DCKomisija()));
        komisija.getјTblKomisija().setEnabled(false);
        fDiplomskiRad.odobri(new PPrijavaDiplomskogRada(), odobravanjeDiplomskogRada, komisija);
        super.setListeners();
        prepareFormFor(FormState.EDIT);
    }



    public void view() {
        fDiplomskiRad.odbrani(new PPrijavaDiplomskogRada(), new POdobravanjeDiplomskogRada(), new POdbraniDiplomskiRad(), new PKomisija());
        fDiplomskiRad.greyAllFields();
    }

    @Override
    public GeneralGUI getGeneralGUI() {
        return fDiplomskiRad;
    }

    @Override
    public void showMessage(String signal) {
        fDiplomskiRad.setMessage(signal);
    }

    @Override
    public void closeForm() {
        fDiplomskiRad.close();
    }

    public DCDiplomskiRad getDiplomskiRad() {
        return diplomskiRad;
    }

    @Override
    public GeneralDObject getGdo() {
        return diplomskiRad;
    }

    private void emptySession() {
        Session.getInstance().getMap().clear();
    }

    public void setDiplomskiRad(DCDiplomskiRad diplomskiRad) {
        this.diplomskiRad = diplomskiRad;
    }


}
