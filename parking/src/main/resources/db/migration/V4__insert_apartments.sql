---------------------------------------------------------
-- V4 — Inserção dos Apartments com floor e apartment_type
---------------------------------------------------------

---------------------------------------------------------
-- BUILDING CB (id = 1)
-- 12 andares, 8 aptos por andar
-- EXCEÇÃO: 1202 + 1203 = cobertura única → apenas 1202
---------------------------------------------------------

-- Andares 1 a 11 — todos STANDARD
INSERT INTO apartments (number, floor, apartment_type, building_id) VALUES
-- Floor 1 (101–108)
(101, 1, 'STANDARD', 1), (102, 1, 'STANDARD', 1), (103, 1, 'STANDARD', 1), (104, 1, 'STANDARD', 1),
(105, 1, 'STANDARD', 1), (106, 1, 'STANDARD', 1), (107, 1, 'STANDARD', 1), (108, 1, 'STANDARD', 1),

-- Floor 2 (201–208)
(201, 2, 'STANDARD', 1), (202, 2, 'STANDARD', 1), (203, 2, 'STANDARD', 1), (204, 2, 'STANDARD', 1),
(205, 2, 'STANDARD', 1), (206, 2, 'STANDARD', 1), (207, 2, 'STANDARD', 1), (208, 2, 'STANDARD', 1),

-- Floor 3
(301, 3, 'STANDARD', 1), (302, 3, 'STANDARD', 1), (303, 3, 'STANDARD', 1), (304, 3, 'STANDARD', 1),
(305, 3, 'STANDARD', 1), (306, 3, 'STANDARD', 1), (307, 3, 'STANDARD', 1), (308, 3, 'STANDARD', 1),

-- Floor 4
(401, 4, 'STANDARD', 1), (402, 4, 'STANDARD', 1), (403, 4, 'STANDARD', 1), (404, 4, 'STANDARD', 1),
(405, 4, 'STANDARD', 1), (406, 4, 'STANDARD', 1), (407, 4, 'STANDARD', 1), (408, 4, 'STANDARD', 1),

-- Floor 5
(501, 5, 'STANDARD', 1), (502, 5, 'STANDARD', 1), (503, 5, 'STANDARD', 1), (504, 5, 'STANDARD', 1),
(505, 5, 'STANDARD', 1), (506, 5, 'STANDARD', 1), (507, 5, 'STANDARD', 1), (508, 5, 'STANDARD', 1),

-- Floor 6
(601, 6, 'STANDARD', 1), (602, 6, 'STANDARD', 1), (603, 6, 'STANDARD', 1), (604, 6, 'STANDARD', 1),
(605, 6, 'STANDARD', 1), (606, 6, 'STANDARD', 1), (607, 6, 'STANDARD', 1), (608, 6, 'STANDARD', 1),

-- Floor 7
(701, 7, 'STANDARD', 1), (702, 7, 'STANDARD', 1), (703, 7, 'STANDARD', 1), (704, 7, 'STANDARD', 1),
(705, 7, 'STANDARD', 1), (706, 7, 'STANDARD', 1), (707, 7, 'STANDARD', 1), (708, 7, 'STANDARD', 1),

-- Floor 8
(801, 8, 'STANDARD', 1), (802, 8, 'STANDARD', 1), (803, 8, 'STANDARD', 1), (804, 8, 'STANDARD', 1),
(805, 8, 'STANDARD', 1), (806, 8, 'STANDARD', 1), (807, 8, 'STANDARD', 1), (808, 8, 'STANDARD', 1),

-- Floor 9
(901, 9, 'STANDARD', 1), (902, 9, 'STANDARD', 1), (903, 9, 'STANDARD', 1), (904, 9, 'STANDARD', 1),
(905, 9, 'STANDARD', 1), (906, 9, 'STANDARD', 1), (907, 9, 'STANDARD', 1), (908, 9, 'STANDARD', 1),

-- Floor 10
(1001, 10, 'STANDARD', 1), (1002, 10, 'STANDARD', 1), (1003, 10, 'STANDARD', 1), (1004, 10, 'STANDARD', 1),
(1005, 10, 'STANDARD', 1), (1006, 10, 'STANDARD', 1), (1007, 10, 'STANDARD', 1), (1008, 10, 'STANDARD', 1),

-- Floor 11
(1101, 11, 'STANDARD', 1), (1102, 11, 'STANDARD', 1), (1103, 11, 'STANDARD', 1), (1104, 11, 'STANDARD', 1),
(1105, 11, 'STANDARD', 1), (1106, 11, 'STANDARD', 1), (1107, 11, 'STANDARD', 1), (1108, 11, 'STANDARD', 1);

-- Floor 12 (coverage + standard)
INSERT INTO apartments (number, floor, apartment_type, building_id) VALUES
(1201, 12, 'STANDARD', 1),
(1202, 12, 'COVERAGE', 1),
-- 1203 DOES NOT EXISTS, SHARE COVERAGE WITH 1202
(1204, 12, 'STANDARD', 1),
(1205, 12, 'STANDARD', 1),
(1206, 12, 'STANDARD', 1),
(1207, 12, 'STANDARD', 1),
(1208, 12, 'STANDARD', 1);


