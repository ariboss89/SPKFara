# Host: localhost  (Version: 5.5.8)
# Date: 2020-10-12 14:00:06
# Generator: MySQL-Front 5.3  (Build 4.81)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "tb_admin"
#

DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_admin"
#

INSERT INTO `tb_admin` VALUES ('fara123','1234567');

#
# Structure for table "tb_deteksi"
#

DROP TABLE IF EXISTS `tb_deteksi`;
CREATE TABLE `tb_deteksi` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `idriwayat` varchar(255) DEFAULT NULL,
  `kode` varchar(255) DEFAULT NULL,
  `gejala` varchar(255) DEFAULT NULL,
  `jawaban` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=96 DEFAULT CHARSET=latin1;

#
# Data for table "tb_deteksi"
#

/*!40000 ALTER TABLE `tb_deteksi` DISABLE KEYS */;
INSERT INTO `tb_deteksi` VALUES (73,'R001','G001','Lampu Padam','YA'),(74,'R001','G002','Lampu Menyala','YA'),(75,'R001','G003','Lampu Berkedip','YA'),(76,'R001','G004','Kwh Tersambar Petir','YA'),(77,'R001','G008','Pelanggan Tidak Bisa Input Pulsa di KWH','YA'),(78,'R001','G012','Tombol Kwh Tidak Bisa diTekan','YA'),(79,'R001','G014','Voltase Naik Turun','YA'),(80,'R001','G015','Muncul Angka Tak Beraturan','YA'),(81,'R001','G016','Muncul Tulisan Error','YA'),(82,'R001','G017','Layar Display Blank','YA'),(83,'R001','G018','Pulsa Boros','YA'),(84,'R001','G019','Pulsa Tertera Minus','YA'),(85,'R002','G001','Lampu Padam','YA'),(86,'R002','G002','Lampu Menyala','YA'),(87,'R002','G003','Lampu Berkedip','TIDAK'),(88,'R002','G004','Kwh Tersambar Petir','YA'),(89,'R002','G008','Pelanggan Tidak Bisa Input Pulsa di KWH','YA'),(90,'R002','G009','Muncul Gambar Telapak Tangan','YA'),(91,'R002','G010','Muncul Tulisan Periksa','YA'),(92,'R002','G011','Terdengar Bunyi Seperti Alarm di KWH','YA'),(93,'R002','G023','Muncul Gambar Benang Putus','YA'),(94,'R002','G027','Relay Terputus','YA'),(95,'R002','G029','Instalasi Pelanggan Bermasalah','YA');
/*!40000 ALTER TABLE `tb_deteksi` ENABLE KEYS */;

#
# Structure for table "tb_gejala"
#

DROP TABLE IF EXISTS `tb_gejala`;
CREATE TABLE `tb_gejala` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(11) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

#
# Data for table "tb_gejala"
#

/*!40000 ALTER TABLE `tb_gejala` DISABLE KEYS */;
INSERT INTO `tb_gejala` VALUES (1,'G001','Lampu Padam'),(2,'G002','Lampu Menyala'),(3,'G003','Lampu Berkedip'),(4,'G004','Kwh Tersambar Petir'),(5,'G005','Atap Rumah Nyetrum'),(6,'G006','Lantai Rumah Panas'),(7,'G007','Timbul Percikan Api'),(8,'G008','Pelanggan Tidak Bisa Input Pulsa di KWH'),(9,'G009','Muncul Gambar Telapak Tangan'),(10,'G010','Muncul Tulisan Periksa'),(11,'G011','Terdengar Bunyi Seperti Alarm di KWH'),(12,'G012','Tombol Kwh Tidak Bisa diTekan'),(13,'G013','Netral Pelanggan Ada Api'),(14,'G014','Voltase Naik Turun'),(15,'G015','Muncul Angka Tak Beraturan'),(16,'G016','Muncul Tulisan Error'),(17,'G017','Layar Display Blank'),(18,'G018','Pulsa Boros'),(19,'G019','Pulsa Tertera Minus'),(20,'G020','Mcb Berputar ke Arah Off  / Terbalik'),(21,'G021','Pemakaian Pelanggan Melebihi Kapasitas'),(22,'G022','Mcb Lost / Tidak Bisa Bergerak'),(23,'G023','Muncul Gambar Benang Putus'),(24,'G024','Daya Lebih'),(25,'G025','Kehilangan Supply 220V'),(26,'G026','Mcb App Trip'),(27,'G027','Relay Terputus'),(28,'G028','Muncul Tulisan Daya Lebih'),(29,'G029','Instalasi Pelanggan Bermasalah'),(30,'G030','Baut Cover App Patah / Longgar'),(31,'G031','Lampu Padam Sesaat');
/*!40000 ALTER TABLE `tb_gejala` ENABLE KEYS */;

