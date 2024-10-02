package org.example.Moduuli7.Moduuli7_4.sql.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.Moduuli7.Moduuli7_4.sql.datasource.MariaDbJpaConnection;
import org.example.Moduuli7.Moduuli7_4.sql.entity.Currency2;

import java.util.ArrayList;

public class CurrencyDao {

    public Currency2 getCurrency(String code) {
        EntityManager em = MariaDbJpaConnection.getInstanceC();
        try {
            Query query = em.createQuery("SELECT c FROM Currency2 c WHERE c.code = :code", Currency2.class);
            query.setParameter("code", code);
            Currency2 c = (Currency2) query.getSingleResult();
            System.out.println(c.getName() + " " + c.getCode() + " " + c.getRate());
            return c;
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return null; // Return null or handle it as needed
        } finally {
            if (em != null && em.isOpen()) {
                em.close(); // Ensure the EntityManager is closed
            }
        }
    }

    public ArrayList<String> getCurrencyCodes() {
        EntityManager em = MariaDbJpaConnection.getInstanceC();
        try {
            Query query = em.createQuery("SELECT c.code FROM Currency2 c");
            return (ArrayList<String>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ArrayList<>(); // Return an empty list or handle as needed
        } finally {
            if (em != null && em.isOpen()) {
                em.close(); // Ensure the EntityManager is closed
            }
        }
    }

    public void addCurrency(Currency2 c) {
        EntityManager em = MariaDbJpaConnection.getInstanceC();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Roll back if transaction is active
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close(); // Ensure the EntityManager is closed
            }
        }
    }

    public boolean connectionToString() {
        EntityManager em = MariaDbJpaConnection.getInstanceC();
        try {
            Query query = em.createQuery("SELECT 1");
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close(); // Ensure the EntityManager is closed
            }
        }
    }

    public void addCurrency(String text, String text1, double v) {
        persist(new Currency2(text, text1, v));
    }

    private void persist(Currency2 currency) {
        EntityManager em = MariaDbJpaConnection.getInstanceC();
        try {
            em.getTransaction().begin();
            em.persist(currency);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Roll back if transaction is active
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close(); // Ensure the EntityManager is closed
            }
        }
    }
}
