/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.search;

import javax.swing.JComboBox;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCTemaDiplomskogRada;

/**
 *
 * @author MARINA
 */
public class ComboBoxFilter {
    public static Object getFilter(JComboBox comboBox) {
        Object obj = comboBox.getSelectedItem();
        return obj;
    }


    public static boolean isEqual(JComboBox comboBox,Object value) {
        if(comboBox.getSelectedItem().toString().equalsIgnoreCase("svi")) return true;
        Object filter = getFilter(comboBox);
        return filter.equals(value);
        
    }
}
