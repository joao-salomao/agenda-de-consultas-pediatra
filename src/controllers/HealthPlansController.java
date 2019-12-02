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

    private final EntityManager entityManager;

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

    public boolean remove(HealthPlan h) {
        try {
            entityManager.getTransaction().begin();
            
            entityManager.createQuery(
                "UPDATE Patient SET health_plan_id = null "
                + "WHERE health_plan_id = " + h.getId()
            ).executeUpdate();
            
            entityManager.remove(h);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("ERRO AO DELETAR PLANO DE SAÚDE: " + e);
        }
        return false;
    }

    public boolean store(HealthPlan h) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(h);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("ERRO AO CADASTRAR PLANO DE SAÚDE: " + e);
        }
        return false;
    }

    public boolean update(HealthPlan h) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(h);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("ERRO AO EDITAR PLANO DE SAÚDE: " + e);
        }
        return false;
    }
}
