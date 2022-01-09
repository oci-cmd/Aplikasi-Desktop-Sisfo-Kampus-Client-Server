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
-- Definition of table `tbl_dosen_pengampu`
--

DROP TABLE IF EXISTS `tbl_dosen_pengampu`;
CREATE TABLE `tbl_dosen_pengampu` (
  `IdPengampu` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdMk` int(10) unsigned NOT NULL,
  `IdDosen` int(10) unsigned NOT NULL,
  PRIMARY KEY (`IdPengampu`),
  KEY `FK_tbl_dosen_pengampu_IdMk` (`IdMk`),
  KEY `FK_tbl_dosen_pengampu_IdDosen` (`IdDosen`),
  CONSTRAINT `FK_tbl_dosen_pengampu_IdDosen` FOREIGN KEY (`IdDosen`) REFERENCES `tbl_dosen` (`IdDosen`),
  CONSTRAINT `FK_tbl_dosen_pengampu_IdMk` FOREIGN KEY (`IdMk`) REFERENCES `tbl_mk` (`IdMk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_dosen_pengampu`
--

/*!40000 ALTER TABLE `tbl_dosen_pengampu` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dosen_pengampu` ENABLE KEYS */;


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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_fakultas`
--

/*!40000 ALTER TABLE `tbl_fakultas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_fakultas` ENABLE KEYS */;


--
-- Definition of table `tbl_krs`
--

DROP TABLE IF EXISTS `tbl_krs`;
CREATE TABLE `tbl_krs` (
  `IdKrs` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdPengampu` int(10) unsigned NOT NULL,
  `IdMhs` int(10) unsigned NOT NULL,
  `TglKrs` date NOT NULL,
  PRIMARY KEY (`IdKrs`),
  KEY `FK_tbl_krs_IdPengampu` (`IdPengampu`),
  KEY `FK_tbl_krs_IdMhs` (`IdMhs`),
  CONSTRAINT `FK_tbl_krs_IdMhs` FOREIGN KEY (`IdMhs`) REFERENCES `tbl_mhs` (`IdMhs`),
  CONSTRAINT `FK_tbl_krs_IdPengampu` FOREIGN KEY (`IdPengampu`) REFERENCES `tbl_dosen_pengampu` (`IdPengampu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_krs`
--

/*!40000 ALTER TABLE `tbl_krs` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_krs` ENABLE KEYS */;


--
-- Definition of table `tbl_mhs`
--

DROP TABLE IF EXISTS `tbl_mhs`;
CREATE TABLE `tbl_mhs` (
  `IdMhs` int(15) unsigned NOT NULL AUTO_INCREMENT,
  `IdProdi` int(10) unsigned NOT NULL,
  `TglDaftar` date NOT NULL,
  `Nim` varchar(25) NOT NULL,
  `NamaLengkap` varchar(50) NOT NULL,
  `AlamatLengkap` text DEFAULT NULL,
  `JenisKelamin` enum('Pria','Wanita') NOT NULL,
  `GolonganDarah` char(2) NOT NULL,
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
-- Definition of table `tbl_mk`
--

DROP TABLE IF EXISTS `tbl_mk`;
CREATE TABLE `tbl_mk` (
  `IdMk` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NamaMk` varchar(45) NOT NULL,
  `SKS` tinyint(2) unsigned NOT NULL,
  `Semester` tinyint(2) unsigned NOT NULL,
  PRIMARY KEY (`IdMk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_mk`
--

/*!40000 ALTER TABLE `tbl_mk` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_mk` ENABLE KEYS */;


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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_prodi`
--

/*!40000 ALTER TABLE `tbl_prodi` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_prodi` ENABLE KEYS */;


--
-- Definition of table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `IdUser` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NamaUser` varchar(45) NOT NULL,
  `Password` varchar(455) NOT NULL,
  PRIMARY KEY (`IdUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
