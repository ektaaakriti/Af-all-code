-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vfschema
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `os_type_master`
--

DROP TABLE IF EXISTS `os_type_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `os_type_master` (
  `id` int DEFAULT NULL,
  `os_type` text,
  `os_version` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_type_master`
--

LOCK TABLES `os_type_master` WRITE;
/*!40000 ALTER TABLE `os_type_master` DISABLE KEYS */;
INSERT INTO `os_type_master` VALUES (1,'Windows 7','Windows 7 Home Basic'),(2,'Windows 7','Windows 7 Home Premium'),(3,'Windows 7','Windows 7 Professional'),(4,'Windows 7','Windows 7 Enterprise'),(5,'Windows 7','Windows 7 Ultimate'),(6,'Windows 8','Windows 8'),(7,'Windows 8','Windows 8 Pro'),(8,'Windows 8.1','Windows 8 Enterprise'),(9,'Windows 8.1','Windows 8.1'),(10,'Windows 8.1','Windows 8.1 Pro'),(11,'Windows 8.1','Windows 8.1 Enterprise'),(12,'Windows 8.1','Windows 8.1 with Bing'),(13,'Windows 10','Windows 10 Home'),(14,'Windows 10','Windows 10 Pro'),(15,'Windows 10','Windows 10 Pro Education'),(16,'Windows 10','Windows 10 Pro for Workstations'),(17,'Windows 10','Windows 10 Enterprise'),(18,'Windows 10','Windows 10 Enterprise LTSC (formerly LTSB)'),(19,'Windows 10','Windows 10 Education'),(20,'Windows 10','Windows 10 IoT Core'),(21,'Windows 10','Windows 10 IoT Enterprise'),(22,'Windows 10','Windows 10 S '),(23,'Windows Server 2003','Windows Server 2003, Standard Edition'),(24,'Windows Server 2003','Windows Server 2003, Enterprise Edition'),(25,'Windows Server 2003','Windows Server 2003, Datacenter Edition'),(26,'Windows Server 2003','Windows Server 2003, Web Edition'),(27,'Windows Server 2003','Windows Storage Server 2003'),(28,'Windows Server 2003','Windows Small Business Server 2003'),(29,'Windows Server 2003 R2','Windows Server 2003 R2, Standard Edition'),(30,'Windows Server 2003 R2','Windows Server 2003 R2, Enterprise Edition'),(31,'Windows Server 2003 R2','Windows Server 2003 R2, Datacenter Edition'),(32,'Windows Server 2003 R2','Windows Storage Server 2003 R2'),(33,'Windows Server 2003 R2','Windows Small Business Server 2003 R2'),(34,'Windows Server 2003 R2','Windows Compute Cluster Server 2003'),(35,'Windows Server 2008','Windows Server 2008 Standard'),(36,'Windows Server 2008','Windows Server 2008 Enterprise'),(37,'Windows Server 2008','Windows Server 2008 Datacenter'),(38,'Windows Server 2008','Windows Server 2008 Foundation'),(39,'Windows Server 2008','Windows Essential Business Server 2008'),(40,'Windows Server 2008','Windows HPC Server 2008'),(41,'Windows Server 2008','Windows Small Business Server 2008'),(42,'Windows Server 2008','Windows Storage Server 2008'),(43,'Windows Server 2008','Windows Server 2008 Web'),(44,'Windows Server 2008 R2','Windows Server 2008 R2 Foundation'),(45,'Windows Server 2008 R2','Windows Server 2008 R2 Standard'),(46,'Windows Server 2008 R2','Windows Server 2008 R2 Enterprise'),(47,'Windows Server 2008 R2','Windows Server 2008 R2 Datacenter'),(48,'Windows Server 2008 R2','Windows Server 2008 R2 Web'),(49,'Windows Server 2008 R2','Windows Storage Server 2008 R2'),(50,'Windows Server 2008 R2','Windows HPC Server 2008 R2'),(51,'Windows Server 2008 R2','Windows Small Business Server 2011'),(52,'Windows Server 2008 R2','Windows Home Server 2011'),(53,'Windows Server 2008 R2','Windows MultiPoint Server 2010'),(54,'Windows Server 2008 R2','Windows MultiPoint Server 2011'),(55,'Windows Server 2012','Windows Server 2012 Foundation'),(56,'Windows Server 2012','Windows Server 2012 Essentials'),(57,'Windows Server 2012','Windows Server 2012 Standard'),(58,'Windows Server 2012','Windows Server 2012 Datacenter'),(59,'Windows Server 2012','Windows MultiPoint Server 2012'),(60,'Windows Server 2012 R2','Windows Server 2012 R2 Foundation'),(61,'Windows Server 2012 R2','Windows Server 2012 R2 Essentials'),(62,'Windows Server 2012 R2','Windows Server 2012 R2 Standard'),(63,'Windows Server 2012 R2','Windows Server 2012 R2 Datacenter'),(64,'Windows Server 2016','Windows Server 2016 Essentials'),(65,'Windows Server 2016','Windows Server 2016 Standard'),(66,'Windows Server 2016','Windows Server 2016 Datacenter'),(67,'Windows Server 2019','Windows Server 2019 Essentials'),(68,'Windows Server 2019','Windows Server 2019 Standard'),(69,'Windows Server 2019','Windows Server 2019 Datacenter'),(70,'Windows','Windows 10');
/*!40000 ALTER TABLE `os_type_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-30  9:33:25
