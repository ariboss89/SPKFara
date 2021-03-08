# Host: localhost  (Version: 5.5.5-10.4.17-MariaDB)
# Date: 2021-03-08 22:59:11
# Generator: MySQL-Front 5.3  (Build 4.81)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "tb_admin"
#

DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `Id` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_admin"
#

INSERT INTO `tb_admin` VALUES ('9299000','Superadmin','adm123','1234567','SUPERADMIN'),('9299001','Mohamad Khilwan','mohd123','1234567','ADMIN'),('9299003','Ridho Wahyu P','ridho123','1234567','ADMIN'),('9299002','Ryan Apriyandi','ryan123','1234567','ADMIN');
