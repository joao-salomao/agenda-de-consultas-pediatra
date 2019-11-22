/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author João Salomão
 */
public class Connection {
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("persistence-unit");
    
    public static EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }
}
