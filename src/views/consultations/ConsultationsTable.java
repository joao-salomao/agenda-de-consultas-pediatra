/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.consultations;

import controllers.ConsultationsController;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Consultation;
import views.components.Button;

/**
 *
 * @author João Salomão
 */
public class ConsultationsTable extends JInternalFrame {

    private JTable table;
    private JPanel buttonsPane;
    private JScrollPane scrollBar;
    private JPanel backgroundPane;
    private final DefaultTableModel tableModel;
    private ArrayList<Consultation> consultations;
    private ConsultationsController consultationsController;

    public ConsultationsTable(ArrayList<Consultation> consultationsList, ConsultationsController cController) {
        super();
        tableModel = new DefaultTableModel();
        consultations = consultationsList;
        consultationsController = cController;
        createTable();
        createFrame();
    }

    public void createFrame() {
        this.setName("Consultas");
        buttonsPane = new JPanel();
        scrollBar = new JScrollPane(table);
        backgroundPane = new JPanel();
        backgroundPane.setLayout(new BorderLayout());
        backgroundPane.add(BorderLayout.CENTER, scrollBar);
        buttonsPane.add(new Button("Editar Consulta", this, "editConsult"));
        buttonsPane.add(new Button("Deletar Consulta", this, "deleteConsult"));
        backgroundPane.add(BorderLayout.SOUTH, buttonsPane);

        getContentPane().add(backgroundPane);
        setVisible(true);
    }

    private void createTable() {
        table = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("DATA");
        tableModel.addColumn("PERÍODO");
        tableModel.addColumn("É REVISÃO");
        tableModel.addColumn("PACIENTE");
        tableModel.addColumn("AGENDA");

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
        consultations.forEach((Consultation c) -> {
            tableModel.addRow(new Object[]{c.getId(), c.getDate().toString(), c.getPeriod().toString(),
                c.isIsReview(), c.getPatient().getName(), c.getSchedule().getClinicName()});
        });
    }
}
