INSERT INTO transmission(variant_transmission, amount_gear) VALUES ('hydraulic', 6);
INSERT INTO transmission(variant_transmission, amount_gear) VALUES ('variator', 7);
INSERT INTO transmission(variant_transmission, amount_gear) VALUES ('mechanic', 5);

INSERT INTO engine(fuel, volume_engine, mileage) VALUES ('disel', 6, 600);
INSERT INTO engine(fuel, volume_engine, mileage) VALUES ('gasoline', 4, 1000);
INSERT INTO engine(fuel, volume_engine, mileage) VALUES ('disel', 2, 400000);

INSERT INTO bodyesCar(variant_bodies, amount_doors, salon_car, convenience) VALUES ('sedan', 4, 'letheret', 'air-conditioner');
INSERT INTO bodyesCar(variant_bodies, amount_doors, salon_car, convenience) VALUES ('wagon', 5, 'letheret', 'parktronik');

INSERT INTO car(name_car, transmission_id, engine_id, bodyesCar_id) VALUES ('BMW_750', 2, 1, 1);
INSERT INTO car(name_car, transmission_id, engine_id, bodyesCar_id) VALUES ('Mersedes_S500', 1, 2, 2);
INSERT INTO car(name_car, transmission_id, engine_id) VALUES ('Kalina', 3, 3);