/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form;

import javax.swing.JButton;
import javax.swing.JCheckBox;

/**
 *
 * @author MARINA
 */
public interface GeneralGUISearch {
    public JCheckBox getBasicSearchCheckbox();
    public JCheckBox getAdvancedSearchCheckbox();
    public void addBasicSearchPanel();
    public void addAdvancedSearchPanel();

    public void removeBasicSearchPanel();
    public void removeAdvancedSearchPanel();

    public JButton getView();

    public JButton getSelect();

}
