/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import java.awt.event.ActionEvent;

/**
 *
 * @author João Salomão
 */
public class Button extends javax.swing.JButton {

    public Button(String title) {
        super(title);

    }

    private void addNewPatientListener() {
        this.addActionListener((ActionEvent e) -> {

        });
    }

    private void addEditPatientListener() {
        this.addActionListener((ActionEvent e) -> {

        });
    }

    private void addNewConsultationAListener() {
        this.addActionListener((ActionEvent e) -> {

        });
    }
}
