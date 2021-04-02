-- tables
-- Table: clientes
CREATE TABLE clientes (
    id_cliente serial  NOT NULL,
    correo varchar(100)  NOT NULL,
    password varchar(100)  NOT NULL,
    estado boolean  NOT NULL,
    nombres varchar(100)  NOT NULL,
    apellidos varchar(100)  NOT NULL,
    fecha_nacimiento date,
    telefono varchar(50),
    direccion varchar(100)  NOT NULL,
    PRIMARY KEY (id_cliente)
);

-- Table: roles
CREATE TABLE roles (
    id_rol serial  NOT NULL,
    rol varchar(50)  NOT NULL,
    CONSTRAINT roles_pk PRIMARY KEY (id_rol)
);

-- Table: usuarios
CREATE TABLE usuarios (
    id_usuario serial  NOT NULL,
    username varchar(50)  NOT NULL,
    password varchar(50)  NOT NULL,
    estado boolean  NOT NULL,
    nombres varchar(100)  NOT NULL,
    apellidos varchar(100)  NOT NULL,
    email varchar(100),
    CI varchar(50),
    telefono varchar(50)  NOT NULL,
    PRIMARY KEY (id_usuario)
);

-- Table: roles_usuarios
CREATE TABLE roles_usuarios (
    	id_rol int  NOT NULL,
    	id_usuario int  NOT NULL,
	foreign key (id_rol) references roles,
	foreign key (id_usuario) references usuarios
);