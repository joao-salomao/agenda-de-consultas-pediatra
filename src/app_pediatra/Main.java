/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_pediatra;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Consultation;
import models.Patient;
import models.Schedule;
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");;
        EntityManager em = emf.createEntityManager();
        setLookAndFeel();
        new MainFrame().setVisible(true);
        //System.exit(1);
        
//        Patient p = em.find(Patient.class,1);
//        Schedule s = em.find (Schedule.class, 1);
//        
//        Consultation c = new Consultation();
//        
//        c.setDate(new Date());
//        c.setMaxDate(new Date());
//        c.setPatient(p);
//        c.setSchedule(s);
//        c.setIsReview(true);
//        c.setPeriod(new Date());
//        
//        em.getTransaction().begin();
//        em.persist(c);
//        em.getTransaction().commit();
//        
//        System.out.println(p.getName()+" "+p.getHealthPlan().getName());
//        em.getTransaction().begin();
//        em.persist(p);
//        em.getTransaction().commit();
    }

    public static void setLookAndFeel() {
        try {
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
