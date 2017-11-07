select * from car;

select car.name_car, b.variant_bodies from car as car left outer join bodyesCar as b on car.id_car = b.id_bodyes where car.bodyesCar_id is null;