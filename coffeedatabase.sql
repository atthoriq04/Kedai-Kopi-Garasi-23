-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 20, 2022 at 05:20 PM
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
  `Jumlah` int(11) NOT NULL DEFAULT '0',
  `patokanRestok` int(11) NOT NULL DEFAULT '1',
  `Status` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`idInventory`, `idKategori`, `namaBarang`, `Jumlah`, `patokanRestok`, `Status`) VALUES
(1, 3, 'Oreo', 52, 13, 1),
(2, 2, 'Lecy Syrup', 600, 200, 1),
(3, 2, 'Tiramisu', 200, 100, 1),
(4, 1, 'Arabica', 300, 100, 1);

-- --------------------------------------------------------

--
-- Table structure for table `inventorycategory`
--

CREATE TABLE `inventorycategory` (
  `idKategori` int(11) NOT NULL,
  `Kategori` varchar(50) NOT NULL,
  `Satuan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inventorycategory`
--

INSERT INTO `inventorycategory` (`idKategori`, `Kategori`, `Satuan`) VALUES
(1, 'Gram', 'Gr'),
(2, 'Mili Litter', 'Ml'),
(3, 'Pieces', 'pcs');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `idMenu` int(11) NOT NULL,
  `idKategori` int(11) NOT NULL,
  `Menu` varchar(100) NOT NULL,
  `Harga` int(11) NOT NULL,
  `Active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`idMenu`, `idKategori`, `Menu`, `Harga`, `Active`) VALUES
(1, 1, 'Kopi Sobat (Hazelnut)', 16000, 1),
(2, 1, 'Kopi Bestie (Caramel)', 16000, 1),
(3, 1, 'Kopi Sohib (Vanilla)', 16000, 1),
(4, 1, 'Kopi Konco (Tiramisu)', 16000, 1),
(5, 1, 'Kopi D\'Java (Gula Aren)', 16000, 1),
(6, 1, 'Kopi Sedulur (Pandan)', 16000, 1),
(7, 1, 'Cappucino - Hot', 15000, 1),
(8, 1, 'Cappucino - Ice', 16000, 1),
(9, 2, 'Rockberry', 15000, 1),
(10, 2, 'Deep Purple', 15000, 1),
(11, 2, 'Apple Drop ', 15000, 1),
(12, 2, 'Irish Vibe\r\n', 15000, 1),
(13, 2, 'Lychee Fantasy', 15000, 1),
(14, 2, 'Lemonade', 15000, 1),
(15, 2, 'Kiwi Dreams', 15000, 1),
(16, 3, 'Red Lava', 15000, 1),
(17, 3, 'Matcha', 15000, 1),
(18, 3, 'Chocho Retro', 15000, 1),
(19, 3, 'Little Taro', 15000, 1),
(20, 3, 'Vanilla Oreo', 16000, 1),
(21, 3, 'Pinkberry', 16000, 1),
(22, 4, 'V60', 15000, 1),
(23, 4, 'Japanesse', 16000, 1),
(24, 4, 'Americano - Hot', 13000, 1),
(25, 4, 'Americano - Ice', 15000, 1),
(26, 4, 'Kopi Tubruk', 13000, 1),
(27, 5, 'BlueBerry', 15000, 1),
(28, 5, 'Strawberry', 15000, 1),
(29, 6, 'Strawberry tea', 13000, 1),
(30, 6, 'Lemon tea ', 13000, 1),
(31, 6, 'Lychee Tea', 13000, 1),
(32, 7, 'Indomie Rebus Single', 7500, 1),
(33, 7, 'Indomie Goreng Single', 7500, 1);

-- --------------------------------------------------------

--
-- Table structure for table `menucategory`
--

CREATE TABLE `menucategory` (
  `idKategori` int(11) NOT NULL,
  `KategoriMenu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menucategory`
--

INSERT INTO `menucategory` (`idKategori`, `KategoriMenu`) VALUES
(1, 'Signature'),
(2, 'Mocktail'),
(3, 'Milk Series'),
(4, 'Black Cofee'),
(5, 'Yakult'),
(6, 'Tea'),
(7, 'Makanan');

-- --------------------------------------------------------

--
-- Table structure for table `restok`
--

CREATE TABLE `restok` (
  `idRestok` int(11) NOT NULL,
  `Tanggal` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idInventory` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restok`
--

INSERT INTO `restok` (`idRestok`, `Tanggal`, `idInventory`, `jumlah`) VALUES
(2, '2022-12-19 21:05:45', 1, 13),
(3, '2022-12-19 21:05:45', 2, 400),
(4, '2022-12-20 20:17:45', 3, 100),
(5, '2022-12-20 20:17:45', 1, 26),
(6, '2022-12-20 21:12:29', 4, 200),
(7, '2022-12-20 21:13:26', 1, 13),
(8, '2022-12-20 21:13:26', 2, 200),
(9, '2022-12-20 21:13:26', 3, 100),
(10, '2022-12-20 21:13:26', 4, 100);

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
  `Nama` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` char(244) NOT NULL,
  `role` int(1) NOT NULL,
  `userActive` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `Nama`, `username`, `password`, `role`, `userActive`) VALUES
(6, 'Admini', 'admin', '58acb7acccce58ffa8b953b12b5a7702bd42dae441c1ad85057fa70b', 1, 1),
(8, 'AtthoriqAziz', 'AtthoriqAziz', '5874109ebd0afedb9eb96b3995a40801da7672d0c332bb85987f53c8', 1, 1),
(9, 'Dimas Kanjeng', 'DimasKanjeng', '99c1850975b1c2c545ad7e4fc84aef55fcf94250675cb493f7ae897b', 2, 1),
(10, 'Bumi Putera', 'BumiPutera', '929a47b7cee800ce11dba820ca5017cd42dc8fea5df4d3959b161767', 1, 2),
(12, 'Sarimanko Ayaka', 'SarimankoAyaka', '3f908544c0104a75a8f4caec12be3892d57a15ab47b449d5b0b24f49', 2, 1),
(13, 'Sarigenaku Aaya', 'SarigenakuAaya', '632e5d141a815d997d6be741e2ef6414869a063f97396fb5aacf1b0f', 1, 1);

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
-- Indexes for table `inventorycategory`
--
ALTER TABLE `inventorycategory`
  ADD PRIMARY KEY (`idKategori`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`idMenu`);

--
-- Indexes for table `menucategory`
--
ALTER TABLE `menucategory`
  ADD PRIMARY KEY (`idKategori`);

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
  MODIFY `idInventory` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `inventorycategory`
--
ALTER TABLE `inventorycategory`
  MODIFY `idKategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `idMenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `menucategory`
--
ALTER TABLE `menucategory`
  MODIFY `idKategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `restok`
--
ALTER TABLE `restok`
  MODIFY `idRestok` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `securityquestion`
--
ALTER TABLE `securityquestion`
  MODIFY `sqId` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `usersq`
--
ALTER TABLE `usersq`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
