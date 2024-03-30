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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `First_Name` text,
  `Last_Name` text,
  `AD_User_login_ID` int DEFAULT NULL,
  `Password_enc` text,
  `Mobile` bigint DEFAULT NULL,
  `Email_ID` text,
  `Password` text,
  `Department` text,
  `Location` text,
  `Manager_Name` text,
  `Manager_User_ID` int DEFAULT NULL,
  `Emp_Code` int DEFAULT NULL,
  `username` text,
  `admin_panel_enable` text,
  `user_group_id` text,
  `user_id` int DEFAULT NULL,
  `delete_status` text,
  `id` int DEFAULT NULL,
  `ItsmAPI` text,
  `ItsmUsername` text,
  `ItsmUserId` text,
  `user_locked` text,
  `user_type` varchar(2) DEFAULT NULL,
  `user_login` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Abrar','Ahmad',1,'Afs@123#',8826035564,'maheshwar@aforeserve.co.in12','U2FsdGVkX1804ExVbaTdx6n3sPsU/kdjX60uz0RWuMs=','Sales','Rampur','Sulabh Awasthi',110025,110024,'Abrar','YES','1',1421,'No',0,'','','','N','A',NULL),('ekta','Sharma',2,'Afs@123#',8826135564,'ektasharma011@gmail.com','U2FsdGVkX1804ExVbaTdx6n3sPsU/kdjX60uz0RWuMs=','Sales','Noida','Rajeev sharma',110045,111987,'ekta','YES','1',1422,'No',1,'','','','N','U','Y'),('Chiranjeev','Patel',3,'Afs@123#',9826035564,'chiranjeev@aforesight.local','U2FsdGVkX1804ExVbaTdx6n3sPsU/kdjX60uz0RWuMs=','IT','Delhi','Rajnish Tripathi',110215,119876,'Chiranjeev','YES','1',1423,'No',2,'','','','N','A','Y'),('Aforesight','asc',4,'Afs@123#',6826035564,'mohsin.khan@kratikal.com','U2FsdGVkX1804ExVbaTdx6n3sPsU/kdjX60uz0RWuMs=','IT','Delhi','Rajnish Tripathi',113808,110986,'kratikal','YES','1',1424,'No',4,'','','','N','A',NULL),('Prabhat','Shukla',5,'Afs@123#',6326035569,'prabhat@aforesight.local','U2FsdGVkX1804ExVbaTdx6n3sPsU/kdjX60uz0RWuMs=','CCC','Delhi','KK Bijani',115609,110098,'Prabhat','YES','1',1425,'No',5,'','','','N','A',NULL),('Abdul','Ahad',6,'Afs@123#',6386294991,'abdul@aforesight.local','U2FsdGVkX1804ExVbaTdx6n3sPsU/kdjX60uz0RWuMs=','CCC','Delhi','Rajeev Bansal',113324,117765,'Abdulahad','YES','1',1426,'No',6,'','','','N','A','Y'),('Maheshwar','Dobhal',123,'Afs@123#',9311379514,'maheshwar@aforeserve.co.in1','U2FsdGVkX1804ExVbaTdx6n3sPsU/kdjX60uz0RWuMs=','Sales','Noida','NA',1234,123456,'Piyush-AFS','YES','1',2620,'YES',7,'','','','N','A',NULL),('Maheshwar1','Dobhal',123,'123456',1234567890,'maheshwar@aforeserve.co.in1','U2FsdGVkX1804ExVbaTdx6n3sPsU/kdjX60uz0RWuMs=','Sales','Noida','NA',1234,123456,'Sam','YES','1',2626,'YES',8,'','','','N','A',NULL),('mahesh','dobhal',1,'U2FsdGVkX1971oE3NusXJBP7sOKgBMvR7y/vRKNQfVc=',9311379514,'maheshwar@aforeserve.co.in12','U2FsdGVkX1+Jjhz2BqkyxHLy7V3ei2u8tvEtB9QImWI=','Information Technology','Uttar Pradesh','RT1',1,118811,'maheshd',NULL,'1',11,'NO',26,NULL,NULL,NULL,'N','U','N'),('mahesh.dobhal','shivani',12,'U2FsdGVkX19waJ5tV6hF90Gml3VDg0T/nmVm5d+tVIs=',9876543210,'mahesh.dobhal512@gmail.com','U2FsdGVkX1/5npMbcHzXfaRw2PxmpPwA143vG6lTgjY=','Information Technology','Uttar Pradesh','RT',12,119911,'mahesh',NULL,'12',12,'NO',27,NULL,NULL,NULL,NULL,'A','Y');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-30  9:33:23
