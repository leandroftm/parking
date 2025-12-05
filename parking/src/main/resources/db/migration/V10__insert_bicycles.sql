-----------------------------------------
-- Insert sample Bicycles (safe version)
-----------------------------------------

-- Caloi Elite (101 CB)
INSERT INTO bicycles (model, color, identifier, apartment_id)
SELECT 'Caloi Elite', 'Blue', 'BIKE001', a.id
FROM apartments a
JOIN buildings b ON a.building_id = b.id
WHERE a.number = 101 AND b.code = 'CB';


-- Scott Scale (202 CD)
INSERT INTO bicycles (model, color, identifier, apartment_id)
SELECT 'Scott Scale', 'Red', 'BIKE003', a.id
FROM apartments a
JOIN buildings b ON a.building_id = b.id
WHERE a.number = 202 AND b.code = 'CD';



-- Trek Marlin (308 CB)
INSERT INTO bicycles (model, color, identifier, apartment_id)
SELECT 'Trek Marlin', 'Green', 'BIKE004', a.id
FROM apartments a
JOIN buildings b ON a.building_id = b.id
WHERE a.number = 308 AND b.code = 'CB';
