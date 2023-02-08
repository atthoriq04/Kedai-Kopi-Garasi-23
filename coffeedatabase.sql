-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 08, 2023 at 04:21 AM
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
-- Table structure for table `akses`
--

CREATE TABLE `akses` (
  `idAkses` int(11) NOT NULL,
  `NamaAkses` varchar(60) NOT NULL,
  `Admin` int(11) NOT NULL,
  `Karyawan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `akses`
--

INSERT INTO `akses` (`idAkses`, `NamaAkses`, `Admin`, `Karyawan`) VALUES
(1, 'Data Menu', 1, 0),
(2, 'Resep', 1, 0),
(3, 'Data Stok', 1, 0),
(4, 'Data Supplier', 1, 0),
(5, 'Pengaturan', 1, 0),
(6, 'Data User', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `idInventory` int(11) NOT NULL,
  `Satuan` varchar(100) NOT NULL,
  `namaBarang` varchar(50) NOT NULL,
  `Jumlah` int(11) NOT NULL DEFAULT '0',
  `patokanRestok` int(11) NOT NULL DEFAULT '1',
  `Status` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`idInventory`, `Satuan`, `namaBarang`, `Jumlah`, `patokanRestok`, `Status`) VALUES
(1, 'ml', 'Sirup Trieste', 1950, 650, 1),
(2, 'ml', 'Sirup Gula Aren', 1200, 1200, 1),
(3, 'ml', 'Sirup Pandan', 1300, 650, 1),
(4, 'ml', 'Sirup Taro', 650, 650, 1),
(5, 'ml', 'Sirup Red Velvet', 650, 650, 1),
(7, 'ml', 'Sirup Lemonade', 650, 650, 1),
(8, 'ml', 'Sirup Strawberry', 535, 650, 1),
(9, 'ml', 'Simple Sirup', 2000, 1000, 1),
(10, 'ml', 'Creamer', 1000, 1000, 1),
(11, 'ml', 'Soda', 1800, 1800, 1),
(12, 'gr', 'Arabika', 152, 200, 1),
(13, 'gr', 'Robusta', 1000, 1000, 1),
(14, 'pcs', 'Yakult', 19, 5, 1),
(15, 'gr', 'Daun Teh', 970, 1000, 1),
(16, 'pcs', 'Oreo', 54, 12, 1),
(17, 'pcs', 'Indomie Goreng', 40, 40, 1),
(18, 'pcs', 'Indomie Rebus', 40, 40, 1),
(19, 'ml', 'Susu Full Cream', 1000, 1000, 1),
(20, 'gr', 'Selai Blueberry', 300, 300, 1),
(21, 'ml', 'Sirup Lychee', 650, 650, 1);

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
(1, 1, 'Kopi Sobat (Hazelnut)', 13000, 1),
(2, 1, 'Kopi Bestie (Caramel)', 16000, 1),
(3, 1, 'Kopi Sohib (Vanilla)', 16000, 1),
(4, 1, 'Kopi Konco (Tiramisu)', 16000, 1),
(5, 1, 'Kopi DJava (Gula Aren)', 16000, 1),
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
(33, 7, 'Indomie Goreng Single', 7500, 1),
(34, 7, 'Indomie Rebus Double', 15000, 1),
(35, 7, 'Indomie Goreng Double', 15000, 1),
(36, 7, 'Kentang Goreng', 7000, 1);

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
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `idPenjualan` int(11) NOT NULL,
  `idMenu` int(11) NOT NULL,
  `tanggal` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `jumlah` int(11) NOT NULL,
  `pendapatan` varchar(100) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`idPenjualan`, `idMenu`, `tanggal`, `jumlah`, `pendapatan`, `idUser`) VALUES
(1, 29, '2023-01-29 15:53:58', 1, '13000', 6),
(2, 22, '2023-01-29 15:54:18', 3, '45000', 6),
(3, 28, '2023-01-29 15:54:30', 1, '15000', 6),
(4, 22, '2023-02-08 09:40:24', 1, '15000', 8);

-- --------------------------------------------------------

--
-- Table structure for table `resep`
--

CREATE TABLE `resep` (
  `id` int(11) NOT NULL,
  `idMenu` int(11) NOT NULL,
  `idInventory` int(11) NOT NULL,
  `dibutuhkan` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `resep`
--

INSERT INTO `resep` (`id`, `idMenu`, `idInventory`, `dibutuhkan`) VALUES
(1, 22, 12, 12),
(2, 23, 13, 15),
(4, 25, 13, 10),
(5, 24, 13, 8),
(6, 26, 13, 15),
(7, 27, 14, 1),
(8, 27, 20, 30),
(9, 28, 14, 1),
(11, 28, 8, 100),
(12, 29, 15, 30),
(13, 29, 8, 15),
(14, 30, 15, 30),
(15, 30, 7, 20),
(16, 31, 15, 30),
(17, 31, 21, 15),
(19, 32, 18, 1);

-- --------------------------------------------------------

--
-- Table structure for table `restok`
--

CREATE TABLE `restok` (
  `idRestok` int(11) NOT NULL,
  `Tanggal` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idSuplier` int(11) NOT NULL,
  `idInventory` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restok`
--

INSERT INTO `restok` (`idRestok`, `Tanggal`, `idSuplier`, `idInventory`, `jumlah`, `userId`) VALUES
(1, '2023-01-29 15:51:43', 1, 1, 650, 6),
(2, '2023-01-29 15:51:43', 1, 2, 1200, 6),
(3, '2023-01-29 15:51:43', 1, 3, 650, 6),
(4, '2023-01-29 15:51:43', 1, 4, 650, 6),
(5, '2023-01-29 15:51:43', 1, 5, 650, 6),
(6, '2023-01-29 15:51:43', 1, 7, 650, 6),
(7, '2023-01-29 15:51:43', 1, 8, 650, 6),
(8, '2023-01-29 15:51:43', 1, 9, 2000, 6),
(9, '2023-01-29 15:51:43', 1, 10, 1000, 6),
(10, '2023-01-29 15:51:43', 2, 11, 1800, 6),
(11, '2023-01-29 15:51:43', 1, 12, 200, 6),
(12, '2023-01-29 15:51:43', 1, 13, 1000, 6),
(13, '2023-01-29 15:51:43', 3, 14, 20, 6),
(14, '2023-01-29 15:53:07', 1, 15, 1000, 6),
(15, '2023-01-29 15:53:07', 3, 16, 60, 6),
(16, '2023-01-29 15:53:07', 1, 17, 40, 6),
(17, '2023-01-29 15:53:07', 2, 18, 40, 6),
(18, '2023-01-29 15:53:07', 2, 19, 1000, 6),
(19, '2023-01-29 15:53:07', 3, 20, 300, 6),
(20, '2023-01-29 15:53:07', 1, 21, 650, 6),
(21, '2023-02-08 09:34:53', 1, 1, 1300, 8),
(22, '2023-02-08 09:34:53', 2, 3, 650, 8);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `idrole` int(11) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`idrole`, `role`) VALUES
(1, 'Admin'),
(2, 'Karyawan');

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
(7, 'Apa Olahraga Favorit Anda?'),
(8, 'Merk Smartphone Pertama Anda?'),
(9, 'Siapa Nama Ibu Anda?');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `idSuplier` int(11) NOT NULL,
  `namaSuplier` varchar(50) NOT NULL,
  `noTelepon` varchar(27) NOT NULL,
  `alamatSuplier` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`idSuplier`, `namaSuplier`, `noTelepon`, `alamatSuplier`) VALUES
(1, 'Pasar Baru', '089214122255', 'Bekasi Timur'),
(2, 'Alfamart', '021 5575 5966.', 'Duren Jaya'),
(3, 'Indomart', '021 8875 5966.', 'Duren Jaya'),
(4, 'Warung Pintar', '089612341235', 'Perumnas 3 Bekasi Timur');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` int(10) NOT NULL,
  `idInventory` int(10) NOT NULL,
  `jumlah` int(15) NOT NULL,
  `tanggalTransaksi` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idUser` int(10) NOT NULL DEFAULT '6',
  `Keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `idInventory`, `jumlah`, `tanggalTransaksi`, `idUser`, `Keterangan`) VALUES
