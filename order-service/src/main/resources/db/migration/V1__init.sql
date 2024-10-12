CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    order_number VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL
);