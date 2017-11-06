create database java_a_to_z;

create table enter (
	enter_id serial PRIMARY KEY,
	user_login CHARACTER VARYING (30),
	password CHARACTER VARYING (30)
)

create table items (
	item_id PRIMARY KEY,
	work_application CHARACTER VARYING (50),
	work_role CHARACTER VARYING (50),
	create_data timestamp,
	id_enter INTEGER REFERENCES enter (enter_id),
	work_user CHARACTER VARYING (50)
)

create table users (
	user_id serial PRIMARY KEY,
	user_login INTEGER REFERENCES enter (user_login), 
	name CHARACTER VARYING (15),
	create_information CHARACTER VARYING (100),
	password INTEGER REFERENCES enter (password),
	id_item INTEGER REFERENCES items (item_id),
	work_date CHARACTER VARYING (50)
)

create table role (
	role_id serial PRIMARY KEY,
	status_role CHARACTER VARYING (20),
	description_role CHARACTER VARYING (1000),
	id_item INTEGER REFERENCES items (item_id)
)

create table rule_role (
	rule_id serial PRIMARY KEY,
	algoritm CHARACTER VARYING (300),
	number_rows CHARACTER VARYING (30),
	id_role INTEGER REFERENCES role (role_id)
)

create table attached_files (
	date_id serial PRIMARY KEY,
	documents CHARACTER VARYING (2000),
	letters CHARACTER VARYING (1000),
	id_user INTEGER REFERENCES users (user_id)
)

create table application (
	application_id PRIMARY KEY,
	applications CHARACTER VARYING (400),
	description_application CHARACTER VARYING (1000),
	id_item INTEGER REFERENCES items (item_id)
)

create table comment_application (
	comment_id PRIMARY KEY,
	comments CHARACTER VARYING (500),
	id_application INTEGER REFERENCES application(application_id)
)