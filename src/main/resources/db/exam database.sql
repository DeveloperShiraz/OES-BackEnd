-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: exam
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `active_exam_questions`
--

DROP TABLE IF EXISTS `active_exam_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `active_exam_questions` (
  `active_exam_question_id` int NOT NULL AUTO_INCREMENT,
  `question_id` int NOT NULL,
  `exam_history_id` int NOT NULL,
  `exam_status` varchar(25) NOT NULL,
  `user_answer` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`active_exam_question_id`),
  KEY `question_id_idx` (`question_id`),
  KEY `exam_foreign_key_1_idx` (`exam_history_id`),
  CONSTRAINT `exam_foreign_key_1` FOREIGN KEY (`exam_history_id`) REFERENCES `exam_history` (`exam_history_id`),
  CONSTRAINT `exam_foreign_key_2` FOREIGN KEY (`question_id`) REFERENCES `exam_questions` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `active_exam_questions`
--

LOCK TABLES `active_exam_questions` WRITE;
/*!40000 ALTER TABLE `active_exam_questions` DISABLE KEYS */;
INSERT INTO `active_exam_questions` VALUES (1,21,1,'Test_started',NULL),(2,20,1,'Test_started',NULL),(3,4,1,'Test_started',NULL),(4,1,1,'Test_started',NULL),(5,8,1,'Test_started',NULL),(6,1,2,'Test_started',NULL),(7,3,2,'Test_started',NULL),(8,19,2,'Test_started',NULL),(9,23,2,'Test_started',NULL),(10,16,2,'Test_started',NULL),(11,13,3,'Test_started',NULL),(12,7,3,'Test_started',NULL),(13,23,3,'Test_started',NULL),(14,5,3,'Test_started','c'),(15,9,3,'Test_started',NULL);
/*!40000 ALTER TABLE `active_exam_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_history`
--

DROP TABLE IF EXISTS `exam_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_history` (
  `exam_history_id` int NOT NULL AUTO_INCREMENT,
  `email_id` varchar(50) NOT NULL,
  `exam_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `no_of_questions_attempted` int NOT NULL,
  `actual_no_of_questions` int NOT NULL,
  `marks_gained` int NOT NULL,
  `exam_status` varchar(25) NOT NULL,
  PRIMARY KEY (`exam_history_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_history`
--

LOCK TABLES `exam_history` WRITE;
/*!40000 ALTER TABLE `exam_history` DISABLE KEYS */;
INSERT INTO `exam_history` VALUES (1,'shiraz@google.com','2022-04-27 00:00:00',0,5,0,'failed'),(2,'shiraz@google.com','2022-04-27 00:00:00',0,5,0,'failed'),(3,'shiraz@google.com','2022-04-27 00:00:00',0,5,0,'failed');
/*!40000 ALTER TABLE `exam_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_questions`
--

DROP TABLE IF EXISTS `exam_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_questions` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(1000) NOT NULL,
  `option_a` varchar(250) NOT NULL,
  `option_b` varchar(250) NOT NULL,
  `option_c` varchar(250) NOT NULL,
  `option_d` varchar(250) NOT NULL,
  `answer` varchar(1) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_questions`
--

LOCK TABLES `exam_questions` WRITE;
/*!40000 ALTER TABLE `exam_questions` DISABLE KEYS */;
INSERT INTO `exam_questions` VALUES (1,'Who invented Java programming?','a) Guido Van Rossum','b) James Gosling','c) Dennis Ritchie','d) Bjarne Stroustrup','b'),(2,'Which Statement is True About Java?','a) Java is a sequence-dependent programming language','b) Java is a code dependent programming language','c) Java is a platform-dependent programming language','d) Java is a platform-independent programming language','d'),(3,'Which component is used to compile, debug and execute the java programs?','a) JRE','b) JIT','c) JDK','d) JVM','c'),(4,'Which one of the following is not a Java feature?','a) Object-oriented','b) Use of pointers','c) Portable','d) Dynamic and Extensible','b'),(5,'Which of these cannot be used for a variable name in Java?','a) identifier & keyword','b) identifier','c) keyword','d) none of the mentioned','c'),(6,'What is the extension of java code files?','a) .js','b) .txt','c) .class','d) .java','d'),(7,'Which environment variable is used to set the java path?','a) MAVEN_Path','b) JavaPATH','c) JAVA','d) JAVA_HOME','d'),(8,'Which of the following is not an OOPS concept in Java?','a) Polymorphism','b) Inheritance','c) Compilation','d) Encapsulation','c'),(9,'What is not the use of “this” keyword in Java?','a) Referring to the instance variable when a local variable has the same name','b) Passing itself to the method of the same class','c) Passing itself to another method','d) Calling another constructor in constructor chaining','b'),(10,'Which of the following is a type of polymorphism in Java Programming?','a) Multiple polymorphism','b) Compile time polymorphism','c) Multilevel polymorphism','d) Execution time polymorphism','b'),(11,'What is Truncation in Java?','a) Floating-point value assigned to a Floating type','b) Floating-point value assigned to an integer type','c) Integer value assigned to floating type','d) Integer value assigned to floating type','b'),(12,'What is the extension of compiled java classes?','a) .txt','b) .js','c) .class','d) .java','c'),(13,'Which exception is thrown when java is out of memory?','a) MemoryError','b) OutOfMemoryError','c) MemoryOutOfBoundsException','d) MemoryFullException','b'),(14,'Which of these are selection statements in Java?','a) break','b) continue','c) for()','d) if()','d'),(15,'Which of these keywords is used to define interfaces in Java?','a) intf','b) Intf','c) interface','d) Interface','c'),(16,'Which of the following is a superclass of every class in Java?','a) ArrayList','b) Abstract class','c) Object class','d) String','c'),(17,'Which of the below is not a Java Profiler?','a) JProfiler','b) Eclipse Profiler','c) JVM','d) JConsole','c'),(18,'Which of these packages contains the exception Stack Overflow in Java?','a) java.io','b) java.system','c) java.lang','d) java.util','c'),(19,'Which of these statements is incorrect about Thread?','a) start() method is used to begin execution of the thread','b) run() method is used to begin execution of a thread before start() method in special cases','c) A thread can be formed by implementing Runnable interface only','d) A thread can be formed by a class that extends Thread class','b'),(20,'Which of these keywords are used for the block to be examined for exceptions?','a) check','b) throw','c) catch','d) try','d'),(21,'Which one of the following is not an access modifier?','a) Protected','b) Void','c) Public','d) Private','b'),(22,'What is the numerical range of a char data type in Java?','a) 0 to 256','b) -128 to 127','c) 0 to 65535','d) 0 to 32767','c'),(23,'Which class provides system independent server side implementation?','a) Server','b) ServerReader','c) Socket','d) ServerSocket','d'),(24,'Which of the following is true about servlets?','a) Servlets can use the full functionality of the Java class libraries','b) Servlets execute within the address space of web server, platform independent and uses the functionality of java class libraries','c) Servlets execute within the address space of web server','d) Servlets are platform-independent because they are written in java','b');
/*!40000 ALTER TABLE `exam_questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-29 15:02:23
