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
-- Table structure for table `discovered_assets`
--

DROP TABLE IF EXISTS `discovered_assets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discovered_assets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `adobe_reader` varchar(4) DEFAULT 'NA',
  `aforesight_agent_id` varchar(40) DEFAULT 'NA',
  `anydesk` varchar(4) DEFAULT 'NA',
  `assets_status` varchar(40) DEFAULT 'NA',
  `auto_cad` varchar(4) DEFAULT 'NA',
  `department_name` varchar(40) DEFAULT 'NA',
  `google_chrome` varchar(4) DEFAULT 'NA',
  `java8` varchar(4) DEFAULT 'NA',
  `mbd_make` varchar(40) DEFAULT 'NA',
  `mbd_model` varchar(40) DEFAULT 'NA',
  `mbd_serial_no` varchar(40) DEFAULT 'NA',
  `ms_office_2007` varchar(4) DEFAULT 'NA',
  `ms_office_2010` varchar(4) DEFAULT 'NA',
  `ms_office_2013` varchar(4) DEFAULT 'NA',
  `ms_office_2016` varchar(4) DEFAULT 'NA',
  `mcafee_antivirus` varchar(4) DEFAULT 'NA',
  `microsoft_teams` varchar(4) DEFAULT 'NA',
  `monitor_make` varchar(40) DEFAULT 'NA',
  `monitor_model` varchar(40) DEFAULT 'NA',
  `monitor_screen_size` varchar(40) DEFAULT 'NA',
  `monitor_serial_number` varchar(100) DEFAULT 'NA',
  `mozilla_firefox` varchar(4) DEFAULT 'NA',
  `one_drive` varchar(40) DEFAULT 'NA',
  `proccessor` varchar(70) DEFAULT 'NA',
  `procument_id` varchar(4) DEFAULT 'NA',
  `procured_date` varchar(4) DEFAULT 'NA',
  `ram_available` varchar(10) DEFAULT 'NA',
  `ram_used` varchar(10) DEFAULT 'NA',
  `retired_date` varchar(10) DEFAULT 'NA',
  `site_name` varchar(40) DEFAULT 'NA',
  `software_list_with_version_and_installed_date` varchar(40) DEFAULT 'NA',
  `sub_department_name` varchar(40) DEFAULT 'NA',
  `symantec_antivirus` varchar(4) DEFAULT 'NA',
  `system_hostname` varchar(40) DEFAULT 'NA',
  `system_ip` varchar(40) DEFAULT 'NA',
  `system_model_no` varchar(40) DEFAULT 'NA',
  `system_os_type` varchar(40) DEFAULT 'NA',
  `system_serial_no` varchar(40) DEFAULT 'NA',
  `team_viewer` varchar(4) DEFAULT 'NA',
  `total_ram` varchar(40) DEFAULT 'NA',
  `trend_micro_antivirus` varchar(4) DEFAULT 'NA',
  `type_of_chipset` varchar(40) DEFAULT 'NA',
  `user_id` varchar(40) DEFAULT 'NA',
  `warranty_amc` varchar(40) DEFAULT 'NA',
  `warranty_amc_vendor_name` varchar(40) DEFAULT 'NA',
  `warrenty_amc_from` varchar(40) DEFAULT 'NA',
  `warrenty_amc_to` varchar(40) DEFAULT 'NA',
  `webex` varchar(4) DEFAULT 'NA',
  `winrar` varchar(4) DEFAULT 'NA',
  `zoom` varchar(4) DEFAULT 'NA',
  `hd_capacity` varchar(40) DEFAULT 'NA',
  `hd_make` varchar(40) DEFAULT 'NA',
  `hd_model` varchar(40) DEFAULT 'NA',
  `hd_serial_number` varchar(40) DEFAULT 'NA',
  `os_version` varchar(40) DEFAULT 'NA',
  `product_type` varchar(40) DEFAULT 'NA',
  `scan_date` varchar(40) DEFAULT 'NA',
  `system_make` varchar(40) DEFAULT 'NA',
  `username` varchar(40) DEFAULT 'NA',
  `zip7` varchar(4) DEFAULT 'NA',
  `os_key` varchar(40) DEFAULT 'NA',
  `os_license_details` varchar(40) DEFAULT 'NA',
  `system_form_factor` varchar(10) DEFAULT 'NA',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discovered_assets`
--

LOCK TABLES `discovered_assets` WRITE;
/*!40000 ALTER TABLE `discovered_assets` DISABLE KEYS */;
INSERT INTO `discovered_assets` VALUES (10,'NO','NA','NO','NA','NO','NA','NO','YES','Microsoft Corporation','Virtual Machine','0000-0000-7569-8504-2450-7952-18','NO','NO','NO','NO','NO','NO','(Standard monitor types)','DesktopMonitor1','1024*768','DISPLAY\\MSH062E\\5&1A097CD8&0&UID5527112','NO','NO','Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz','NA','NA','5.0GB','11.0GB','NA','NA','NA','NA','NO','AVDevserver','10.0.0.4','Virtual Machine','Windows','0000-0000-7569-8504-2450-7952-18','NO','16.0GB','NO','NA','NA','NA','NA','NA','NA','NO','NO','NO','31 GB','(Standard disk drives)','Microsoft Virtual Disk','NA','Windows 10','Desktop MT','2023-04-12 11:18:26','Microsoft Corporation','ekta','NO','NA','NA','NA'),(12,'NO','NA','NO','NA','NO','NA','NO','YES','Microsoft Corporation','Virtual Machine','0000-0000-7569-8504-2450-7952-18','NO','NO','NO','NO','NO','NO','(Standard monitor types)','DesktopMonitor1','1024*768','DISPLAY\\MSH062E\\5&1A097CD8&0&UID5527112','NO','NO','Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz','NA','NA','11.0GB','5.0GB','NA','NA','NA','NA','NO','AVDevserver','10.0.0.4','Virtual Machine','Windows','0000-0000-7569-8504-2450-7952-18','NO','16.0GB','NO','NA','NA','NA','NA','NA','NA','NO','NO','NO','31 GB','(Standard disk drives)','Microsoft Virtual Disk','','Windows 10','Desktop MT','2023-06-06 09:07:01','Microsoft Corporation','ekta','NO','NA','NA','NA'),(13,'YES','NA','NO','NA','NO','NA','NO','YES','Microsoft Corporation','Virtual Machine','0000-0000-7569-8504-2450-7952-18','NO','NO','NO','NO','NO','NO','(Standard monitor types)','DesktopMonitor1','1024*768','DISPLAY\\MSH062E\\5&1A097CD8&0&UID5527112','NO','NO','Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz','NA','NA','12.0GB','4.0GB','NA','NA','NA','NA','NO','AVDevserver','10.0.0.4','Virtual Machine','Windows','0000-0000-7569-8504-2450-7952-18','NO','16.0GB','NO','NA','NA','NA','NA','NA','NA','NO','NO','NO','31 GB','(Standard disk drives)','Microsoft Virtual Disk','','Windows 10','Desktop MT','2023-12-21 06:06:49','Microsoft Corporation','ekta','NO','NA','NA','NA');
/*!40000 ALTER TABLE `discovered_assets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-30  9:33:26
