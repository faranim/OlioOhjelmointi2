package org.example.Moduuli7.Moduuli7_4.sql.dao;


import jakarta.persistence.EntityManager;
import org.example.Moduuli7.Moduuli7_4.sql.datasource.MariaDbJpaConnection;
import org.example.Moduuli7.Moduuli7_4.sql.entity.Currency2;
import org.example.Moduuli7.Moduuli7_4.sql.entity.Transaction;

public class TransactionDao {

    public void addTransaction(Currency2 currency_from, Currency2 currency_to, double amount_from, double amount_to){
        Transaction t = new Transaction(currency_from, currency_to, amount_from, amount_to);
        persist(t);
    }

    private void persist(Transaction t) {
        EntityManager em = MariaDbJpaConnection.getInstanceC();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

    }
}