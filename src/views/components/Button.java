/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import java.awt.event.ActionEvent;
import views.patient.PatientsTable;
import views.consultation.ConsultationsTable;

/**
 *
 * @author João Salomão
 */
public class Button extends javax.swing.JButton {

    public Button(String title, PatientsTable patientsList, String operation) {
        super(title);
        switch (operation) {
            case "createPacient":
                addNewPatientListener(patientsList);
                break;
            case "editPacient":
                addEditPatientListener(patientsList);
                break;
            case "deletePacient":
                addDeletePacientListener(patientsList);
                break;
            case "createAppointment":
                addNewAppointmentListener(patientsList);
                break;
        }
    }

    public Button(String title, ConsultationsTable consultationTable, String operation) {
        super(title);
    }

    private void addNewPatientListener(PatientsTable patientsTable) {
        this.addActionListener((ActionEvent e) -> {
            new views.patient.Form(patientsTable, false).setVisible(true);
        });
    }

    private void addNewAppointmentListener(PatientsTable patientsTable) {
        this.addActionListener((ActionEvent e) -> {
            new views.consultation.Form(patientsTable, false).setVisible(true);
        });
    }

    private void addEditPatientListener(PatientsTable patientsTable) {
        this.addActionListener((ActionEvent e) -> {
            new views.patient.Form(patientsTable, true).setVisible(true);
        });
    }

    private void addDeletePacientListener(PatientsTable patientsTable) {
        this.addActionListener((ActionEvent e) -> {
            patientsTable.removeRow();
        });
    }
}
