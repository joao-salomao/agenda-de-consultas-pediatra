/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Connection;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import models.Patient;

/**
 *
 * @author João Salomão
 */
public class PatientsController {

    private EntityManager entityManager;

    public PatientsController() {
        entityManager = Connection.getEntityManager();
    }

    public boolean store(Patient p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO ALGO PERSISTIR PACIENTE NO BANCO DE DADOS: " + e.getMessage());
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<Patient> all() {
        try {
            ArrayList<Patient> patients = (ArrayList<Patient>) entityManager
                    .createQuery("FROM Patient as patients")
                    .getResultList();
            return patients;
        } catch (Exception e) {
            System.out.println("ERRO AO PEGAR TODOS OS PACIENTS DO BANCO: " + e.getMessage());
            return null;
        }
    }

    public boolean update(Patient p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(p);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO AO ATUALIZAR PACIENTE: "+e);
        }
        return false;
    }
}
