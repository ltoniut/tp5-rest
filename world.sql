-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2018 a las 08:27:59
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `world`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aeropuerto`
--

CREATE TABLE `aeropuerto` (
  `id` bigint(20) NOT NULL,
  `iata` varchar(255) NOT NULL,
  `langitud` float NOT NULL,
  `latitud` float NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `id_ciudad` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aeropuerto`
--

INSERT INTO `aeropuerto` (`id`, `iata`, `langitud`, `latitud`, `nombre`, `id_ciudad`) VALUES
(1, '333', 123, 123, 'ezeiza', 1),
(2, '4444', 435345, 7657, 'chinchulin', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabina`
--

CREATE TABLE `cabina` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cabina`
--

INSERT INTO `cabina` (`id`, `nombre`) VALUES
(1, 'Económica'),
(2, 'Business');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `id` bigint(20) NOT NULL,
  `iata` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `id_estado` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`id`, `iata`, `nombre`, `id_estado`) VALUES
(1, '432', 'mar del plata', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employees`
--

CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `designation` varchar(255) NOT NULL,
  `expertise` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `employees`
--

INSERT INTO `employees` (`id`, `created_at`, `designation`, `expertise`, `name`) VALUES
(1, '2018-05-30 00:00:00', 'asdasd', 'vcxvcx', 'pingo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `info`
--

CREATE TABLE `info` (
  `id` bigint(20) NOT NULL,
  `browser` varchar(255) DEFAULT NULL,
  `fecha_hora` tinyblob,
  `op` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informacion`
--

CREATE TABLE `informacion` (
  `id` bigint(20) NOT NULL,
  `browser` varchar(255) DEFAULT NULL,
  `fecha_hora` tinyblob,
  `op` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `id` bigint(20) NOT NULL,
  `iso` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`id`, `iso`, `nombre`) VALUES
(1, 'ewq12', 'asd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precio`
--

CREATE TABLE `precio` (
  `id` bigint(20) NOT NULL,
  `desde` varchar(255) NOT NULL,
  `precio` bigint(20) NOT NULL,
  `hasta` varchar(255) NOT NULL,
  `id_cabina_x_nombre` bigint(20) DEFAULT NULL,
  `ruta` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `precio`
--

INSERT INTO `precio` (`id`, `desde`, `precio`, `hasta`, `id_cabina_x_nombre`, `ruta`) VALUES
(1, '23/4/2018', 200, '29/4/2018', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `id` bigint(20) NOT NULL,
  `iata` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `id_pais` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`id`, `iata`, `nombre`, `id_pais`) VALUES
(1, '432', 'san luis', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ruta`
--

CREATE TABLE `ruta` (
  `id` bigint(20) NOT NULL,
  `distancia` int(11) NOT NULL,
  `origen_id` bigint(20) DEFAULT NULL,
  `destino_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ruta`
--

INSERT INTO `ruta` (`id`, `distancia`, `origen_id`, `destino_id`) VALUES
(1, 2000, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `sex` char(10) NOT NULL,
  `dob` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `section` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `firstAttempt` tinyint(1) NOT NULL,
  `subjects` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `student`
--

INSERT INTO `student` (`id`, `firstName`, `lastName`, `sex`, `dob`, `email`, `section`, `country`, `firstAttempt`, `subjects`) VALUES
(1, 'marco', 'polo', 'M', '2018-05-22', 'asd@asad.com', 'Graduate', 'FRANCE', 1, 'Computer Science,Mathmatics'),
(3, 'qqqqa', 'sss', 'F', '2016-05-22', 'francobostian@gmail.com', 'Graduate', 'USA', 0, 'Political Science'),
(4, 'qqzz', 'zzqqq', 'M', '1999-12-12', 'coca@cola.com', 'Research', 'USA', 0, 'Physics'),
(5, 'qqzz', 'zzqqq', 'M', '2016-05-22', 'zxc@vfd.com', 'Post Graduate', 'INDIA', 0, 'Mathmatics'),
(6, 'qqqqa', 'polo', 'F', '2016-05-22', 'zxc@cds.com', 'Post Graduate', 'GERMANY', 0, 'Political Science'),
(7, 'ddd', 'dddddd', 'F', '2016-05-22', 'francobostian@gmail.com', 'Research', 'USA', 0, 'Life Science'),
(8, 'zzzz', 'zzz', 'F', '1999-12-12', 'qwe@qwe.com', 'Post Graduate', 'ITALY', 0, 'Political Science'),
(9, 'ddssdas', 'sdassd', 'F', '2015-03-25', 'zxc@vfd.com', 'Post Graduate', 'GERMANY', 0, 'Life Science');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aeropuerto`
--
ALTER TABLE `aeropuerto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKaw4khhvymut34w8wu9xgn655` (`id_ciudad`);

--
-- Indices de la tabla `cabina`
--
ALTER TABLE `cabina`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhpas0dqhxraie9uxfkx4lpm8p` (`id_estado`);

--
-- Indices de la tabla `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `info`
--
ALTER TABLE `info`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `informacion`
--
ALTER TABLE `informacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `precio`
--
ALTER TABLE `precio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4mlpsj0ndbk9lfkq4gukmu6it` (`id_cabina_x_nombre`),
  ADD KEY `FKfanj5k4196k347jx584gntg85` (`ruta`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp37jnxd9htn7o8v195jm4uvre` (`id_pais`);

--
-- Indices de la tabla `ruta`
--
ALTER TABLE `ruta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgshs1aosp9t8csyw9annpsqio` (`origen_id`),
  ADD KEY `FK6nrh3wuf3kjmwreuim244l6e1` (`destino_id`);

--
-- Indices de la tabla `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `employees`
--
ALTER TABLE `employees`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `info`
--
ALTER TABLE `info`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `informacion`
--
ALTER TABLE `informacion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
