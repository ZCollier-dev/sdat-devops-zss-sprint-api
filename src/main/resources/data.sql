-- Cities
INSERT INTO city (id, name, state, population) VALUES (1, 'Toronto', 'ON', 3000000);
INSERT INTO city (id, name, state, population) VALUES (2, 'Vancouver', 'BC', 1000000);

-- Airports
INSERT INTO airport (id, name, code, city_id) VALUES (1, 'Toronto Pearson Intl', 'YYZ', 1);
INSERT INTO airport (id, name, code, city_id) VALUES (2, 'Vancouver Intl', 'YVR', 2);

-- Aircraft
INSERT INTO aircraft (id, model, capacity) VALUES (1, 'Boeing 737', 180);
INSERT INTO aircraft (id, model, capacity) VALUES (2, 'Airbus A320', 150);

-- Passengers
INSERT INTO passenger (id, name, email) VALUES (1, 'Scarlett Budgell', 'scar@example.com', 1);
INSERT INTO passenger (id, name, email) VALUES (2, 'Alex Mercer', 'alex@example.com', 2);

-- Gates
INSERT INTO gate (id, gate_number, airport_id) VALUES (1, 'A12', 1);
INSERT INTO gate (id, gate_number, airport_id) VALUES (2, 'A13', 1);
INSERT INTO gate (id, gate_number, airport_id) VALUES (3, 'B2', 2);
INSERT INTO gate (id, gate_number, airport_id) VALUES (4, 'B7', 2);

-- Join Tables (you may need to adjust names based on your @ManyToMany setup)

-- Passenger <-> Aircraft (flown on)
INSERT INTO passenger_aircraft (passenger_id, aircraft_id) VALUES (1, 1);
INSERT INTO passenger_aircraft (passenger_id, aircraft_id) VALUES (1, 2);
INSERT INTO passenger_aircraft (passenger_id, aircraft_id) VALUES (2, 2);

-- Passenger <-> Airport (used)
INSERT INTO passenger_airport (passenger_id, airport_id) VALUES (1, 1);
INSERT INTO passenger_airport (passenger_id, airport_id) VALUES (1, 2);

-- Aircraft <-> Airport (uses)
INSERT INTO aircraft_airport (aircraft_id, airport_id) VALUES (1, 1);
INSERT INTO aircraft_airport (aircraft_id, airport_id) VALUES (2, 2);
