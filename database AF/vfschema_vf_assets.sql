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
-- Table structure for table `vf_assets`
--

DROP TABLE IF EXISTS `vf_assets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vf_assets` (
  `asset_id` text,
  `PN` text,
  `sw_install_path` text,
  `ip_address` text,
  `UN` text,
  `asset_description` text,
  `asset_type` text,
  `asset_creation_date` text,
  `asset_shared_location` text,
  `asset_updation_date` text,
  `created_by` text,
  `updated_by` text,
  `id` int DEFAULT NULL,
  `delete_status` text,
  `software_install_choice` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vf_assets`
--

LOCK TABLES `vf_assets` WRITE;
/*!40000 ALTER TABLE `vf_assets` DISABLE KEYS */;
INSERT INTO `vf_assets` VALUES ('AS5003','NA','C://Users//ekta//Desktop//software_list//winrar-x64-621.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','WINRAR','sw','2022-02-28 11:50:10','--','2022-02-28 11:50:10','system','system',3,'NO',3),('AS5001','NA','C://Users//ekta//Desktop//software_list//AcroRdrDC2001320074_en_US.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','ADOBE','sw','2022-02-28 11:49:53','--','2022-02-28 11:49:53','system','system',1,'NO',1),('AS5002','NA','C://Users//ekta//Desktop//software_list//FirefoxInstaller.exe','C://Users//Administrator//Desktop//Software_list//FirefoxSetup96.0.1.exe','\"Administrator,Afs@123#\"','FIREFOX','sw','2022-02-28 11:50:02','--','2022-02-28 11:50:02','system','system',2,'NO',2),('AS5004','NA','C://Users//Administrator//Desktop//Software_list//OFFICE2007.zip','\"182.75.176.109\"','\"Administrator,Afs@123#\"','office','swe','2022-02-28 11:50:21','--','2022-02-28 11:50:21','system','system',4,'NO',4),('AS5006','NA','C://Users//Administrator//Desktop//Software_list//jre-8u271-windows-i586.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','java 32 bit','swe','2022-02-28 11:50:41','--','2022-02-28 11:50:41','system','system',6,'NO',6),('AS5007','NA','C://Users//Administrator//Desktop//Software_list//jre-8u272-windows-x64.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','JAVA 64B','swe','2022-02-28 11:50:50','--','2022-02-28 11:50:50','system','system',7,'NO',7),('AS5005','NA','C://Users//Administrator//Desktop//Software_list//ChromeSetup.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','CHROME','swe','2022-02-28 11:50:31','--','2022-02-28 11:50:31','system','system',5,'NO',5),('AS5008','NA','C://Users//Administrator//Desktop//Software_list//AnyDesk.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','ANYDESK','swe','2022-03-03 16:43:32','--','2022-03-03 16:43:32','system','system',8,'NO',8),('As0001','N/A','C://Users//ekta//Desktop//software_list//HP_M1130_M1210_MFP_Full_Solution-v20180815-10158769_1.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','HP_M1130','lpr','2022-02-28 11:48:38','--','2022-02-28 11:48:38','system','system',17,'NO',0),('As0003','\"HP LaserJet Professional M1136 MFP\"','C://Users//Administrator//Desktop//Software_list//HPM1210.inf','\"192.168.1.197\"','NA','HP LaserJet Professional M1136 MFP','spr','2022-02-28 11:49:20','--','2022-02-28 11:49:20','system','system',0,'NO',0),('AS000','NA','NA','NA','NA','dummy','dummy','2022-03-10 15:19:17','NA','2022-03-10 15:19:17','NA','NA',0,'NA',10),('AS50051','NA','C://Users//Administrator//Desktop//Software_list//MS OFFICE 16 64 BIT.zip','\"182.75.176.109\"','\"Administrator,Afs@123#\"','office 365','swe','2022-02-28 11:50:31','--','2022-02-28 11:50:31','system','system',10,'NO',10),('AS5009','NA','C://Users//Administrator//Desktop//Software_list//Webex.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','WEBEX','swe','2022-08-17 16:44:04','--','2022-08-17 16:44:04','system','system',9,'NO',9),('AS5011','NA','C://Users//ekta//Desktop//software_list//ZoomInstallerFull.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','ZOOM','sw','2022-08-17 16:45:41','--','2022-08-17 16:45:41','system','system',11,'NO',13),('AS5012','NA','C://Users//ekta//Desktop//software_list//7z2201-x64.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','7ZIP','sw','2022-08-17 16:47:22','--','2022-08-17 16:47:22','system','system',12,'NO',14),('AS5013','NA','C://Users//ekta//Desktop//software_list//TeamViewer_Setup_x64.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','TEAM VIEWER','sw','2022-08-17 16:48:52','--','2022-08-17 16:48:52','system','system',13,'NO',12),('As00011','N/A','C://Users//Administrator//Desktop//Software_list//ljP1000_P1500-HB-pnp-win64-en.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','ljP1000_P1500-HB-pnp','lpr','2022-08-17 17:08:22','--','2022-08-17 17:08:22','system','system',0,'NO',0),('As000113','N/A','C://Users//Administrator//Desktop//Software_list//ljP1000_P1500-HB-pnp-win64-en.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','ljP1000_P1500-HB-pnp','lpreee','2022-08-17 17:09:22','--','2022-08-17 17:09:22','system','system',0,'NO',0),('AS5014','NA','C://Users//ekta//Desktop//software_list//MSTeamsSetup_c_l_.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','MS TEAMS','sw','2022-08-17 17:16:15','--','2022-08-17 17:16:15','system','system',14,'NO',10),('AS5015','NA','C://Users//ekta//Desktop//software_list//OneDriveSetup','\"182.75.176.109\"','\"Administrator,Afs@123#\"','ONE DRIVE','swe','2022-08-17 17:17:26','--','2022-08-17 17:17:26','system','system',9,'NO',9),('AS50111','NA','C://Users//ekta//Desktop//software_list//NXSetupU-x64-10.2.324.exe','\"182.75.176.109\"','\"Administrator,Afs@123#\"','SONIC WALL VPN','sw','2022-08-23 16:09:52','--','2022-08-23 16:09:52','system','system',15,'NO',11);
/*!40000 ALTER TABLE `vf_assets` ENABLE KEYS */;
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
