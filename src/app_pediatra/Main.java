/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_pediatra;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Patient;
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
        Patient p = em.find(Patient.class, 1);
        ArrayList<Patient> list = new ArrayList<>();
        list.add(p);
        new MainFrame(list).setVisible(true);
        //System.exit(1);
//        Patient p = em.find(Patient.class,1);;
//        System.out.println(p.getName()+" "+p.getHealthPlan().getName());
//        em.getTransaction().begin();
//        em.persist(p);
//        em.getTransaction().commit();
    }

}
