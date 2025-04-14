-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gamelisttest
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avaliacao` (
  `id_avaliacao` int(11) NOT NULL AUTO_INCREMENT,
  `id_jogo` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `tx_comentario` text DEFAULT NULL,
  `nr_usuario_nota` decimal(3,1) NOT NULL,
  `dt_comentario` date DEFAULT NULL,
  `dt_envio` varchar(45) NOT NULL,
  PRIMARY KEY (`id_avaliacao`),
  KEY `t_avaliacao_ibfk_1` (`id_usuario`),
  KEY `t_avaliacao_ibfk_4` (`id_jogo`),
  CONSTRAINT `t_avaliacao_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `t_avaliacao_ibfk_4` FOREIGN KEY (`id_jogo`) REFERENCES `jogo` (`id_jogo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `desenvolvedora`
--

DROP TABLE IF EXISTS `desenvolvedora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `desenvolvedora` (
  `id_desenvolvedora` int(11) NOT NULL AUTO_INCREMENT,
  `nm_desenvolvedora` varchar(100) NOT NULL,
  PRIMARY KEY (`id_desenvolvedora`),
  UNIQUE KEY `nm_desenvolvedora_UNIQUE` (`nm_desenvolvedora`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desenvolvedora`
--

LOCK TABLES `desenvolvedora` WRITE;
/*!40000 ALTER TABLE `desenvolvedora` DISABLE KEYS */;
/*!40000 ALTER TABLE `desenvolvedora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribuidora`
--

DROP TABLE IF EXISTS `distribuidora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribuidora` (
  `id_distribuidora` int(11) NOT NULL AUTO_INCREMENT,
  `nm_distribuidora` varchar(100) NOT NULL,
  PRIMARY KEY (`id_distribuidora`),
  UNIQUE KEY `nm_distribuidora_UNIQUE` (`nm_distribuidora`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribuidora`
--

LOCK TABLES `distribuidora` WRITE;
/*!40000 ALTER TABLE `distribuidora` DISABLE KEYS */;
/*!40000 ALTER TABLE `distribuidora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `id_genero` int(11) NOT NULL AUTO_INCREMENT,
  `nm_genero` varchar(100) NOT NULL,
  PRIMARY KEY (`id_genero`),
  UNIQUE KEY `nm_genero_UNIQUE` (`nm_genero`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero_do_jogo`
--

DROP TABLE IF EXISTS `genero_do_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero_do_jogo` (
  `id_jogo` int(11) NOT NULL,
  `id_genero` int(11) NOT NULL,
  PRIMARY KEY (`id_jogo`,`id_genero`),
  KEY `fk_T_JOGO_has_T_GENERO_T_GENERO1_idx` (`id_genero`),
  KEY `fk_T_JOGO_has_T_GENERO_T_JOGO1_idx` (`id_jogo`),
  CONSTRAINT `fk_T_JOGO_has_T_GENERO_T_GENERO1` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_JOGO_has_T_GENERO_T_JOGO1` FOREIGN KEY (`id_jogo`) REFERENCES `jogo` (`id_jogo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero_do_jogo`
--

LOCK TABLES `genero_do_jogo` WRITE;
/*!40000 ALTER TABLE `genero_do_jogo` DISABLE KEYS */;
/*!40000 ALTER TABLE `genero_do_jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogo`
--

DROP TABLE IF EXISTS `jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jogo` (
  `id_jogo` int(11) NOT NULL AUTO_INCREMENT,
  `id_distribuidora` int(11) NOT NULL,
  `id_desenvolvedora` int(11) NOT NULL,
  `nm_jogo` varchar(200) NOT NULL,
  `ds_sinopse` text NOT NULL,
  `dt_lancamento` date NOT NULL,
  `ds_imagem` varchar(255) NOT NULL,
  PRIMARY KEY (`id_jogo`),
  UNIQUE KEY `nm_jogo_UNIQUE` (`nm_jogo`),
  UNIQUE KEY `ds_imagem_UNIQUE` (`ds_imagem`),
  KEY `fk_T_JOGO_T_DISTRIBUIDORA1_idx` (`id_distribuidora`),
  KEY `fk_T_JOGO_T_DESENVOLVEDORA1_idx` (`id_desenvolvedora`),
  CONSTRAINT `fk_T_JOGO_T_DESENVOLVEDORA1` FOREIGN KEY (`id_desenvolvedora`) REFERENCES `desenvolvedora` (`id_desenvolvedora`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_JOGO_T_DISTRIBUIDORA1` FOREIGN KEY (`id_distribuidora`) REFERENCES `distribuidora` (`id_distribuidora`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogo`
--

LOCK TABLES `jogo` WRITE;
/*!40000 ALTER TABLE `jogo` DISABLE KEYS */;
/*!40000 ALTER TABLE `jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogo_adicionado`
--

DROP TABLE IF EXISTS `jogo_adicionado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jogo_adicionado` (
  `id_lista` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_jogo` int(11) NOT NULL,
  KEY `fk_t_jogo_adicionado_t_lista1_idx` (`id_lista`),
  KEY `fk_t_jogo_adicionado_t_usuario1_idx` (`id_usuario`),
  KEY `fk_t_jogo_adicionado_t_jogo1_idx` (`id_jogo`),
  CONSTRAINT `fk_t_jogo_adicionado_t_jogo1` FOREIGN KEY (`id_jogo`) REFERENCES `jogo` (`id_jogo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_jogo_adicionado_t_lista1` FOREIGN KEY (`id_lista`) REFERENCES `lista` (`id_lista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_jogo_adicionado_t_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogo_adicionado`
--

LOCK TABLES `jogo_adicionado` WRITE;
/*!40000 ALTER TABLE `jogo_adicionado` DISABLE KEYS */;
/*!40000 ALTER TABLE `jogo_adicionado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista`
--

DROP TABLE IF EXISTS `lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista` (
  `id_lista` int(11) NOT NULL AUTO_INCREMENT,
  `nm_lista` varchar(45) NOT NULL,
  PRIMARY KEY (`id_lista`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista`
--

LOCK TABLES `lista` WRITE;
/*!40000 ALTER TABLE `lista` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modo`
--

DROP TABLE IF EXISTS `modo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modo` (
  `id_modo` int(11) NOT NULL AUTO_INCREMENT,
  `nm_modo` varchar(100) NOT NULL,
  PRIMARY KEY (`id_modo`),
  UNIQUE KEY `nm_modo_UNIQUE` (`nm_modo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modo`
--

LOCK TABLES `modo` WRITE;
/*!40000 ALTER TABLE `modo` DISABLE KEYS */;
/*!40000 ALTER TABLE `modo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modo_de_jogo`
--

DROP TABLE IF EXISTS `modo_de_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modo_de_jogo` (
  `id_jogo` int(11) NOT NULL,
  `id_modo` int(11) NOT NULL,
  PRIMARY KEY (`id_jogo`,`id_modo`),
  KEY `fk_T_JOGO_has_T_MODO_JOGO_T_MODO_JOGO1_idx` (`id_modo`),
  KEY `fk_T_JOGO_has_T_MODO_JOGO_T_JOGO1_idx` (`id_jogo`),
  CONSTRAINT `fk_T_JOGO_has_T_MODO_JOGO_T_JOGO1` FOREIGN KEY (`id_jogo`) REFERENCES `jogo` (`id_jogo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_JOGO_has_T_MODO_JOGO_T_MODO_JOGO1` FOREIGN KEY (`id_modo`) REFERENCES `modo` (`id_modo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modo_de_jogo`
--

LOCK TABLES `modo_de_jogo` WRITE;
/*!40000 ALTER TABLE `modo_de_jogo` DISABLE KEYS */;
/*!40000 ALTER TABLE `modo_de_jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissao` (
  `id_permissao` int(11) NOT NULL AUTO_INCREMENT,
  `nm_permissao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_permissao`),
  UNIQUE KEY `nmPermissao_UNIQUE` (`nm_permissao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao`
--

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` VALUES (1,'Administrador');
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plataforma`
--

DROP TABLE IF EXISTS `plataforma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plataforma` (
  `id_plataforma` int(11) NOT NULL AUTO_INCREMENT,
  `nm_plataforma` varchar(100) NOT NULL,
  PRIMARY KEY (`id_plataforma`),
  UNIQUE KEY `nm_plataforma_UNIQUE` (`nm_plataforma`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plataforma`
--

LOCK TABLES `plataforma` WRITE;
/*!40000 ALTER TABLE `plataforma` DISABLE KEYS */;
/*!40000 ALTER TABLE `plataforma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plataformas_jogaveis`
--

DROP TABLE IF EXISTS `plataformas_jogaveis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plataformas_jogaveis` (
  `id_plataforma` int(11) NOT NULL,
  `id_jogo` int(11) NOT NULL,
  PRIMARY KEY (`id_plataforma`,`id_jogo`),
  KEY `fk_t_plataforma_has_t_jogo_t_jogo1_idx` (`id_jogo`),
  KEY `fk_t_plataforma_has_t_jogo_t_plataforma1_idx` (`id_plataforma`),
  CONSTRAINT `fk_t_plataforma_has_t_jogo_t_jogo1` FOREIGN KEY (`id_jogo`) REFERENCES `jogo` (`id_jogo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_plataforma_has_t_jogo_t_plataforma1` FOREIGN KEY (`id_plataforma`) REFERENCES `plataforma` (`id_plataforma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plataformas_jogaveis`
--

LOCK TABLES `plataformas_jogaveis` WRITE;
/*!40000 ALTER TABLE `plataformas_jogaveis` DISABLE KEYS */;
/*!40000 ALTER TABLE `plataformas_jogaveis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_permissao` int(11) NOT NULL,
  `nm_username` varchar(255) DEFAULT NULL,
  `nm_apelido` varchar(255) DEFAULT NULL,
  `ds_email` varchar(255) DEFAULT NULL,
  `ds_senha` varchar(255) DEFAULT NULL,
  `nr_telefone` varchar(20) DEFAULT NULL,
  `dt_nascimento` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `ds_email_UNIQUE` (`ds_email`),
  UNIQUE KEY `nm_username_UNIQUE` (`nm_username`),
  UNIQUE KEY `nm_apelido_UNIQUE` (`nm_apelido`),
  UNIQUE KEY `nr_telefone_UNIQUE` (`nr_telefone`),
  KEY `fk_T_USUARIO_T_PERMISSAO1_idx` (`id_permissao`),
  CONSTRAINT `fk_T_USUARIO_T_PERMISSAO1` FOREIGN KEY (`id_permissao`) REFERENCES `permissao` (`id_permissao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'AokiFernandes','Aoki','duduzebas@gmail.com','123456789',NULL,NULL),(2,1,'ThiagoDosSantos','Sr_Xurineio','ThiagoDosSantos','987654321',NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-14 17:39:35
