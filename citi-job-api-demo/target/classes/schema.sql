DROP TABLE IF EXISTS account;
CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(100) NOT NULL
);
-- Példa felhsználók--
INSERT INTO account (name, country) VALUES ('Aladar', 'Hungary');
INSERT INTO account (name, country) VALUES ('Belle', 'Germany');
INSERT INTO account (name, country) VALUES ('Carlos', 'Spain');
