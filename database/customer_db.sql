-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 25, 2017 at 06:07 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `customer_db`
--
CREATE DATABASE IF NOT EXISTS `customer_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `customer_db`;

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE IF NOT EXISTS `user_table` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `POINTS` int(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`ID`, `NAME`, `EMAIL`, `PASSWORD`, `POINTS`) VALUES
(6, 'navjot_admin', 'navjotsingh9633@gmail.com', '12345678', NULL),
(15, 'nav', 'n@n', 'n', 54),
(16, 'lucky', 'l@l', 'l', 10),
(17, 'jas', 'j@j', 'j', 4),
(18, 'k', 'k@k', 'k', 14),
(19, 'y', 'y@y', 'y', 0),
(20, 'q', 'qq@q', 'q', 0),
(21, 'qqq', 'qqq@q', 'q', 0),
(22, 'eee', 'eee@ee', 'e', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
