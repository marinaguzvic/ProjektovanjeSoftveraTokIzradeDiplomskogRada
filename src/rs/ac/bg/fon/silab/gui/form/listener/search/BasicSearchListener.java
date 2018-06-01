/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.fon.silab.gui.controller.GeneralControllerSearch;

/**
 *
 * @author MARINA
 */
public class BasicSearchListener implements ActionListener{
    GeneralControllerSearch gcn;
    
    public BasicSearchListener(GeneralControllerSearch gcn) {
        this.gcn = gcn;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Basic listener");
        if(gcn.getBasicSearchChecked())gcn.addBasicSearchPanel();
        else gcn.removeBasicSearchPanel();
    }
    
}
