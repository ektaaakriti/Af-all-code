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
-- Table structure for table `vf_agent_mgs_dtls`
--

DROP TABLE IF EXISTS `vf_agent_mgs_dtls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vf_agent_mgs_dtls` (
  `Msg_id` text,
  `Msg_description` text,
  `Msg_datetime` datetime DEFAULT NULL,
  `msg_enqueue_datetime` text,
  `msg_deueue_datetime` datetime DEFAULT NULL,
  `msg_ticket_id` int DEFAULT NULL,
  `msg_status_YN` text,
  `username` text,
  `password` text,
  `asset_id` text,
  `ticket_id` text,
  `user_id` text,
  `software_install_choice` int DEFAULT NULL,
  `itsm_reqid` int DEFAULT NULL,
  `outlook_email` text,
  `system_name` text,
  `ItsmassignTo` text,
  `mail_send` text,
  `feedback_datetime` datetime DEFAULT NULL,
  `csat_rating` varchar(255) DEFAULT NULL,
  `qfix_description` varchar(50) DEFAULT NULL,
  `csat_rating_mean1` varchar(10) GENERATED ALWAYS AS ((case when (`csat_rating` = _utf8mb4'1') then _utf8mb4'poor' when (`csat_rating` = _utf8mb4'2') then _utf8mb4'average' when (`csat_rating` = _utf8mb4'3') then _utf8mb4'good' when (`csat_rating` = _utf8mb4'4') then _utf8mb4'very good' when (`csat_rating` = _utf8mb4'5') then _utf8mb4'excellent' end)) VIRTUAL,
  `qfix_category` varchar(20) GENERATED ALWAYS AS ((case when (`Msg_id` = _utf8mb4'Msg0001') then _utf8mb4'Printer related' when (`Msg_id` = _utf8mb4'Msg0002') then _utf8mb4'Printer related' when (`Msg_id` = _utf8mb4'Msg0003') then _utf8mb4'Printer related' when (`Msg_id` = _utf8mb4'Msg0004') then _utf8mb4'System related' when (`Msg_id` = _utf8mb4'Msg0005') then _utf8mb4'Software related' when (`Msg_id` = _utf8mb4'Msg0006') then _utf8mb4'Software related' when (`Msg_id` = _utf8mb4'Msg0007') then _utf8mb4'Software related' when (`Msg_id` = _utf8mb4'Msg0008') then _utf8mb4'Email Issues' when (`Msg_id` = _utf8mb4'Msg0009') then _utf8mb4'Email Issues' when (`Msg_id` = _utf8mb4'Msg0010') then _utf8mb4'Email Issues' when (`Msg_id` = _utf8mb4'Msg0011') then _utf8mb4'Email Issues' when (`Msg_id` = _utf8mb4'Msg0012') then _utf8mb4'Outlook Configuration' when (`Msg_id` = _utf8mb4'Msg0013') then _utf8mb4'VPN configuration' when (`Msg_id` = _utf8mb4'Msg0014') then _utf8mb4'Antivirus ' end)) VIRTUAL,
  `csat_rating_mean` varchar(10) GENERATED ALWAYS AS ((case when (`csat_rating` = _utf8mb4'1') then _utf8mb4'poor' when (`csat_rating` = _utf8mb4'2') then _utf8mb4'average' when (`csat_rating` = _utf8mb4'3') then _utf8mb4'good' when (`csat_rating` = _utf8mb4'4') then _utf8mb4'very good' when (`csat_rating` = _utf8mb4'5') then _utf8mb4'excellent' end)) VIRTUAL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vf_agent_mgs_dtls`
--

LOCK TABLES `vf_agent_mgs_dtls` WRITE;
/*!40000 ALTER TABLE `vf_agent_mgs_dtls` DISABLE KEYS */;
INSERT INTO `vf_agent_mgs_dtls` (`Msg_id`, `Msg_description`, `Msg_datetime`, `msg_enqueue_datetime`, `msg_deueue_datetime`, `msg_ticket_id`, `msg_status_YN`, `username`, `password`, `asset_id`, `ticket_id`, `user_id`, `software_install_choice`, `itsm_reqid`, `outlook_email`, `system_name`, `ItsmassignTo`, `mail_send`, `feedback_datetime`, `csat_rating`, `qfix_description`) VALUES ('Msg0004','Disk cleanup','2023-04-12 10:08:14','2023-04-12 10:08:14','2023-04-13 05:55:40',2,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0005','Install WINRAR','2023-04-13 06:06:05','2023-04-13 06:06:05','2023-05-01 06:35:29',4,'C',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0006','Uninstall WINRAR','2023-05-01 09:24:29','2023-05-01 09:24:29','2023-05-01 09:26:27',5,'O',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0005','Install FIREFOX','2023-05-01 09:27:33','2023-05-01 09:27:33','2023-05-01 09:27:53',6,'Of',NULL,NULL,'AS5002',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0006','Uninstall FIREFOX','2023-05-01 09:31:08','2023-05-01 09:31:08','2023-05-01 09:31:29',7,'C',NULL,NULL,'AS5002',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0005','Install TEAM VIEWER','2023-05-01 09:32:38','2023-05-01 09:32:38','2023-05-01 09:32:56',8,'C',NULL,NULL,'AS5013',NULL,'ekta',12,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0006','Uninstall TEAM VIEWER','2023-05-01 09:34:07','2023-05-01 09:34:07','2023-05-01 09:34:27',9,'C',NULL,NULL,'AS5013',NULL,'ekta',12,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0005','Install WINRAR','2023-05-01 09:45:24','2023-05-01 09:45:24','2023-05-01 09:45:44',10,'C',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0005','Install FIREFOX','2023-05-01 10:42:32','2023-05-01 10:42:32','2023-05-01 10:42:52',11,'C',NULL,NULL,'AS5002',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0006','Uninstall FIREFOX','2023-05-01 10:43:42','2023-05-01 10:43:42','2023-05-01 10:44:03',12,'C',NULL,NULL,'AS5002',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0004','Disk cleanup','2023-05-02 05:33:40','2023-05-02 05:33:40','2023-05-02 05:33:59',13,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0004','Disk cleanup','2023-05-02 05:50:01','2023-05-02 05:50:01','2023-05-02 05:50:42',14,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0004','Disk cleanup','2023-05-02 06:55:28','2023-05-02 06:55:28','2023-05-02 06:56:08',15,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0004','Disk cleanup','2023-05-02 10:37:11','2023-05-02 10:37:11',NULL,16,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0004','Disk cleanup','2023-05-02 11:00:26','2023-05-02 11:00:26',NULL,17,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0004','Disk cleanup','2023-05-02 11:08:09','2023-05-02 11:08:09','2023-05-02 11:08:45',18,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0004','Disk cleanup','2023-05-03 08:41:19','2023-05-03 08:41:19','2023-05-03 08:41:38',19,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0005','Install WINRAR','2023-05-03 08:45:10','2023-05-03 08:45:10','2023-05-03 08:45:27',20,'C',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0006','Uninstall WINRAR','2023-05-03 08:46:36','2023-05-03 08:46:36','2023-05-03 08:46:55',21,'C',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0004','Disk cleanup','2023-05-04 05:55:13','2023-05-04 05:55:13','2023-05-04 05:55:36',22,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0004','Disk cleanup','2023-05-04 05:58:15','2023-05-04 05:58:15','2023-05-04 05:58:46',23,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-03 05:59:19','3',NULL),('Msg0005','Install TEAM VIEWER','2023-05-04 06:10:01','2023-05-04 06:10:01','2023-05-04 06:10:20',24,'C',NULL,NULL,'AS5013',NULL,'ekta',12,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:05:00','4',NULL),('Msg0006','Uninstall TEAM VIEWER','2023-05-04 06:11:15','2023-05-04 06:11:15','2023-05-04 06:11:35',25,'C',NULL,NULL,'AS5013',NULL,'ekta',12,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:46:40','4',NULL),('Msg0005','Install SONIC WALL VPN','2023-05-06 12:39:23','2023-05-06 12:39:23','2023-05-06 12:39:41',28,'C',NULL,NULL,'AS50111',NULL,'ekta',11,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:05:34','4',NULL),('Msg0005','Install SONIC WALL VPN','2023-05-06 12:42:06','2023-05-06 12:42:06','2023-05-06 12:43:03',29,'C',NULL,NULL,'AS50111',NULL,'ekta',11,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:46:44','4',NULL),('Msg0009','Outlook2013','2023-05-06 13:11:22','2023-05-06 13:11:22','2023-05-06 13:11:41',32,'C',NULL,NULL,'AS000',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:47:24','3',NULL),('Msg0009','Outlook2013','2023-05-06 13:13:18','2023-05-06 13:13:18','2023-05-06 13:13:34',33,'C',NULL,NULL,'AS000',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:46:57','2',NULL),('Msg0009','Outlook2013','2023-05-06 13:22:41','2023-05-06 13:22:41','2023-05-06 13:22:58',34,'C',NULL,NULL,'AS000',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:51:49','3',NULL),('Msg0009','Outlook2013','2023-05-06 14:00:50','2023-05-06 14:00:50','2023-05-06 14:01:06',39,'C',NULL,NULL,'AS000',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:51:53','3',NULL),('Msg0004','Disk cleanup','2023-05-09 09:53:52','2023-05-09 09:53:52','2023-05-09 09:54:19',41,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:52:16','2',NULL),('Msg0004','Disk cleanup','2023-05-09 09:55:48','2023-05-09 09:55:48','2023-05-09 09:56:03',42,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-09 09:57:32','4',NULL),('Msg0005','Install WINRAR','2023-05-09 10:00:30','2023-05-09 10:00:30','2023-05-09 10:00:48',43,'C',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:52:50','3',NULL),('Msg0006','Uninstall WINRAR','2023-05-09 10:01:37','2023-05-09 10:01:37','2023-05-09 10:01:57',44,'C',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:52:30','4',NULL),('Msg0005','Install WINRAR','2023-05-09 10:02:28','2023-05-09 10:02:28','2023-05-09 10:02:46',45,'C',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:53:01','4',NULL),('Msg0001','HP_M1130','2023-05-09 10:03:34','2023-05-09 10:03:34','2023-05-09 10:04:00',46,'C',NULL,NULL,'As0001',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:53:13','4',NULL),('Msg0013','VPN Configuration','2023-05-09 10:04:41','2023-05-09 10:04:41','2023-05-09 10:04:57',47,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:53:24','4',NULL),('Msg0013','VPN Configuration','2023-05-09 10:07:55','2023-05-09 10:07:55','2023-05-09 10:08:10',48,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:53:34','5',NULL),('Msg0013','VPN Configuration','2023-05-09 10:11:38','2023-05-09 10:11:38','2023-05-09 10:11:55',49,'O',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:53:56','1',NULL),('Msg0006','Uninstall SONIC WALL VPN','2023-05-09 10:13:36','2023-05-09 10:13:36','2023-05-09 10:13:54',50,'C',NULL,NULL,'AS50111',NULL,'ekta',11,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:54:07','4',NULL),('Msg0005','Install SONIC WALL VPN','2023-05-09 10:14:24','2023-05-09 10:14:24','2023-05-09 10:14:42',51,'C',NULL,NULL,'AS50111',NULL,'ekta',11,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:54:20','4',NULL),('Msg0013','VPN Configuration','2023-05-09 10:14:58','2023-05-09 10:14:58','2023-05-09 10:15:15',52,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:54:44','3',NULL),('Msg0014','Antivirus Update','2023-05-09 10:17:01','2023-05-09 10:17:01','2023-05-09 10:17:18',53,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:55:03','4',NULL),('Msg0009','Outlook2013','2023-05-09 10:18:13','2023-05-09 10:18:13','2023-05-09 10:18:30',54,'C',NULL,NULL,'AS000',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:55:14','3',NULL),('Msg0004','Disk cleanup','2023-05-17 05:31:38','2023-05-17 05:31:38','2023-05-18 10:29:03',55,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:55:26','3',NULL),('Msg0004','Disk cleanup','2023-05-18 10:29:37','2023-05-18 10:29:37','2023-05-18 10:29:54',56,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:55:36','3',NULL),('Msg0014','Antivirus Update','2023-05-18 10:31:31','2023-05-18 10:31:31','2023-05-18 10:31:47',57,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:55:46','4',NULL),('Msg0014','Antivirus Update','2023-05-18 10:32:16','2023-05-18 10:32:16','2023-05-18 10:32:36',58,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:57:05','4',NULL),('Msg0006','Uninstall ADOBE','2023-05-18 10:33:28','2023-05-18 10:33:28','2023-05-18 10:33:55',59,'C',NULL,NULL,'AS5001',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:42:08','3',NULL),('Msg0006','Uninstall SONIC WALL VPN','2023-05-18 10:33:32','2023-05-18 10:33:32','2023-05-18 10:34:23',60,'C',NULL,NULL,'AS50111',NULL,'ekta',11,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 07:05:41','4',NULL),('Msg0005','Install SONIC WALL VPN','2023-05-18 10:35:01','2023-05-18 10:35:01','2023-05-18 10:35:18',61,'C',NULL,NULL,'AS50111',NULL,'ekta',11,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 07:05:44','4',NULL),('Msg0013','VPN Configuration','2023-05-18 10:36:05','2023-05-18 10:36:05','2023-05-18 10:36:22',62,'O',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:42:24','',NULL),('Msg0013','VPN Configuration','2023-05-18 10:41:05','2023-05-18 10:41:05','2023-05-18 10:41:25',63,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:42:35','4',NULL),('Msg0009','Outlook2013','2023-05-18 10:57:03','2023-05-18 10:57:03','2023-05-18 10:57:19',64,'C',NULL,NULL,'AS000',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:42:45','4',NULL),('Msg0009','Outlook2013','2023-05-18 10:58:14','2023-05-18 10:58:14','2023-05-18 10:58:32',65,'C',NULL,NULL,'AS000',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:43:18','5',NULL),('Msg0001','HP_M1130','2023-05-18 11:01:25','2023-05-18 11:01:25','2023-05-18 11:01:55',66,'C',NULL,NULL,'As0001',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:43:28','4',NULL),('Msg0001','ljP1000_P1500-HB-pnp','2023-05-18 11:03:02','2023-05-18 11:03:02','2023-05-18 11:03:18',67,'C',NULL,NULL,'As00011',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:44:52','4',NULL),('Msg0006','Uninstall WINRAR','2023-05-18 12:17:16','2023-05-18 12:17:16','2023-05-18 12:17:35',68,'C',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:45:07','5',NULL),('Msg0005','Install ADOBE','2023-05-18 12:28:37','2023-05-18 12:28:37','2023-05-18 12:28:47',69,'C',NULL,NULL,'AS5001',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:45:20','5',NULL),('Msg0005','Install ADOBE','2023-05-18 12:35:05','2023-05-18 12:35:05','2023-05-18 12:35:29',70,'C',NULL,NULL,'AS5001',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:45:31','4',NULL),('Msg0005','Install 7ZIP','2023-05-18 12:36:31','2023-05-18 12:36:31','2023-05-18 12:36:48',71,'C',NULL,NULL,'AS5012',NULL,'ekta',111,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:45:43','5',NULL),('Msg0005','Install 7ZIP','2023-05-18 12:37:26','2023-05-18 12:37:26','2023-05-18 12:37:42',72,'O',NULL,NULL,'AS5012',NULL,'ekta',111,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:45:58','5',NULL),('Msg0005','Install FIREFOX','2023-05-18 12:38:16','2023-05-18 12:38:16','2023-05-18 12:38:36',73,'C',NULL,NULL,'AS5002',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:46:09','4',NULL),('Msg0006','Uninstall FIREFOX','2023-05-18 12:38:58','2023-05-18 12:38:58','2023-05-18 12:39:16',74,'C',NULL,NULL,'AS5002',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:46:30','5',NULL),('Msg0005','Install FIREFOX','2023-05-18 12:39:54','2023-05-18 12:39:54','2023-05-18 12:40:15',75,'C',NULL,NULL,'AS5002',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:46:48','3',NULL),('Msg0006','Uninstall FIREFOX','2023-05-18 12:41:13','2023-05-18 12:41:13','2023-05-18 12:41:34',76,'C',NULL,NULL,'AS5002',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:46:57','2',NULL),('Msg0005','Install MS TEAMS','2023-05-18 12:42:58','2023-05-18 12:42:58','2023-05-18 12:43:18',77,'C',NULL,NULL,'AS5014',NULL,'ekta',14,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:47:14','1',NULL),('Msg0005','Install TEAM VIEWER','2023-05-18 12:45:33','2023-05-18 12:45:33','2023-05-18 12:45:55',78,'C',NULL,NULL,'AS5013',NULL,'ekta',12,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:47:24','2',NULL),('Msg0006','Uninstall ADOBE','2023-05-18 12:47:29','2023-05-18 12:47:29','2023-05-18 12:47:52',79,'C',NULL,NULL,'AS5001',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:51:07','4',NULL),('Msg0006','Uninstall MS TEAMS','2023-05-18 12:54:16','2023-05-18 12:54:16','2023-05-18 12:54:31',80,'C',NULL,NULL,'AS5014',NULL,'ekta',14,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:50:10','4',NULL),('Msg0006','Uninstall TEAM VIEWER','2023-05-18 12:55:58','2023-05-18 12:55:58','2023-05-18 12:56:16',81,'C',NULL,NULL,'AS5013',NULL,'ekta',12,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:49:57','4',NULL),('Msg0005','Install 7ZIP','2023-05-19 06:19:05','2023-05-19 06:19:05','2023-05-19 06:19:22',82,'C',NULL,NULL,'AS5012',NULL,'ekta',14,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:49:42','4',NULL),('Msg0005','Install MS TEAMS','2023-05-19 06:22:36','2023-05-19 06:22:36','2023-05-19 06:22:56',83,'C',NULL,NULL,'AS5014',NULL,'ekta',14,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:49:30','3',NULL),('Msg0005','Install MS TEAMS','2023-05-19 06:24:37','2023-05-19 06:24:37','2023-05-19 06:24:55',84,'C',NULL,NULL,'AS5014',NULL,'ekta',14,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:49:28','3',NULL),('Msg0005','Install MS TEAMS','2023-05-19 06:49:55','2023-05-19 06:49:55','2023-05-19 06:50:55',85,'C',NULL,NULL,'AS5014',NULL,'ekta',10,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:49:24','3',NULL),('Msg0006','Uninstall MS TEAMS','2023-05-22 05:51:07','2023-05-22 05:51:07','2023-05-22 05:52:43',86,'C',NULL,NULL,'AS5014',NULL,'ekta',10,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:48:49','4',NULL),('Msg0005','Install 7ZIP','2023-05-22 05:53:36','2023-05-22 05:53:36','2023-05-22 05:53:55',87,'C',NULL,NULL,'AS5012',NULL,'ekta',14,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:48:38','2',NULL),('Msg0005','Install ADOBE','2023-05-22 05:55:38','2023-05-22 05:55:38','2023-05-22 05:55:58',88,'C',NULL,NULL,'AS5001',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:48:17','4',NULL),('Msg0005','Install FIREFOX','2023-05-22 05:58:20','2023-05-22 05:58:20','2023-05-22 05:58:38',89,'C',NULL,NULL,'AS5002',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:47:51','4',NULL),('Msg0005','Install MS TEAMS','2023-05-22 05:59:47','2023-05-22 05:59:47','2023-05-22 06:01:06',90,'C',NULL,NULL,'AS5014',NULL,'ekta',10,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-22 06:47:39','3',NULL),('Msg0006','Uninstall ADOBE','2023-05-23 05:48:46','2023-05-23 05:48:46','2023-05-23 05:49:12',91,'C',NULL,NULL,'AS5001',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:56:11','5',NULL),('Msg0006','Uninstall MS TEAMS','2023-05-23 05:50:34','2023-05-23 05:50:34','2023-05-23 05:51:36',92,'C',NULL,NULL,'AS5014',NULL,'ekta',10,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:56:23','4',NULL),('Msg0006','Uninstall FIREFOX','2023-05-23 05:52:12','2023-05-23 05:52:12','2023-05-23 05:52:33',93,'C',NULL,NULL,'AS5002',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:56:34','4',NULL),('Msg0006','Uninstall 7ZIP','2023-05-23 05:53:09','2023-05-23 05:53:09','2023-05-23 05:53:27',94,'C',NULL,NULL,'AS5012',NULL,'ekta',14,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:56:46','5',NULL),('Msg0006','Uninstall SONIC WALL VPN','2023-05-23 05:53:46','2023-05-23 05:53:46','2023-05-23 05:54:07',95,'C',NULL,NULL,'AS50111',NULL,'ekta',11,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 05:57:10','5',NULL),('Msg0005','Install 7ZIP','2023-05-23 06:07:43','2023-05-23 06:07:43','2023-05-23 06:08:03',96,'C',NULL,NULL,'AS5012',NULL,'ekta',14,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 06:08:40','3',NULL),('Msg0014','Antivirus Update','2023-05-23 06:09:00','2023-05-23 06:09:00','2023-05-23 06:09:17',97,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 06:09:58','4',NULL),('Msg0005','Install SONIC WALL VPN','2023-05-23 06:10:11','2023-05-23 06:10:11','2023-05-23 06:10:27',98,'C',NULL,NULL,'AS50111',NULL,'ekta',11,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 06:11:07','3',NULL),('Msg0013','VPN Configuration','2023-05-23 06:11:29','2023-05-23 06:11:29','2023-05-23 06:11:47',99,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 06:14:12','5',NULL),('Msg0009','Outlook2013','2023-05-23 06:15:32','2023-05-23 06:15:32','2023-05-23 06:15:47',100,'C',NULL,NULL,'AS000',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 06:21:33','4',NULL),('Msg0004','Disk cleanup','2023-05-23 06:21:48','2023-05-23 06:21:48','2023-05-23 06:22:06',101,'O',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-05-23 06:23:08','',NULL),('Msg0004','Disk cleanup','2023-06-06 09:33:15','2023-06-06 09:33:15','2023-06-06 09:33:32',102,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:15:03','4',NULL),('Msg0013','VPN Configuration','2023-06-06 09:38:02','2023-06-06 09:38:02','2023-06-06 09:38:17',103,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:15:19','3',NULL),('Msg0009','Outlook2013','2023-06-06 15:34:49','2023-06-06 15:34:49','2023-06-06 15:35:09',104,'C',NULL,NULL,'AS000',NULL,'ekta',2,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:15:33','2',NULL),('Msg0014','Antivirus Update','2023-06-06 15:37:50','2023-06-06 15:37:50','2023-06-06 15:38:07',105,'C',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:15:45','5',NULL),('Msg0006','Uninstall 7ZIP','2023-06-06 15:40:29','2023-06-06 15:40:29','2023-06-06 15:40:45',106,'O',NULL,NULL,'AS5012',NULL,'ekta',14,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:16:06','',NULL),('Msg0006','Uninstall 7ZIP','2023-06-06 15:43:13','2023-06-06 15:43:13','2023-06-06 15:43:29',107,'C',NULL,NULL,'AS5012',NULL,'ekta',14,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:16:20','5',NULL),('Msg0006','Uninstall SONIC WALL VPN','2023-06-06 15:46:01','2023-06-06 15:46:01','2023-06-06 15:46:19',108,'C',NULL,NULL,'AS50111',NULL,'ekta',11,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:16:30','5',NULL),('Msg0005','Install MS TEAMS','2023-06-06 15:47:59','2023-06-06 15:47:59','2023-06-06 15:49:00',109,'C',NULL,NULL,'AS5014',NULL,'ekta',10,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:16:43','5',NULL),('Msg0005','Install TEAM VIEWER','2023-06-06 15:52:59','2023-06-06 15:52:59','2023-06-06 15:53:18',110,'C',NULL,NULL,'AS5013',NULL,'ekta',12,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:17:03','4',NULL),('Msg0005','Install 7ZIP','2023-06-06 16:02:17','2023-06-06 16:02:17','2023-06-06 16:02:34',111,'C',NULL,NULL,'AS5012',NULL,'ekta',14,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:17:22','5',NULL),('Msg0005','Install ADOBE','2023-06-06 16:03:06','2023-06-06 16:03:06','2023-06-06 16:03:33',112,'C',NULL,NULL,'AS5001',NULL,'ekta',1,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:17:32','4',NULL),('Msg0005','Install WINRAR','2023-06-06 16:05:42','2023-06-06 16:05:42','2023-06-06 16:06:02',113,'C',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,'2023-06-07 05:17:44','4',NULL),('Msg0004','Disk cleanup','2023-06-07 06:54:36','2023-06-07 06:54:36','2023-12-29 17:38:53',114,'N',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'maheshwar@aforeserve.co.in',NULL,NULL,NULL,NULL,NULL,NULL),('Msg0006','Uninstall MS TEAMS','2023-06-07 07:11:45','2023-06-07 07:11:45','2023-06-07 07:12:44',115,'N',NULL,NULL,'AS5014',NULL,'ekta',10,NULL,'maheshwar@aforeserve.co.in',NULL,NULL,NULL,NULL,NULL,NULL),('Msg0005','Install MS TEAMS','2023-06-07 07:12:49','2023-06-07 07:12:49','2023-06-07 07:13:58',116,'N',NULL,NULL,'AS5014',NULL,'ekta',10,NULL,'maheshwar@aforeserve.co.in',NULL,NULL,NULL,NULL,NULL,NULL),('Msg0004','Disk cleanup','2023-12-22 05:54:17','2023-12-22 05:54:17','2023-12-22 05:55:14',117,'N',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL),('Msg0005','Install WINRAR','2023-12-22 05:55:58','2023-12-22 05:55:58','2023-12-22 05:56:16',118,'N',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL),('Msg0005','Install WINRAR','2023-12-22 05:58:12','2023-12-22 05:58:12','2023-12-22 05:58:31',119,'N',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL),('Msg0006','Uninstall WINRAR','2023-12-22 05:59:12','2023-12-22 05:59:12','2023-12-22 05:59:30',120,'N',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL),('Msg0004','Disk cleanup','2023-12-30 06:50:50','2023-12-30 06:50:50','2023-12-30 06:51:07',121,'N',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL),('Msg0004','Disk cleanup','2023-12-30 06:52:24','2023-12-30 06:52:24','2023-12-30 06:52:43',122,'N',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL),('Msg0005','Install WINRAR','2023-12-30 08:53:02','2023-12-30 08:53:02','2023-12-30 08:53:22',123,'N',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL),('Msg0004','Disk cleanup','2023-12-30 09:39:58','2023-12-30 09:39:58','2023-12-30 09:40:16',124,'N',NULL,NULL,'AS000',NULL,'ekta',0,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL),('Msg0005','Install WINRAR','2023-12-30 09:41:05','2023-12-30 09:41:05','2023-12-30 09:41:21',125,'N',NULL,NULL,'AS5003',NULL,'ekta',3,NULL,'ektasharma011@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `vf_agent_mgs_dtls` ENABLE KEYS */;
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
