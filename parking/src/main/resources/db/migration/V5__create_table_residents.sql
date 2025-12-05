CREATE TABLE residents (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    cpf VARCHAR(15) NOT NULL UNIQUE,
    phone VARCHAR(15) NOT NULL UNIQUE,
    type VARCHAR(20) NOT NULL,
    apartment_id BIGINT NOT NULL,

    CONSTRAINT fk_resident_apartment
        FOREIGN KEY (apartment_id)
        REFERENCES apartments(id)
);
