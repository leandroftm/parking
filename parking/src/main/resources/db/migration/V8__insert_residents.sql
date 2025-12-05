-----------------------------------------
-- Insert sample Residents
-----------------------------------------

-- João Silva (PRIMARY - 101 CB)
INSERT INTO residents (name, cpf, phone, type, apartment_id)
SELECT 'João Silva', '11111111111', '11988880001', 'PRIMARY', a.id
FROM apartments a
JOIN buildings b ON a.building_id = b.id
WHERE a.number = 101 AND b.code = 'CB';


-- Maria Souza (TENANT - 101 CB)
INSERT INTO residents (name, cpf, phone, type, apartment_id)
SELECT 'Maria Souza', '22222222222', '11988880002', 'PERMANENT_TENANT', a.id
FROM apartments a
JOIN buildings b ON a.building_id = b.id
WHERE a.number = 101 AND b.code = 'CB';


-- Carlos Lima (PRIMARY - 202 CD)
INSERT INTO residents (name, cpf, phone, type, apartment_id)
SELECT 'Carlos Lima', '33333333333', '11988880003', 'TEMPORARY_TENANT', a.id
FROM apartments a
JOIN buildings b ON a.building_id = b.id
WHERE a.number = 202 AND b.code = 'CD';


-- Ana Costa (TENANT - 308 CB)
INSERT INTO residents (name, cpf, phone, type, apartment_id)
SELECT 'Ana Costa', '44444444444', '11988880004', ' PRIMARY', a.id
FROM apartments a
JOIN buildings b ON a.building_id = b.id
WHERE a.number = 308 AND b.code = 'CB';
