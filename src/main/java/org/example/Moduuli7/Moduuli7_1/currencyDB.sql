DROP DATABASE IF EXISTS currency_db;

CREATE DATABASE currency_db;
USE currency_db;

CREATE TABLE Currency (
    abbreviation VARCHAR(3) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    conversion_rate DECIMAL(10, 6) NOT NULL
);

INSERT INTO Currency (abbreviation, name, conversion_rate) VALUES
    ('USD', 'United States Dollar', 1.000000),
    ('EUR', 'Euro', 1.100000),
    ('JPY', 'Japanese Yen', 0.007000),
    ('GBP', 'British Pound', 1.250000),
    ('AUD', 'Australian Dollar', 0.650000),
    ('CAD', 'Canadian Dollar', 0.740000),
    ('CHF', 'Swiss Franc', 1.080000),
    ('CNY', 'Chinese Yuan', 0.150000);

DROP USER IF EXISTS 'appuser'@'localhost';

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'nimohanna';

GRANT SELECT, INSERT, UPDATE ON currency_db.* TO 'appuser'@'localhost';



