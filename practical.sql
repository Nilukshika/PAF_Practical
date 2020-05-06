-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 08:59 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `practical`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `DocID` int(11) NOT NULL,
  `DocName` varchar(200) NOT NULL,
  `DocNIC` varchar(11) NOT NULL,
  `Gender` varchar(11) NOT NULL,
  `ReqNo` int(11) NOT NULL,
  `Specialized` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`DocID`, `DocName`, `DocNIC`, `Gender`, `ReqNo`, `Specialized`, `Email`) VALUES
(4, 'Dr.Nalinda', '34567281V', 'Male', 1234, 'skin Specialized', 'Nalin@gmail.com'),
(5, 'Dr.Sathmini', '897645231V', 'Female', 4567, 'Children\'s Specialized', 'sathmini@gmail.com'),
(6, 'Dr.Gamini+perera', '45872343V', 'male', 6547, 'Hair%2BSpecialized', 'Gamini.i%2540gmail.com'),
(7, 'Dr.malithi Desliva', '956784361V', 'Female', 5678, 'brand Specialized', 'malithi.D@gmail.com'),
(8, 'Dr.nipunika+', '2346865V', 'Female', 3245, 'Children\'s', 'Nipuni.l%40gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`DocID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `DocID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
