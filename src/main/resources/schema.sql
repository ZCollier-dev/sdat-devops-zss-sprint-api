-- DROP in dependency-safe order
DROP TABLE IF EXISTS aircraft_passenger;
DROP TABLE IF EXISTS passenger_aircraft;
DROP TABLE IF EXISTS passenger_airport;
DROP TABLE IF EXISTS aircraft_airport;
DROP TABLE IF EXISTS passenger;
DROP TABLE IF EXISTS aircraft;
DROP TABLE IF EXISTS airport;
DROP TABLE IF EXISTS city;


-- RECREATE all tables
CREATE TABLE city (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    state VARCHAR(255),
    population INT
);

CREATE TABLE airport (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    code VARCHAR(10),
    city_id INT,
    FOREIGN KEY (city_id) REFERENCES city(id)
);

CREATE TABLE aircraft (
    id INT PRIMARY KEY,
    model VARCHAR(255),
    capacity INT
);

CREATE TABLE passenger (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
    city_id INT,
    FOREIGN KEY (city_id) REFERENCES city(id)
);

CREATE TABLE gate (
    id INT PRIMARY KEY,
    gate_number VARCHAR(10),
    airport_id INT,
    FOREIGN KEY (airport_id) REFERENCES airport(id)
);

CREATE TABLE passenger_aircraft (
    passenger_id INT,
    aircraft_id INT,
    PRIMARY KEY (passenger_id, aircraft_id),
    FOREIGN KEY (passenger_id) REFERENCES passenger(id),
    FOREIGN KEY (aircraft_id) REFERENCES aircraft(id)
);

CREATE TABLE passenger_airport (
    passenger_id INT,
    airport_id INT,
    PRIMARY KEY (passenger_id, airport_id),
    FOREIGN KEY (passenger_id) REFERENCES passenger(id),
    FOREIGN KEY (airport_id) REFERENCES airport(id)
);

CREATE TABLE aircraft_airport (
    aircraft_id INT,
    airport_id INT,
    PRIMARY KEY (aircraft_id, airport_id),
    FOREIGN KEY (aircraft_id) REFERENCES aircraft(id),
    FOREIGN KEY (airport_id) REFERENCES airport(id)
);
