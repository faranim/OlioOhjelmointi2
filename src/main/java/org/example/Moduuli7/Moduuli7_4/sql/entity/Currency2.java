package org.example.Moduuli7.Moduuli7_4.sql.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
@Table(name = "currency")
public class Currency2 {
    @Column(name = "c_name")
    private String name;
    @Column(name = "abbreviation")
    private String code;
    @Column(name = "rate")
    private double rate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Currency2(String name, String code, double rate) {
        this();
        this.name = name;
        this.code = code;
        this.rate = rate;
    }

    public Currency2() {

    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getRate() {
        return rate;
    }



}