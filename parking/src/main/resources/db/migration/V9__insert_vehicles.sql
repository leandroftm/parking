-----------------------------------------
-- Insert sample Vehicles (safe version)
-----------------------------------------

-- Honda Civic (101 CB)
INSERT INTO vehicles (plate, model, color, parked, apartment_id)
SELECT 'ABC1A23', 'Honda Civic', 'Black', FALSE, a.id
FROM apartments a
JOIN buildings b ON a.building_id = b.id
WHERE a.number = 101 AND b.code = 'CB';


-- Toyota Corolla (202 CD)
INSERT INTO vehicles (plate, model, color, parked, apartment_id)
SELECT 'BCD3D45', 'Toyota Corolla', 'Silver', TRUE, a.id
FROM apartments a
JOIN buildings b ON a.building_id = b.id
WHERE a.number = 202 AND b.code = 'CD';


