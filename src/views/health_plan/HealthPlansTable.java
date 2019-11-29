/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.health_plan;

import controllers.HealthPlansController;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.HealthPlan;
import views.components.Button;

/**
 *
 * @author João Salomão
 */
public class HealthPlansTable extends JInternalFrame {

    private JTable table;
    private JPanel buttonsPane;
    private JScrollPane scrollBar;
    private JPanel backgroundPane;
    private ArrayList<HealthPlan> healthPlans;
    private HealthPlansController healthPlansController;
    private final DefaultTableModel tableModel;
    
    public HealthPlansTable(ArrayList<HealthPlan> plans,HealthPlansController controller) {
        healthPlans = plans;
        healthPlansController = controller;
        tableModel = new DefaultTableModel();
        
        createTable();
        createFrame();
    }

    public void createFrame() {
        this.setName("Planos de Saúde");
        buttonsPane = new JPanel();
        scrollBar = new JScrollPane(table);
        backgroundPane = new JPanel();
        backgroundPane.setLayout(new BorderLayout());
        backgroundPane.add(BorderLayout.CENTER, scrollBar);
//        buttonsPane.add(new Button("Editar Consulta", this, "editConsult"));
//        buttonsPane.add(new Button("Deletar Consulta", this, "deleteConsult"));
        backgroundPane.add(BorderLayout.SOUTH, buttonsPane);

        getContentPane().add(backgroundPane);
        setVisible(true);
    }

    private void createTable() {
        table = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("NAME");
        tableModel.addColumn("QUANTIDADE DE CONSULTAS");

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
        healthPlans.forEach((HealthPlan h) -> {
            tableModel.addRow(new Object[]{h.getId(), h.getName(), h.getAppointmentLimit()});
        });
    }
}