(1, 15, 30, '2023-01-29 15:53:58', 6, 'Produksi'),
(2, 8, 15, '2023-01-29 15:53:58', 6, 'Produksi'),
(3, 12, 36, '2023-01-29 15:54:17', 6, 'Produksi'),
(4, 14, 1, '2023-01-29 15:54:29', 6, 'Produksi'),
(5, 8, 100, '2023-01-29 15:54:29', 6, 'Produksi'),
(6, 16, 3, '2023-01-29 15:55:17', 6, 'Di Makan Sendiri'),
(7, 16, 3, '2023-02-08 09:36:48', 8, 'Rusak'),
(8, 12, 12, '2023-02-08 09:40:22', 8, 'Produksi');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` char(244) NOT NULL,
  `idRole` int(1) NOT NULL,
  `userActive` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `Nama`, `username`, `password`, `idRole`, `userActive`) VALUES
(6, 'Fiddin ', 'Admin', '58acb7acccce58ffa8b953b12b5a7702bd42dae441c1ad85057fa70b', 1, 1),
(8, 'Atthoriq Aziz', 'Atthoriq', '52cb30747e84166ce691d0605890b89b8684b7855530114ff636169e', 1, 1),
(15, 'Andi Wijaya', 'AndiWijaya', 'a671fd5f3caccf0e94fba01ce2d22e2d4436a52454ebf8a95e31fcd7', 2, 1),
(16, 'Atthoriq', 'Atthoriq', 'd0d704a44135b26557befb6800ed91f7437ed3cc5a871a806a32feb6', 2, 1);

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
(1, 6, 1, 'dca08c944a652fbf0131bf7b15ecd38fde5539d5a6226171379a1816'),
(2, 6, 2, 'Kano'),
(3, 6, 4, 'Soto'),
(4, 8, 1, 'dca08c944a652fbf0131bf7b15ecd38fde5539d5a6226171379a1816'),
(5, 8, 7, 'Motorsport'),
(6, 8, 3, 'Hitam'),
(7, 14, 1, 'ad994d0950d1a2b2c807f60789b055d27cd53b1c22987eea28eb3693'),
(8, 14, 3, 'Merah'),
(9, 14, 8, 'Apple'),
(10, 13, 1, '2cfcbdc839cf550004a0115a366cd5260becb7269f038e2a1911f44d'),
(11, 13, 8, 'Samsung'),
(12, 13, 7, 'Basket'),
(13, 15, 1, 'dca08c944a652fbf0131bf7b15ecd38fde5539d5a6226171379a1816'),
(14, 15, 3, 'Kuning'),
(15, 15, 8, 'Samsung');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akses`
--
ALTER TABLE `akses`
  ADD PRIMARY KEY (`idAkses`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`idInventory`);

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
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`idPenjualan`);

--
-- Indexes for table `resep`
--
ALTER TABLE `resep`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restok`
--
ALTER TABLE `restok`
  ADD PRIMARY KEY (`idRestok`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`idrole`);

--
-- Indexes for table `securityquestion`
--
ALTER TABLE `securityquestion`
  ADD PRIMARY KEY (`sqId`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`idSuplier`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`);

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
-- AUTO_INCREMENT for table `akses`
--
ALTER TABLE `akses`
  MODIFY `idAkses` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `idInventory` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `idMenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `menucategory`
--
ALTER TABLE `menucategory`
  MODIFY `idKategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `idPenjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `resep`
--
ALTER TABLE `resep`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `restok`
--
ALTER TABLE `restok`
  MODIFY `idRestok` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `idrole` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `securityquestion`
--
ALTER TABLE `securityquestion`
  MODIFY `sqId` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `idSuplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `idTransaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `usersq`
--
ALTER TABLE `usersq`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
