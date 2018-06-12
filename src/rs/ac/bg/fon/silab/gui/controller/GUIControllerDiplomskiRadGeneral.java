/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.gui.controller;

import rs.ac.bg.fon.silab.jpa.example1.domain.DCDiplomskiRad;

/**
 *
 * @author MARINA
 */
public interface GUIControllerDiplomskiRadGeneral {

    DCDiplomskiRad getDiplomskiRad();

    void odbrani();

    void odobri();

    void prijavi();

    void setDiplomskiRad(DCDiplomskiRad diplomskiRad);

    void view();
    
}
