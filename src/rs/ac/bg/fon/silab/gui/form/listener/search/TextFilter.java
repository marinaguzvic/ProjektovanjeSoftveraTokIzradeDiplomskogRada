/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.search;

import javax.swing.JTextField;

/**
 *
 * @author MARINA
 */
public class TextFilter {
        


    public static Object getFilter(JTextField textField) {
        String nameFilter = textField.getText().trim();
        return nameFilter;
    }


    public static boolean isEqual(JTextField textField,String value) {
        String filter = (String)getFilter(textField);
//        if(filter == null || filter.isEmpty())return true;
        return value.toLowerCase().contains(filter.toLowerCase());
        
    }
}
