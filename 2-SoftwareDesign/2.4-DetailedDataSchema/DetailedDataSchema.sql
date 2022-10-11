drop table literature_genres CASCADE;
drop table genres CASCADE;
drop table users_literature CASCADE;
drop table literature CASCADE;
drop table literature_types CASCADE;
drop table roles_authorities CASCADE;
drop table authorities CASCADE;
drop table users CASCADE;
drop table roles CASCADE;

CREATE TABLE roles(
	role_id INT PRIMARY KEY,
	role_name VARCHAR
);

CREATE TABLE users(
	user_id INT PRIMARY KEY,
	role_id INT REFERENCES roles(role_id),
	user_name VARCHAR,
	surname VARCHAR,
	balance DECIMAL(10, 2),
	email VARCHAR CHECK(email ~* '^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$'),
	mobile VARCHAR CHECK (mobile ~* '^\+?3?8?(0[\s\.-]\d{2}[\s\.-]\d{3}[\s\.-]\d{2}[\s\.-]\d{2})$')
);

CREATE TABLE authorities(
	authority_id INT PRIMARY KEY,
	authority_name VARCHAR
);

CREATE TABLE roles_authorities(
	role_id INT REFERENCES roles(role_id),
	authority_id INT REFERENCES authorities(authority_id),
	PRIMARY KEY(role_id, authority_id)
);

CREATE TABLE literature_types(
	literature_type_id INT PRIMARY KEY,
	ltype_name VARCHAR
);

CREATE TABLE literature(
	literature_id INT PRIMARY KEY,
	literature_name VARCHAR,
	description VARCHAR,
	literature_type_id INT REFERENCES literature_types(literature_type_id),
	litarature_cost DECIMAL(10, 3),
	author_id INT REFERENCES users(user_id)
);

CREATE TABLE users_literature(
	user_id INT REFERENCES users(user_id),
	literature_id INT REFERENCES literature(literature_id),
	obtained DATE,
	PRIMARY KEY(user_id, literature_id)
);

CREATE TABLE genres(
	genre_id INT PRIMARY KEY,
	genre_name VARCHAR
);

CREATE TABLE literature_genres(
	literature_id INT REFERENCES literature(literature_id),
	genre_id INT REFERENCES genres(genre_id),
	PRIMARY KEY(literature_id, genre_id)
);
