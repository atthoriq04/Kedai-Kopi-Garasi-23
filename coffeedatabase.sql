-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2023 at 12:05 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

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
(5, 'Pengaturan', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `idInventory` int(11) NOT NULL,
  `Satuan` varchar(100) NOT NULL,
  `namaBarang` varchar(50) NOT NULL,
  `Jumlah` int(11) NOT NULL DEFAULT 0,
  `patokanRestok` int(11) NOT NULL DEFAULT 1,
  `Status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`idInventory`, `Satuan`, `namaBarang`, `Jumlah`, `patokanRestok`, `Status`) VALUES
(1, 'Pcs', 'Oreo', 10, 13, 1),
(2, 'Ml', 'Lecy Syrup', 200, 200, 1),
(3, 'Ml', 'Tiramisu', 80, 100, 1),
(4, 'Gr', 'Arabica', 0, 100, 1),
(5, 'Ml', 'Sprite', 0, 1500, 1),
(6, 'Pcs', 'Indomie Goreng', 31, 10, 1),
(7, 'Pcs', 'Indomie Rebus', 8, 10, 1),
(8, 'Ml', 'Full Cream', 144, 160, 1),
(9, 'Ml', 'Creamer', 190, 200, 1),
(10, 'Ml', 'Vanilla Sirup', 144, 160, 1);

-- --------------------------------------------------------

--
-- Table structure for table `jenistransaksi`
--

CREATE TABLE `jenistransaksi` (
  `idJenisTransaksi` int(11) NOT NULL,
  `jenisTransaksi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jenistransaksi`
--

INSERT INTO `jenistransaksi` (`idJenisTransaksi`, `jenisTransaksi`) VALUES
(1, 'Penjualan'),
(2, 'Restok'),
(3, 'Kehilangan');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `idMenu` int(11) NOT NULL,
  `idKategori` int(11) NOT NULL,
  `Menu` varchar(100) NOT NULL,
  `Harga` int(11) NOT NULL,
  `Active` tinyint(1) NOT NULL DEFAULT 1
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
(34, 7, 'Indomie Rebus Double', 15000, 1);

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
  `tanggal` datetime NOT NULL DEFAULT current_timestamp(),
  `jumlah` int(11) NOT NULL,
  `pendapatan` varchar(100) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`idPenjualan`, `idMenu`, `tanggal`, `jumlah`, `pendapatan`, `idUser`) VALUES
(1, 33, '2023-01-08 20:24:23', 3, '22500', 6),
(2, 22, '2023-01-08 22:37:44', 2, '30000', 6),
(3, 33, '2023-01-08 22:38:01', 3, '22500', 6),
(4, 32, '2023-01-09 12:11:08', 1, '7500', 6),
(5, 33, '2023-01-09 12:12:23', 1, '7500', 8),
(6, 22, '2023-01-09 18:53:05', 1, '15000', 6),
(7, 20, '2023-01-09 22:34:04', 1, '16000', 8),
(8, 32, '2023-01-09 22:34:19', 1, '7500', 8);

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
(1, 33, 6, 1),
(2, 22, 4, 30),
(3, 13, 2, 16),
(4, 13, 5, 20),
(5, 12, 1, 3),
(6, 12, 3, 10),
(7, 32, 7, 1),
(8, 20, 8, 16),
(9, 20, 9, 10),
(10, 20, 10, 16),
(11, 20, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `restok`
--

CREATE TABLE `restok` (
  `idRestok` int(11) NOT NULL,
  `Tanggal` datetime NOT NULL DEFAULT current_timestamp(),
  `idSuplier` int(11) NOT NULL,
  `idInventory` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restok`
--

INSERT INTO `restok` (`idRestok`, `Tanggal`, `idSuplier`, `idInventory`, `jumlah`, `userId`) VALUES
(1, '2023-01-08 16:56:07', 4, 4, 100, 8),
(2, '2023-01-08 16:56:07', 4, 2, 200, 8),
(3, '2023-01-08 16:56:07', 1, 6, 10, 8),
(4, '2023-01-08 20:57:04', 2, 6, 30, 14),
(5, '2023-01-09 12:10:48', 2, 7, 10, 6),
(6, '2023-01-09 18:53:57', 4, 3, 100, 6),
(7, '2023-01-09 22:33:43', 1, 1, 13, 8),
(8, '2023-01-09 22:33:43', 3, 8, 160, 8),
(9, '2023-01-09 22:33:43', 2, 9, 200, 8),
(10, '2023-01-09 22:33:43', 4, 10, 160, 8);

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
(1, 'Alfamart', '11111', 'Jalan Bintan'),
(2, 'Indomaret', '12345', 'Jalan Surya Kencana'),
(3, 'Warung Pintar Pak Rahmat', '089912312345', 'Bekasi Timur'),
(4, 'Warung Firman', '089601945983', 'JL P Sulawesi Raya F2 no 3');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` int(10) NOT NULL,
  `idInventory` int(10) NOT NULL,
  `jumlah` int(15) NOT NULL,
  `tanggalTransaksi` datetime NOT NULL DEFAULT current_timestamp(),
  `idUser` int(10) NOT NULL DEFAULT 6,
  `Keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `idInventory`, `jumlah`, `tanggalTransaksi`, `idUser`, `Keterangan`) VALUES
