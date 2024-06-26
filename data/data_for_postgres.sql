CREATE SEQUENCE IF NOT EXISTS alien_id_seq START 1;

CREATE TABLE IF NOT EXISTS alien (
                                     id BIGINT PRIMARY KEY DEFAULT nextval('alien_id_seq'),
                                     type VARCHAR(255),
                                     full_name VARCHAR(255),
                                     weight INT,
                                     run_speed NUMERIC(10, 2),
                                     height INT
);

INSERT INTO alien (type, full_name, weight, run_speed, height)
VALUES ('Type A', 'John Doe', 70, 12.5, 180),
       ('Type B', 'Jane Smith', 65, 10.0, 170),
       ('Type C', 'Michael Johnson', 80, 15.2, 190);


CREATE SEQUENCE IF NOT EXISTS space_id_seq START 1;

CREATE TABLE IF NOT EXISTS space_ship_entity (
                                                 id BIGINT PRIMARY KEY DEFAULT nextval('space_id_seq'),
                                                 ship_name VARCHAR(255),
                                                 fuel INT,
                                                 max_speed DOUBLE PRECISION
);

-- SQL script for data insertion in both PostgreSQL and H2
INSERT INTO space_ship_entity (ship_name, fuel, max_speed)
VALUES ('Enterprise', 100, 9.8),
       ('Millennium Falcon', 80, 12.5),
       ('Star Destroyer', 120, 10.0);


