CREATE DATABASE stationeryshop;

USE stationeryshop;

CREATE TABLE category(
   	category_id INT AUTO_INCREMENT NOT NULL,
   	category_name VARCHAR(20) NOT NULL,
	PRIMARY KEY(category_id)
);

CREATE TABLE product(
   	product_id INT AUTO_INCREMENT NOT NULL,
	product_name VARCHAR(40) NOT NULL,
	brand_id INT NOT NULL,
	category_id INT NOT NULL,
	price DOUBLE NOT NULL,
	PRIMARY KEY(product_id),
	FOREIGN KEY (brand_id) REFERENCES brand(brand_id)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	FOREIGN KEY (category_id) REFERENCES category(category_id)
	ON UPDATE CASCADE
	ON DELETE CASCADE	
);

CREATE TABLE brand(
	brand_id INT AUTO_INCREMENT NOT NULL,
	brand_name VARCHAR(20),
	PRIMARY KEY(brand_id)
);


INSERT INTO category(category_name)
VALUES ('notebook'),
	('pen'),
	('pencil'),
	('agenda'),
	('accessories');

INSERT INTO brand(brand_name)
VALUES ('legami'),
	('fabriano'),
	('moleskine'),
	('stabilo'),
	('bic');

INSERT INTO product(product_name, brand_id, category_id, price)
VALUES ('Erasable Gel Pen', 1, 2, 1.95),
	('Heart-Shaped Pencil', 1, 3, 1.95),
	('Fabriano Artist Journal', 2, 1, 16.50),
	('Fabriano Notebook', 2, 1, 5.45),
	('Moleskine classic Agenda', 3, 4, 17.02),
	('Moleskine Harry Potter Agenda', 3, 4, 25.60),
	('Stabilo Pointball', 4, 2, 2.70),
	('Stabilo Kids Pencil', 4, 3, 2.64),
	('Bic sphere', 5, 2, 1.34),
	('Bic cristal', 5, 2, 1.34),
	('Panda timer', 1, 5, 5.60),
	('Purrito mousepad', 1, 5, 10.56);


	
	