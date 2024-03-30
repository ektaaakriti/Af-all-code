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
-- Table structure for table `asset_master`
--

DROP TABLE IF EXISTS `asset_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_master` (
  `asset_id` int NOT NULL AUTO_INCREMENT,
  `adobe_reader` varchar(4) DEFAULT 'NA',
  `aforesight_agent_id` varchar(40) DEFAULT 'NA',
  `anydesk` varchar(4) DEFAULT 'NA',
  `assets_status` varchar(40) DEFAULT 'NA',
  `auto_cad` varchar(4) DEFAULT 'NA',
  `delete_status` text,
  `department_name` varchar(40) DEFAULT 'NA',
  `google_chrome` varchar(4) DEFAULT 'NA',
  `hd_capacity` varchar(40) DEFAULT 'NA',
  `hd_make` varchar(40) DEFAULT 'NA',
  `hd_model` varchar(40) DEFAULT 'NA',
  `hd_serial_number` varchar(40) DEFAULT 'NA',
  `java8` varchar(4) DEFAULT 'NA',
  `mbd_make` varchar(40) DEFAULT 'NA',
  `mbd_model` varchar(40) DEFAULT 'NA',
  `mbd_serial_number` varchar(40) DEFAULT 'NA',
  `ms_office_2007` varchar(4) DEFAULT 'NA',
  `ms_office_2010` varchar(4) DEFAULT 'NA',
  `ms_office_2013` varchar(4) DEFAULT 'NA',
  `ms_office_2016` varchar(4) DEFAULT 'NA',
  `mcafee_antivirus` varchar(4) DEFAULT 'NA',
  `microsoft_teams` varchar(4) DEFAULT 'NA',
  `monitor_model` varchar(40) DEFAULT 'NA',
  `monitor_screen_make` varchar(40) DEFAULT 'NA',
  `monitor_screen_size` varchar(40) DEFAULT 'NA',
  `monitor_serial_number` varchar(100) DEFAULT 'NA',
  `mozilla_firefox` varchar(4) DEFAULT 'NA',
  `os_version` varchar(40) DEFAULT 'NA',
  `one_drive` varchar(40) DEFAULT 'NA',
  `processor_details` varchar(70) DEFAULT 'NA',
  `procument_id` varchar(4) DEFAULT 'NA',
  `procured_date` varchar(4) DEFAULT 'NA',
  `product_type` varchar(40) DEFAULT 'NA',
  `ram_available` varchar(10) DEFAULT 'NA',
  `ram_used` varchar(10) DEFAULT 'NA',
  `retired_date` varchar(20) DEFAULT 'NA',
  `scan_date` datetime DEFAULT NULL,
  `site_name` varchar(40) DEFAULT 'NA',
  `software_list_with_version_and_installed_date` varchar(40) DEFAULT 'NA',
  `sub_department_name` varchar(40) DEFAULT 'NA',
  `symantec_antivirus` varchar(4) DEFAULT 'NA',
  `system_hostname` varchar(40) DEFAULT 'NA',
  `system_ip_address` varchar(40) DEFAULT 'NA',
  `system_make` varchar(40) DEFAULT 'NA',
  `system_model` varchar(40) DEFAULT 'NA',
  `system_os_type` varchar(40) DEFAULT 'NA',
  `system_serial_number` varchar(40) DEFAULT 'NA',
  `team_viewer` varchar(4) DEFAULT 'NA',
  `total_ram` varchar(40) DEFAULT 'NA',
  `trend_micro_antivirus` varchar(4) DEFAULT 'NA',
  `type_of_chipset` varchar(40) DEFAULT 'NA',
  `username` varchar(40) DEFAULT 'NA',
  `warranty_amc` varchar(40) DEFAULT 'NA',
  `warranty_amc_vendor_name` varchar(40) DEFAULT 'NA',
  `warrenty_amc_from` varchar(40) DEFAULT 'NA',
  `warrenty_amc_to` varchar(40) DEFAULT 'NA',
  `webex` varchar(4) DEFAULT 'NA',
  `winrar` varchar(4) DEFAULT 'NA',
  `zoom` varchar(4) DEFAULT 'NA',
  `zip7` varchar(4) DEFAULT 'NA',
  `os_key` varchar(40) DEFAULT 'NA',
  `os_license_details` varchar(40) DEFAULT 'NA',
  `system_form_factor` text,
  `ram_slots_available` text,
  `ram_slots_used` text,
  `user_id` varchar(40) DEFAULT 'NA',
  `count` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`asset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_master`
--

LOCK TABLES `asset_master` WRITE;
/*!40000 ALTER TABLE `asset_master` DISABLE KEYS */;
INSERT INTO `asset_master` VALUES (33,'NO','NA','NO','DeAllocated','NO','NO','Store','NO','465 GB','(Standard disk drives)','WDC WD5000AAKX-75U6AA0','WD-WCC2E3RVL1NL','NO','Dell Inc.','OptiPlex 3020','5NZBH92','NO','NO','NO','NO','NO','NO','DesktopMonitor1','(Standard monitor types)','NA','DISPLAY\\DEFAULT_MONITOR\\1&1F0C3C2F&0&UID256','NO','Windows 10 Pro','NO','Intel(R) Core(TM) i3-4160 CPU @ 3.60GHz','NA','NA','Desktop MT','4.59Gb','3.33Gb','2022-02-30 01:02:35','2023-04-12 11:18:26','NA','NA','NA','NO','DESKTOP-QOSIS42','192.168.0.207','Dell Inc.','OptiPlex 3020','Windows 10','5NZBH92','NO','7.92Gb','NO','NA','ekta','NA','NA','NA','NA','NO','NO','NO','NO','NA','NA','NA','NA','NA','ekta',NULL),(34,'NO','NA','NO','Allocate','NO','NO','Designing','NO','465 GB','(Standard disk drives)','ST500LT012-1DG142','S3PV99NH','NO','Dell Inc.','Latitude E6330','6WZXFV1','NO','NO','NO','NO','NO','NO','DesktopMonitor1','(Standard monitor types)','NA','DISPLAY\\SEC5441\\4&1C857E9B&0&UID67568640','NO','Windows 10 Pro','NO','Intel(R) Core(TM) i5-3320M CPU @ 2.60GHz','NA','NA','Desktop MT','2.41Gb','5.48Gb','2022-08-30 03:08:09','2023-04-12 11:18:26','Noida','NA','NA','NO','DESKTOP-R2C1E0U','172.21.144.1','Dell Inc.','Latitude E6330','Windows 10','6WZXFV1','NO','7.89Gb','NO','NA','ram','NA','NA','NA','NA','NO','NO','NO','NO','NA','NA','NA','NA','NA','Abrar',NULL),(35,'NO','NA','NO','NA','NO','NO','Project','NO','465 GB','(Standard disk drives)','WDC WD5000AAKX-08U6AA0','WD-WCC2EVK89876','NO','Dell Inc.','OptiPlex 3020','BGJHG32','NO','NO','NO','NO','NO','NO','DesktopMonitor1','(Standard monitor types)','NA','DISPLAY\\ACR0425\\4&1E13E2A2&0&UID16843008','NO','Windows 8.1','NO','Intel(R) Core(TM) i3-4130 CPU @ 3.40GHz','NA','NA','Desktop MT','5.86Gb','2.06Gb','NA','2023-04-12 11:18:26','Noida','NA','NA','NO','ABC','192.168.0.231','Dell Inc.','OptiPlex 3020','Windows','BGJHG32','NO','7.92Gb','NO','NA','vikas','NA','NA','NA','NA','NO','NO','NO','NO','NA','NA','NA','NA','NA','Aforesight3',NULL);
/*!40000 ALTER TABLE `asset_master` ENABLE KEYS */;
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
