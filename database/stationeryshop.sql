CREATE DATABASE stationeryshop;

USE stationeryshop;

CREATE TABLE category(
   	category_id INT AUTO_INCREMENT NOT NULL,
   	category_name VARCHAR(20) NOT NULL,
	PRIMARY KEY(category_id)
);

CREATE TABLE brand(
	brand_id INT AUTO_INCREMENT NOT NULL,
	brand_name VARCHAR(20),
	PRIMARY KEY(brand_id)
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



CREATE TABLE product_preview(
	product_preview_id INT AUTO_INCREMENT NOT NULL,
	src VARCHAR(200) NOT NULL,
	img_index INT NOT NULL,
	product_id INT NOT NULL,
	PRIMARY KEY(product_preview_id),
	FOREIGN KEY (product_id) REFERENCES product(product_id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
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


INSERT INTO product_preview(src, img_index, product_id) 
VALUES ('https://www.legami.com/dw/image/v2/BDSQ_PRD/on/demandware.static/-/Sites-legami-master-catalog/default/dwc6761158/images_legami/zoom/EP0005_1.jpg?sw=800&sh=800', 1, 1),
('https://www.legami.com/dw/image/v2/BDSQ_PRD/on/demandware.static/-/Sites-legami-master-catalog/default/dw03f0ae2e/images_legami/zoom/EP0005_2.jpg?sw=1200&sh=1200', 2, 1),
('https://www.legami.com/dw/image/v2/BDSQ_PRD/on/demandware.static/-/Sites-legami-master-catalog/default/dwb6d3ee8e/images_legami/zoom/EP0005_3.jpg?sw=1200&sh=1200', 3, 1),
('https://www.legami.com/dw/image/v2/BDSQ_PRD/on/demandware.static/-/Sites-legami-master-catalog/default/dw5f7dee78/images_legami/zoom/EP0005_4.jpg?sw=1200&sh=1200', 4, 1),
('https://www.legami.com/dw/image/v2/BDSQ_PRD/on/demandware.static/-/Sites-legami-master-catalog/default/dw596f9322/images_legami/zoom/HP0001_1.jpg?sw=1200&sh=1200', 1, 2),
('https://www.legami.com/dw/image/v2/BDSQ_PRD/on/demandware.static/-/Sites-legami-master-catalog/default/dw643ad439/images_legami/zoom/HP0001_2.jpg?sw=1200&sh=1200', 2, 2),
('https://www.legami.com/dw/image/v2/BDSQ_PRD/on/demandware.static/-/Sites-legami-master-catalog/default/dwbfba2321/images_legami/zoom/HP0001_3.jpg?sw=1200&sh=1200', 3, 2),
('https://www.fabrianoboutique.eu/media/catalog/product/cache/5/thumbnail/1000x1194.6902654867/9df78eab33525d08d6e5fb8d27136e95/4/8/48441616_02.jpg', 1, 3),
('https://www.fabrianoboutique.eu/media/catalog/product/cache/5/thumbnail/1000x1194.6902654867/9df78eab33525d08d6e5fb8d27136e95/4/8/48441616_03.jpg
', 2, 3),
('https://www.fabrianoboutique.eu/media/catalog/product/cache/5/thumbnail/1000x1194.6902654867/9df78eab33525d08d6e5fb8d27136e95/4/8/48441616_04.jpg
', 3, 3),
('https://www.fabrianoboutique.eu/media/catalog/product/cache/5/thumbnail/1000x1194.6902654867/9df78eab33525d08d6e5fb8d27136e95/0/1/01300332_02.jpg', 1, 4),
('https://www.fabrianoboutique.eu/media/catalog/product/cache/5/thumbnail/1000x1194.6902654867/9df78eab33525d08d6e5fb8d27136e95/0/1/01300332_03.jpg
', 2, 4),
('https://www.fabrianoboutique.eu/media/catalog/product/cache/5/thumbnail/1000x1194.6902654867/9df78eab33525d08d6e5fb8d27136e95/0/1/01300332_04.jpg
', 3, 4),
('https://www.fabrianoboutique.eu/media/catalog/product/cache/5/thumbnail/1000x1194.6902654867/9df78eab33525d08d6e5fb8d27136e95/0/1/01300332_06.jpg
', 4, 4),
('https://www.moleskine.com/dw/image/v2/BFRN_PRD/on/demandware.static/-/Sites-masterCatalog_Moleskine/default/dw793edeff/images/large-PDP/gtin_8056598857122_01.png?sh=453', 1, 5),
('https://www.moleskine.com/dw/image/v2/BFRN_PRD/on/demandware.static/-/Sites-masterCatalog_Moleskine/default/dw7f534406/images/large-PDP/gtin_8056598857122_02.png?sh=453', 2, 5),
('https://www.moleskine.com/dw/image/v2/BFRN_PRD/on/demandware.static/-/Sites-masterCatalog_Moleskine/default/dwe4e08b64/images/large-PDP/gtin_8056598857122_03.png?sh=453', 3, 5),
('https://m.media-amazon.com/images/I/81nhQYHaKdL._AC_SL1500_.jpg', 1, 6),
('https://m.media-amazon.com/images/I/715L3a65ZrL._AC_SL1500_.jpg', 2, 6),
('https://m.media-amazon.com/images/I/71rei5xmBjL._AC_SL1500_.jpg', 3, 6),
('https://m.media-amazon.com/images/I/61UIDLP-5dL._AC_SL1500_.jpg', 1, 7),
('https://m.media-amazon.com/images/I/313OBULwM9L._AC_.jpg', 2, 7),
('https://m.media-amazon.com/images/I/71PMY9cl9vL._AC_SL1500_.jpg', 3, 7),
('https://sta-live-cdn.b-cdn.net/thumbnail/a7/ff/e3/1662505340/St_174985_882_205-450_Pen_diagonal_cs_560x560.jpg', 1, 8),
('https://sta-live-cdn.b-cdn.net/thumbnail/2a/69/20/1662505345/St_174995_882_205-450_Pen_zoom-tip_cs_560x560.jpg', 2, 8),
('https://sta-live-cdn.b-cdn.net/thumbnail/d5/e5/a2/1662505347/St_231979_882_xx_mood_cs_560x560.jpg', 3, 8),
('https://m.media-amazon.com/images/I/81S4cndRaXL._AC_SL1500_.jpg', 1, 9),
('https://m.media-amazon.com/images/I/51BvcqgJJ3L._AC_SL1500_.jpg', 1, 10),
('https://m.media-amazon.com/images/I/71VLtiLONaL._AC_SL1500_.jpg', 2, 10),
('https://www.legami.com/dw/image/v2/BDSQ_PRD/on/demandware.static/-/Sites-legami-master-catalog/default/dw064997d3/images_legami/zoom/KT0002_1.jpg?sw=1200&sh=1200', 1, 11),
('https://www.legami.com/dw/image/v2/BDSQ_PRD/on/demandware.static/-/Sites-legami-master-catalog/default/dwdacffb1a/images_legami/zoom/KT0002_2.jpg?sw=1200&sh=1200', 2, 11),
('https://ih1.redbubble.net/image.3138646301.9261/ur,desk_mat_flatlay,square,600x600.u3.jpg', 1, 12),
('https://ih1.redbubble.net/image.3138646301.9261/ur,desk_mat_flatlay_prop,square,1000x1000.u3.jpg', 2, 12);
	
	