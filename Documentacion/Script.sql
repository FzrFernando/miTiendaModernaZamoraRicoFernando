CREATE DATABASE cochesAdame;


	CREATE TABLE cochesAdame.USUARIO(
	USUARIO VARCHAR(50) UNIQUE,
	PASSWORD VARCHAR(32),
	NOMBRE_APELLIDO VARCHAR(75),
	FECHA_NACIMIENTO DATE,
	GENERO BOOLEAN,
	ADMINISTRADOR BOOLEAN,
	CONSTRAINT PK_USUARIO PRIMARY KEY(USUARIO)
	);

INSERT INTO cochesAdame.USUARIO (`USUARIO`, `PASSWORD`, `NOMBRE_APELLIDO`, `FECHA_NACIMIENTO`, `GENERO`, `ADMINISTRADOR`) VALUES (TRIM('alberto'), MD5('alberto'), 'Alberto Adame Roldan', '1999-03-08', '1', '1');
INSERT INTO cochesAdame.USUARIO (`USUARIO`, `PASSWORD`, `NOMBRE_APELLIDO`, `FECHA_NACIMIENTO`, `GENERO`, `ADMINISTRADOR`) VALUES (TRIM('prueba'), MD5('prueba'), 'Usuario De Prueba', '2022-11-07', '0', '0');

	CREATE TABLE cochesAdame.CATEGORIA(
	ID_CATEGORIA NUMERIC(5) UNIQUE,
	NOMBRE VARCHAR(50),
	DESCRIPCION VARCHAR(150),
	CONSTRAINT PK_CATEGORIA PRIMARY KEY(ID_CATEGORIA)
	);

insert into cochesAdame.CATEGORIA (id_categoria, nombre, descripcion) values (1, 'Pontiac', 'Acquired pure red cell aplasia, unspecified');
insert into cochesAdame.CATEGORIA (id_categoria, nombre, descripcion) values (2, 'Chevrolet', 'Nondisp fx of lateral condyle of l femr, 7thB');
insert into cochesAdame.CATEGORIA (id_categoria, nombre, descripcion) values (3, 'Ford', 'Driver of hv veh inj pick-up truck, pk-up/van in traf, init');
insert into cochesAdame.CATEGORIA (id_categoria, nombre, descripcion) values (4, 'Kia', 'Other specified fracture of right pubis');
insert into cochesAdame.CATEGORIA (id_categoria, nombre, descripcion) values (5, 'Saab', 'Malignant neoplasm of short bones of unspecified lower limb');
insert into cochesAdame.CATEGORIA (id_categoria, nombre, descripcion) values (6, 'Ford', 'Unsp physeal fracture of lower end of unsp fibula, sequela');
insert into cochesAdame.CATEGORIA (id_categoria, nombre, descripcion) values (7, 'GMC', 'Smith''s fx unsp rad, subs for opn fx type I/2 w routn heal');
insert into cochesAdame.CATEGORIA (id_categoria, nombre, descripcion) values (8, 'Chrysler', 'Fracture of fifth cervical vertebra');
insert into cochesAdame.CATEGORIA (id_categoria, nombre, descripcion) values (9, 'Chevrolet', 'Vogt-Koyanagi syndrome, left eye');
insert into cochesAdame.CATEGORIA (id_categoria, nombre, descripcion) values (10, 'Poltec', 'Disorders of meninges, not elsewhere classified');

	CREATE TABLE cochesAdame.PRODUCTO(
	ID_PRODUCTO NUMERIC(5) UNIQUE,
	NOMBRE VARCHAR(50) UNIQUE,
	DESCRIPCION VARCHAR(150),
	PRECIO FLOAT(5,2),
	ID_CATEGORIA NUMERIC(5),
	CONSTRAINT PK_PRODUCTO PRIMARY KEY(ID_PRODUCTO),
	CONSTRAINT FK_PRODUCTO FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA(ID_CATEGORIA)
	);

insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (1, 'Avenger', 'Burn of unsp deg mult sites of right ankle and foot, subs', 38.82, 1);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (2, 'Explorer', 'Unspecified dislocation of unspecified toe(s)', 3.26, 2);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (3, 'Accord Crosstour', 'Asphyxiation due to plastic bag, assault, subs encntr', 21.81, 3);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (4, 'S90', 'Toxic effect of contact w oth venomous plant, undet, sequela', 98.25, 4);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (5, 'H1', 'Oth injury of dorsal vein of unspecified foot, init encntr', 84.15, 5);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (6, 'Sorento', 'Salter-Harris Type III physeal fracture of right calcaneus', 80.2, 6);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (7, 'LX', 'Pressure ulcer of left upper back, unstageable', 34.41, 7);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (8, 'Probe', 'Displaced pilon fx left tibia, subs for clos fx w routn heal', 82.79, 8);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (9, '100', 'Displ seg fx shaft of l femur, subs for clos fx w routn heal', 35.89, 9);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (10, 'Montego', 'Driver of 3-whl mv inj in nonclsn trnsp acc nontraf, sequela', 27.15, 10);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (11, 'Accent', 'Acquired absence of limb, unspecified', 13.71, 1);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (12, 'GTO', 'Disp fx of posterior column of right acetab, init for opn fx', 62.43, 2);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (13, 'MDX', 'Unsp inj less saphenous at lower leg level, left leg, subs', 16.78, 3);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (14, 'Dakota Club', 'Unsp injury of right quadriceps muscle, fascia and tendon', 4.07, 4);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (15, '240SX', 'Acute dilatation of stomach', 29.49, 5);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (16, 'Quattroporte', 'Acute sialoadenitis', 66.23, 6);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (17, 'Mirage', 'Nondisp fx of unsp tibial tuberosity, 7thB', 25.94, 7);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (18, 'Dakota', 'Disp fx of neck of right radius, init for opn fx type 3A/B/C', 65.13, 8);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (19, 'Azera', 'Oth fx shaft of rad, unsp arm, subs for clos fx w nonunion', 55.97, 9);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (20, 'IS-F', 'Occupant of hv veh injured in oth trnsp acc, sequela', 30.55, 10);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (21, 'Suburban 1500', 'Villonodular synovitis (pigmented), unspecified hand', 79.65, 1);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (22, 'Fury', 'Other physeal fracture of lower end of humerus', 35.15, 2);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (23, 'Grand Vitara', 'Pnctr w/o fb of r idx fngr w damage to nail, sequela', 61.86, 3);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (24, 'C8', 'Displ oblique fx shaft of r femr, 7thR', 23.21, 4);
insert into cochesAdame.PRODUCTO (id_producto, nombre, descripcion, precio, id_categoria) values (25, 'Parejo', 'Actvty, oth w oth sports & athletics played as a team or grp', 74.27, 5);

	CREATE TABLE cochesAdame.VENTA(
	ID_VENTA NUMERIC(5),
	USUARIO VARCHAR(50),
	ID_PRODUCTO NUMERIC(5),
	CANTIDAD NUMERIC(10),
	PRECIO FLOAT(5,2),
	FECHA_VENTA DATE,
	CONSTRAINT PK_VENTA PRIMARY KEY(ID_VENTA),
	CONSTRAINT FK_VENTA_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO(ID_PRODUCTO),
	CONSTRAINT FK_VENTA_USUARIO FOREIGN KEY (USUARIO) REFERENCES USUARIO(USUARIO)
	);


insert into cochesAdame.VENTA (id_venta, usuario, id_producto, cantidad, precio, fecha_venta) values (1, 'alberto', 22, 31, 19.88, '2022-06-02');
insert into cochesAdame.VENTA (id_venta, usuario, id_producto, cantidad, precio, fecha_venta) values (2, 'alberto', 10, 12, 37.72, '2022-01-18');
insert into cochesAdame.VENTA (id_venta, usuario, id_producto, cantidad, precio, fecha_venta) values (3, 'prueba', 5, 69, 31.07, '2022-01-07');
insert into cochesAdame.VENTA (id_venta, usuario, id_producto, cantidad, precio, fecha_venta) values (4, 'alberto', 8, 58, 39.97, '2022-02-09');
insert into cochesAdame.VENTA (id_venta, usuario, id_producto, cantidad, precio, fecha_venta) values (5, 'prueba', 25, 9, 6.74, '2022-09-20');

COMMIT;




GRANT ALL PRIVILEGES ON cochesAdame.* TO 'adame'@'%' identified by 'alberto';
