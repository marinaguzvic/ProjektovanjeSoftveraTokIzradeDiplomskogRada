/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.form;

import java.awt.Frame;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author MARINA
 */
public class FStudentNew extends javax.swing.JDialog implements GeneralGUI,GeneralGUINew{

    /**
     * Creates new form FStudentNew
     * @param parent
     * @param modal
     */
    public FStudentNew(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setButtons();
        setDatumRodjenjaField();
        pack();
    }

    private void setButtons() {
        jPanelButtons = new PButtonsNew();
        jPanelButtons.setVisible(true);
        this.add(jPanelButtons,BoxLayout.Y_AXIS);
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtBrojIndeksa3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtBrojIndeksa = new javax.swing.JTextField();
        jTxtJMBG = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtIme = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtPrezime = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSpinnerGodinaStudija = new javax.swing.JSpinner();
        jCheckBoxBudzet = new javax.swing.JCheckBox();
        jCheckBoxPrviPutUpisao = new javax.swing.JCheckBox();
        jBtnGenerisiBrojIndeksa = new javax.swing.JButton();
        jDateRodjenja = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("Broj indeksa:");

        jTxtBrojIndeksa.setEditable(false);

        jLabel2.setText("JMBG:");

        jLabel3.setText("Ime:");

        jLabel4.setText("Prezime:");

        jLabel5.setText("Datum rodjenja:");

        jLabel6.setText("Godina studija:");

        jCheckBoxBudzet.setText("Budzet");

        jCheckBoxPrviPutUpisao.setText("Prvi put upisao");

        jBtnGenerisiBrojIndeksa.setText("Generisi broj indeksa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jTxtIme))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtJMBG))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTxtPrezime)
                                            .addComponent(jSpinnerGodinaStudija)
                                            .addComponent(jDateRodjenja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtBrojIndeksa, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnGenerisiBrojIndeksa, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBoxBudzet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxPrviPutUpisao)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtBrojIndeksa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnGenerisiBrojIndeksa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jDateRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jSpinnerGodinaStudija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxBudzet)
                    .addComponent(jCheckBoxPrviPutUpisao))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnGenerisiBrojIndeksa;
    private javax.swing.JCheckBox jCheckBoxBudzet;
    private javax.swing.JCheckBox jCheckBoxPrviPutUpisao;
    private org.jdesktop.swingx.JXDatePicker jDateRodjenja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinnerGodinaStudija;
    private javax.swing.JTextField jTxtBrojIndeksa;
    private javax.swing.JTextField jTxtBrojIndeksa3;
    private javax.swing.JTextField jTxtIme;
    private javax.swing.JTextField jTxtJMBG;
    private javax.swing.JTextField jTxtPrezime;
    // End of variables declaration//GEN-END:variables
    private PButtonsNew jPanelButtons;

    public String getBrojIndeksa() {
        return jTxtBrojIndeksa.getText().trim();
    }

    public String getJMBG() {
        return jTxtJMBG.getText().trim();
    }

    public String getIme() {
        return jTxtIme.getText().trim();
    }

    public String getPrezime() {
        return jTxtPrezime.getText().trim();
    }

    public boolean getBudzet() {
        return jCheckBoxBudzet.isSelected();
    }

    public int getGodinaStudija() {
        return (Integer)jSpinnerGodinaStudija.getValue();
    }

    public LocalDate getDatumRodjenja() {
        return jDateRodjenja.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public boolean getPrviPutUpisao() {
        return jCheckBoxPrviPutUpisao.isSelected();              
    }



    public void setBrojIndeksa(String brojIndeksa) {
        jTxtBrojIndeksa.setText(brojIndeksa);
    }

    public void setJMBG(String jmbg) {
        jTxtJMBG.setText(jmbg);
    }

    public void setIme(String ime) {
        jTxtIme.setText(ime);
    }

    public void setPrezime(String prezime) {
        jTxtPrezime.setText(prezime);
    }

    public void setBudzet(boolean budzet) {
        jCheckBoxBudzet.setSelected(budzet);
    }

    public void setGodinaStudija(int godinaStudija) {
        jSpinnerGodinaStudija.setValue(godinaStudija);
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        jDateRodjenja.setDate(new Date(datumRodjenja.toEpochDay()));
    }

    public void setPrviPutUpisao(boolean prviPutUpisao) {
        jCheckBoxPrviPutUpisao.setSelected(prviPutUpisao);
    }

    
    @Override
    public JButton getSave(){
        return jPanelButtons.getjBtnSave();
    }
    
    @Override
    public JButton getUpdate(){
        return jPanelButtons.getjBtnUpdate();
    }
    
    @Override
    public JButton getEdit(){
        return jPanelButtons.getJbtnEdit();
    }
    
    @Override
    public JButton getCancel(){
        return jPanelButtons.getjBtnCancel();
    }
    
    public JButton getGenerisiBrojIndeksa(){
        return jBtnGenerisiBrojIndeksa;
    }

    @Override
    public void setMessage(String signal) {
        JOptionPane.showMessageDialog(rootPane, signal);
    }

    @Override
    public void close() {
        dispose();
    }

    public javax.swing.JCheckBox getjCheckBoxBudzet() {
        return jCheckBoxBudzet;
    }

    public javax.swing.JCheckBox getjCheckBoxPrviPutUpisao() {
        return jCheckBoxPrviPutUpisao;
    }

    public org.jdesktop.swingx.JXDatePicker getjDateRodjenja() {
        return jDateRodjenja;
    }

    public javax.swing.JTextField getjTxtBrojIndeksa() {
        return jTxtBrojIndeksa;
    }

    public javax.swing.JTextField getjTxtIme() {
        return jTxtIme;
    }

    public javax.swing.JTextField getjTxtJMBG() {
        return jTxtJMBG;
    }

    public JTextField getjTxtPrezime() {
        return jTxtPrezime;
    }

    public PButtonsNew getjPanelButtons() {
        return jPanelButtons;
    }

    public javax.swing.JSpinner getjSpinnerGodinaStudija() {
        return jSpinnerGodinaStudija;
    }

    private void setDatumRodjenjaField() {
        int year = Calendar.getInstance().get(Calendar.YEAR) - 1919;
        jDateRodjenja.setDate(new Date(year, 0, 1));
    }


}