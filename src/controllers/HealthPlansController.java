/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Connection;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import models.HealthPlan;

/**
 *
 * @author João Salomão
 */
public class HealthPlansController {

    private EntityManager entityManager;

    public HealthPlansController() {
        entityManager = Connection.getEntityManager();
    }
    
    public ArrayList<HealthPlan> all() {
                try {
            ArrayList<HealthPlan> patients = (ArrayList<HealthPlan>) entityManager
                    .createQuery("FROM HealthPlan as patients")
                    .getResultList();
            return patients;
        } catch (Exception e) {
            System.out.println("ERRO AO PEGAR TODOS OS PLANOS DE SAÚDE DO BANCO: " + e.getMessage());
            return null;
        }
    }

}
