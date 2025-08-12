-- Create the database
CREATE DATABASE IF NOT EXISTS airport_db
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

-- Create application user
CREATE USER IF NOT EXISTS 'appuser'@'%' IDENTIFIED BY 'app-pass';

-- Grant privileges to appuser
GRANT ALL PRIVILEGES ON airport_db.* TO 'appuser'@'%';
FLUSH PRIVILEGES;

-- Use the database
USE airport_db;

-- Create example table
CREATE TABLE IF NOT EXISTS airports (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100),
    country VARCHAR(100)
);

-- Insert example data
INSERT INTO airports (code, name, city, country)
VALUES
    ('YYZ', 'Toronto Pearson International Airport', 'Toronto', 'Canada'),
    ('YVR', 'Vancouver International Airport', 'Vancouver', 'Canada'),
    ('YUL', 'Montréal-Pierre Elliott Trudeau International Airport', 'Montreal', 'Canada')
ON DUPLICATE KEY UPDATE
    name = VALUES(name),
    city = VALUES(city),
    country = VALUES(country);