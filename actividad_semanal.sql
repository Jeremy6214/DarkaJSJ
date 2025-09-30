-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-09-2025 a las 21:33:08
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `darkaischool`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad_semanal`
--

CREATE TABLE `actividad_semanal` (
  `id` bigint(20) NOT NULL,
  `dia_semana` int(11) NOT NULL,
  `horas` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `actividad_semanal`
--

INSERT INTO `actividad_semanal` (`id`, `dia_semana`, `horas`) VALUES
(1, 1, 7),
(2, 0, 24),
(4, 2, 10),
(5, 3, 5),
(6, 4, 2),
(7, 5, 1),
(8, 6, 7),
(9, 7, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividad_semanal`
--
ALTER TABLE `actividad_semanal`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividad_semanal`
--
ALTER TABLE `actividad_semanal`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
