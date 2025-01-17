-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2025 at 12:36 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kepegawaian_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `absensi`
--

CREATE TABLE `absensi` (
  `id_absensi` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `status_kehadiran` enum('Hadir','Tidak Hadir','Sakit','Izin') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `absensi`
--

INSERT INTO `absensi` (`id_absensi`, `id_pegawai`, `tanggal`, `status_kehadiran`) VALUES
(1, 1, '2025-01-01', 'Hadir'),
(2, 2, '2025-01-01', 'Sakit'),
(3, 3, '2025-01-01', 'Hadir'),
(4, 1, '2025-01-04', 'Hadir');

-- --------------------------------------------------------

--
-- Table structure for table `departemen`
--

CREATE TABLE `departemen` (
  `id_departemen` int(11) NOT NULL,
  `nama_departemen` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `departemen`
--

INSERT INTO `departemen` (`id_departemen`, `nama_departemen`) VALUES
(1, 'IT'),
(2, 'Finance'),
(3, 'HRD');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` int(11) NOT NULL,
  `nama_pegawai` varchar(100) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `gaji` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_pegawai`, `jabatan`, `gaji`) VALUES
(1, 'Ahmad Fauzi Wibowo', 'Manager', '7500000.00'),
(2, 'Siti Nurhaliza', 'Staff', '5000000.00'),
(3, 'Budi Santoso', 'Supervisor', '6500000.00'),
(4, 'Afriza Rizqi', 'HRD', '10000000.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absensi`
--
ALTER TABLE `absensi`
  ADD PRIMARY KEY (`id_absensi`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indexes for table `departemen`
--
ALTER TABLE `departemen`
  ADD PRIMARY KEY (`id_departemen`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absensi`
--
ALTER TABLE `absensi`
  MODIFY `id_absensi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `departemen`
--
ALTER TABLE `departemen`
  MODIFY `id_departemen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `id_pegawai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absensi`
--
ALTER TABLE `absensi`
  ADD CONSTRAINT `absensi_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
