use converterdb;

SELECT * FROM Currency;

SELECT * FROM Currency WHERE abbreviation = 'EUR';

SELECT COUNT(*) FROM Currency;

SELECT * FROM Currency ORDER BY conversion_rate DESC LIMIT 1;
