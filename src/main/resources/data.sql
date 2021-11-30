DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS comments;
 
CREATE TABLE products (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  cost INT(250) NOT NULL
);
 
INSERT INTO products (name, description, cost) VALUES
  ('iphone', 'smartphone apple', 1000),
  ('ipad', 'tablette apple', 500),
  ('imac', 'ordinateur apple', 2000);

 CREATE TABLE comments (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  content VARCHAR(250) NOT NULL,
  id_product INT(250) 
);

INSERT INTO comments (content, id_product) VALUES
  ('trop cool',1),
  ('trop nul',3),
  ('excellent',3);

CREATE TABLE categories (
  id_category INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

INSERT INTO categories (name) VALUES
  ('smart phone'),
  ('tablette'),
  ('ordinateur'),
  ('apple');
  
CREATE TABLE category_product (
  id_category INT NOT NULL,
  id_product INT NOT NULL
);

INSERT INTO category_product (id_category, id_product) VALUES
  (1,1),
  (2,2),
  (3,3),
  (4,1),
  (4,2),
  (4,3);