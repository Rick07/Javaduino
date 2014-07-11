-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 11-07-2014 a las 23:25:15
-- Versión del servidor: 5.5.16
-- Versión de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bioconecta`
--
DROP DATABASE `bioconecta`;
CREATE DATABASE `bioconecta` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bioconecta`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `raspberry`
--

DROP TABLE IF EXISTS `raspberry`;
CREATE TABLE IF NOT EXISTS `raspberry` (
  `mac` varchar(17) NOT NULL,
  `ubicacion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mac`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `raspberry`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `raspivideo`
--

DROP TABLE IF EXISTS `raspivideo`;
CREATE TABLE IF NOT EXISTS `raspivideo` (
  `idraspivideo` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(9) DEFAULT NULL,
  `tiempo` varchar(8) DEFAULT NULL,
  `raspimac` varchar(17) DEFAULT NULL,
  PRIMARY KEY (`idraspivideo`),
  KEY `FK_6jcpmdp52a7rpo1jk4eo6m5pd` (`raspimac`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=0 ;


--
-- Filtros para la tabla `raspivideo`
--
ALTER TABLE `raspivideo`
  ADD CONSTRAINT `FK_6jcpmdp52a7rpo1jk4eo6m5pd` FOREIGN KEY (`raspimac`) REFERENCES `raspberry` (`mac`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
