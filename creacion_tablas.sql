-- tables
-- Table: clientes
CREATE TABLE clientes (
    id_cliente serial  NOT NULL,
    correo varchar(100)  NOT NULL,
    password varchar(100)  NOT NULL,
    estado int  NOT NULL,
    nombres varchar(100)  NOT NULL,
    apellidos varchar(100)  NOT NULL,
    fecha_nacimiento date  NOT NULL,
    telefono varchar(50)  NOT NULL,
    direccion varchar(100),
    PRIMARY KEY (id_cliente)
);

-- Table: roles
CREATE TABLE roles (
    id_rol serial  NOT NULL,
    rol varchar(100)  NOT NULL,
    PRIMARY KEY (id_rol)
);

-- Table: usuarios
CREATE TABLE usuarios (
    id_usuario serial  NOT NULL,
    id_rol int  NOT NULL,
    usuario varchar(100)  NOT NULL,
    password varchar(100)  NOT NULL,
    estado int  NOT NULL,
    nombres varchar(100)  NOT NULL,
    apellidos varchar(100)  NOT NULL,
    email varchar(100)  NOT NULL,
    CI varchar(50)  NOT NULL,
    telefono varchar(50)  NOT NULL,
	foreign key (id_rol) references roles,
    PRIMARY KEY (id_usuario)
);