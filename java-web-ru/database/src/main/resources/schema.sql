-- BEGIN
DROP TABLE IF EXISTS products;

CREATE TABLE Products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    price INT
);

-- END