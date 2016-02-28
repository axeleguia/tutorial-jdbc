DROP DATABASE IF EXISTS db_sales;
CREATE DATABASE db_sales;

USE db_sales;

DROP TABLE IF EXISTS customer;
CREATE TABLE customer
(
id INT NOT NULL AUTO_INCREMENT,
companyName VARCHAR(30),
contactName VARCHAR(30),
address VARCHAR(30),
mailContact VARCHAR(30),
phoneNumber VARCHAR(30),
createdDate DATETIME DEFAULT CURRENT_TIMESTAMP,
updatedDate DATETIME,
deletedDate DATETIME,
deleted CHAR(1) DEFAULT '0',
PRIMARY KEY (id)
);

DROP TABLE IF EXISTS product;
CREATE TABLE product
(
id INT NOT NULL AUTO_INCREMENT,
productName VARCHAR(30),
unitPrice DOUBLE(8,2),
stock INT,
createdDate DATETIME DEFAULT CURRENT_TIMESTAMP,
updatedDate DATETIME,
deletedDate DATETIME,
deleted CHAR(1) DEFAULT '0',
PRIMARY KEY (id)
);

DROP TABLE IF EXISTS orders;
CREATE TABLE orders
(
id INT NOT NULL AUTO_INCREMENT,
customerId INT,
orderDate DATETIME,
status VARCHAR(30), 
totalPrice DOUBLE(8,2),
createdDate DATETIME DEFAULT CURRENT_TIMESTAMP,
updatedDate DATETIME,
deletedDate DATETIME,
deleted CHAR(1) DEFAULT '0',
PRIMARY KEY (id),
FOREIGN KEY (customerId) REFERENCES customer (id) 
);

DROP TABLE IF EXISTS orderDetail;
CREATE TABLE orderDetail
(
id INT NOT NULL AUTO_INCREMENT,
orderId INT NOT NULL,
productId INT NOT NULL,
unitPrice DOUBLE(8,2),
quantity INT,
subTotal DOUBLE(8,2),
PRIMARY KEY (id),
FOREIGN KEY (orderId) REFERENCES orders (id),
FOREIGN KEY (productId) REFERENCES product (id)
);

-- CUSTOMER
INSERT INTO customer (id, companyName, contactName, address, mailContact, phoneNumber, createdDate, updatedDate, deletedDate, deleted) VALUES(NULL,'Boruboard','Jorge Linares','Calle Las Lomas #456','jorgitum@example.com','564-5455',NOW(),NULL,NULL,'0');
INSERT INTO customer (id, companyName, contactName, address, mailContact, phoneNumber, createdDate, updatedDate, deletedDate, deleted) VALUES(NULL,'Cataris','Isabel Uzel','Jr. Los Alamos Mz.4','isabelum@example.com','454-4875',NOW(),NULL,NULL,'0');
INSERT INTO customer (id, companyName, contactName, address, mailContact, phoneNumber, createdDate, updatedDate, deletedDate, deleted) VALUES(NULL,'Bodeguita de Yun','Carlos Izaguirre','Calle Las Vegas','carlois@example.com','989-879745',NOW(),NULL,NULL,'0');

-- PRODUCT
INSERT INTO product (id, productName, unitPrice, stock, createdDate, updatedDate, deletedDate, deleted) VALUES(NULL,'Agua Cielo - 625ml',1.80,144,NOW(),NULL,NULL,0);
INSERT INTO product (id, productName, unitPrice, stock, createdDate, updatedDate, deletedDate, deleted) VALUES(NULL,'Coca Cola - 625ml',2.20,136,NOW(),NULL,NULL,0);
INSERT INTO product (id, productName, unitPrice, stock, createdDate, updatedDate, deletedDate, deleted) VALUES(NULL,'Cifrut Punch - 625ml',1.50,108,NOW(),NULL,NULL,0);
INSERT INTO product (id, productName, unitPrice, stock, createdDate, updatedDate, deletedDate, deleted) VALUES(NULL,'Pulpin - 450ml',1.10,120,NOW(),NULL,NULL,0);
INSERT INTO product (id, productName, unitPrice, stock, createdDate, updatedDate, deletedDate, deleted) VALUES(NULL,'Guarana - 625ml',2.50,144,NOW(),NULL,NULL,0);
