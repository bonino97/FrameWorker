CREATE DATABASE  IF NOT EXISTS `frameworker` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `frameworker`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: frameworker
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `comando`
--

DROP TABLE IF EXISTS `comando`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comando` (
  `idLenguaje` int(11) NOT NULL,
  `commandKey` int(11) NOT NULL,
  `value` varchar(100) DEFAULT NULL,
  KEY `idLenguaje` (`idLenguaje`),
  CONSTRAINT `comando_ibfk_1` FOREIGN KEY (`idLenguaje`) REFERENCES `lenguaje` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comando`
--

LOCK TABLES `comando` WRITE;
/*!40000 ALTER TABLE `comando` DISABLE KEYS */;
/*!40000 ALTER TABLE `comando` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lenguaje`
--

DROP TABLE IF EXISTS `lenguaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lenguaje` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `path` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lenguaje`
--

LOCK TABLES `lenguaje` WRITE;
/*!40000 ALTER TABLE `lenguaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `lenguaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libreria`
--

DROP TABLE IF EXISTS `libreria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libreria` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `idLenguaje` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idLenguaje` (`idLenguaje`),
  CONSTRAINT `libreria_ibfk_1` FOREIGN KEY (`idLenguaje`) REFERENCES `lenguaje` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libreria`
--

LOCK TABLES `libreria` WRITE;
/*!40000 ALTER TABLE `libreria` DISABLE KEYS */;
/*!40000 ALTER TABLE `libreria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `idLenguaje` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `idLenguaje` (`idLenguaje`),
  CONSTRAINT `proyecto_ibfk_1` FOREIGN KEY (`idLenguaje`) REFERENCES `lenguaje` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectolenguajelibreria`
--

DROP TABLE IF EXISTS `proyectolenguajelibreria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectolenguajelibreria` (
  `idProyecto` int(11) DEFAULT NULL,
  `idLenguaje` int(11) DEFAULT NULL,
  `idLibreria` int(11) DEFAULT NULL,
  KEY `idLenguaje` (`idLenguaje`),
  KEY `idLibreria` (`idLibreria`),
  KEY `proyectolenguajelibreria_ibfk_1_idx` (`idProyecto`),
  CONSTRAINT `proyectolenguajelibreria_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyecto` (`idLenguaje`),
  CONSTRAINT `proyectolenguajelibreria_ibfk_2` FOREIGN KEY (`idLenguaje`) REFERENCES `lenguaje` (`id`),
  CONSTRAINT `proyectolenguajelibreria_ibfk_3` FOREIGN KEY (`idLibreria`) REFERENCES `libreria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectolenguajelibreria`
--

LOCK TABLES `proyectolenguajelibreria` WRITE;
/*!40000 ALTER TABLE `proyectolenguajelibreria` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyectolenguajelibreria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `mac` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `surname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (4,'test2','test2',NULL,'test2','test2','test2@test2'),(5,'test3','test3',NULL,'test3',NULL,'test3@test3.com'),(6,'test4','test4',NULL,'test4',NULL,'test4@test4.com'),(7,'test5','test5',NULL,'test5','test5','test5@test5.com'),(8,'test6','test6',NULL,'test6','test6','test6@test6.com'),(9,'test7','test7',NULL,'test7','test7','test7@test7.com');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioproyecto`
--

DROP TABLE IF EXISTS `usuarioproyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarioproyecto` (
  `idUsuario` int(11) NOT NULL,
  `idProyecto` int(11) NOT NULL,
  KEY `usuarioproyecto_ibfk_1_idx` (`idUsuario`),
  KEY `usuarioproyecto_ibfk_2_idx` (`idProyecto`),
  CONSTRAINT `usuarioproyecto_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `usuarioproyecto_ibfk_2` FOREIGN KEY (`idProyecto`) REFERENCES `proyecto` (`idLenguaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioproyecto`
--

LOCK TABLES `usuarioproyecto` WRITE;
/*!40000 ALTER TABLE `usuarioproyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarioproyecto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-13  3:56:49
