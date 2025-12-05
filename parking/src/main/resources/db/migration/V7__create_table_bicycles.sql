CREATE TABLE bicycles (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    model VARCHAR(30),
    color VARCHAR(30) NOT NULL,
    identifier VARCHAR(15) NOT NULL UNIQUE,
    apartment_id BIGINT,

    CONSTRAINT fk_bicycle_apartment
        FOREIGN KEY (apartment_id)
        REFERENCES apartments(id)
        ON DELETE SET NULL
);