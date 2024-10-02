package org.example.Moduuli7.Moduuli7_3.sql.datasource;

import jakarta.persistence.*;
import jakarta.persistence.spi.PersistenceProvider;

public class MariaDbJpaConnection {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManager getInstance() {
        // you need to add synchronization if you run in a multi-threaded environment

        if (em==null) {
            if (emf==null) {
                emf = Persistence.createEntityManagerFactory("CurrencyDb");
            }
            em = emf.createEntityManager();
        }
        return em;
    }
}