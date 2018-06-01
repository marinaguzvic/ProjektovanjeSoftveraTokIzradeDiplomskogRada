/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form.listener.search;

import javax.swing.JRadioButton;

/**
 *
 * @author MARINA
 */
public class RadioButtonFIlter {

    public static Object getFilter(JRadioButton button) {


        String text = button.getText();
        if (text.equalsIgnoreCase("Da")) {
            return true;
        } else if (text.equalsIgnoreCase("Ne")) {
            return false;
        } else {
            return null;
        }

    }


    public static boolean isEqual(JRadioButton button,boolean value) {
        Boolean buttonValue = (Boolean) getFilter(button);
        if (buttonValue == null) {
            return true;
        }else if(buttonValue == value){
            return true;
        }else{
            return false;
        }

    }
}
