-- SQL script to create the table in H2
CREATE TABLE IF NOT EXISTS alien (
                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     type VARCHAR(255),
                                     full_name VARCHAR(255),
                                     weight INT,
                                     run_speed NUMERIC(10, 2),
                                     height INT
);

-- SQL script for data insertion
INSERT INTO alien (type, full_name, weight, run_speed, height)
VALUES ('Type A', 'John Doe', 70, 12.5, 180),
       ('Type B', 'Jane Smith', 65, 10.0, 170),
       ('Type C', 'Michael Johnson', 80, 15.2, 190);


-- H2 SQL script to create the table for SpaceShipEntity
CREATE TABLE IF NOT EXISTS space_ship_entity (
                                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                                 ship_name VARCHAR(255),
                                                 fuel INT,
                                                 max_speed DOUBLE
);

-- SQL script for data insertion in both PostgreSQL and H2
INSERT INTO space_ship_entity (ship_name, fuel, max_speed)
VALUES ('Enterprise', 100, 9.8),
       ('Millennium Falcon', 80, 12.5),
       ('Star Destroyer', 120, 10.0);

select *
from space_ship_entity;