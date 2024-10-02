package org.example.Moduuli7.Moduuli7_4.sql.datasource;

import jakarta.persistence.*;

public class MariaDbJpaConnection {

    private static EntityManagerFactory emCf = null;
    private static EntityManagerFactory emTf = null;
    private static EntityManager emC = null;
    private static EntityManager emT = null;


    public static EntityManager getInstanceC() {
        // you need to add synchronization if you run in a multi-threaded environment

        if (emC==null) {
            if (emCf==null) {
                emCf = Persistence.createEntityManagerFactory("currency_db");
            }
            emC = emCf.createEntityManager();
        }
        return emC;
    }

    public static EntityManager getInstanceT() {
        // you need to add synchronization if you run in a multi-threaded environment

        if (emT==null) {
            if (emTf==null) {
                emTf = Persistence.createEntityManagerFactory("TransactionDb");
            }
            emT = emTf.createEntityManager();
        }
        return emT;
    }
}