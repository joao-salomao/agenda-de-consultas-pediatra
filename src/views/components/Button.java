/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
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
        }
    }

    public Button(String title, PatientsTable patientsTable, ConsultationsTable consultationsTable, String operation) {
        super(title);
        switch (operation) {
            case "createAppointment":
                addNewAppointmentListener(patientsTable, consultationsTable);
                break;
        }
    }

    public Button(String title, ConsultationsTable consultationsTable, String operation) {
        super(title);
        switch (operation) {
            case "editConsult":
                addEditConsultationListener(consultationsTable);
                break;
            case "deleteConsult":
                addDeleteConsultationListener(consultationsTable);
                break;

        }
    }

    private void addDeleteConsultationListener(ConsultationsTable consultationsTable) {
        this.addActionListener((ActionEvent e) -> {
            boolean result = consultationsTable.removeRow();
            if (result) {
                JOptionPane.showMessageDialog(null, "A consulta foi deletada com sucesso");
            } else {
                JOptionPane.showConfirmDialog(null, "Algo deu errrado. Tente novamnete !");
            }
        });
    }

    private void addEditConsultationListener(ConsultationsTable consultationsTable) {
        this.addActionListener((ActionEvent e) -> {
            new views.consultation.Form(null, consultationsTable, true).setVisible(true);
        });
    }

    private void addNewPatientListener(PatientsTable patientsTable) {
        this.addActionListener((ActionEvent e) -> {
            new views.patient.Form(patientsTable, false).setVisible(true);
        });
    }

    private void addNewAppointmentListener(PatientsTable patientsTable, ConsultationsTable consultationsTable) {
        this.addActionListener((ActionEvent e) -> {
            new views.consultation.Form(patientsTable, consultationsTable, false).setVisible(true);
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
