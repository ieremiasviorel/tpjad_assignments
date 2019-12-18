CREATE TABLE tpjad_assig2_ejb.city (
	id BIGINT NOT NULL,
	country varchar(100) NULL,
	latitude FLOAT NULL,
	longitude FLOAT NULL,
	name varchar(100) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

CREATE TABLE tpjad_assig2_ejb.flight (
	id BIGINT NOT NULL,
	flight_number varchar(100) NULL,
	airplane_type varchar(100) NULL,
	departure_city BIGINT NULL,
	departure_date DATETIME NULL,
	arrival_city BIGINT NULL,
	arrival_date DATETIME NULL,
	CONSTRAINT flight_pk PRIMARY KEY (id),
	CONSTRAINT flight_fk FOREIGN KEY (departure_city) REFERENCES tpjad_assig2_ejb.flight(id),
	CONSTRAINT flight_fk_1 FOREIGN KEY (arrival_city) REFERENCES tpjad_assig2_ejb.city(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;