#
# Structure for table "tb_kerusakan"
#

DROP TABLE IF EXISTS `tb_kerusakan`;
CREATE TABLE `tb_kerusakan` (
  `Id` varchar(11) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_kerusakan"
#

INSERT INTO `tb_kerusakan` VALUES ('K01','Gangguan dan Kerusakan pada Instalasi Pelanggan'),('K02','Gangguan Umum Pada Kwh Meter'),('K03','Gangguan Pada Kabel SR/TR');

#
# Structure for table "tb_penyebab"
#

DROP TABLE IF EXISTS `tb_penyebab`;
CREATE TABLE `tb_penyebab` (
  `Id` varchar(11) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT NULL,
  `kode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "tb_penyebab"
#

/*!40000 ALTER TABLE `tb_penyebab` DISABLE KEYS */;
INSERT INTO `tb_penyebab` VALUES ('P01','Instalasi Pelanggan Shot','K01'),('P02','Kwh Meter tertera Periksa','K02'),('P03','App Error','K02'),('P04','Mcb App Trip','K02'),('P05','Mcb Rusak','K02'),('P06','Relay Putus','K02'),('P07','Daya Kurang','K02'),('P08','Lost kontak di Dak Standart/OKA','K03');
/*!40000 ALTER TABLE `tb_penyebab` ENABLE KEYS */;

#
# Structure for table "tb_riwayat"
#

DROP TABLE IF EXISTS `tb_riwayat`;
CREATE TABLE `tb_riwayat` (
  `idriwayat` varchar(20) NOT NULL DEFAULT '',
  `gejala` int(11) DEFAULT NULL,
  `solusi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idriwayat`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "tb_riwayat"
#

/*!40000 ALTER TABLE `tb_riwayat` DISABLE KEYS */;
INSERT INTO `tb_riwayat` VALUES ('R001',12,'P03'),('R002',11,'P02');
/*!40000 ALTER TABLE `tb_riwayat` ENABLE KEYS */;

#
# Structure for table "tb_solusi"
#

DROP TABLE IF EXISTS `tb_solusi`;
CREATE TABLE `tb_solusi` (
  `Id` varchar(11) NOT NULL DEFAULT '',
  `solusi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "tb_solusi"
#

/*!40000 ALTER TABLE `tb_solusi` DISABLE KEYS */;
INSERT INTO `tb_solusi` VALUES ('P01','Periksa kabel instalasi , pastikan kabel tidak  bocor dan beradu, perkuat setiap sambungan yang dicurigai longgar/kendur, disarankan ke biro instalasi.'),('P02','Periksa Instalasi pelanggan, pastikan kabel terbebas dari shot/beradu, Input clear tamper pada kWh meter, memastikan cover kWh tidak longgar.'),('P03','Mengganti unit kWh dengan yang baru, memasang kWh sementara atau kWh Dummy.'),('P04','Memastikan Mcb dalam posisi On, memastikan Mcb dalam kondisi baik, memastikan tengangan DR bagus, memastikan Mcb App tidak lost/rusak.'),('P05','Untuk Mcb dalam : Disarankan pelanggan mengganti sendiri Mcb Pengaman bagian dalam. Untuk Mcb luar : petugas mengganti Mcb app yang baru sesuai dengan daya yang terpasang'),('P06','Mengetes Relay dengan menekan 01 kemudan tekan Enter, jika menekan 01 gagal makan input clear temper pada kWh meter'),('P07','Disarankan pelanggan untuk tambah daya.'),('P08','Pastikan tengangan kabel SR bagus, perkuat sambungan konektor dari SR induk ke SR Pelanggan, memastikan tidak pohon atau benda lain yang menempel pada kabel SR, perkuat sambungan yang lainnya pastikan tidak ada yang bocor.');
/*!40000 ALTER TABLE `tb_solusi` ENABLE KEYS */;
