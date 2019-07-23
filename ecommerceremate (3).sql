-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-07-2019 a las 15:05:28
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ecommerceremate`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `visible` tinyint(1) DEFAULT '1',
  `categoriapadre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`, `visible`, `categoriapadre`) VALUES
(1, 'EDUCACIÓN', 1, 0),
(2, 'DEPORTE', 1, 0),
(3, 'MÓVILES', 1, 0),
(4, 'HOGAR', 1, 0),
(5, 'ELECTROHOGAR', 1, 0),
(6, 'BOLÍGRAFOS', 1, 1),
(7, 'CUADERNOS', 1, 1),
(8, 'LAPTOP', 1, 1),
(9, 'PAPELERÍA', 1, 1),
(10, 'LIBROS', 1, 1),
(11, 'ZAPATILAS', 1, 2),
(12, 'CINTA ADICIVA', 1, 2),
(13, 'CELULARES', 1, 3),
(14, 'TABLET', 1, 3),
(15, 'MUEBLES', 1, 4),
(16, 'ARTICULOS DE BAÑO', 1, 4),
(17, 'LINEA BLANCA ', 1, 5),
(18, 'CLIMATIZACIÓN', 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `appaterno` varchar(60) DEFAULT NULL,
  `apmaterno` varchar(60) DEFAULT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `sexo` varchar(20) DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `fecharegistro` datetime DEFAULT NULL,
  `iddistrito` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `appaterno`, `apmaterno`, `nombre`, `telefono`, `sexo`, `fechanacimiento`, `fecharegistro`, `iddistrito`) VALUES
(1, 'QUISPE', 'BAUTISTA', 'PELAYO', '921290945', 'v', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleorden`
--

