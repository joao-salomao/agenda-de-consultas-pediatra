/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.patient;

import models.Patient;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



/**
 *
 * @author João Salomão
 */
public class PatientsList extends JInternalFrame {

    private JPanel backgroundPane;
    private JPanel buttonsPane;
    private JTable table;
    private JScrollPane scrollBar;
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private ArrayList<Patient> patients;

    public PatientsList(ArrayList<Patient> patientsList) {
        patients = patientsList;
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
//        buttonsPane.add(new DeleteProductButton(this));;
//        buttonsPane.add(new EditProductButton(this));
//        buttonsPane.add(new NewProductButton(this));
        backgroundPane.add(BorderLayout.SOUTH, buttonsPane);

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        getContentPane().add(backgroundPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTable() {
        table = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("NOME");
        tableModel.addColumn("EMAIL");
        tableModel.addColumn("ENDEREÇO");
        tableModel.addColumn("PLANO DE SAÚDE");
        tableModel.addColumn("DATA DE NASCIMENTO");
        tableModel.addColumn("DATA DA PRIMEIRA CONSULTA");
        
        table.getColumnModel().getColumn(0)
                .setPreferredWidth(10);
        table.getColumnModel().getColumn(1)
                .setPreferredWidth(120);
        table.getColumnModel().getColumn(1)
                .setPreferredWidth(80);
        table.getColumnModel().getColumn(1)
                .setPreferredWidth(120);
        addItemsToTable();
    }

    public void addItemsToTable() {
        tableModel.setNumRows(0);
        patients.forEach((p) -> {
            tableModel.addRow(new Object[]{p.getId(), p.getName(), p.getEmail(),
                p.getAddress(), p.getHealthPlan().getName(), p.getBirthDate(), p.getFirstAppointmentDate()});
        });
    }
}
