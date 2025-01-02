-- Crear schema de DB
CREATE SCHEMA `test_praxis` ;
use  `test_praxis` ;

-- Tabla Producto
CREATE TABLE Producto (
    id BIGINT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100),
    precio DECIMAL(10, 2) NOT NULL
);

-- Tabla Promocion
CREATE TABLE Promocion (
    id BIGINT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    porcentaje_descuento DECIMAL(5, 2) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL
);

-- Tabla Producto_Promocion (tabla intermedia para la relación muchos a muchos)
CREATE TABLE Producto_Promocion (
    producto_id BIGINT(11) NOT NULL,
    promocion_id BIGINT(11) NOT NULL,
    PRIMARY KEY (producto_id, promocion_id),
    FOREIGN KEY (producto_id) REFERENCES Producto(id),
    FOREIGN KEY (promocion_id) REFERENCES Promocion(id)
);

-- Poblar datos en las tablas
insert into `test_praxis`.`producto` (`nombre`, `descripcion`, `precio`) values ('Smartphone', null, 800.00);
insert into `test_praxis`.`promocion` (`porcentaje_descuento`, `fecha_inicio`, `fecha_fin`) values (15, '2024-12-24', '2025-01-12');
insert into `test_praxis`.`producto_promocion` (`producto_id`, `promocion_id`) values (1, 1);

insert into `test_praxis`.`producto` (`nombre`, `descripcion`, `precio`) values ('Mando X-BOX', "Mando para conectar por USB en un equipo", 1400.00);
insert into `test_praxis`.`promocion` (`porcentaje_descuento`, `fecha_inicio`, `fecha_fin`) values (25, '2025-01-06', '2025-01-31');
insert into `test_praxis`.`producto_promocion` (`producto_id`, `promocion_id`) values (2, 2);
