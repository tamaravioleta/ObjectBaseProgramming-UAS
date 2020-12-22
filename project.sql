-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2020 at 02:12 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` varchar(20) NOT NULL,
  `namaproduk` varchar(50) NOT NULL,
  `jumlah` varchar(30) NOT NULL,
  `harga` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`id`, `namaproduk`, `jumlah`, `harga`) VALUES
('001', 'Gula', '1kg', 20000),
('002', 'Beras', '1kg', 80000),
('003', 'Susu Kental Manis', '500 ml', 17000),
('004', 'Minyak Goreng ', '1 Liter', 25000),
('005', 'Indomie Kuah', '1 Dus (12pcs)', 26000),
('006', 'Indomie Goreng', '1 Dus (12pcs)', 26000),
('007', 'Kecap Manis', '500 ml', 15000),
('008', 'Kecap Asin', '500 ml', 15000),
('009', 'Telur Bebek', '5 Butir', 15000),
('010', 'Telur Ayam', '5 Butir', 12000),
('011', 'Tepung Tapioka', '500 gram', 12000),
('012', 'Tepung Segitiga', '500 gram', 12000),
('013', 'Teh Sari Murni', '1 Box (15pcs)', 7500),
('014', 'Kopi Kapal', '500 Gram', 15000),
('015', 'Garam', '500 Gram', 12000),
('016', 'Sirup Marja', '500 ml', 21000);

-- --------------------------------------------------------

--
-- Table structure for table `dataregis`
--

CREATE TABLE `dataregis` (
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dataregis`
--

INSERT INTO `dataregis` (`firstname`, `lastname`, `gender`, `username`, `email`, `password`, `id`) VALUES
('tamara', 'violeta', 'female', 'admin', 'tamara@gmail.com', 'admin', '003'),
('arthur', 'marunduh', 'Male', 'arthur06', 'marunduh@gmail.com', 'asdasd', '1');

-- --------------------------------------------------------

--
-- Table structure for table `keranjang`
--

CREATE TABLE `keranjang` (
  `idcart` varchar(10) NOT NULL,
  `namaproduk` varchar(30) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `namaproduk` (`namaproduk`);

--
-- Indexes for table `dataregis`
--
ALTER TABLE `dataregis`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Username` (`username`);

--
-- Indexes for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD PRIMARY KEY (`idcart`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
