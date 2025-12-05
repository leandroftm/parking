CREATE TABLE vehicles (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    plate VARCHAR(15) NOT NULL UNIQUE,
    model VARCHAR(30) NOT NULL,
    color VARCHAR(30) NOT NULL,
    parked BOOLEAN NOT NULL,
    apartment_id BIGINT,

    CONSTRAINT fk_vehicle_apartment
        FOREIGN KEY (apartment_id)
        REFERENCES apartments(id)
        ON DELETE SET NULL
);