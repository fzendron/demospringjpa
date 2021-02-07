DROP TABLE IF EXISTS People;

CREATE TABLE People (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              name VARCHAR(250) NOT NULL,
                              email VARCHAR(250) NOT NULL,
                              phone VARCHAR(250) DEFAULT NULL
);