/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.patient;

import controllers.PatientsController;
import models.Patient;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import views.components.Button;

/**
 *
 * @author João Salomão
 */
public class PatientsTable extends JInternalFrame {

    private JTable table;
    private JPanel buttonsPane;
    private JScrollPane scrollBar;
    private JPanel backgroundPane;
    private ArrayList<Patient> patients;
    private final PatientsController patientsController;
    private final DefaultTableModel tableModel = new DefaultTableModel();

    public PatientsTable(ArrayList<Patient> patientsList, PatientsController pController) {
        patients = patientsList;
        patientsController = pController;
        createTable();
        createFrame();

    }

    public void createFrame() {
        this.setName("Pacientes");
        buttonsPane = new JPanel();
        scrollBar = new JScrollPane(table);
        backgroundPane = new JPanel();
        backgroundPane.setLayout(new BorderLayout());
        backgroundPane.add(BorderLayout.CENTER, scrollBar);
        buttonsPane.add(new Button("Cadastrar Novo Paciente", this, "createPacient"));
        buttonsPane.add(new Button("Editar Paciente", this, "editPacient"));
        buttonsPane.add(new Button("Deletar Pacientes", this, "deletePacient"));
        backgroundPane.add(BorderLayout.SOUTH, buttonsPane);

        getContentPane().add(backgroundPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTable() {
        table = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("NOME");
        tableModel.addColumn("ENDEREÇO");
        tableModel.addColumn("EMAIL");
        tableModel.addColumn("PLANO DE SAÚDE");
        tableModel.addColumn("DATA DE NASCIMENTO");
        tableModel.addColumn("DATA DA PRIMEIRA CONSULTA");

//        table.getColumnModel().getColumn(0);
//                .setPreferredWidth(10);
//        table.getColumnModel().getColumn(1)
//                .setPreferredWidth(120);
//        table.getColumnModel().getColumn(1)
//                .setPreferredWidth(80);
//        table.getColumnModel().getColumn(1)
//                .setPreferredWidth(120);
        addItemsToTable();
    }

    public void addItemsToTable() {
        tableModel.setNumRows(0);
        patients.forEach((p) -> {
            tableModel.addRow(new Object[]{p.getId(), p.getName(), p.getAddress(),
                p.getEmail(), "IMPLEMENTAR", p.getBirthDate(), p.getFirstAppointmentDateString()});
        });
    }

    public Patient getSelectedPatient() {
        int index = table.getSelectedRow();
        return patients.get(index);
    }

    public boolean addRow(Patient p) {
        boolean result = patientsController.store(p);
        if (result) {
            patients.add(p);
            tableModel.addRow(new Object[]{p.getId(), p.getName(), p.getAddress(), p.getEmail(),
                "IMPLEMENTAR", p.getBirthDate(), p.getFirstAppointmentDateString()});
        }
        return result;
    }

    public boolean updateRow(Patient p) {
        boolean result = patientsController.update(p);
        if (result) {
            int index = patients.indexOf(p);
            tableModel.setValueAt(p.getName(),index, 1);
            tableModel.setValueAt(p.getAddress(),index, 2);
            tableModel.setValueAt(p.getEmail(),index, 3);
            tableModel.setValueAt("IMPLEMENTAR",index, 4);
            tableModel.setValueAt(p.getBirthDate(),index, 5);
            tableModel.setValueAt(p.getFirstAppointmentDateString(),index, 6);   
        }
        return result;
    }

}
