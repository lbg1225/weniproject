
DROP TABLE IF EXISTS Products;
CREATE TABLE Products
(
    prod_id     IDENTITY        PRIMARY KEY,
    prod_name   VARCHAR(255)    NOT NULL,
    prod_price  INT             NOT NULL
);

DROP TABLE IF EXISTS users;
CREATE TABLE users(
    id IDENTITY PRIMARY KEY,
    email VARCHAR(30),
    name VARCHAR(30),
    tel VARCHAR(30)
);

DROP TABLE IF EXISTS student;
create table student (
    student_id varchar(30),
    name varchar(30),
    school_id int,
    score int,
    primary key(student_id, name)
);

