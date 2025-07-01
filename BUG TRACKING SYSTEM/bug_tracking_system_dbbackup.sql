-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: bds
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `bugreport`
--

DROP TABLE IF EXISTS `bugreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bugreport` (
  `bugNo` int NOT NULL,
  `bugCode` int DEFAULT NULL,
  `projectID` int DEFAULT NULL,
  `TCode` int DEFAULT NULL,
  `ECode` int DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `bugDes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bugNo`),
  KEY `bugCode` (`bugCode`),
  KEY `projectID` (`projectID`),
  KEY `TCode` (`TCode`),
  KEY `ECode` (`ECode`),
  CONSTRAINT `bugreport_ibfk_1` FOREIGN KEY (`bugCode`) REFERENCES `bugtype` (`bugCode`),
  CONSTRAINT `bugreport_ibfk_2` FOREIGN KEY (`projectID`) REFERENCES `project` (`projectID`),
  CONSTRAINT `bugreport_ibfk_3` FOREIGN KEY (`TCode`) REFERENCES `employee` (`empCode`),
  CONSTRAINT `bugreport_ibfk_4` FOREIGN KEY (`ECode`) REFERENCES `employee` (`empCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bugreport`
--

LOCK TABLES `bugreport` WRITE;
/*!40000 ALTER TABLE `bugreport` DISABLE KEYS */;
INSERT INTO `bugreport` VALUES (302,4,202,114,108,'resolved','Login screen throws runtime exception.'),(303,6,203,115,109,'pending','Incorrect tax calculation in billing.'),(304,9,204,116,110,'pending','UI not aligned on mobile view.'),(305,12,205,117,111,'resolved','Password reset leaks token in URL.'),(306,13,206,118,112,'pending','App crashes instantly on startup.'),(307,15,207,123,119,'pending','User session expires too early.'),(308,3,208,124,120,'resolved','Submit button missing from contact form.'),(309,2,209,125,121,'resolved','Compilation error due to missing semicolon.'),(310,10,210,126,122,'pending','App loads very slowly on homepage.'),(312,16,212,114,107,'pending','Email input does not validate format.'),(313,5,213,115,108,'resolved','WebSocket connection randomly fails.'),(314,14,214,116,109,'pending','Back button leads to wrong page.'),(315,8,215,117,110,'pending','Incorrect currency conversion.'),(316,11,201,118,111,'resolved','Broken link on FAQ page.'),(317,7,202,123,112,'pending','Unhandled exception on error popup.'),(318,20,203,124,119,'resolved','Form allows multiple submits.'),(319,18,204,125,120,'pending','Data not saved after form submission.'),(320,19,205,126,121,'pending','Push notifications not sent.'),(322,4,207,114,130,'pending','App freezes after login.'),(323,6,208,115,107,'resolved','Wrong logic used in age calculation.'),(324,12,209,116,108,'pending','Sensitive data exposed in logs.'),(325,10,210,117,109,'resolved','Page load time exceeds 8 seconds.'),(326,13,211,118,110,'pending','Crash when switching tabs quickly.'),(327,15,212,123,111,'resolved','Session timeout does not log out.'),(328,3,213,124,112,'pending','Submit command not working.'),(329,2,214,125,119,'resolved','Syntax error on build.'),(330,14,215,126,120,'pending','Wrong screen opened from dashboard.'),(332,7,202,114,122,'pending','No error handling for empty fields.'),(333,8,203,115,130,'pending','Decimal rounding issue in reports.'),(334,17,204,116,107,'resolved','Images not visible in gallery.'),(335,16,205,117,108,'pending','Email field accepts special characters.'),(338,18,208,114,110,'Pending','Website crashes');
/*!40000 ALTER TABLE `bugreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bugtype`
--

DROP TABLE IF EXISTS `bugtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bugtype` (
  `bugCode` int NOT NULL,
  `bugCatgory` varchar(30) DEFAULT NULL,
  `bugSeverty` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`bugCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bugtype`
--

LOCK TABLES `bugtype` WRITE;
/*!40000 ALTER TABLE `bugtype` DISABLE KEYS */;
INSERT INTO `bugtype` VALUES (1,'Functional Error','Critical'),(2,'Compilation Error','Major'),(3,'Missing Command','Medium'),(4,'Runtime Error','Critical'),(5,'Communication Problem','Major'),(6,'Logical Error','Major'),(7,'Inappropriate Error Handling','Medium'),(8,'Calculation Issue','Major'),(9,'UI Misalignment','Low'),(10,'Slow Response','Medium'),(11,'Broken Link','Low'),(12,'Security Vulnerability','Critical'),(13,'Crash on Launch','Critical'),(14,'Incorrect Navigation','Medium'),(15,'Session Timeout Issue','Major'),(16,'Incorrect Validation','Major'),(17,'Image Not Loading','Low'),(18,'Data Not Saving','Critical'),(19,'Missing Notification','Low'),(20,'Multiple Submissions','Medium');
/*!40000 ALTER TABLE `bugtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `empCode` int NOT NULL,
  `empName` varchar(30) DEFAULT NULL,
  `empEmail` varchar(40) DEFAULT NULL,
  `empPassword` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `DOB` varchar(20) DEFAULT NULL,
  `mobileNo` bigint DEFAULT NULL,
  `Role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`empCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (101,'Ananya Singh','ananya.admin@gmail.com','Admin@123','Female','1990-06-15',9876543210,'Admin'),(102,'Rohan Mehta','rohan_mehta@outlook.com','Rohan#456','Male','1988-04-20',8765432109,'Admin'),(103,'Meera Das','meera_das@hotmail.com','Meera$789','Female','1992-01-12',7654321098,'Admin'),(104,'Sahil Kapoor','kapoorsahil13@gmail.com','Sahil@#321','Male','1985-07-09',9123456789,'Manager'),(105,'Priya Verma','priya.v@outlook.com','Priya123$','Female','1987-03-23',9234567890,'Manager'),(106,'Ankit Rana','ankit.rana607@outlook.com','Ankit@456','Male','1991-12-17',7889123345,'Manager'),(107,'Deepika Sharma','deepika.dev@gmail.com','DevPass1!','Female','1994-09-02',9456789012,'Developer'),(108,'Rajiv Nair','rajiv.nair@yahoo.com','Rajiv#789','Male','1993-08-19',9567890123,'Developer'),(109,'Kritika Malhotra','kritika.m@protonmail.com','Kriti@dev9','Female','1990-11-25',9678901234,'Developer'),(110,'Neeraj Kumar','neeraj.k@zoho.com','NKumar123$','Male','1989-05-11',9789012345,'Developer'),(111,'Simran Kaur','simran.k@gmail.com','Simran#007','Female','1995-04-10',9890123456,'Developer'),(112,'Tanmay Rao','tanmayr@outlook.com','TanR@dev','Male','1992-03-30',9001234567,'Developer'),(114,'Vivek Bhatt','vivek.b@gmail.com','Vivek@test','Male','1991-08-13',9223456789,'Tester'),(115,'Ritika Bansal','ritika_bansal@yahoo.com','Ritika!321','Female','1993-07-21',9334567890,'Tester'),(116,'Yash Agarwal','yash.a@zoho.com','Yash#999','Male','1990-06-08',9445678901,'Tester'),(117,'Sneha Jain','sneha.j@protonmail.com','Sneha456$','Female','1995-01-01',9556789012,'Tester'),(118,'Karan Oberoi','karan.o@outlook.com','Karan@1234','Male','1988-12-31',9667890123,'Tester'),(119,'Isha Talwar','isha.t@gmail.com','Isha987$','Female','1991-09-14',9778901234,'Developer'),(120,'Dev Joshi','dev.j@outlook.com','DevJ@321','Male','1993-05-22',9889012345,'Developer'),(121,'Neha Rawat','neha.r@zoho.com','Neha@1010','Female','1992-07-07',9990123456,'Developer'),(122,'Puneet Gill','puneet.g@hotmail.com','Puneet#234','Male','1989-10-16',9011234567,'Developer'),(123,'Divya Roy','divya.r@gmail.com','Divya@000','Female','1994-03-03',9122345678,'Tester'),(124,'Aman Seth','aman.s@yahoo.com','Aman@T999','Male','1990-11-11',9233456789,'Tester'),(125,'Srishti Kapoor','srishti.k@zoho.com','Srishti#121','Female','1991-01-20',9344567890,'Tester'),(126,'Zaid Khan','zaid.k@outlook.com','Zaid123@','Male','1992-08-08',9455678901,'Tester'),(127,'Nidhi Mishra','nidhi.m@gmail.com','Nidhi@321','Female','1987-06-06',9566789012,'Manager'),(128,'Manav Arora','manav.a@yahoo.com','Manav!432','Male','1986-12-12',9677890123,'Manager'),(129,'Tanya Sengupta','tanya.s@zoho.com','Tanya$999','Female','1990-02-14',9788901234,'Manager'),(130,'Rajat Desai','rajat.d@protonmail.com','RajatDev@8','Male','1988-01-30',9899012345,'Developer'),(178,'Neraj Jain','Neeru45%@outlook.com','Neeraj78','Male','1998-09-21',9005674512,'Developer');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `projectID` int NOT NULL,
  `projectName` varchar(30) DEFAULT NULL,
  `SDate` varchar(30) DEFAULT NULL,
  `EDate` varchar(30) DEFAULT NULL,
  `projectDec` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`projectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (201,'AI Chatbot System','2023-06-01','2025-01-30','An AI-powered chatbot for customer service automation.'),(202,'Smart Health Tracker','2024-01-15','2025-07-31','Wearable-integrated platform to track health vitals in real-time.'),(203,'E-Learning Portal','2022-10-10','2024-12-20','Interactive learning platform for online courses and exams.'),(204,'Weather Prediction System','2023-11-20','2025-08-10','A machine learning model to predict local weather patterns.'),(205,'Crypto Wallet App','2023-03-01','2024-11-30','Secure mobile wallet to store and manage cryptocurrencies.'),(206,'Food Delivery System','2022-09-15','2024-07-15','Real-time food ordering and delivery tracking app.'),(207,'Online Voting Platform','2023-12-01','2025-05-01','A secure blockchain-based online election system.'),(208,'Fitness App with AI','2024-05-01','2025-12-31','AI-driven fitness recommendations and progress tracking app.'),(209,'Virtual Internship Portal','2024-02-15','2025-06-15','Portal to manage remote internships for students.'),(210,'Inventory Management','2023-08-10','2024-10-25','System for tracking stock levels, orders, and deliveries.'),(211,'Online Banking UI Redesign','2024-03-05','2025-03-01','Frontend redesign for mobile and web banking applications.'),(212,'Job Recommendation Engine','2023-07-01','2024-09-01','Machine learning based job matching and recommendation system.'),(213,'Expense Splitter App','2022-12-20','2024-08-15','Mobile app for tracking and splitting group expenses.'),(214,'E-Vehicle Charge Finder','2024-06-01','2026-01-01','App to locate nearby electric vehicle charging stations.'),(215,'Smart Home Dashboard','2023-10-15','2025-02-28','Dashboard to control and monitor IoT-based home appliances.');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-01 14:01:56