---------------------------------------------------------
-- BUILDING CD (id = 2)
-- 12 andares, 9 aptos por andar
-- Todos STANDARD
---------------------------------------------------------

INSERT INTO apartments (number, floor, apartment_type, building_id) VALUES
-- Floor 1 (101–109)
(101, 1, 'STANDARD', 2), (102, 1, 'STANDARD', 2), (103, 1, 'STANDARD', 2), (104, 1, 'STANDARD', 2),
(105, 1, 'STANDARD', 2), (106, 1, 'STANDARD', 2), (107, 1, 'STANDARD', 2), (108, 1, 'STANDARD', 2), (109, 1, 'STANDARD', 2),

-- Floor 2
(201, 2, 'STANDARD', 2), (202, 2, 'STANDARD', 2), (203, 2, 'STANDARD', 2), (204, 2, 'STANDARD', 2),
(205, 2, 'STANDARD', 2), (206, 2, 'STANDARD', 2), (207, 2, 'STANDARD', 2), (208, 2, 'STANDARD', 2), (209, 2, 'STANDARD', 2),

-- Floor 3
(301, 3, 'STANDARD', 2), (302, 3, 'STANDARD', 2), (303, 3, 'STANDARD', 2), (304, 3, 'STANDARD', 2),
(305, 3, 'STANDARD', 2), (306, 3, 'STANDARD', 2), (307, 3, 'STANDARD', 2), (308, 3, 'STANDARD', 2), (309, 3, 'STANDARD', 2),

-- Floor 4
(401, 4, 'STANDARD', 2), (402, 4, 'STANDARD', 2), (403, 4, 'STANDARD', 2), (404, 4, 'STANDARD', 2),
(405, 4, 'STANDARD', 2), (406, 4, 'STANDARD', 2), (407, 4, 'STANDARD', 2), (408, 4, 'STANDARD', 2), (409, 4, 'STANDARD', 2),

-- Floor 5
(501, 5, 'STANDARD', 2), (502, 5, 'STANDARD', 2), (503, 5, 'STANDARD', 2), (504, 5, 'STANDARD', 2),
(505, 5, 'STANDARD', 2), (506, 5, 'STANDARD', 2), (507, 5, 'STANDARD', 2), (508, 5, 'STANDARD', 2), (509, 5, 'STANDARD', 2),

-- Floor 6
(601, 6, 'STANDARD', 2), (602, 6, 'STANDARD', 2), (603, 6, 'STANDARD', 2), (604, 6, 'STANDARD', 2),
(605, 6, 'STANDARD', 2), (606, 6, 'STANDARD', 2), (607, 6, 'STANDARD', 2), (608, 6, 'STANDARD', 2), (609, 6, 'STANDARD', 2),

-- Floor 7
(701, 7, 'STANDARD', 2), (702, 7, 'STANDARD', 2), (703, 7, 'STANDARD', 2), (704, 7, 'STANDARD', 2),
(705, 7, 'STANDARD', 2), (706, 7, 'STANDARD', 2), (707, 7, 'STANDARD', 2), (708, 7, 'STANDARD', 2), (709, 7, 'STANDARD', 2),

-- Floor 8
(801, 8, 'STANDARD', 2), (802, 8, 'STANDARD', 2), (803, 8, 'STANDARD', 2), (804, 8, 'STANDARD', 2),
(805, 8, 'STANDARD', 2), (806, 8, 'STANDARD', 2), (807, 8, 'STANDARD', 2), (808, 8, 'STANDARD', 2), (809, 8, 'STANDARD', 2),

-- Floor 9
(901, 9, 'STANDARD', 2), (902, 9, 'STANDARD', 2), (903, 9, 'STANDARD', 2), (904, 9, 'STANDARD', 2),
(905, 9, 'STANDARD', 2), (906, 9, 'STANDARD', 2), (907, 9, 'STANDARD', 2), (908, 9, 'STANDARD', 2), (909, 9, 'STANDARD', 2),

-- Floor 10
(1001, 10, 'STANDARD', 2), (1002, 10, 'STANDARD', 2), (1003, 10, 'STANDARD', 2), (1004, 10, 'STANDARD', 2),
(1005, 10, 'STANDARD', 2), (1006, 10, 'STANDARD', 2), (1007, 10, 'STANDARD', 2), (1008, 10, 'STANDARD', 2), (1009, 10, 'STANDARD', 2),

-- Floor 11
(1101, 11, 'STANDARD', 2), (1102, 11, 'STANDARD', 2), (1103, 11, 'STANDARD', 2), (1104, 11, 'STANDARD', 2),
(1105, 11, 'STANDARD', 2), (1106, 11, 'STANDARD', 2), (1107, 11, 'STANDARD', 2), (1108, 11, 'STANDARD', 2), (1109, 11, 'STANDARD', 2),

-- Floor 12
(1201, 12, 'STANDARD', 2), (1202, 12, 'STANDARD', 2), (1203, 12, 'STANDARD', 2), (1204, 12, 'STANDARD', 2),
(1205, 12, 'STANDARD', 2), (1206, 12, 'STANDARD', 2), (1207, 12, 'STANDARD', 2), (1208, 12, 'STANDARD', 2), (1209, 12, 'STANDARD', 2);
