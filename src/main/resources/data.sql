INSERT INTO farm (id, name) VALUES (1, 'MyFarm');
INSERT INTO planting_info (id, crop_type, planting_area, expected_product, farm_id, season) VALUES (1, 'Tomato', 100.0, 200.0, 1, 'Harvest');
INSERT INTO planting_info (id, crop_type, planting_area, expected_product, farm_id, season) VALUES (2, 'Potatoes', 50.0, 80.0, 1, 'Harvest');
INSERT INTO harvesting_info (id, crop_type, actual_harvested_product, farm_id, season) VALUES (1, 'Tomato', 190.0, 1, 'Harvest');
INSERT INTO harvesting_info (id, crop_type, actual_harvested_product, farm_id, season) VALUES (2, 'Potatoes', 85.0, 1, 'Harvest');