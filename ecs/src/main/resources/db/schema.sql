DROP TABLE IF EXISTS Products;

CREATE TABLE Products
(
    prod_id     IDENTITY        PRIMARY KEY,
    prod_name   VARCHAR(255)    NOT NULL,
    prod_price  INT             NOT NULL
);

DROP TABLE IF EXISTS user;
CREATE TABLE user(
    id INT PRIMARY KEY,
    email VARCHAR(30),
    name VARCHAR(30),
    tel VARCHAR(30)
);

DROP TABLE IF EXISTS product;
CREATE TABLE product (
    no VARCHAR(5),
    name VARCHAR(50)
);

