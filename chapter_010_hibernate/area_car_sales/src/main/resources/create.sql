CREATE SCHEMA IF NOT EXISTS carStore AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS body(
  id serial PRIMARY KEY,
  body VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO body(body) VALUES ('hatchback');
INSERT INTO body(body) VALUES ('sedan');
INSERT INTO body(body) VALUES ('universal');
INSERT INTO body(body) VALUES ('jeep');
INSERT INTO body(body) VALUES ('bus');

CREATE TABLE IF NOT EXISTS brand(
  id serial PRIMARY KEY,
  brandCar VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO brand(brandCar) VALUES ('mersedes');
INSERT INTO brand(brandCar) VALUES ('bmv');
INSERT INTO brand(brandCar) VALUES ('kia');
INSERT INTO brand(brandCar) VALUES ('audi');
INSERT INTO brand(brandCar) VALUES ('ford');

CREATE TABLE IF NOT EXISTS drive(
  id serial PRIMARY KEY,
  drive VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO drive(drive) VALUES ('front');
INSERT INTO drive(drive) VALUES ('back');
INSERT INTO drive(drive) VALUES ('full');

CREATE TABLE IF NOT EXISTS engine(
  id serial PRIMARY KEY,
  engineSize DECIMAL NOT NULL UNIQUE
);

INSERT INTO engine(engineSize) VALUES (1.4);
INSERT INTO engine(engineSize) VALUES (1.6);
INSERT INTO engine(engineSize) VALUES (1.8);
INSERT INTO engine(engineSize) VALUES (2.0);
INSERT INTO engine(engineSize) VALUES (2.2);

CREATE TABLE IF NOT EXISTS fuel(
  id serial PRIMARY KEY,
  fuel VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO fuel(fuel) VALUES ('gas');
INSERT INTO fuel(fuel) VALUES ('petrol');
INSERT INTO fuel(fuel) VALUES ('diesel');

CREATE TABLE IF NOT EXISTS image(
  id serial PRIMARY KEY,
  URLImage VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS location(
  id serial PRIMARY KEY,
  location VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO location(location) VALUES ('Minsk');
INSERT INTO location(location) VALUES ('Vitebsk');
INSERT INTO location(location) VALUES ('Mogilev');
INSERT INTO location(location) VALUES ('Brest');
INSERT INTO location(location) VALUES ('Grodno');

CREATE TABLE IF NOT EXISTS model(
  id serial PRIMARY KEY,
  modelCar VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO model(model) VALUES ('A4');
INSERT INTO model(model) VALUES ('525');
INSERT INTO model(model) VALUES ('ceed');
INSERT INTO model(model) VALUES ('A140');
INSERT INTO model(model) VALUES ('Explorer');

CREATE TABLE IF NOT EXISTS price(
  id serial PRIMARY KEY,
  price INTEGER NOT NULL UNIQUE
);

INSERT INTO price(price) VALUES (30000);
INSERT INTO price(price) VALUES (25000);
INSERT INTO price(price) VALUES (48250);
INSERT INTO price(price) VALUES (55050);
INSERT INTO price(price) VALUES (47625);

CREATE TABLE IF NOT EXISTS transmission(
  id serial PRIMARY KEY,
  transmission VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO transmission(transmission) VALUES ('mechanic');
INSERT INTO transmission(transmission) VALUES ('robot');
INSERT INTO transmission(transmission) VALUES ('auto');
INSERT INTO transmission(transmission) VALUES ('variator');

CREATE TABLE IF NOT EXISTS year(
  id serial PRIMARY KEY,
  releaseYear INTEGER NOT NULL UNIQUE
);

INSERT INTO year(year) VALUES (2006);
INSERT INTO year(year) VALUES (2009);
INSERT INTO year(year) VALUES (2015);
INSERT INTO year(year) VALUES (1995);
INSERT INTO year(year) VALUES (2018);

CREATE TABLE IF NOT EXISTS owner(
  id serial PRIMARY KEY,
  name VARCHAR(255) NOT NULL UNIQUE,
  login VARCHAR(255) NOT NULL UNIQUE,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL UNIQUE,
  phone VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS orders(
  id serial PRIMARY KEY,
  createDate TIMESTAMP DEFAULT now(),
  id_car INTEGER REFERENCES car(id) NOT NULL,
  description VARCHAR(255) NOT NULL UNIQUE,
  id_location INTEGER REFERENCES location(id) NOT NULL,
  id_imageList INTEGER REFERENCES image(id) NOT NULL,
  id_owner INTEGER REFERENCES owner(id) NOT NULL,
  id_price INTEGER REFERENCES price(id) NOT NULL,
  sold BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS car(
  id serial PRIMARY KEY,
  id_body INTEGER REFERENCES body(id) NOT NULL,
  id_brand INTEGER REFERENCES brand(id) NOT NULL,
  id_drive INTEGER REFERENCES drive(id) NOT NULL,
  id_engine INTEGER REFERENCES engine(id) NOT NULL,
  id_fuel INTEGER REFERENCES fuel(id) NOT NULL,
  id_model INTEGER REFERENCES model(id) NOT NULL,
  id_transmission INTEGER REFERENCES transmission(id) NOT NULL,
  id_year INTEGER REFERENCES year(id) NOT NULL,
  color VARCHAR(255) NOT NULL UNIQUE,
  mileage INTEGER NOT NULL UNIQUE
);