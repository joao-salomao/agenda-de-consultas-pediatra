/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_pediatra;

import controllers.SchedulesController;
import java.util.ArrayList;
import models.Schedule;
import utils.Utils;
import views.MainFrame;

/**
 *
 * @author João Salomão
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            insertDefaultValues();
            setLookAndFeel();
            new MainFrame().setVisible(true);
        } catch (Exception e) {
            System.out.println("ERRO AO INICIALIZAR O PROGRAMA: " + e);
            System.exit(1);
        }

    }

    public static void insertDefaultValues() {
        SchedulesController sc = new SchedulesController();
        
        if (sc.all().isEmpty()) {
            Object[][] values = {
                {"Ilha", 30, 2, "13:30:00", "09:00:00", "12:30:00", "18:00:00"},
                {"Ilha", 30, 6, "13:30:00", "09:00:00", "12:30:00", "18:00:00"},
                {"Tijuca", 30, 3, "13:30:00", "10:00:00", "12:30:00", "18:00:00"},
                {"Tijuca", 30, 4, "13:30:00", "10:00:00", "12:30:00", "18:00:00"},
                {"Bonsucesso", 30, 5, "13:30:00", "10:00:00", "12:30:00", "18:00:00"},};
            
            String format = "HH:mm:ss";
            
            for (int i = 0; i < 5; i++) {
                Schedule s = new Schedule();
                
                s.setClinicName((String) values[i][0]);
                s.setConsultationPeriod((int) values[i][1]);
                s.setDayOfWeek((int) values[i][2]);
                s.setInitialLunchTime(Utils.parseStringToDate((String) values[i][5], format));
                s.setFinalLunchTime(Utils.parseStringToDate((String) values[i][3], format));
                s.setFirstAppointmentTime(Utils.parseStringToDate((String) values[i][4], format));
                s.setLastAppointmentTime(Utils.parseStringToDate((String) values[i][6], format));
                
                sc.store(s);
            }
        }
    }

    public static void setLookAndFeel() {
        try {
            javax.swing.UIManager.put("Label.font", new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException e) {
            System.out.println("Erro ao setar lookAndFell: " + e);
        }
    }

}
