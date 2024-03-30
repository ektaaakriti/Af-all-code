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
-- Table structure for table `report_of_ticket`
--

DROP TABLE IF EXISTS `report_of_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report_of_ticket` (
  `total_tickets` int DEFAULT NULL,
  `tickets_failed` int DEFAULT NULL,
  `tickets_resolved` int DEFAULT NULL,
  `auto_resolvable_tickets` int DEFAULT NULL,
  `automation_success_rate` int DEFAULT NULL,
  `machines_ticket_not_raised` int DEFAULT NULL,
  `machines_tickets_not_raised_via_af` int DEFAULT NULL,
  `manually_resolvable_tickets` int DEFAULT NULL,
  `no_of_machine_tickets_via_af` int DEFAULT NULL,
  `no_of_machines_deployed` int DEFAULT NULL,
  `per_tickets_auto_resolved` int DEFAULT NULL,
  `per_tickets_raised_via_af` int DEFAULT NULL,
  `tickets_on_itsm_tool_directly` int DEFAULT NULL,
  `tickets_via_af` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_of_ticket`
--

LOCK TABLES `report_of_ticket` WRITE;
/*!40000 ALTER TABLE `report_of_ticket` DISABLE KEYS */;
INSERT INTO `report_of_ticket` VALUES (60,0,0,56,0,0,0,4,3,7,0,93,4,56);
/*!40000 ALTER TABLE `report_of_ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-30  9:33:24
