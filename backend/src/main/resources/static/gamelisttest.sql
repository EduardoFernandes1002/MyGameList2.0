-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gamelisttest
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `avaliacao` VALUES (1,2,1,'TesteComentario',7.0,'2025-05-13','2025-05-13'),(2,2,2,'Tão bom que jogo até quando não deveria',10.0,'2025-05-22','2025-05-22');
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `desenvolvedora`
--

DROP TABLE IF EXISTS `desenvolvedora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `desenvolvedora` (
  `id_desenvolvedora` int(11) NOT NULL AUTO_INCREMENT,
  `nm_desenvolvedora` varchar(100) NOT NULL,
  PRIMARY KEY (`id_desenvolvedora`),
  UNIQUE KEY `nm_desenvolvedora_UNIQUE` (`nm_desenvolvedora`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desenvolvedora`
--

LOCK TABLES `desenvolvedora` WRITE;
/*!40000 ALTER TABLE `desenvolvedora` DISABLE KEYS */;
INSERT INTO `desenvolvedora` VALUES (2,' Afterthought LLC'),(7,'CD Projekt Red'),(8,'EA Vancouver'),(5,'Epic Games'),(4,'FromSoftware'),(11,'InnerSloth'),(6,'Mojang Studios'),(3,'Nintendo EPD'),(12,'Respawn Entertainment'),(9,'Santa Monica Studio'),(10,'Supergiant Games'),(1,'TesteDesenvolvedora');
/*!40000 ALTER TABLE `desenvolvedora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribuidora`
--

DROP TABLE IF EXISTS `distribuidora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `distribuidora` VALUES (2,'Afterthought LLC'),(4,'Bandai Namco Entertainment'),(7,'CD Projekt'),(8,'Electronic Arts'),(5,'Epic Games'),(11,'InnerSloth'),(3,'Nintendo'),(9,'Sony Interactive Entertainment'),(10,'Supergiant Games'),(1,'TesteDistribuidora'),(6,'Xbox Game Studios');
/*!40000 ALTER TABLE `distribuidora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `id_genero` int(11) NOT NULL AUTO_INCREMENT,
  `nm_genero` varchar(100) NOT NULL,
  PRIMARY KEY (`id_genero`),
  UNIQUE KEY `nm_genero_UNIQUE` (`nm_genero`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Ação'),(3,'Aventura'),(9,'Battle Royale'),(8,'Esporte'),(4,'FPS'),(13,'Hack and Slash'),(6,'Luta'),(11,'MMORPG'),(12,'Mundo Aberto'),(10,'Patlaforma'),(5,'RPG'),(14,'SandBox'),(7,'Simulacao'),(2,'Sobrevivencia');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero_do_jogo`
--

DROP TABLE IF EXISTS `genero_do_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `genero_do_jogo` VALUES (1,1),(1,2),(2,2),(2,3),(3,1),(3,3),(4,5),(4,12),(5,4),(5,9),(6,2),(6,14),(7,1),(7,12),(8,7),(8,8),(9,1),(9,13),(10,1),(10,5),(11,1),(11,9),(12,4),(12,9);
/*!40000 ALTER TABLE `genero_do_jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogo`
--

DROP TABLE IF EXISTS `jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jogo` (
  `id_jogo` int(11) NOT NULL AUTO_INCREMENT,
  `id_distribuidora` int(11) NOT NULL,
  `id_desenvolvedora` int(11) NOT NULL,
  `nm_jogo` varchar(200) NOT NULL,
  `ds_sinopse` text NOT NULL,
  `dt_lancamento` date NOT NULL,
  `ds_imagem` varchar(255) NOT NULL,
  `nr_total_nota` decimal(3,1) DEFAULT NULL,
  PRIMARY KEY (`id_jogo`),
  UNIQUE KEY `nm_jogo_UNIQUE` (`nm_jogo`),
  UNIQUE KEY `ds_imagem_UNIQUE` (`ds_imagem`),
  KEY `fk_T_JOGO_T_DISTRIBUIDORA1_idx` (`id_distribuidora`),
  KEY `fk_T_JOGO_T_DESENVOLVEDORA1_idx` (`id_desenvolvedora`),
  CONSTRAINT `fk_T_JOGO_T_DESENVOLVEDORA1` FOREIGN KEY (`id_desenvolvedora`) REFERENCES `desenvolvedora` (`id_desenvolvedora`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_JOGO_T_DISTRIBUIDORA1` FOREIGN KEY (`id_distribuidora`) REFERENCES `distribuidora` (`id_distribuidora`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogo`
--

LOCK TABLES `jogo` WRITE;
/*!40000 ALTER TABLE `jogo` DISABLE KEYS */;
INSERT INTO `jogo` VALUES (1,1,1,'TesteJogo','TesteSinopse','2000-01-01','https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Test.svg/1200px-Test.svg.png',9.9),(2,2,2,'The Isle','Jogo de dino legal','2015-11-01','https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/376210/capsule_616x353.jpg?t=1653237914',10.0),(3,3,3,'The Legend of Zelda: Breath of the Wild','Em um reino devastado, Link deve explorar Hyrule para derrotar Calamity Ganon.','2017-03-03','https://assets.nintendo.com/image/upload/ar_16:9,c_lpad,w_656/b_white/f_auto/q_auto/ncom/software/switch/70010000000025/7137262b5a64d921e193653f8aa0b722925abc5680380ca0e18a5cfd91697f58',8.0),(4,4,4,'Elden Ring','Um RPG de ação em um mundo aberto criado por Hidetaka Miyazaki e George R.R. Martin.','2022-02-25','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5Nou4oHurJxom1LW1QZvXbvtsRRzpNTD28g&s',8.7),(5,5,5,'Fortnite','Um jogo de battle royale onde 100 jogadores lutam até restar um vencedor.','2017-07-25','https://cdn2.unrealengine.com/14br-consoles-1920x1080-wlogo-1920x1080-432974386.jpg',6.0),(6,6,6,'Minecraft','Construa, explore e sobreviva em um mundo gerado proceduralmente.','2011-11-18','https://image.api.playstation.com/vulcan/img/cfn/11307uYG0CXzRuA9aryByTHYrQLFz-HVQ3VVl7aAysxK15HMpqjkAIcC_R5vdfZt52hAXQNHoYhSuoSq_46_MT_tDBcLu49I.png',8.7),(7,7,7,'Cyberpunk 2077','Em Night City, um mercenário busca um implante único que concede a imortalidade.','2020-12-10','https://image.api.playstation.com/vulcan/ap/rnd/202209/2703/8ZqdXQN9qkBGLaO5R9dUQJGQ.png',8.0),(8,8,8,'FIFA 23','O último jogo da franquia FIFA com times, estádios e modos atualizados.','2022-09-30','https://image.api.playstation.com/vulcan/ap/rnd/202207/1219/5fz6p4zQmQ5SqUgjKu6GqMX3.png',6.0),(9,9,9,'God of War: Ragnarök','Kratos e Atreus enfrentam o Fimbulwinter e a chegada do Ragnarök.','2022-11-09','https://image.api.playstation.com/vulcan/ap/rnd/202207/1210/4xJ8XB3bi888QTLZYdl7Oi0s.png',9.0),(10,10,10,'Hades','Um roguelike onde Zagreus tenta escapar do Submundo grego.','2020-09-17','https://image.api.playstation.com/vulcan/ap/rnd/202008/1321/5m0Tz5MELh6DdQ43SJtBw4GJ.png',7.1),(11,11,11,'Among Us','Um jogo de dedução social onde tripulantes precisam encontrar o impostor.','2018-06-15','https://image.api.playstation.com/vulcan/ap/rnd/202011/1300/0f8s6H8L46AJTbx9qQFnk1Zt.png',6.4),(12,8,12,'Apex Legends','Um battle royale futurista com personagens únicos e habilidades especiais.','2019-02-04','https://image.api.playstation.com/vulcan/ap/rnd/202206/0720/eEczyEMDd2B8PfNAh4hBgl67.png',4.0);
/*!40000 ALTER TABLE `jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogo_adicionado`
--

DROP TABLE IF EXISTS `jogo_adicionado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `jogo_adicionado` VALUES (1,1,4),(1,1,5),(1,1,7),(1,1,8),(1,1,10),(1,1,2),(1,1,1);
/*!40000 ALTER TABLE `jogo_adicionado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista`
--

DROP TABLE IF EXISTS `lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `lista` VALUES (1,'Geral'),(2,'Jogando'),(3,'Completo'),(4,'Abandonado'),(5,'Pausado'),(6,'Desejo');
/*!40000 ALTER TABLE `lista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modo`
--

DROP TABLE IF EXISTS `modo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modo` (
  `id_modo` int(11) NOT NULL AUTO_INCREMENT,
  `nm_modo` varchar(100) NOT NULL,
  PRIMARY KEY (`id_modo`),
  UNIQUE KEY `nm_modo_UNIQUE` (`nm_modo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modo`
--

LOCK TABLES `modo` WRITE;
/*!40000 ALTER TABLE `modo` DISABLE KEYS */;
INSERT INTO `modo` VALUES (2,'Cooperativo'),(5,'Cooperativo Local'),(3,'Multijogador'),(6,'Multijogador Local'),(4,'Online'),(7,'RogueLike'),(1,'Um Jogador');
/*!40000 ALTER TABLE `modo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modo_de_jogo`
--

DROP TABLE IF EXISTS `modo_de_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `modo_de_jogo` VALUES (1,1),(1,3),(1,4),(2,2),(2,4),(2,5);
/*!40000 ALTER TABLE `modo_de_jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `permissao` VALUES (2,'Administrador'),(1,'Usuario');
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plataforma`
--

DROP TABLE IF EXISTS `plataforma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `plataforma` VALUES (2,'Console'),(1,'PC');
/*!40000 ALTER TABLE `plataforma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plataforma_de_jogo`
--

DROP TABLE IF EXISTS `plataforma_de_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plataforma_de_jogo` (
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
-- Dumping data for table `plataforma_de_jogo`
--

LOCK TABLES `plataforma_de_jogo` WRITE;
/*!40000 ALTER TABLE `plataforma_de_jogo` DISABLE KEYS */;
INSERT INTO `plataforma_de_jogo` VALUES (1,1),(1,2),(2,1);
/*!40000 ALTER TABLE `plataforma_de_jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,2,'AokiFernandes','Aoki','duduzebas@gmail.com','123456789',NULL,NULL),(2,2,'ThiagoDosSantos','Sr_Xurineio','ThiagoDosSantos','987654321',NULL,NULL),(3,1,'Teste','Teste','Teste@gmail.com','1231',NULL,NULL),(4,1,'Marcos Pedro','Marquin','MarcosPedro12@gmail.com','MarcosPedro12',NULL,NULL),(5,1,'Guilherme Laurindo','Abobora12','LaurindoG@gmail.com','Guilherme12',NULL,NULL),(10,1,NULL,NULL,'{\"senhaUsuario\":\"\"}',NULL,NULL,NULL);
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

-- Dump completed on 2025-06-24 19:28:14
