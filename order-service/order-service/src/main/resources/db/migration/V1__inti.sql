CREATE TABLE t_orders (
    id BIGINT NOT NULL AUTO_INCREMENT,
    order_number VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id)
);
