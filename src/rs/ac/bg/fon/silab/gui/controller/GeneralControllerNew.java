/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import rs.ac.bg.fon.silab.gui.form.GeneralGUINew;
import rs.ac.bg.fon.silab.gui.form.listener.create.CancelListener;
import rs.ac.bg.fon.silab.gui.form.listener.create.EditListener;
import rs.ac.bg.fon.silab.gui.form.listener.create.SaveListener;
import rs.ac.bg.fon.silab.gui.form.listener.create.UpdateListener;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public abstract class GeneralControllerNew extends GUIControllerDialog {

    @Override
    public void setListeners() {
        GeneralGUINew form = (GeneralGUINew) getGeneralGUI();
        form.getSave().addActionListener(new SaveListener(this));
        form.getEdit().addActionListener(new EditListener(this));
        form.getCancel().addActionListener(new CancelListener(this));
        form.getUpdate().addActionListener(new UpdateListener(this));

    }

    public abstract GeneralDObject getGdo();

}
