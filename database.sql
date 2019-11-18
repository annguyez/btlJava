-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

CREATE SCHEMA `shop` ;
use shop;

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` text,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Áo phông','1.jpg'),(2,'Đầm','2.jpg'),(3,'Quần áo thể thao','3.jpg'),(4,'Quần vải','4.jpg'),(9,'Chân váy',NULL),(10,'Áo khoác',NULL),(11,'Áo Polo',NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `color` (
  `color_id` int(11) NOT NULL AUTO_INCREMENT,
  `color_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`color_id`),
  UNIQUE KEY `color_name_UNIQUE` (`color_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (4,'Cam'),(3,'Nâu'),(8,'Tím'),(2,'Trắng'),(6,'Vàng'),(5,'Xanh dương'),(1,'Đen'),(7,'Đỏ');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` tinyint(4) NOT NULL,
  `idcard` char(14) NOT NULL,
  `role_id` int(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `fk_employees_roles` (`role_id`),
  CONSTRAINT `fk_employees_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Phạm Thị Huyền','Hải Dương',1,'124224',2,'huyen@gmail.com','huyen','123456'),(2,'Phạm Văn A','Hà Nội',0,'322455',2,'van@gmail.com','sale','123456'),(3,'Phạm Văn An','Hà Nội',0,'322455',2,'vanAA@gmail.com','pvan','123456'),(4,'Nguyễn Văn A','Hải Dương',1,'440440',1,'nguyenvana@gmail.com','admin','123456');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `orders_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` char(12) NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `orders_status` tinyint(4) NOT NULL,
  `orders_date` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`orders_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (55,'Nguyễn Xuân Quyền','3231231','Tứ kỳ hải dương',1,'2019-08-16','Không'),(56,'Nguyễn Văn Bắc','323d65612','Hà Nội',2,'2019-08-16','Không'),(57,'Hà Văn Chiến','0123456789','Hà Nội',1,'2019-08-16','Không'),(58,'Nguyễn Văn An','323123177','Hà Nội',0,'2019-08-16','Không'),(59,'Phạm thị Huyền','012345678','Hà Nội',1,'2019-08-16','Không'),(60,'Trung kien','399347171','Đức Thượng, Hoài Đức',0,'2019-08-16',''),(61,'Nguyễn Trung Kiên','399347171','Đức Thượng, Hoài Đức',0,'2019-08-17',''),(62,'Nguyễn Trung Kiên','0399347171','Đức Thượng, Hoài Đức',1,'2019-08-18',''),(63,'Nguyễn Văn Hiếu','0399347171','Hà Nội',0,'2019-08-18',''),(64,'Nguyễn Văn A','399347171','Đức Thượng, Hoài Đức',0,'2019-08-18',''),(65,'Nguyễn Trung Kiên','399347171','Đức Thượng, Hoài Đức',0,'2019-08-18','');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_detail`
--

DROP TABLE IF EXISTS `orders_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders_detail` (
  `orders_id` int(11) NOT NULL,
  `product_detail_id` varchar(35) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` varchar(100) NOT NULL,
  PRIMARY KEY (`orders_id`,`product_detail_id`),
  KEY `fk_orders_detail_product_idx` (`product_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_detail`
--

LOCK TABLES `orders_detail` WRITE;
/*!40000 ALTER TABLE `orders_detail` DISABLE KEYS */;
INSERT INTO `orders_detail` VALUES (55,'50-6-1',3,'500000.0'),(56,'10-1-1',3,'1000000.0'),(56,'11-1-1',1,'50000.0'),(57,'50-6-1',1,'500000.0'),(58,'5-2-2',1,'500000.0'),(58,'6-2-2',1,'100000.0'),(59,'4-1-1',1,'250000.0'),(59,'5-2-2',1,'500000.0'),(60,'50-6-1',4,'500000.0'),(61,'10-1-1',1,'1000000.0'),(62,'50-4-2',6,'500000.0'),(63,'5-2-2',2,'500000.0'),(63,'5-7-1',2,'500000.0'),(63,'7-2-2',2,'250000.0'),(63,'7-3-3',1,'250000.0'),(64,'11-1-1',2,'50000.0'),(65,'11-1-1',3,'50000.0'),(65,'50-4-2',2,'500000.0');
/*!40000 ALTER TABLE `orders_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` varchar(50) NOT NULL,
  `descriptions` text,
  `image` text NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_name_UNIQUE` (`product_name`),
  KEY `fk_product_category` (`category_id`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'Áo ba lỗ in to','250000','','resources/image/products/1.jpg'),(2,1,'Quần Denim1970','250000','LỚP NGOÀI: Denim Thailand','resources/image/products/2.jpg'),(3,2,'Váy bộ liền','300000','','resources/image/products/3.jpg'),(4,2,'Váy liền có mũ','250000','Áo phông trơn ngắn tay chất liệu cotton, Dễ phối đồ','resources/image/products/4.jpg'),(5,2,'Váy nữ dáng ôm','500000','Kết hợp công nghệ in tân tiến, chất liệu cotton 100% xử lý mịn và form áo được nghiên cứu fit cực chuẩn.','resources/image/products/5.jpg'),(6,2,'Váy liền in hình','100000','','resources/image/products/6.jpg'),(7,2,'Váy nữ','250000','','resources/image/products/7.jpg'),(10,4,'Áo khoác mũ chùm','1000000','','resources/image/products/10.jpg'),(11,3,'Hoodi active','50000','Kết hợp công nghệ in tân tiến, chất liệu cotton 100% xử lý mịn và form áo được nghiên cứu fit cực chuẩn.','resources/image/products/11.jpg'),(12,1,'Áo phông kẻ','23000','','resources/image/products/12.jpg'),(50,3,'Quần tank-top active','500000','Chất liệu da 100% , phong cách thời trang, thích hợp đi chơi ','resources/image/products/50.jpg'),(53,1,'Áo phông nữ unisex','250000','','resources/image/products/53.jpg'),(55,1,'Áo ba lỗ nữ','250000','','resources/image/products/55.jpg'),(56,1,'Áo phông mickey','250000','','resources/image/products/56.jpg'),(57,1,'Áo phông mickey có mũ','270000','','resources/image/products/57.jpg'),(58,1,'Áo phông họa tiết','270000','','resources/image/products/58.jpg'),(59,1,'Áo phông in hình','270000','','resources/image/products/59.jpg'),(60,1,'Áo phôngkẻ mickey','270000','','resources/image/products/60.jpg'),(61,3,'Quần dài nữ active','70000','','resources/image/products/61.jpg'),(62,4,'Culottes giả da','500000','','resources/image/products/62.jpg'),(63,4,'Quần len ống loa','300000','','resources/image/products/63.jpg'),(64,4,'Quần dài nữ','300000','','resources/image/products/64.jpg'),(65,9,'Chân váy da','350000','','resources/image/products/65.jpg'),(66,9,'Chân váy jean','350000','','resources/image/products/66.jpg'),(67,9,'Chân váy kéo giả da','350000','','resources/image/products/67.jpg'),(68,9,'Chân váy xếp ly','150000','','resources/image/products/68.jpg'),(69,9,'Chân váy ngắn','150000','','resources/image/products/69.jpg'),(70,10,'Áo khoác lông vũ','700000','','resources/image/products/70.jpg'),(71,10,'Áo khoác lông vũ 2','700000','','resources/image/products/71.jpg'),(72,10,'Áo khoác nữ','700000','','resources/image/products/72.jpg'),(73,10,'Áo khoác trend dáng dài','900000','','resources/image/products/73.jpg'),(74,11,'Áo polo cotton','170000','','resources/image/products/74.jpg'),(75,11,'Áo polo họa tiết','165000','','resources/image/products/75.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail`
--

DROP TABLE IF EXISTS `product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_detail` (
  `product_detail_id` varchar(35) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `size_id` int(11) NOT NULL,
  `color_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`product_detail_id`),
  KEY `fk_product_detail_id_product` (`product_id`),
  KEY `fk_product_detail_id_size` (`size_id`),
  KEY `fk_product_detail_id_color` (`color_id`),
  CONSTRAINT `fk_product_detail_id_color` FOREIGN KEY (`color_id`) REFERENCES `color` (`color_id`),
  CONSTRAINT `fk_product_detail_id_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `fk_product_detail_id_size` FOREIGN KEY (`size_id`) REFERENCES `size` (`size_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail`
--

LOCK TABLES `product_detail` WRITE;
/*!40000 ALTER TABLE `product_detail` DISABLE KEYS */;
INSERT INTO `product_detail` VALUES ('1-1-1',1,1,1,21),('1-2-1',1,1,2,4),('1-2-2',1,2,2,5),('1-2-3',1,3,2,10),('1-3-3',1,3,3,10),('1-4-4',1,4,4,15),('1-5-5',1,5,5,10),('10-1-1',10,1,1,0),('10-2-2',10,2,2,10),('10-6-3',10,3,6,5),('11-1-1',11,1,1,1),('11-1-2',11,2,1,8),('11-1-3',11,3,1,4),('11-2-1',11,1,2,9),('11-2-2',11,2,2,7),('12-1-1',12,1,1,13),('12-1-2',12,2,1,11),('12-2-1',12,1,2,7),('12-2-2',12,2,2,11),('12-2-3',12,3,2,11),('12-3-1',12,1,3,10),('12-3-4',12,4,3,10),('2-1-4',2,4,1,30),('2-2-1',2,1,2,10),('2-2-3',2,3,2,10),('2-3-3',2,3,3,10),('2-4-4',2,4,4,30),('3-1-1',3,1,1,20),('3-2-2',3,2,2,20),('3-2-3',3,3,2,10),('3-3-3',3,3,3,5),('3-4-4',3,4,4,50),('3-5-5',3,5,5,10),('4-1-1',4,1,1,19),('4-1-2',4,2,1,15),('4-2-2',4,2,2,5),('4-3-3',4,3,3,20),('4-4-4',4,4,4,15),('4-5-5',4,5,5,10),('5-2-1',5,1,2,100),('5-2-2',5,2,2,106),('5-2-6',5,6,2,100),('5-4-3',5,3,4,150),('5-7-1',5,1,7,13),('50-4-2',50,2,4,34),('50-6-1',50,1,6,55),('50-6-2',50,2,6,10),('50-6-3',50,3,6,60),('53-4-2',53,2,4,9),('53-4-3',53,3,4,99),('55-4-2',55,2,4,200),('55-7-1',55,1,7,200),('55-7-2',55,2,7,200),('55-7-6',55,6,7,200),('56-4-2',56,2,4,200),('56-6-1',56,1,6,30),('56-6-2',56,2,6,40),('56-7-1',56,1,7,200),('56-7-2',56,2,7,200),('56-7-6',56,6,7,200),('56-8-1',56,1,8,200),('57-2-3',57,3,2,40),('57-4-2',57,2,4,200),('57-6-1',57,1,6,30),('57-6-2',57,2,6,40),('57-7-1',57,1,7,200),('57-7-2',57,2,7,200),('57-7-6',57,6,7,200),('57-8-1',57,1,8,200),('58-2-3',58,3,2,40),('58-4-2',58,2,4,200),('58-5-1',58,1,5,70),('58-5-2',58,2,5,70),('58-5-3',58,3,5,70),('58-6-1',58,1,6,30),('58-6-2',58,2,6,40),('58-7-1',58,1,7,200),('58-7-2',58,2,7,200),('58-7-6',58,6,7,200),('58-8-1',58,1,8,200),('59-2-3',59,3,2,40),('59-4-2',59,2,4,200),('59-5-1',59,1,5,70),('59-5-2',59,2,5,70),('59-5-3',59,3,5,70),('59-6-1',59,1,6,30),('59-6-2',59,2,6,40),('59-7-1',59,1,7,200),('59-7-2',59,2,7,200),('59-7-6',59,6,7,200),('59-8-1',59,1,8,200),('6-2-2',6,2,2,14),('6-4-4',6,4,4,15),('6-6-1',6,1,6,20),('60-2-3',60,3,2,40),('60-4-2',60,2,4,200),('60-5-1',60,1,5,70),('60-5-2',60,2,5,70),('60-5-3',60,3,5,70),('60-6-1',60,1,6,30),('60-6-2',60,2,6,40),('60-7-1',60,1,7,200),('60-7-2',60,2,7,200),('60-7-6',60,6,7,200),('60-8-1',60,1,8,200),('61-1-1',61,1,1,50),('61-1-2',61,2,1,50),('61-1-6',61,6,1,10),('61-4-3',61,3,4,10),('62-1-1',62,1,1,100),('62-1-2',62,2,1,100),('62-1-6',62,6,1,100),('62-4-4',62,4,4,100),('63-1-1',63,1,1,100),('63-1-2',63,2,1,100),('63-1-6',63,6,1,100),('63-4-4',63,4,4,100),('64-1-1',64,1,1,100),('64-1-2',64,2,1,100),('64-1-6',64,6,1,100),('64-4-4',64,4,4,100),('65-1-1',65,1,1,100),('65-1-2',65,2,1,100),('65-1-6',65,6,1,100),('66-1-1',66,1,1,100),('66-1-2',66,2,1,100),('66-1-6',66,6,1,100),('66-2-1',66,1,2,100),('66-2-2',66,2,2,100),('66-5-2',66,2,5,1),('67-1-1',67,1,1,100),('67-1-2',67,2,1,100),('67-1-6',67,6,1,100),('67-2-1',67,1,2,100),('67-2-2',67,2,2,100),('68-1-1',68,1,1,100),('68-1-2',68,2,1,100),('68-1-6',68,6,1,100),('68-2-1',68,1,2,100),('68-2-2',68,2,2,100),('69-1-1',69,1,1,100),('69-1-2',69,2,1,100),('69-1-6',69,6,1,100),('69-2-1',69,1,2,100),('69-2-2',69,2,2,100),('7-2-2',7,2,2,13),('7-3-3',7,3,3,19),('7-8-1',7,1,8,20),('70-2-1',70,1,2,100),('70-5-1',70,1,5,100),('70-5-2',70,2,5,200),('70-5-3',70,3,5,100),('71-2-1',71,1,2,100),('71-4-1',71,1,4,100),('71-4-2',71,2,4,100),('71-4-3',71,3,4,100),('71-5-1',71,1,5,100),('71-5-2',71,2,5,200),('71-5-3',71,3,5,100),('71-7-2',71,2,7,100),('71-7-6',71,6,7,100),('72-2-1',72,1,2,100),('72-4-1',72,1,4,100),('72-4-2',72,2,4,100),('72-4-3',72,3,4,100),('72-5-1',72,1,5,100),('72-5-2',72,2,5,200),('72-5-3',72,3,5,100),('72-7-2',72,2,7,100),('72-7-6',72,6,7,100),('73-2-1',73,1,2,100),('73-4-1',73,1,4,100),('73-4-2',73,2,4,100),('73-4-3',73,3,4,100),('73-5-1',73,1,5,100),('73-5-2',73,2,5,200),('73-5-3',73,3,5,100),('73-7-2',73,2,7,100),('73-7-6',73,6,7,100),('74-4-1',74,1,4,100),('74-4-2',74,2,4,100),('74-4-3',74,3,4,100),('75-3-1',75,1,3,100),('75-4-1',75,1,4,100),('75-4-2',75,2,4,100),('75-4-3',75,3,4,100),('75-5-2',75,2,5,100),('75-6-2',75,2,6,100);
/*!40000 ALTER TABLE `product_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_SALE');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sale` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sale_start` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sale_end` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descriptions` text,
  `sale_images` text,
  `discount` int(11) NOT NULL,
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (1,'Giảm giá chào hè','2019-07-19','2019-09-12','',NULL,18),(2,'Giảm giá chào hè','2019-07-19','2019-07-21','',NULL,30),(3,'Giảm giá chào hè','2019-07-19','2019-07-21','',NULL,50),(4,'Giảm giá chào hè','2019-07-17','2019-07-21','',NULL,20);
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_detail`
--

DROP TABLE IF EXISTS `sale_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sale_detail` (
  `sale_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`sale_id`,`product_id`),
  KEY `fk_sale_detail_product` (`product_id`),
  CONSTRAINT `fk_sale_detail_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `fk_sale_detail_sale` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_detail`
--

LOCK TABLES `sale_detail` WRITE;
/*!40000 ALTER TABLE `sale_detail` DISABLE KEYS */;
INSERT INTO `sale_detail` VALUES (1,1),(1,2),(1,4),(1,5),(1,6),(1,50);
/*!40000 ALTER TABLE `sale_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `size` (
  `size_id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`size_id`),
  UNIQUE KEY `size_UNIQUE` (`size`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (2,'L'),(1,'M'),(6,'S'),(3,'XL'),(4,'XXL'),(5,'XXXL');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-18 13:01:15
