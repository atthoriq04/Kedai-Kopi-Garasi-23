-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 05, 2022 at 05:13 PM
-- Server version: 5.7.24
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffeedatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `idInventory` int(11) NOT NULL,
  `idKategori` int(11) NOT NULL,
  `namaBarang` varchar(50) NOT NULL,
  `Jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `kategori_inventory`
--

CREATE TABLE `kategori_inventory` (
  `idKategori` int(11) NOT NULL,
  `Kategori` varchar(50) NOT NULL,
  `Satuan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `kategori_menu`
--

CREATE TABLE `kategori_menu` (
  `idKategori` int(11) NOT NULL,
  `KategoriMenu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kategori_menu`
--

INSERT INTO `kategori_menu` (`idKategori`, `KategoriMenu`) VALUES
(1, 'Signature'),
(2, 'Mocktail'),
(3, 'Milk Series'),
(4, 'Black Cofee'),
(5, 'Yakult'),
(6, 'Tea'),
(7, 'Makanan');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `idMenu` int(11) NOT NULL,
  `idKategori` int(11) NOT NULL,
  `Menu` varchar(100) NOT NULL,
  `Harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`idMenu`, `idKategori`, `Menu`, `Harga`) VALUES
(1, 1, 'Kopi Sobat (Hazelnut)', 16000),
(2, 1, 'Kopi Bestie (Caramel)', 16000),
(3, 1, 'Kopi Sohib (Vanilla)', 16000),
(4, 1, 'Kopi Konco (Tiramisu)', 16000),
(5, 1, 'Kopi D\'Java (Gula Aren)', 16000),
(6, 1, 'Kopi Sedulur (Pandan)', 16000),
(7, 1, 'Cappucino - Hot', 15000),
(8, 1, 'Cappucino - Ice', 16000),
(9, 2, 'Rockberry', 15000),
(10, 2, 'Deep Purple', 15000),
(11, 2, 'Apple Drop ', 15000),
(12, 2, 'Irish Vibe\r\n', 15000),
(13, 2, 'Lychee Fantasy', 15000),
(14, 2, 'Lemonade', 15000),
(15, 2, 'Kiwi Dreams', 15000),
(16, 3, 'Red Lava', 15000),
(17, 3, 'Matcha', 15000),
(18, 3, 'Chocho Retro', 15000),
(19, 3, 'Little Taro', 15000),
(20, 3, 'Vanilla Oreo', 16000),
(21, 3, 'Pinkberry', 16000),
(22, 4, 'V60', 15000),
(23, 4, 'Japanesse', 16000),
(24, 4, 'Americano - Hot', 13000),
(25, 4, 'Americano - Ice', 15000),
(26, 4, 'Kopi Tubruk', 13000),
(27, 5, 'BlueBerry', 15000),
(28, 5, 'Strawberry', 15000),
(29, 6, 'Strawberry tea', 13000),
(30, 6, 'Lemon tea ', 13000),
(31, 6, 'Lychee Tea', 13000);

-- --------------------------------------------------------

--
-- Table structure for table `restok`
--

CREATE TABLE `restok` (
  `idRestok` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `idInventory` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `securityquestion`
--

CREATE TABLE `securityquestion` (
  `sqId` int(12) NOT NULL,
  `sQuestion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `securityquestion`
--

INSERT INTO `securityquestion` (`sqId`, `sQuestion`) VALUES
(1, 'Masukan 5 Digit Angka Keamanan Anda'),
(2, 'Siapa Nama Hewan Peliharaan Anda?'),
(3, 'Apa Warna Favorit Anda?'),
(4, 'Apa Makanan Favorit Anda?'),
(5, 'Di Mana Tempat Lahir Anda?'),
(6, 'Apa Film Favorit Anda?'),
(7, 'Apa Olahraga Favorit Anda?');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` char(244) NOT NULL,
  `role` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES
(6, 'admin', '58acb7acccce58ffa8b953b12b5a7702bd42dae441c1ad85057fa70b', 1);

-- --------------------------------------------------------

--
-- Table structure for table `usersq`
--

CREATE TABLE `usersq` (
  `id` int(5) NOT NULL,
  `UserId` int(5) NOT NULL,
  `sqId` int(5) NOT NULL,
  `Answer` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usersq`
--

INSERT INTO `usersq` (`id`, `UserId`, `sqId`, `Answer`) VALUES
(1, 6, 1, '232d1fa11c274153938d24515a520557e75093f2b6d8cad775c5886b'),
(2, 6, 3, 'Biru'),
(3, 6, 6, 'Interstellar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`idInventory`);

--
-- Indexes for table `kategori_inventory`
--
ALTER TABLE `kategori_inventory`
  ADD PRIMARY KEY (`idKategori`);

--
-- Indexes for table `kategori_menu`
--
ALTER TABLE `kategori_menu`
  ADD PRIMARY KEY (`idKategori`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`idMenu`);

--
-- Indexes for table `restok`
--
ALTER TABLE `restok`
  ADD PRIMARY KEY (`idRestok`);

--
-- Indexes for table `securityquestion`
--
ALTER TABLE `securityquestion`
  ADD PRIMARY KEY (`sqId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usersq`
--
ALTER TABLE `usersq`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `idInventory` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kategori_inventory`
--
ALTER TABLE `kategori_inventory`
  MODIFY `idKategori` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kategori_menu`
--
ALTER TABLE `kategori_menu`
  MODIFY `idKategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `idMenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `restok`
--
ALTER TABLE `restok`
  MODIFY `idRestok` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `securityquestion`
--
ALTER TABLE `securityquestion`
  MODIFY `sqId` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `usersq`
--
ALTER TABLE `usersq`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
