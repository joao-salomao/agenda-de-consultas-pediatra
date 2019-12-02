/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.consultation;

import controllers.ConsultationsController;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Consultation;
import models.Schedule;
import utils.Utils;
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
    private final ArrayList<Consultation> consultations;
    private final ArrayList<Schedule> schedules;
    private final ConsultationsController consultationsController;

    public ConsultationsTable(
            ArrayList<Consultation> consultationsList,
            ArrayList<Schedule> schedulesList,
            ConsultationsController cController
    ) {
        super();
        tableModel = new DefaultTableModel();

        consultations = consultationsList;
        schedules = schedulesList;

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
            tableModel.addRow(new Object[]{
                c.getId(),
                Utils.parseDateToString(c.getDate(), null),
                Utils.parseDateToString(c.getPeriod(), "HH:mm"),
                c.isIsReview(),
                c.getPatient().getName(),
                c.getSchedule().getClinicName()
            });
        });
    }

    public boolean addRow(Consultation c) {
        boolean result = consultationsController.store(c);
        if (result) {
            consultations.add(c);
            tableModel.addRow(new Object[]{
                c.getId(),
                Utils.parseDateToString(c.getDate(), null),
                Utils.parseDateToString(c.getPeriod(), "HH:mm"),
                c.isIsReview(),
                c.getPatient().getName(),
                c.getSchedule().getClinicName()
            });
        }
        return result;
    }

    public boolean updateRow(Consultation c) {
        boolean result = consultationsController.update(c);
        if (result) {
            int index = consultations.indexOf(c);
            tableModel.setValueAt(Utils.parseDateToString(c.getDate(), null), index, 1);
            tableModel.setValueAt(Utils.parseDateToString(c.getPeriod(), "HH:mm"), index, 2);
            tableModel.setValueAt(c.isIsReview(), index, 3);
            tableModel.setValueAt(c.getPatient().getName(), index, 4);
            tableModel.setValueAt(c.getSchedule().getClinicName(), index, 5);
        }
        return result;
    }

    public int canMarkConsultation(Date date, Date time, Date start, Date end) {
        int result;
        if (hasMoreThanTwoConsultations(date)) {
            result = 1;
        } else if (isLunchTime(time, start, end)) {
            result = 2;
        } else {
            result = 0;
        }
        return result;
    }

    private boolean isLunchTime(Date time, Date start, Date end) {
        return true;
//return time.after(start) && time.before(end);
    }

    private boolean hasMoreThanTwoConsultations(Date date) {
        int count = 0;

        for (Consultation c : consultations) {
            if (c.getDate().compareTo(date) == 0) {
                count++;
            }
        }
        return count > 2;
    }

    public boolean removeRow() {
        Consultation c = getSelectedConsultation();
        boolean result = consultationsController.delete(c);

        if (result) {
            tableModel.removeRow(consultations.indexOf(c));
            consultations.remove(c);
        }
        return result;
    }

    public ArrayList<Consultation> getConsultations() {
        return consultations;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public Consultation getSelectedConsultation() {
        Consultation c = null;
        try {
            int index = table.getSelectedRow();
            c = consultations.get(index);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Selecione uma consulta para poder edita-la");
            System.out.println(e);
        }
        return c;
    }
}
