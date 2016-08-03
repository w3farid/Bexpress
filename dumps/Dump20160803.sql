CREATE DATABASE  IF NOT EXISTS `bexpresstest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bexpresstest`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: bexpresstest
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bmanager`
--

DROP TABLE IF EXISTS `bmanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bmanager` (
  `bmanager_id` int(11) NOT NULL,
  `username` text,
  `name` text,
  `com_id` int(11) DEFAULT NULL,
  `designation` text,
  `email` text,
  `password` text,
  PRIMARY KEY (`bmanager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bmanager`
--

LOCK TABLES `bmanager` WRITE;
/*!40000 ALTER TABLE `bmanager` DISABLE KEYS */;
INSERT INTO `bmanager` VALUES (1,'gazifarid','Md. Farid',1195915,'Business Manager','w3farid@gmail.com','123'),(3,'mohasin','Mohasin',11959152,'Data Entry Operator','mamun@gmail.com','1234');
/*!40000 ALTER TABLE `bmanager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `cat_id` int(11) NOT NULL,
  `cat_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (111,'Watch'),(222,'Wearable Technology'),(333,'Home Theater  and Audio'),(444,'Televisions'),(555,'Home Automation and Security'),(888,'hhh'),(999,'Electorinics');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `gradeId` int(11) NOT NULL,
  `grade_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`gradeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1001,'A'),(1002,'B'),(1003,'C'),(1004,'D');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `managers` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(45) DEFAULT NULL,
  `com_id` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
INSERT INTO `managers` VALUES (1,'bbb','12345','dsfdsf'),(2,'Rashed','546845','Moghbazar');
/*!40000 ALTER TABLE `managers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offer` (
  `offer_id` int(11) NOT NULL,
  `Xiongshi_XSDST_2` int(11) DEFAULT NULL,
  `Yitong_XS-818T` int(11) DEFAULT NULL,
  `YITONG_YT-B1` int(11) DEFAULT NULL,
  `Xiongshi_Ice Block` int(11) DEFAULT NULL,
  `yitong_IB50` int(11) DEFAULT NULL,
  `Offer_date` date DEFAULT NULL,
  PRIMARY KEY (`offer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` VALUES (123,2,2,5,10,5,'2016-08-01'),(124,1,2,0,5,1,'2016-07-30'),(125,2,1,3,1,0,'2016-08-02'),(126,1,2,1,5,10,'2016-08-03');
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `rep_name` varchar(45) DEFAULT NULL,
  `pro_id` int(11) DEFAULT NULL,
  `pro_name` varchar(45) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `Date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'45',454,'451',454,'2016-07-05 00:00:00'),(2,'45',454,'451',454,'2016-07-25 02:29:24');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prices`
--

DROP TABLE IF EXISTS `prices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prices` (
  `p_id` int(11) NOT NULL,
  `Xiongshi_XSDST_2` double DEFAULT NULL,
  `Yitong_XS-818T` double DEFAULT NULL,
  `YITONG_YT-B1` double DEFAULT NULL,
  `Xiongshi_Ice Block` double DEFAULT NULL,
  `yitong_IB50` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prices`
--

