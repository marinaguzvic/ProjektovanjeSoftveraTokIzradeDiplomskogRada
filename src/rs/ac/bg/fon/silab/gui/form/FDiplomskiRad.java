/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.silab.gui.form.listener.main.TemaSearchListener;
import rs.ac.bg.fon.silab.session.Session;

/**
 *
 * @author MARINA
 */
public class FDiplomskiRad extends javax.swing.JFrame implements GeneralGUI,GeneralGUINew{

    /**
     * Creates new form FDiplomskiRad
     */
    public FDiplomskiRad() {
        initComponents();
    }
    
    public void prijavi(PPrijavaDiplomskogRada pPrijavaDiplomskogRada) {
        initPrijava(pPrijavaDiplomskogRada);       
        initButtons();        
        pack();
    }
    
    public void odobri(PPrijavaDiplomskogRada pPrijavaDiplomskogRada, POdobravanjeDiplomskogRada pOdobravanjeDiplomskogRada,PKomisija pKomisija) {
        initPrijava(pPrijavaDiplomskogRada);
        initOdobravanje(pOdobravanjeDiplomskogRada);
        initKomisija(pKomisija);
        initButtons();
        pack();        
    }
    
    public void odbrani(PPrijavaDiplomskogRada pPrijavaDiplomskogRada, POdobravanjeDiplomskogRada pOdobravanjeDiplomskogRada, POdbraniDiplomskiRad pOdbraniDiplomskiRad, PKomisija pKomisija) {
        initPrijava(pPrijavaDiplomskogRada);
        initOdobravanje(pOdobravanjeDiplomskogRada);
        initKomisija(pKomisija);
        initOdbrani(pOdbraniDiplomskiRad);
        initButtons();
        pack();
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelStudent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtBrojIndeksa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtIme = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtPrezime = new javax.swing.JTextField();
        jBtnSearchStudent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanelStudent.setBorder(javax.swing.BorderFactory.createTitledBorder("Student"));

        jLabel1.setText("Broj indeksa:");

        jTxtBrojIndeksa.setEditable(false);

        jLabel3.setText("Ime:");

        jTxtIme.setEditable(false);

        jLabel4.setText("Prezime:");

        jTxtPrezime.setEditable(false);

        jBtnSearchStudent.setText("Search for a student");

        javax.swing.GroupLayout jPanelStudentLayout = new javax.swing.GroupLayout(jPanelStudent);
        jPanelStudent.setLayout(jPanelStudentLayout);
        jPanelStudentLayout.setHorizontalGroup(
            jPanelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStudentLayout.createSequentialGroup()
                        .addGroup(jPanelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtIme)
                            .addComponent(jTxtPrezime)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStudentLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtBrojIndeksa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStudentLayout.createSequentialGroup()
                        .addGap(0, 605, Short.MAX_VALUE)
                        .addComponent(jBtnSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelStudentLayout.setVerticalGroup(
            jPanelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtBrojIndeksa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSearchStudent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelStudent);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSearchStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelStudent;
    private javax.swing.JTextField jTxtBrojIndeksa;
    private javax.swing.JTextField jTxtIme;
    private javax.swing.JTextField jTxtPrezime;
    // End of variables declaration//GEN-END:variables
    private PPrijavaDiplomskogRada pPrijavaDiplomskogRada;
    private POdobravanjeDiplomskogRada pOdobravanjeDiplomskogRada;
    private POdbraniDiplomskiRad pOdbraniDiplomskiRad;
    private PButtonsNew jPanelButtons;
    private PKomisija pKomisija;


    @Override
    public void close() {
        dispose();
    }

    @Override
    public void setMessage(String signal) {
        JOptionPane.showMessageDialog(rootPane, signal);
    }


    public PPrijavaDiplomskogRada getpPrijavaDiplomskogRada() {
        return pPrijavaDiplomskogRada;
    }

    public POdobravanjeDiplomskogRada getpOdobravanjeDiplomskogRada() {
        return pOdobravanjeDiplomskogRada;
    }

    public POdbraniDiplomskiRad getpOdbraniDiplomskiRad() {
        return pOdbraniDiplomskiRad;
    }

    public javax.swing.JButton getjBtnSaveAccept() {
        return jPanelButtons.getjBtnSave();
    }

    public javax.swing.JButton getjBtnCancel() {
        return jPanelButtons.getjBtnCancel();
    }

    public javax.swing.JTextField getjTxtBrojIndeksa() {
        return jTxtBrojIndeksa;
    }

    public void setjTxtBrojIndeksa(javax.swing.JTextField jTxtBrojIndeksa) {
        this.jTxtBrojIndeksa = jTxtBrojIndeksa;
    }

    public javax.swing.JTextField getjTxtIme() {
        return jTxtIme;
    }

    public void setjTxtIme(javax.swing.JTextField jTxtIme) {
        this.jTxtIme = jTxtIme;
    }

    public javax.swing.JTextField getjTxtPrezime() {
        return jTxtPrezime;
    }

    public void setjTxtPrezime(javax.swing.JTextField jTxtPrezime) {
        this.jTxtPrezime = jTxtPrezime;
    }

    public javax.swing.JButton getjBtnSearchStudent() {
        return jBtnSearchStudent;
    }
        private void initButtons() {
        jPanelButtons = new PButtonsNew();
        jPanelButtons.setVisible(true);
        this.add(jPanelButtons,BoxLayout.Y_AXIS);
    }

    public void initOdbrani(POdbraniDiplomskiRad pOdbraniDiplomskiRad1) {
        this.pOdbraniDiplomskiRad = pOdbraniDiplomskiRad1;
        this.pOdbraniDiplomskiRad.setVisible(true);
        this.add(this.pOdbraniDiplomskiRad,BoxLayout.Y_AXIS);
    }

    public void initOdobravanje(POdobravanjeDiplomskogRada pOdobravanjeDiplomskogRada1) {
        this.pOdobravanjeDiplomskogRada = pOdobravanjeDiplomskogRada1;
        this.pOdobravanjeDiplomskogRada.setVisible(true);
        this.add(this.pOdobravanjeDiplomskogRada,BoxLayout.Y_AXIS);
    }

    public void initPrijava(PPrijavaDiplomskogRada pPrijavaDiplomskogRada1) {
        this.pPrijavaDiplomskogRada = pPrijavaDiplomskogRada1;
        
        this.pPrijavaDiplomskogRada.setVisible(true);
        this.add(this.pPrijavaDiplomskogRada,BoxLayout.Y_AXIS);
    }

    public void initKomisija(PKomisija pKomisija) {
        this.pKomisija = pKomisija;
        this.pKomisija.setVisible(true);
        this.add(this.pKomisija,BoxLayout.Y_AXIS);
    }

    public PKomisija getpKomisija() {
        return pKomisija;
    }

    public void greyAllFields() {
        
        if(pPrijavaDiplomskogRada != null){
            pPrijavaDiplomskogRada.getjBtnSearch().setEnabled(false);
        }
        if (pOdobravanjeDiplomskogRada != null){
            pOdobravanjeDiplomskogRada.getjBtnEnterKomisija().setEnabled(false);
        }
        if(pKomisija != null){
            pKomisija.getјTblKomisija().setEnabled(false);
        }
        if(pOdbraniDiplomskiRad != null){
            pOdbraniDiplomskiRad.getjDatumOdbrane().setEditable(false);
            pOdbraniDiplomskiRad.getjSpinnerOcena().setEnabled(false);
        }
        if(jPanelButtons != null){
            jPanelButtons.getjBtnSave().setEnabled(false);
        }
                
    }

    @Override
    public JButton getSave() {
        return jPanelButtons.getjBtnSave();
    }

    @Override
    public JButton getUpdate() {
        return jPanelButtons.getjBtnUpdate();
    }

    @Override
    public JButton getEdit() {
        return jPanelButtons.getJbtnEdit();
    }

    @Override
    public JButton getCancel() {
        return jPanelButtons.getjBtnCancel();
    }
    

}
