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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (15,'16004','RAIHAN',64,14,16,21,20,94.76,24,'2016-08-01'),(16,'16005','RAKIB',21,5,5,7,7,47.95,24,'2016-08-01'),(17,'16006','ABDUL',21,5,5,7,7,31.48,24,'2016-08-01'),(18,'16007','JAKARIA',64,14,16,21,20,90.80000000000001,24,'2016-08-01'),(19,'16008','NILOY',64,14,16,21,20,88.59,24,'2016-08-01'),(20,'16009','SHAHIN',21,5,5,7,7,29.27,24,'2016-08-01'),(21,'16004','RAIHAN',108,163,157,18,24,300.33,0,'2016-07-29'),(22,'16005','RAKIB',30,45,44,5,7,99.41,0,'2016-07-29'),(23,'16006','ABDUL',30,45,44,5,7,83.81,0,'2016-07-29'),(24,'16007','JAKARIA',90,136,131,15,20,209.53,0,'2016-07-29'),(25,'16008','NILOY',72,108,105,12,16,151.57999999999998,0,'2016-07-29'),(26,'16009','SHAHIN',30,45,44,5,7,63.56,0,'2016-07-29'),(27,'16004','RAIHAN',25,50,38,50,23,140.73000000000002,9,'2016-07-30'),(28,'16005','RAKIB',8,17,13,17,8,86.91,9,'2016-07-30'),(29,'16006','ABDUL',8,17,13,17,8,47.709999999999994,9,'2016-07-30'),(30,'16007','JAKARIA',25,50,38,50,23,126.02000000000001,9,'2016-07-30'),(31,'16008','NILOY',25,50,38,50,23,118.45,9,'2016-07-30'),(32,'16009','SHAHIN',8,17,13,17,8,40.14,9,'2016-07-30'),(33,'16004','RAIHAN',60,30,45,27,24,133.68,0,'2016-07-31'),(34,'16005','RAKIB',17,8,13,8,7,61.19,0,'2016-07-31'),(35,'16006','ABDUL',17,8,13,8,7,38.39,0,'2016-07-31'),(36,'16007','JAKARIA',40,20,30,18,16,83.72000000000001,0,'2016-07-31'),(37,'16008','NILOY',50,25,38,23,20,101.14000000000001,0,'2016-07-31'),(38,'16009','SHAHIN',17,8,13,8,7,34.790000000000006,0,'2016-07-31');
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-01  4:18:17