(1, 6, 1, '2023-01-08 17:07:02', 6, 'Dimakan Sendiri'),
(2, 4, 10, '2023-01-08 17:07:02', 6, 'Jatuh'),
(3, 6, 3, '2023-01-08 20:24:22', 6, 'Produksi'),
(4, 4, 60, '2023-01-08 22:37:43', 6, 'Produksi'),
(5, 6, 3, '2023-01-08 22:38:00', 6, 'Produksi'),
(6, 7, 1, '2023-01-09 12:11:07', 6, 'Produksi'),
(7, 6, 1, '2023-01-09 12:12:22', 8, 'Produksi'),
(8, 6, 1, '2023-01-09 15:35:46', 6, 'Hilang'),
(9, 4, 30, '2023-01-09 18:53:04', 6, 'Produksi'),
(10, 3, 20, '2023-01-09 18:54:45', 6, 'Rusak'),
(11, 8, 16, '2023-01-09 22:34:03', 8, 'Produksi'),
(12, 9, 10, '2023-01-09 22:34:03', 8, 'Produksi'),
(13, 10, 16, '2023-01-09 22:34:03', 8, 'Produksi'),
(14, 1, 3, '2023-01-09 22:34:03', 8, 'Produksi'),
(15, 7, 1, '2023-01-09 22:34:18', 8, 'Produksi');

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
  `userActive` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `Nama`, `username`, `password`, `idRole`, `userActive`) VALUES
(6, 'Super Admin', 'Admin', '58acb7acccce58ffa8b953b12b5a7702bd42dae441c1ad85057fa70b', 1, 1),
(8, 'Atthoriq Aziz', 'Atthoriq', '52cb30747e84166ce691d0605890b89b8684b7855530114ff636169e', 1, 1),
(9, 'Dimas Kanjeng', 'DimasKanjeng', '99c1850975b1c2c545ad7e4fc84aef55fcf94250675cb493f7ae897b', 2, 2),
(10, 'Bumi Putera', 'BumiPutera', '929a47b7cee800ce11dba820ca5017cd42dc8fea5df4d3959b161767', 1, 2),
(13, 'Bank Jack', 'jackAss', '58acb7acccce58ffa8b953b12b5a7702bd42dae441c1ad85057fa70b', 2, 1),
(14, 'Kawagoe Saaya', 'Saayan', '58acb7acccce58ffa8b953b12b5a7702bd42dae441c1ad85057fa70b', 2, 1);

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
(5, 8, 2, 'Kano'),
(6, 8, 3, 'Hitam'),
(7, 14, 1, 'ad994d0950d1a2b2c807f60789b055d27cd53b1c22987eea28eb3693'),
(8, 14, 3, 'Merah'),
(9, 14, 8, 'Apple'),
(10, 13, 1, '2cfcbdc839cf550004a0115a366cd5260becb7269f038e2a1911f44d'),
(11, 13, 8, 'Samsung'),
(12, 13, 7, 'Basket');

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
-- Indexes for table `jenistransaksi`
--
ALTER TABLE `jenistransaksi`
  ADD PRIMARY KEY (`idJenisTransaksi`);

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
  MODIFY `idAkses` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `idInventory` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `jenistransaksi`
--
ALTER TABLE `jenistransaksi`
  MODIFY `idJenisTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `idMenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `menucategory`
--
ALTER TABLE `menucategory`
  MODIFY `idKategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `idPenjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `resep`
--
ALTER TABLE `resep`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `restok`
--
ALTER TABLE `restok`
  MODIFY `idRestok` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
  MODIFY `idTransaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `usersq`
--
ALTER TABLE `usersq`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
