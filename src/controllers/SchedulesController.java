/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Connection;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import models.Schedule;

/**
 *
 * @author João Salomão
 */
public class SchedulesController {
    
    private final EntityManager entityManager;
    
    public SchedulesController() {
        entityManager = Connection.getEntityManager();       
    }
    public ArrayList<Schedule> all() {
        try {
            ArrayList<Schedule> schedules = (ArrayList<Schedule>) entityManager
                    .createQuery("FROM Schedule as schedules")
                    .getResultList();
            return schedules;
        } catch (Exception e) {
            System.out.println("ERRO AO PEGAR TODOS AS AGENDAS DO BANCO: " + e.getMessage());
            return null;
        }
    }
    
    public boolean store(Schedule s) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(s);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO AO SALVAR AGENDA NO BANCO: "+e);
        }
        return false;
    }
    
}
