SQL

CREATE DATABASE `guarderia`;


CREATE TABLE `infantes` (
  `numeromatricula` varchar(40) NOT NULL,
  `nombreinfante` varchar(200) DEFAULT NULL,
  `infante_fecha_nacimineto` varchar(10) DEFAULT NULL,
  `fecha_ingreso_guarderia` varchar(10) DEFAULT NULL,
  `fecha_de_baja` varchar(15) DEFAULT NULL,
  `alergias_infante` text DEFAULT NULL,
  `acudiente_dni` varchar(10) DEFAULT NULL,
  `acudiente_nombre` varchar(200) DEFAULT NULL,
  `acudiente_direccion` text DEFAULT NULL,
  `acudiente_telefono` varchar(10) DEFAULT NULL,
  `relacion_infanteacu` text DEFAULT NULL,
  `coste_dni` varchar(10) DEFAULT NULL,
  `costea_nombre` varchar(200) DEFAULT NULL,
  `coste_direccion` text DEFAULT NULL,
  `costea_telefono` varchar(10) DEFAULT NULL,
  `costea_numero_cueta` text DEFAULT NULL,
  PRIMARY KEY (`numeromatricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




CREATE TABLE `menus` (
  `numero_menu` varchar(10) NOT NULL,
  `nombre_platos` text DEFAULT NULL,
  `costo_menu` varchar(100) DEFAULT NULL,
  `costo_de_platos` text DEFAULT NULL,
  `ingredientes` text DEFAULT NULL,
  PRIMARY KEY (`numero_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




CREATE TABLE `consumos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numeromatricula` varchar(40) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `numero_menu` varchar(10) NOT NULL,
  `costo_menu` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nmatricula` (`numeromatricula`),
  KEY `fk_numenu` (`numero_menu`),
  CONSTRAINT `fk_nmatricula` FOREIGN KEY (`numeromatricula`) REFERENCES `infantes` (`numeromatricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_numenu` FOREIGN KEY (`numero_menu`) REFERENCES `menus` (`numero_menu`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;