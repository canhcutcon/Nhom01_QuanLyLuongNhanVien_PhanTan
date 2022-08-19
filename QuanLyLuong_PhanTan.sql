-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: quan_ly_luong_nv
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bang_cham_cong`
--

DROP TABLE IF EXISTS `bang_cham_cong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bang_cham_cong` (
  `idBangChamCong` int NOT NULL AUTO_INCREMENT,
  `ngayCong` datetime DEFAULT NULL,
  `chamCong` int NOT NULL DEFAULT '1',
  `maNV` int NOT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`idBangChamCong`),
  KEY `FK_BangChamCong_idx` (`maNV`),
  CONSTRAINT `FK_BangChamCong` FOREIGN KEY (`maNV`) REFERENCES `nhan_vien` (`idNhanVien`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bang_cham_cong`
--

LOCK TABLES `bang_cham_cong` WRITE;
/*!40000 ALTER TABLE `bang_cham_cong` DISABLE KEYS */;
INSERT INTO `bang_cham_cong` VALUES (2,'2022-09-18 00:00:00',1,50,1),(3,'2022-09-18 00:00:00',1,51,1),(4,'2022-09-18 00:00:00',1,52,1),(5,'2022-09-18 00:00:00',1,53,1),(6,'2022-09-18 00:00:00',1,54,1),(7,'2022-09-18 00:00:00',1,55,1),(8,'2022-09-18 00:00:00',0,56,1),(9,'2022-09-18 00:00:00',1,57,1),(10,'2022-09-18 00:00:00',1,58,1),(11,'2022-09-18 00:00:00',0,59,1),(12,'2022-09-18 00:00:00',1,60,1),(13,'2022-09-18 00:00:00',1,61,1),(14,'2022-09-18 00:00:00',1,62,1),(15,'2022-09-18 00:00:00',1,63,1),(16,'2022-09-18 00:00:00',1,64,1),(17,'2022-09-18 00:00:00',1,65,1);
/*!40000 ALTER TABLE `bang_cham_cong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chuc_vu`
--

DROP TABLE IF EXISTS `chuc_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chuc_vu` (
  `idChucVu` int NOT NULL AUTO_INCREMENT,
  `chucVu` varchar(255) NOT NULL,
  `trangThai` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`idChucVu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuc_vu`
--

LOCK TABLES `chuc_vu` WRITE;
/*!40000 ALTER TABLE `chuc_vu` DISABLE KEYS */;
INSERT INTO `chuc_vu` VALUES (1,'SalaryManagerment',1),(2,'Employee',1),(3,'Manager',1);
/*!40000 ALTER TABLE `chuc_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luong_nhan_vien`
--

DROP TABLE IF EXISTS `luong_nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `luong_nhan_vien` (
  `idLuongNhanVien` int NOT NULL AUTO_INCREMENT,
  `thue` double DEFAULT NULL,
  `soNgayLamDuoc` int DEFAULT NULL,
  `luongCoBan` double DEFAULT NULL,
  `ngayTinhLuong` datetime DEFAULT NULL,
  `chungChi` int DEFAULT '0',
  `maPhieuPhat` int DEFAULT NULL,
  `idNhanVien` int NOT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`idLuongNhanVien`,`idNhanVien`),
  KEY `FK_Luong_Nhan_Vien2_idx` (`maPhieuPhat`),
  KEY `FK_Luong_Nhan_Vien_idx` (`idNhanVien`),
  CONSTRAINT `FK_Luong_Nhan_Vien` FOREIGN KEY (`idNhanVien`) REFERENCES `nhan_vien` (`idNhanVien`),
  CONSTRAINT `FK_Luong_Nhan_Vien2` FOREIGN KEY (`maPhieuPhat`) REFERENCES `phieu_phat` (`idPhieuPhat`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luong_nhan_vien`
--

LOCK TABLES `luong_nhan_vien` WRITE;
/*!40000 ALTER TABLE `luong_nhan_vien` DISABLE KEYS */;
INSERT INTO `luong_nhan_vien` VALUES (1,0.05,22,5000000,'2022-09-30 00:00:00',0,1,50,1),(2,0.05,22,5000000,'2022-09-30 00:00:00',1,NULL,51,1),(3,0.05,22,5000000,'2022-09-30 00:00:00',0,NULL,52,1),(4,0.05,22,5000000,'2022-09-30 00:00:00',2,NULL,53,1),(5,0.05,22,5000000,'2022-09-30 00:00:00',0,NULL,54,1);
/*!40000 ALTER TABLE `luong_nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muc_tien_phat`
--

DROP TABLE IF EXISTS `muc_tien_phat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `muc_tien_phat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tenMucPhat` varchar(255) NOT NULL,
  `tienPhat` double DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muc_tien_phat`
--

LOCK TABLES `muc_tien_phat` WRITE;
/*!40000 ALTER TABLE `muc_tien_phat` DISABLE KEYS */;
INSERT INTO `muc_tien_phat` VALUES (1,'Đi trễ',100,1),(2,'Hư hỏng của công',1000,1);
/*!40000 ALTER TABLE `muc_tien_phat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhan_vien` (
  `idNhanVien` int NOT NULL AUTO_INCREMENT,
  `hoTen` varchar(255) NOT NULL,
  `sdt` varchar(10) DEFAULT NULL,
  `cmnd` varchar(15) DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `ngayVaoLam` datetime DEFAULT NULL,
  `ngaySinh` datetime DEFAULT NULL,
  `idChucVu` int NOT NULL DEFAULT '1',
  `matKhau` varchar(255) DEFAULT NULL,
  `hinhAnh` varchar(255) DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`idNhanVien`),
  KEY `FK_NhanVien_idx` (`idChucVu`),
  CONSTRAINT `FK_NhanVien` FOREIGN KEY (`idChucVu`) REFERENCES `chuc_vu` (`idChucVu`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES (50,'Trần Văn Nam','0568255700','271711100','111 Trần Não','2018-01-01 00:00:00','2018-01-01 00:00:00',2,'123456',NULL,1),(51,'Lê Văn Luân','0568255701','271711101','123 Trần Hưng Đạo','2018-01-01 00:00:00','2018-01-01 00:00:00',2,'123456',NULL,1),(52,'Nguyễn Hồng Nhung','0568255702','271711102','234 Lê Duẩn','2018-01-01 00:00:00','2018-01-01 00:00:00',2,'123456',NULL,1),(53,'Nguyễn Thị Thu Vân','0568255703','271711103','33 Điện Biên Phủ','2018-01-01 00:00:00','2018-01-01 00:00:00',2,'123456',NULL,1),(54,'Nguyễn Thế Đạt','0568255704','271711104','287 Thăng Long','2018-01-01 00:00:00','2018-01-01 00:00:00',2,'123456',NULL,1),(55,'Phan Lê Ngọc Duy','0568255705','271711105','230 Tô Ngọc Vân','2018-01-01 00:00:00','2018-01-01 00:00:00',2,'123456',NULL,1),(56,'Huỳnh Quốc Khánh','0568255706','271711106','127 Quang Trung','2018-01-01 00:00:00','2018-01-01 00:00:00',1,'123456',NULL,1),(57,'Trương Ngọc Duy','0568255707','271711107','90 Phạm Ngũ Lão','2018-01-01 00:00:00','2018-01-01 00:00:00',1,'123456',NULL,1),(58,'Ngô Quang Long','0568255708','271711108','134 Hiệp Bình','2018-01-01 00:00:00','2018-01-01 00:00:00',1,'123456',NULL,1),(59,'Lê Dĩ Khang','0568255709','271711109','218 huỳnh Khương An','2018-01-01 00:00:00','2018-01-01 00:00:00',1,'123456',NULL,1),(60,'Nguyễn Thanh Phương','0568255710','271711110','225 Cộng Hòa','2018-01-01 00:00:00','2018-01-01 00:00:00',3,'123456',NULL,1),(61,'Nguyễn Diệu Nhi','0568255711','271711111','137 Mai văn Chí','2018-01-01 00:00:00','2018-01-01 00:00:00',3,'123456',NULL,1),(62,'Nguyễn Văn An','0568255712','271711112','158 Lê Chí Thọ','2018-01-01 00:00:00','2018-01-01 00:00:00',2,'123456',NULL,1),(63,'Nguyễn Minh Đức','0568255713','271711113','256 Lê Văn Tám','2018-01-01 00:00:00','2018-01-01 00:00:00',2,'123456',NULL,1),(64,'Đinh Anh Tú','0568255714','271711114','123 Hai Bà Trưng','2018-01-01 00:00:00','2018-01-01 00:00:00',2,'123456',NULL,1),(65,'Nguyễn Duy Hoài','0568255715','271711115','11 Hoàng Sa','2018-01-01 00:00:00','2018-01-01 00:00:00',2,'123456',NULL,1);
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_luong`
--

DROP TABLE IF EXISTS `phieu_luong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_luong` (
  `idphieu_luong` int NOT NULL AUTO_INCREMENT,
  `maNhanVien` int NOT NULL,
  `ngayNhan` datetime DEFAULT NULL,
  `tongLuongThucNhan` double DEFAULT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`idphieu_luong`),
  KEY `FK_PhieuLuong_idx` (`maNhanVien`),
  CONSTRAINT `FK_PhieuLuong` FOREIGN KEY (`maNhanVien`) REFERENCES `nhan_vien` (`idNhanVien`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_luong`
--

LOCK TABLES `phieu_luong` WRITE;
/*!40000 ALTER TABLE `phieu_luong` DISABLE KEYS */;
INSERT INTO `phieu_luong` VALUES (1,50,'2022-09-30 00:00:00',6000,1),(2,52,'2022-09-30 00:00:00',6000,1),(3,53,'2022-09-30 00:00:00',6000,1);
/*!40000 ALTER TABLE `phieu_luong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_phat`
--

DROP TABLE IF EXISTS `phieu_phat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_phat` (
  `idPhieuPhat` int NOT NULL AUTO_INCREMENT,
  `maMucPhat` int NOT NULL,
  `trangThai` int DEFAULT '1',
  `maNhanVien` int NOT NULL,
  PRIMARY KEY (`idPhieuPhat`),
  KEY `FK_PhieuPhat_idx` (`maMucPhat`),
  KEY `PK_PhieuPhat2_idx` (`maNhanVien`),
  CONSTRAINT `FK_PhieuPhat` FOREIGN KEY (`maMucPhat`) REFERENCES `muc_tien_phat` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `PK_PhieuPhat2` FOREIGN KEY (`maNhanVien`) REFERENCES `nhan_vien` (`idNhanVien`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_phat`
--

LOCK TABLES `phieu_phat` WRITE;
/*!40000 ALTER TABLE `phieu_phat` DISABLE KEYS */;
INSERT INTO `phieu_phat` VALUES (1,1,NULL,50);
/*!40000 ALTER TABLE `phieu_phat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phong_ban`
--

DROP TABLE IF EXISTS `phong_ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phong_ban` (
  `idphong_ban` int NOT NULL AUTO_INCREMENT,
  `tenPhongBan` varchar(255) NOT NULL,
  `quanLyPhongBan` int NOT NULL,
  `trangThai` int DEFAULT '1',
  PRIMARY KEY (`idphong_ban`),
  KEY `FK_Phong_Ban_idx` (`quanLyPhongBan`),
  CONSTRAINT `FK_Phong_Ban` FOREIGN KEY (`quanLyPhongBan`) REFERENCES `nhan_vien` (`idNhanVien`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phong_ban`
--

LOCK TABLES `phong_ban` WRITE;
/*!40000 ALTER TABLE `phong_ban` DISABLE KEYS */;
INSERT INTO `phong_ban` VALUES (3,'Marketing',58,1),(4,'Kế toán',59,1),(5,'Kinh Doanh',60,1);
/*!40000 ALTER TABLE `phong_ban` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-19 21:27:58
