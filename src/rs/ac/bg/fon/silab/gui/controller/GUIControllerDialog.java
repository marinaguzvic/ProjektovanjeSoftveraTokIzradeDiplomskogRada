/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import java.awt.Frame;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import rs.ac.bg.fion.silab.gui.general.GeneralGUI;
import rs.ac.bg.fion.silab.gui.general.FormState;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCKorisnik;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;
import rs.ac.bg.fon.silab.session.Session;
import transfer.request.RequestObject;
import transfer.response.ResponseObject;
import transfer.util.IOperation;
import transfer.util.IStatus;

/**
 *
 * @author MARINA
 */
public abstract class GUIControllerDialog extends GeneralGUIController {

    protected GUIControllerMain controllerMain;
    protected Frame parent;

    public GUIControllerDialog(GUIControllerMain controllerMain, Frame parent) {
        this.controllerMain = controllerMain;
        this.parent = parent;
    }

    public GeneralDObject SOGenerateBrojIndeksa(GeneralDObject gdo) {
        return (GeneralDObject) proccessResponse(SOCall(IOperation.SO_GENERATE_BROJ_INDEKSA, gdo));
    }

    //System operations
    public GeneralDObject SOSave(GeneralDObject gdo) {
        return (GeneralDObject) proccessResponse(SOCall(IOperation.SO_SAVE, gdo));
    }

    private Object proccessResponse(ResponseObject response) {
        if (response.getCode() == IStatus.OK) {
            return  response.getData();
        } else {
            showMessage(response.getMessage());
            return null;
        }
    }

    public void SOConnect(String address, int port) throws IOException {
        Socket socket = new Socket(address, port);
        Session.getInstance().setSocket(socket);
    }

    public void SODisconnect() throws Exception {
        SOLogout();
        Session.getInstance().getOutput().close();
        Session.getInstance().getInput().close();
        Session.getInstance().getSocket().close();
    }

    public GeneralDObject SOUpdate(GeneralDObject gdo) {
        return (GeneralDObject) proccessResponse(SOCall(IOperation.SO_UPDATE, gdo));
    }

    public GeneralDObject SOFindByID(GeneralDObject gdo) {
        return (GeneralDObject) proccessResponse(SOCall(IOperation.SO_FIND_BY_ID, gdo));
    }

    public void SOSaveList(List<GeneralDObject> gdo) {
        for (GeneralDObject generalDObject : gdo) {
            proccessResponse(SOCall(IOperation.SO_SAVE, generalDObject));
        }
    }

    public List<GeneralDObject> SOFindAll(GeneralDObject gdo) {
        return (List<GeneralDObject>) proccessResponse(SOCall(IOperation.SO_FIND_ALL, gdo));
    }

    public void SOLogin(GeneralDObject gdo) throws Exception {
        DCKorisnik korisnik = (DCKorisnik) proccessResponse(SOCall(IOperation.LOGIN, gdo));
        if (korisnik == null) {
            throw new Exception("Logovanje neuspesno");
        }
        Session.getInstance().setKorisnik(korisnik);
    }

    protected ResponseObject SOCall(String SOName, GeneralDObject gdo) {
        try {
            RequestObject request = new RequestObject();
            request.setData(gdo);
            request.setOperation(SOName);
            sendRequest(request);
            return recieveResponse();
        } catch (Exception e) {
            e.printStackTrace();
            showMessage(e.getMessage());
        }
        return null;
    }

    @Override
    public Frame getfParent() {
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

    private void sendRequest(RequestObject request) throws IOException {
        try {
            Session.getInstance().getOutput().writeObject(request);
            Session.getInstance().getOutput().flush();
        } catch (Exception ex) {
            showMessage(ex.getMessage());
            logout();
        }

    }

    private ResponseObject recieveResponse() throws IOException {
        try {
            return (ResponseObject) Session.getInstance().getInput().readObject();
        } catch (Exception ex) {
            showMessage(ex.getMessage());
            logout();
            return null;
        }
    }

    public void logout() throws IOException {
        if (Session.getInstance().getKorisnik() != null) {
            SOLogout();
            controllerMain.logout();
        }
    }

    public void login(DCKorisnik gdo) throws Exception {
        SOLogin(gdo);
        controllerMain.login();
    }

    public void SOLogout() throws IOException {
        GeneralDObject korisnik = (GeneralDObject) proccessResponse(SOCall(IOperation.LOGOUT, Session.getInstance().getKorisnik()));
        Session.getInstance().setKorisnik(null);
        Session.getInstance().closeSocket();
    }

}
