DROP TABLE IF EXISTS planting_info;
DROP TABLE IF EXISTS harvesting_info;
DROP TABLE IF EXISTS farm;

CREATE TABLE farm (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE planting_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    crop_type VARCHAR(255) NOT NULL,
    planting_area DECIMAL(10, 2) NOT NULL,
    expected_product DECIMAL(10, 2) NOT NULL,
    farm_id BIGINT NOT NULL,
    season VARCHAR(255) NOT NULL,
    FOREIGN KEY (farm_id) REFERENCES farm(id)
);

CREATE TABLE planting_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    crop_type VARCHAR(255) NOT NULL,
    planting_area DECIMAL(10, 2) NOT NULL,
    expected_product DECIMAL(10, 2) NOT NULL,
    farm_id BIGINT NOT NULL,
    season VARCHAR(255) NOT NULL,
    FOREIGN KEY (farm_id) REFERENCES farm(id)
);

INSERT INTO farm (id, name) VALUES (1, 'MyFarm');
INSERT INTO planting_info (id, crop_type, planting_area, expected_product, farm_id, season) VALUES (1, 'Tomato', 100.0, 200.0, 1, 'Harvest');
INSERT INTO planting_info (id, crop_type, planting_area, expected_product, farm_id, season) VALUES (2, 'Potatoes', 50.0, 80.0, 1, 'Harvest');
INSERT INTO harvesting_info (id, crop_type, actual_harvested_product, farm_id, season) VALUES (1, 'Tomato', 190.0, 1, 'Harvest');
INSERT INTO harvesting_info (id, crop_type, actual_harvested_product, farm_id, season) VALUES (2, 'Potatoes', 85.0, 1, 'Harvest');