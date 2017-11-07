create database car_storage;

create table transmission (
	id_transmission serial PRIMARY KEY,
	variant_transmission CHARACTER VARYING (50),
	amount_gear INTEGER
);

create table engine (
	id_engine serial PRIMARY KEY,
	fuel CHARACTER VARYING (50),
	volume_engine INTEGER,
	mileage INTEGER
);

create table bodyesCar (
	id_bodyes serial PRIMARY KEY,
	variant_bodies CHARACTER VARYING (10),
	amount_doors INTEGER,
	salon_car CHARACTER VARYING (100),
	convenience CHARACTER VARYING (200)
);

create table car (
	id_car serial PRIMARY KEY,
	name_car CHARACTER VARYING (100),
	transmission_id INTEGER REFERENCES transmission(id_transmission),
	engine_id INTEGER REFERENCES engine(id_engine),
	bodyesCar_id INTEGER REFERENCES bodyesCar(id_bodyes)
);