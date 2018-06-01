/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.form.components.table.model;

import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCClanKomisije;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCKomisija;
import rs.ac.bg.fon.silab.jpa.example1.domain.DCNastavnik;
import rs.ac.bg.fon.silab.jpa.example1.domain.EUlogaClanaKomisije;

/**
 *
 * @author MARINA
 */
public class KomisijaTableModel extends AbstractTableModel {

    DCKomisija komisija;

    public KomisijaTableModel(DCKomisija komisija) {
        this.komisija = komisija;
    }

    @Override
    public int getRowCount() {
        return komisija.getClanovi().size();
    }

    @Override
    public int getColumnCount() {
        return 3;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DCClanKomisije clan = komisija.getClanovi().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return clan.getClanKomisijeRB();
            case 1:
                return clan.getUlogaClanaKomisije();
            case 2:
                return clan.getNastavnik();
            default:
                return "N/A";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        DCClanKomisije clan = komisija.getClanovi().get(rowIndex);
        switch (columnIndex) {
            case 1:
                if (aValue.equals(EUlogaClanaKomisije.MENTOR)) {
                    clan.setUlogaClanaKomisije(EUlogaClanaKomisije.CLAN);
                    checkMentor();
                }
                clan.setUlogaClanaKomisije((EUlogaClanaKomisije) aValue);
                break;
            case 2:                
                clan.setNastavnik((DCNastavnik) aValue);
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1 || columnIndex == 2;
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = new String[]{"RB", "Uloga", "Nastvanik"};
        return columnNames[column];
    }

    public DCKomisija getKomisija() {
        return komisija;
    }

    public void setKomisija(DCKomisija komisija) {
        this.komisija = komisija;
    }

    public void add() throws Exception {
        if (!komisija.getClanovi().isEmpty()) {
            komisija.checkConstraints();
        }
        komisija.getClanovi().add(new DCClanKomisije(komisija, komisija.getClanovi().size() + 1));
        fireTableDataChanged();
    }

    public void remove(int row) {
        komisija.getClanovi().remove(row);
        updateRbs();
        fireTableDataChanged();
    }

    private void updateRbs() {
        int no = 1;
        for (DCClanKomisije dCClanKomisije : komisija.getClanovi()) {
            dCClanKomisije.setClanKomisijeRB(no);
            no++;
        }
    }

    private void checkMentor() {
        for (DCClanKomisije dCClanKomisije : komisija.getClanovi()) {
            if (dCClanKomisije.getUlogaClanaKomisije().equals(EUlogaClanaKomisije.MENTOR)) {
                dCClanKomisije.setUlogaClanaKomisije(EUlogaClanaKomisije.CLAN);
            }
        }
    }



}
