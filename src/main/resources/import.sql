DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS products (id BIGINT auto_increment NOT NULL, title varchar(255) NULL, quantity INT NULL, CONSTRAINT products_PK PRIMARY KEY (id));
INSERT INTO products (title, quantity) VALUES ('Milk', 120), ('Bread', 195), ('Eggs', 90);
