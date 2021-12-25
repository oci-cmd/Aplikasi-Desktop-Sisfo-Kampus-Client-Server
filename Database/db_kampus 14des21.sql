-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.21-MariaDB


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_kampus
--

CREATE DATABASE IF NOT EXISTS db_kampus;
USE db_kampus;

--
-- Definition of table `tbl_dosen`
--

DROP TABLE IF EXISTS `tbl_dosen`;
CREATE TABLE `tbl_dosen` (
  `IdDosen` int(15) unsigned NOT NULL AUTO_INCREMENT,
  `IdProdi` int(10) unsigned NOT NULL,
  `Nidn` varchar(25) NOT NULL,
  `NamaLengkap` varchar(25) NOT NULL,
  `AlamatLengkap` text DEFAULT NULL,
  PRIMARY KEY (`IdDosen`),
  UNIQUE KEY `Nidn` (`Nidn`),
  KEY `FK_tbl_dosen_IdProdi` (`IdProdi`),
  CONSTRAINT `FK_tbl_dosen_IdProdi` FOREIGN KEY (`IdProdi`) REFERENCES `tbl_prodi` (`IdProdi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_dosen`
--

/*!40000 ALTER TABLE `tbl_dosen` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dosen` ENABLE KEYS */;


--
-- Definition of table `tbl_fakultas`
--

DROP TABLE IF EXISTS `tbl_fakultas`;
CREATE TABLE `tbl_fakultas` (
  `IdFakultas` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `KodeFakultas` varchar(45) NOT NULL,
  `NamaFakultas` varchar(45) NOT NULL,
  `Keterangan` varchar(45) NOT NULL,
  PRIMARY KEY (`IdFakultas`),
  UNIQUE KEY `KodeFakultas` (`KodeFakultas`),
  UNIQUE KEY `NamaFakultas` (`NamaFakultas`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_fakultas`
--

/*!40000 ALTER TABLE `tbl_fakultas` DISABLE KEYS */;
INSERT INTO `tbl_fakultas` (`IdFakultas`,`KodeFakultas`,`NamaFakultas`,`Keterangan`) VALUES 
 (1,'FKIP-009','Fakultas Keguruan dan Ilmu Pendidikan','Ada 6 Prrogram Studi'),
 (2,'FILKOM','Fakultas Ilmu Komputer','Ada 2 Program Studi Bla... bla'),
 (18,'FM','Fakultas Mariitm','Testing');
/*!40000 ALTER TABLE `tbl_fakultas` ENABLE KEYS */;


--
-- Definition of table `tbl_mhs`
--

DROP TABLE IF EXISTS `tbl_mhs`;
CREATE TABLE `tbl_mhs` (
  `IdMhs` int(15) unsigned NOT NULL AUTO_INCREMENT,
  `IdProdi` int(10) unsigned NOT NULL,
  `Nim` varchar(25) NOT NULL,
  `NamaLengkap` varchar(50) NOT NULL,
  `AlamatLengkap` text DEFAULT NULL,
  PRIMARY KEY (`IdMhs`),
  UNIQUE KEY `Nim` (`Nim`),
  KEY `FK_tbl_mhs_IdProdi` (`IdProdi`),
  CONSTRAINT `FK_tbl_mhs_IdProdi` FOREIGN KEY (`IdProdi`) REFERENCES `tbl_prodi` (`IdProdi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_mhs`
--

/*!40000 ALTER TABLE `tbl_mhs` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_mhs` ENABLE KEYS */;


--
-- Definition of table `tbl_prodi`
--

DROP TABLE IF EXISTS `tbl_prodi`;
CREATE TABLE `tbl_prodi` (
  `IdProdi` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdFakultas` int(10) unsigned NOT NULL,
  `KodeProdi` varchar(45) NOT NULL,
  `NamaProdi` varchar(45) NOT NULL,
  `StatusProdi` enum('Aktif','Tidak Aktif') NOT NULL DEFAULT 'Aktif',
  `Akreditasi` char(1) NOT NULL,
  `TglBerdiri` date NOT NULL,
  `Keterangan` varchar(45) NOT NULL,
  PRIMARY KEY (`IdProdi`),
  KEY `FK_tbl_prodi_IdFakultas` (`IdFakultas`),
  CONSTRAINT `FK_tbl_prodi_IdFakultas` FOREIGN KEY (`IdFakultas`) REFERENCES `tbl_fakultas` (`IdFakultas`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_prodi`
--

/*!40000 ALTER TABLE `tbl_prodi` DISABLE KEYS */;
INSERT INTO `tbl_prodi` (`IdProdi`,`IdFakultas`,`KodeProdi`,`NamaProdi`,`StatusProdi`,`Akreditasi`,`TglBerdiri`,`Keterangan`) VALUES 
 (1,2,'TI001','Teknik Informatika','Aktif','A','2015-10-15','Testing Lagi'),
 (2,18,'NTK','Nautika Pelayaran','Tidak Aktif','C','2016-05-12','Baru Pengajuan Prodi'),
 (3,2,'SI01','Sistem Informasi','Aktif','B','2014-10-15','Test ...'),
 (4,1,'PBK','Pendidikan Bimbingan Konseling','Aktif','A','2018-08-17','Test Input');
/*!40000 ALTER TABLE `tbl_prodi` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
