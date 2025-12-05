CREATE TABLE apartments (
id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
number INTEGER NOT NULL,
floor INTEGER NOT NULL,
apartment_type VARCHAR(15),
building_id BIGINT NOT NULL,
CONSTRAINT fk_apartment_building FOREIGN KEY (building_id)
    REFERENCES buildings(id),
    CONSTRAINT uq_building_number UNIQUE (building_id, number)
);