CREATE TABLE `detalleorden` (
  `id` int(11) NOT NULL,
  `idproducto` int(11) DEFAULT NULL,
  `idorden` int(11) DEFAULT NULL,
  `precio` decimal(7,2) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distrito`
--

CREATE TABLE `distrito` (
  `id` int(11) NOT NULL,
  `denominacion` varchar(60) DEFAULT NULL,
  `ubigeo` varchar(20) DEFAULT NULL,
  `provincia_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

CREATE TABLE `imagen` (
  `id` int(11) NOT NULL,
  `nombre` varchar(80) DEFAULT NULL,
  `prioridad` int(11) DEFAULT '1',
  `idproducto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`id`, `nombre`, `prioridad`, `idproducto`) VALUES
(1, 'producto0001.png', 1, 1),
(2, 'producto0002.png', 1, 2),
(3, 'producto0003.png', 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `correo` varchar(80) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT '1',
  `idtipousuario` int(11) DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`id`, `correo`, `password`, `estado`, `idtipousuario`, `idcliente`) VALUES
(2, 'sistemas.19@gmail.com', '12345', 1, 1, 1),
(3, 'sistemas@gmail.com', '12345', 1, NULL, NULL),
(4, 'sistemas@gmail.com', '123', 1, NULL, NULL),
(5, 'sistemas@gmail.com', '1234', 1, NULL, NULL),
(6, 'pelayo@gmail.com', '1234567', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `id` int(11) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `visible` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`id`, `nombre`, `visible`) VALUES
(1, 'Imaco', 0),
(2, 'Lenovo', 1),
(3, 'Nike', 1),
(4, 'Adidas', 1),
(5, 'hp', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

CREATE TABLE `orden` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `fechacreacion` date DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  `idlogin` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `precio` decimal(7,2) DEFAULT NULL,
  `precionuevo` decimal(7,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `nuevo` tinyint(1) DEFAULT '1',
  `recomendado` tinyint(1) DEFAULT '0',
  `descripcion` text,
  `visible` tinyint(1) DEFAULT '1',
  `idcategoria` int(11) DEFAULT NULL,
  `idmarca` int(11) DEFAULT NULL,
  `urlimagen` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `precio`, `precionuevo`, `stock`, `nuevo`, `recomendado`, `descripcion`, `visible`, `idcategoria`, `idmarca`, `urlimagen`) VALUES
(1, 'Remate De Tazas Blancas Para Sublimar ', '3.00', '2.00', 4, 1, 1, 'TAZAS BLANCAS PARA SUBLIMAR CALIDAD B A SOLO 2.70', 1, 5, 1, 'producto0001.png'),
(2, 'Cortador de frutas y verduras de acero ', '56.00', '32.00', 6, 1, 0, '-Esta cortadora manual ofrece todas las funciones de múltiples aparatos con 6 Cuchillas intercambiables', 1, 3, NULL, 'producto0002.png'),
(3, 'Remato Sandwichera Grill Antiadherente ', '100.00', '55.00', 3, 0, 1, 'Sandwichera Grill anti-adherente Imaco!!!', 1, 5, NULL, 'producto0003.png'),
(4, 'Hervidor Kitchenaid 1.7 Lt Caja Sellada ', '300.00', '350.00', 2, 1, 0, 'Hervidor KitchenAid Eléctrico 5KEK1722EER', 0, 5, NULL, 'producto0004.png'),
(5, 'Lenovo Thinkpad T430 Ultimas En Remate', '1500.00', '900.00', 1, 1, 0, 'Laptop Lenovo T430 Core I5 de 3era Generación.', 1, 1, NULL, 'producto0005.png'),
(6, 'Remato Lenovo G50-80 I5', '2000.00', '150.00', 2, 0, 1, 'Intel Core i5-5200U 2.20GHz (2.7GHz)', 1, 1, NULL, 'producto0006.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `id` int(11) NOT NULL,
  `denominacion` varchar(60) DEFAULT NULL,
  `ubigeo` varchar(10) DEFAULT NULL,
  `region_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `region`
--

CREATE TABLE `region` (
  `id` int(11) NOT NULL,
  `denominacion` varchar(60) DEFAULT NULL,
  `ubigeo` char(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revision`
--

CREATE TABLE `revision` (
  `id` int(11) NOT NULL,
  `comentario` varchar(200) DEFAULT NULL,
  `estrellas` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `idproducto` int(11) DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

CREATE TABLE `tipousuario` (
  `id` int(11) NOT NULL,
  `tipo` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipousuario`
--

INSERT INTO `tipousuario` (`id`, `tipo`) VALUES
(1, 'Administrador'),
(2, 'Cliente');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `iddistrito` (`iddistrito`);

--
-- Indices de la tabla `detalleorden`
--
ALTER TABLE `detalleorden`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idproducto` (`idproducto`),
  ADD KEY `idorden` (`idorden`);

--
-- Indices de la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `provincia_id` (`provincia_id`);

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idproducto` (`idproducto`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idtipousuario` (`idtipousuario`),
  ADD KEY `idcliente` (`idcliente`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `orden`
--
ALTER TABLE `orden`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idlogin` (`idlogin`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idcategoria` (`idcategoria`),
  ADD KEY `idmarca` (`idmarca`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `region_id` (`region_id`);

--
-- Indices de la tabla `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `revision`
--
ALTER TABLE `revision`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idproducto` (`idproducto`),
  ADD KEY `idcliente` (`idcliente`);

--
-- Indices de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `detalleorden`
--
ALTER TABLE `detalleorden`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `distrito`
--
ALTER TABLE `distrito`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `imagen`
--
ALTER TABLE `imagen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `orden`
--
ALTER TABLE `orden`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `provincia`
--
ALTER TABLE `provincia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `region`
--
ALTER TABLE `region`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `revision`
--
ALTER TABLE `revision`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`iddistrito`) REFERENCES `distrito` (`id`);

--
-- Filtros para la tabla `detalleorden`
--
ALTER TABLE `detalleorden`
  ADD CONSTRAINT `detalleorden_ibfk_1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `detalleorden_ibfk_2` FOREIGN KEY (`idorden`) REFERENCES `orden` (`id`);

--
-- Filtros para la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD CONSTRAINT `distrito_ibfk_1` FOREIGN KEY (`provincia_id`) REFERENCES `provincia` (`id`);

--
-- Filtros para la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD CONSTRAINT `imagen_ibfk_1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`idtipousuario`) REFERENCES `tipousuario` (`id`),
  ADD CONSTRAINT `login_ibfk_2` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `orden`
--
ALTER TABLE `orden`
  ADD CONSTRAINT `orden_ibfk_1` FOREIGN KEY (`idlogin`) REFERENCES `login` (`id`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`id`);

--
-- Filtros para la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD CONSTRAINT `provincia_ibfk_1` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`);

--
-- Filtros para la tabla `revision`
--
ALTER TABLE `revision`
  ADD CONSTRAINT `revision_ibfk_1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `revision_ibfk_2` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
