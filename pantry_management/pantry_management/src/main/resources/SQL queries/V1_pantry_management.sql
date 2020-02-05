-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 02, 2020 at 09:30 AM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pantry_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `item_id` int(11) NOT NULL,
  `item_name` varchar(30) NOT NULL,
  `Quantity_available` int(11) NOT NULL DEFAULT '0',
  `Quantity_sold` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`item_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`item_id`, `item_name`, `Quantity_available`, `Quantity_sold`) VALUES
(1, 'chips', 3, 32),
(3, 'Coke', 11, 9);

-- --------------------------------------------------------

--
-- Table structure for table `items_bought`
--

DROP TABLE IF EXISTS `items_bought`;
CREATE TABLE IF NOT EXISTS `items_bought` (
  `Item_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `DOP` date NOT NULL,
  `Quantity` int(11) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `Item_id` (`Item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items_bought`
--

INSERT INTO `items_bought` (`Item_id`, `user_id`, `DOP`, `Quantity`) VALUES
(1, 7, '2019-12-29', 5),
(3, 1, '2019-12-29', 5),
(3, 3, '2019-12-29', 4),
(1, 1, '2019-12-29', 2),
(1, 1, '2020-02-01', 25);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `DOJ` date NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(40) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `DOJ`, `Username`, `Password`) VALUES
(1, 'Kanishk', '2020-01-08', 'kanishk', 'kanishk'),
(2, 'rahul', '2020-01-13', 'rahul', 'rahul'),
(3, 'test', '2019-12-29', 'test', 'test'),
(4, 'kanishk', '2019-12-29', 'kanishk11', 'kanishk11'),
(5, 'kanishk', '2019-12-29', 'kanisk', 'kanishk'),
(6, 'hgk', '2019-12-29', 'jkgkj', 'kgk'),
(7, 'yogesh', '2019-12-29', 'yogesh123', 'yogesh');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
