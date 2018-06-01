/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.TableModel;
import rs.ac.bg.fon.silab.form.components.table.model.StudentTableModel;
import rs.ac.bg.fon.silab.gui.form.FStudentSearch;
import rs.ac.bg.fon.silab.gui.form.listener.search.CheckboxFIlter;
import rs.ac.bg.fon.silab.gui.form.listener.search.FilterListener;
import rs.ac.bg.fon.silab.gui.form.listener.search.RadioButtonFIlter;
import rs.ac.bg.fon.silab.gui.form.listener.search.TextFilter;
import rs.ac.bg.fon.silab.gui.form.FormState;
import rs.ac.bg.fon.silab.gui.form.GeneralGUI;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCStudent;
import rs.ac.bg.fon.silab.jpa.example1.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public class GUIControllerStudentSearch extends GeneralControllerSearch {

    FStudentSearch fStudentSearch;
    List<DCStudent> students = new ArrayList<>();
    List<DCStudent> filteredStudents;

    public GUIControllerStudentSearch(JFrame parent) throws Exception {
        try {
            this.parent = parent;
            createObject();
            fStudentSearch = new FStudentSearch(parent, true);
            setListeners();
            convertDomainIntoGraphicalObject();
            ((FStudentSearch) fStudentSearch).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Couldn't opet form, couldn't load data!");
        }

    }

    public void populateTable() {

        try {
            TableModel tm = fStudentSearch.getTable().getModel();
            if (tm instanceof StudentTableModel) {
                ((StudentTableModel) tm).setData(filteredStudents);
            } else {
                tm = new StudentTableModel(filteredStudents);
                fStudentSearch.getTable().setModel(tm);
                
            }
//            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void convertGraphicalIntoDomainObject() {
        
    }

    @Override
    public void convertDomainIntoGraphicalObject() {
        populateTable();
    }

    @Override
    public void createObject() {

        try {
            List<GeneralDObject> list = new ArrayList<>();
            SOFindAll(new DCStudent(), list);
            convertListToStudents(list);
            filteredStudents = new ArrayList<>(students);

        } catch (Exception ex) {
            Logger.getLogger(GUIControllerStudentSearch.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void emptyGraphicalObject() {
        
    }

    @Override
    public void setListeners() {
        super.setListeners();
        FStudentSearch form = (FStudentSearch) fStudentSearch;
        form.getBasicSearchPanel().getjTxtIme().getDocument().addDocumentListener(new FilterListener(this));
        form.getBasicSearchPanel().getjTxtPrezime().getDocument().addDocumentListener(new FilterListener(this));
        form.getjTxtBrojIndeksa().getDocument().addDocumentListener(new FilterListener(this));
        form.getAdvancedSearchPanel().getjTxtJMBG().getDocument().addDocumentListener(new FilterListener(this));

        form.getAdvancedSearchPanel().getjCheckBox1().addChangeListener(new FilterListener(this));
        form.getAdvancedSearchPanel().getjCheckBox2().addChangeListener(new FilterListener(this));
        form.getAdvancedSearchPanel().getjCheckBox3().addChangeListener(new FilterListener(this));
        form.getAdvancedSearchPanel().getjCheckBox4().addChangeListener(new FilterListener(this));

        form.getAdvancedSearchPanel().getjRadioButtonBudzetDa().addActionListener(new FilterListener(this));
        form.getAdvancedSearchPanel().getjRadioButtonBudzetNe().addActionListener(new FilterListener(this));
        form.getAdvancedSearchPanel().getjRadioButtonBudzetSvi().addActionListener(new FilterListener(this));

        form.getAdvancedSearchPanel().getjRadioButtonPrviPutUpisaoDa().addActionListener(new FilterListener(this));
        form.getAdvancedSearchPanel().getjRadioButtonPrviPutUpisaoNe().addActionListener(new FilterListener(this));
        form.getAdvancedSearchPanel().getjRadioButtonPrviPutUpisaoSvi().addActionListener(new FilterListener(this));
    }

    

    @Override
    public void filter() {
        FStudentSearch form = (FStudentSearch) fStudentSearch;
        filteredStudents = new ArrayList<>();
        for (DCStudent student : students) {
            if (TextFilter.isEqual(form.getBasicSearchPanel().getjTxtIme(), student.getIme())
                    && TextFilter.isEqual(form.getBasicSearchPanel().getjTxtPrezime(), student.getPrezime())
                    && TextFilter.isEqual(form.getjTxtBrojIndeksa(), student.getBrojIndeksa())
                    && TextFilter.isEqual(form.getAdvancedSearchPanel().getjTxtJMBG(), student.getJmbg())
                    && CheckboxFIlter.isEqual(form.getAdvancedSearchPanel().getCheckBoxesGodinaStudija(), student.getGodinaStudija())
                    && RadioButtonFIlter.isEqual(form.getAdvancedSearchPanel().getSelectedBudzet(), student.isBudzet())
                    && RadioButtonFIlter.isEqual(form.getAdvancedSearchPanel().getPrviPutUpisao(), student.isPrviPutUpisao())) {
                filteredStudents.add(student);
            }
        }

    }

    @Override
    public DCStudent getSelectedObject(){
            StudentTableModel stm = (StudentTableModel) fStudentSearch.getTable().getModel();            
            return stm.getStudents().get(fStudentSearch.getTable().getSelectedRow());
    }
    
        @Override
    public void prepareFormFor(FormState formState) {
    }

    private void convertListToStudents(List<GeneralDObject> list) {
        students = new ArrayList<>();
        list.forEach((generalDObject) -> {
            students.add((DCStudent)generalDObject);
        });
    }

    @Override
    public GeneralGUI getGeneralGUI() {
        return fStudentSearch;
    }

    @Override
    public void showMessage(String signal) {
        fStudentSearch.setMessage(signal);
    }

    @Override
    public void closeForm() {
        fStudentSearch.close();                
    }

    void refreshTable() {
        emptyGraphicalObject();
        createObject();
        convertDomainIntoGraphicalObject();
    }


    
}
