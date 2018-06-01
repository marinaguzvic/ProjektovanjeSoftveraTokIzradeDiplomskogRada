/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.search;

import javax.swing.JCheckBox;

/**
 *
 * @author MARINA
 */
public class CheckboxFIlter {

    public static Object getFilter(JCheckBox checkBox) {
        return checkBox.isSelected();
    }


    public static boolean isEqual(JCheckBox [] checkBoxes,int value) {
        
        for (int i = 1; i <= checkBoxes.length; i++) {
            if((Boolean)getFilter(checkBoxes[i-1])){
                if(i == value)return true;
            }
        }
        return false;
    }
}