LOCK TABLES `prices` WRITE;
/*!40000 ALTER TABLE `prices` DISABLE KEYS */;
INSERT INTO `prices` VALUES (1,630,450,780,1200,620,'2016-07-29');
/*!40000 ALTER TABLE `prices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(45) NOT NULL,
  `suplier_Id` int(11) NOT NULL,
  `cat_id` int(11) NOT NULL,
  `pro_price` double NOT NULL,
  `stock` int(11) NOT NULL,
  `productcol` varchar(45) NOT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchases`
--

DROP TABLE IF EXISTS `purchases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchases` (
  `pur_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) DEFAULT NULL,
  `pro_name` varchar(45) DEFAULT NULL,
  `suplier_name` varchar(45) DEFAULT NULL,
  `Serial_number` varchar(45) DEFAULT NULL,
  `Cat_name` varchar(45) DEFAULT NULL,
  `pur_date` date DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `pur_price` double DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`pur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchases`
--

LOCK TABLES `purchases` WRITE;
/*!40000 ALTER TABLE `purchases` DISABLE KEYS */;
INSERT INTO `purchases` VALUES (1,45,'asdfds','sdfds','245','454','2016-07-11',54,58,'sdfds'),(2,45,'asdfds','sdfds','245','454','2016-07-11',54,58,'sdfds'),(3,4548,'adfd','asdf','4554','451','2016-07-13',5,54,'dsfds'),(4,655,'adfd','45','54','45','2016-07-07',62,62,'dsfds');
/*!40000 ALTER TABLE `purchases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchases_cost`
--

DROP TABLE IF EXISTS `purchases_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchases_cost` (
  `cost_id` int(11) NOT NULL AUTO_INCREMENT,
  `representive_id` int(11) DEFAULT NULL,
  `cost_name` varchar(45) DEFAULT NULL,
  `cost_type` varchar(45) DEFAULT NULL,
  `cost_value` varchar(45) DEFAULT NULL,
  `cost_date` date DEFAULT NULL,
  PRIMARY KEY (`cost_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchases_cost`
--

LOCK TABLES `purchases_cost` WRITE;
/*!40000 ALTER TABLE `purchases_cost` DISABLE KEYS */;
INSERT INTO `purchases_cost` VALUES (1,124,'ads','454','54','2016-07-12');
/*!40000 ALTER TABLE `purchases_cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `representatives`
--

DROP TABLE IF EXISTS `representatives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `representatives` (
  `rep_id` int(11) NOT NULL AUTO_INCREMENT,
  `rep_name` varchar(45) DEFAULT NULL,
  `com_id` varchar(45) DEFAULT NULL,
  `sup_id` varchar(45) DEFAULT NULL,
  `manager_id` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `gradeName` varchar(4) DEFAULT NULL,
  `route_no` int(11) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rep_id`),
  KEY `FK_sup_sup_id_idx` (`sup_id`),
  KEY `FK_manager_manager_id_idx` (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16010 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `representatives`
--

LOCK TABLES `representatives` WRITE;
/*!40000 ALTER TABLE `representatives` DISABLE KEYS */;
INSERT INTO `representatives` VALUES (16004,'Raihan','21548124','16002','16001','Moghbazar','A',1,NULL),(16005,'Rakib','25415487','16002','16001','Shantibagh','B',2,NULL),(16006,'Abdul','215484','16002','16001','Railgate','B',3,NULL),(16007,'Jakaria','4512485','16003','16001','Shahabagh','C',4,NULL),(16008,'Niloy','4518754','16003','16001','Palton','D',5,NULL),(16009,'Shahin','25455846','16003','16001','Sarong ','B',6,NULL);
/*!40000 ALTER TABLE `representatives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_sales`
--

DROP TABLE IF EXISTS `return_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return_sales` (
  `return_id` int(11) NOT NULL AUTO_INCREMENT,
  `rep_id` int(11) DEFAULT NULL,
  `rep_name` varchar(45) DEFAULT NULL,
  `xiongshiA` double DEFAULT NULL,
  `YitongB` double DEFAULT NULL,
  `YITONGC` double DEFAULT NULL,
  `YITONGD` double DEFAULT NULL,
  `XiongshiE` double DEFAULT NULL,
  `target_outlet` int(11) DEFAULT NULL,
  `achieve_outlet` int(11) DEFAULT NULL,
  `totalTaka` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`return_id`),
  KEY `FK_product_pro_id_idx` (`xiongshiA`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_sales`
--

LOCK TABLES `return_sales` WRITE;
/*!40000 ALTER TABLE `return_sales` DISABLE KEYS */;
INSERT INTO `return_sales` VALUES (1,16005,'RAKIB',21,5,5,7,7,25,20,32120,'2016-08-01'),(2,16009,'SHAHIN',21,5,5,7,7,20,18,32120,'2016-08-01'),(3,16004,'RAIHAN',23,40,28,30,20,36,28,102730,'2016-07-30'),(4,16005,'RAKIB',8,15,13,17,8,36,20,47290,'2016-07-30'),(5,16006,'ABDUL',8,17,10,15,8,25,17,43450,'2016-07-30'),(6,16007,'JAKARIA',20,30,30,30,20,30,27,97900,'2016-07-30'),(7,16008,'NILOY',25,50,38,50,23,30,25,142150,'2016-07-30'),(8,16009,'SHAHIN',8,17,13,17,8,40,35,48190,'2016-07-30'),(9,16004,'RAIHAN',60,30,45,27,24,30,25,133680,'2016-07-31'),(10,16005,'RAKIB',17,8,13,8,7,25,20,38390,'2016-07-31'),(11,16006,'ABDUL',17,8,13,8,7,25,18,38390,'2016-07-31'),(12,16007,'JAKARIA',40,20,30,18,16,30,25,89120,'2016-07-31'),(13,16008,'NILOY',50,25,38,23,20,25,15,112390,'2016-07-31'),(14,16009,'SHAHIN',17,8,13,8,7,20,15,38390,'2016-07-31'),(15,16004,'RAIHAN',64,14,16,21,20,36,30,96700,'2016-08-01'),(16,16006,'ABDUL',21,5,5,7,7,20,14,32120,'2016-08-01'),(17,16007,'JAKARIA',64,14,16,21,20,25,22,96700,'2016-08-01'),(18,16008,'NILOY',64,14,16,21,20,25,20,96700,'2016-08-01'),(19,16004,'RAIHAN',108,135,234,76,25,30,30,418010,'2016-08-02'),(20,16005,'RAKIB',22,25,47,13,0,35,25,77370,'2016-08-02'),(21,16006,'ABDUL',22,26,48,14,0,35,25,79800,'2016-08-02'),(22,16007,'JAKARIA',85,109,191,60,17,35,25,334120,'2016-08-02'),(23,16008,'NILOY',85,108,141,64,21,35,25,301950,'2016-08-02'),(24,16009,'SHAHIN',19,26,48,16,0,35,25,80310,'2016-08-02'),(25,16004,'RAIHAN',23,18,16,20,23,30,20,73330,'2016-08-03'),(26,16005,'RAKIB',7,6,4,8,23,25,20,19830,'2016-08-03'),(27,16006,'ABDUL',7,6,4,8,6,35,15,23550,'2016-08-03'),(28,16007,'JAKARIA',18,13,10,17,14,25,20,54070,'2016-08-03'),(29,16008,'NILOY',13,10,7,14,10,35,30,41150,'2016-08-03'),(30,16009,'SHAHIN',7,6,4,8,6,35,30,23550,'2016-08-03');
/*!40000 ALTER TABLE `return_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `sales_id` int(11) NOT NULL AUTO_INCREMENT,
  `rep_id` varchar(45) DEFAULT NULL,
  `rep_name` varchar(45) DEFAULT NULL,
  `xiongshiA` int(11) DEFAULT NULL,
  `YitongB` int(11) DEFAULT NULL,
  `YITONGC` int(11) DEFAULT NULL,
  `YITONGD` int(11) DEFAULT NULL,
  `XiongshiE` int(10) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `offer` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`sales_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (15,'16004','RAIHAN',64,14,16,21,20,94.76,24,'2016-08-01'),(16,'16005','RAKIB',21,5,5,7,7,47.95,24,'2016-08-01'),(17,'16006','ABDUL',21,5,5,7,7,31.48,24,'2016-08-01'),(18,'16007','JAKARIA',64,14,16,21,20,90.80000000000001,24,'2016-08-01'),(19,'16008','NILOY',64,14,16,21,20,88.59,24,'2016-08-01'),(20,'16009','SHAHIN',21,5,5,7,7,29.27,24,'2016-08-01'),(21,'16004','RAIHAN',108,163,157,18,24,300.33,0,'2016-07-29'),(22,'16005','RAKIB',30,45,44,5,7,99.41,0,'2016-07-29'),(23,'16006','ABDUL',30,45,44,5,7,83.81,0,'2016-07-29'),(24,'16007','JAKARIA',90,136,131,15,20,209.53,0,'2016-07-29'),(25,'16008','NILOY',72,108,105,12,16,151.57999999999998,0,'2016-07-29'),(26,'16009','SHAHIN',30,45,44,5,7,63.56,0,'2016-07-29'),(27,'16004','RAIHAN',25,50,38,50,23,140.73000000000002,9,'2016-07-30'),(28,'16005','RAKIB',8,17,13,17,8,86.91,9,'2016-07-30'),(29,'16006','ABDUL',8,17,13,17,8,47.709999999999994,9,'2016-07-30'),(30,'16007','JAKARIA',25,50,38,50,23,126.02000000000001,9,'2016-07-30'),(31,'16008','NILOY',25,50,38,50,23,118.45,9,'2016-07-30'),(32,'16009','SHAHIN',8,17,13,17,8,40.14,9,'2016-07-30'),(33,'16004','RAIHAN',60,30,45,27,24,133.68,0,'2016-07-31'),(34,'16005','RAKIB',17,8,13,8,7,61.19,0,'2016-07-31'),(35,'16006','ABDUL',17,8,13,8,7,38.39,0,'2016-07-31'),(36,'16007','JAKARIA',40,20,30,18,16,83.72000000000001,0,'2016-07-31'),(37,'16008','NILOY',50,25,38,23,20,101.14000000000001,0,'2016-07-31'),(38,'16009','SHAHIN',17,8,13,8,7,34.790000000000006,0,'2016-07-31'),(39,'16004','RAIHAN',108,135,234,76,25,409.66,7,'2016-08-02'),(40,'16005','RAKIB',24,30,52,17,6,160.83,7,'2016-08-02'),(41,'16006','ABDUL',24,30,52,17,6,91.44,7,'2016-08-02'),(42,'16007','JAKARIA',90,113,195,64,21,305.88,7,'2016-08-02'),(43,'16008','NILOY',90,113,195,64,21,292.65,7,'2016-08-02'),(44,'16009','SHAHIN',24,30,52,17,6,78.21000000000001,7,'2016-08-02'),(45,'16004','RAIHAN',28,22,16,30,23,89.38000000000001,19,'2016-08-03'),(46,'16005','RAKIB',7,6,4,8,6,49.449999999999996,19,'2016-08-03'),(47,'16006','ABDUL',7,6,4,8,6,23.31,19,'2016-08-03'),(48,'16007','JAKARIA',18,14,10,19,14,52.78,19,'2016-08-03'),(49,'16008','NILOY',13,10,7,14,10,36.29,19,'2016-08-03'),(50,'16009','SHAHIN',7,6,4,8,6,20.64,19,'2016-08-03');
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervisor`
--

DROP TABLE IF EXISTS `supervisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supervisor` (
  `sup_id` int(11) NOT NULL,
  `sup_name` varchar(45) DEFAULT NULL,
  `manager_id` varchar(45) DEFAULT NULL,
  `com_id` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervisor`
--

LOCK TABLES `supervisor` WRITE;
/*!40000 ALTER TABLE `supervisor` DISABLE KEYS */;
INSERT INTO `supervisor` VALUES (21,'Halim','451','454','Dhanmondi');
/*!40000 ALTER TABLE `supervisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppliers` (
  `suplier_Id` int(11) NOT NULL,
  `company_name` varchar(45) DEFAULT NULL,
  `contact_person_name` varchar(45) DEFAULT NULL,
  `contact_title` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  `mobile` int(11) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `website` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`suplier_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'abc','Ahmed','45','abc dom','02457895',1724486878,'584858455845','abc@gmail.com','https://www.abc.com');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `targetsales`
--

DROP TABLE IF EXISTS `targetsales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `targetsales` (
  `target_id` int(11) NOT NULL,
  `product_name` varchar(45) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `offer_amount` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`target_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `targetsales`
--

LOCK TABLES `targetsales` WRITE;
/*!40000 ALTER TABLE `targetsales` DISABLE KEYS */;
/*!40000 ALTER TABLE `targetsales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bexpresstest'
--

--
-- Dumping routines for database 'bexpresstest'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-03  7:40:09
