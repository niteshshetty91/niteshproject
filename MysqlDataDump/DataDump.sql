CREATE DATABASE  IF NOT EXISTS `project` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `project`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `audit_log`
--

DROP TABLE IF EXISTS `audit_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit_log` (
  `audit_log_id` varchar(255) NOT NULL,
  `column_name` varchar(255) DEFAULT NULL,
  `column_value` varchar(255) DEFAULT NULL,
  `request_date` date DEFAULT NULL,
  `table_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`audit_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_log`
--

LOCK TABLES `audit_log` WRITE;
/*!40000 ALTER TABLE `audit_log` DISABLE KEYS */;
INSERT INTO `audit_log` VALUES ('17','customerPanNo','1223233223','2020-07-12','Policy'),('18','customerPanNo','1223233223','2020-07-12','Policy'),('19','customerPanNo','1223233223','2020-07-12','Policy'),('20','emailAddress','nitesh.shetty@gmail.com','2020-07-12','Policy'),('21','mobileNumber','8655530692','2020-07-12','Policy'),('24','emailAddress','nitesh.shetty@gmail.com','2020-07-12','Policy'),('25','emailAddress','nitesh.shetty@gmail.com','2020-07-12','Policy'),('26','mobileNumber','8655530693','2020-07-12','Policy'),('27','customerPanNo','123123','2020-07-12','Policy'),('29','emailAddress','nitesh.shetty@gmail.com','2020-07-12','Policy'),('7','emailAddress','niteshshetty91@yahoo.in','2020-07-10','Policy'),('8','mobileNumber','8655530693','2020-07-10','Policy'),('9','customerPanNo','123123','2020-07-10','Policy');
/*!40000 ALTER TABLE `audit_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (30);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy`
--

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `policy` (
  `policy_number` int NOT NULL,
  `bank_account_number` varchar(255) DEFAULT NULL,
  `contact_number_last_updated` varchar(255) DEFAULT NULL,
  `customer_id` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_pan_no` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `email_address_last_updated` varchar(255) DEFAULT NULL,
  `insured_name` varchar(255) DEFAULT NULL,
  `last_premium_paid` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `neft_registered` bit(1) DEFAULT NULL,
  `outstanding_payout` varchar(255) DEFAULT NULL,
  `policy_issuance_date` date DEFAULT NULL,
  `policy_status` varchar(255) DEFAULT NULL,
  `premium_mode` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `reinvest_applicable` bit(1) DEFAULT NULL,
  `unclaimed_amount` varchar(255) DEFAULT NULL,
  `whatsapp_opt_in_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`policy_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
INSERT INTO `policy` VALUES (2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,_binary '\0',NULL,NULL),(3,'12345','2020-01-01','1034','Nitesh Shetty','DMYPS2176A','2020-01-01','nitesh.shetty@gmail.com','2020-01-01','Nitesh Shetty','Y','8655530692',_binary '\0','21231.1232','2020-01-01','ACTIVE','MONTHLY','ID34555','Product 1',_binary '','13212.32','ACTIVE'),(4,'12345','2020-01-01','1034','Nitesh Shetty','DMYPS2176A','2020-01-01','nitesh.shetty@gmail.com','2020-01-01','Nitesh Shetty','Y','8655530692',_binary '\0','21231.1232','2020-01-01','ACTIVE','MONTHLY','ID34555','Product 1',_binary '','13212.32','ACTIVE'),(5,'12345','2020-01-01','1034','Nitesh Shetty','DMYPS2176A','2020-01-01','nitesh.shetty@gmail.com','2020-01-01','Nitesh Shetty','Y','8655530692',_binary '\0','21231.1232','2020-01-01','ACTIVE','MONTHLY','ID34555','Product 1',_binary '','13212.32','ACTIVE'),(6,'12345','2020-01-01','1034','Nitesh Shetty','DMYPS2176A','2020-01-01','nitesh.shetty@gmail.com','2020-01-01','Nitesh Shetty','Y','8655530693',_binary '\0','21231.1232','2020-01-01','ACTIVE','MONTHLY','ID34555','Product 1',_binary '','13212.32','ACTIVE'),(23,'12345','2020-01-01','1034','Rakesh Shetty','DMYPS2176A','2020-01-01','nitesh.shetty@gmail.com','2020-01-01','Rakesh Shetty','Y','8655530692',_binary '\0','21231.1232','2020-01-01','ACTIVE','MONTHLY','ID34555','Product 1',_binary '','13212.32','ACTIVE');
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` varchar(255) NOT NULL,
  `product_details` varchar(255) DEFAULT NULL,
  `product_end_date` varchar(255) DEFAULT NULL,
  `product_launch_date` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp_user`
--

DROP TABLE IF EXISTS `temp_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temp_user` (
  `mobile_number` varchar(255) NOT NULL,
  `created_time` date DEFAULT NULL,
  `expire_time` date DEFAULT NULL,
  `otp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mobile_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp_user`
--

LOCK TABLES `temp_user` WRITE;
/*!40000 ALTER TABLE `temp_user` DISABLE KEYS */;
INSERT INTO `temp_user` VALUES ('8655530692','2020-07-12','2020-07-12','1234'),('8655530693','2020-07-12','2020-07-12','1234');
/*!40000 ALTER TABLE `temp_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `whats_app_opt_in`
--

DROP TABLE IF EXISTS `whats_app_opt_in`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `whats_app_opt_in` (
  `optin_id` varchar(255) NOT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `optin_date` date DEFAULT NULL,
  `policy_number` int DEFAULT NULL,
  PRIMARY KEY (`optin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `whats_app_opt_in`
--

LOCK TABLES `whats_app_opt_in` WRITE;
/*!40000 ALTER TABLE `whats_app_opt_in` DISABLE KEYS */;
INSERT INTO `whats_app_opt_in` VALUES ('11','8655530692','2020-07-10',3),('12','8655530692','2020-07-11',3),('13','8655530692','2020-07-11',3),('14','8655530692','2020-07-11',3),('15','8655530692','2020-07-12',3),('16','8655530692','2020-07-12',3),('22','8655530693','2020-07-12',6),('28','8655530692','2020-07-12',3);
/*!40000 ALTER TABLE `whats_app_opt_in` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-12 16:43:13
