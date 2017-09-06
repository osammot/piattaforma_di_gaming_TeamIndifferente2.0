-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: gameplatform
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `title` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `Average_vote` float NOT NULL DEFAULT '2.5',
  `description` text NOT NULL,
  `value` int(10) NOT NULL,
  `template` varchar(50) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES ('Age Of The Gods: King Of Olympus','casino',1,'Gioca con gli Dei dell Olimpo e prova a vincere!',3,'','2017-07-06 19:40:40'),('Asteroids','arcade',2.5,' Il giocatore comanda una navicella intrappolata in un campo di asteroidi. Lo scopo è distruggere tutti gli asteroidi nelle vicinanze',6,'','2017-07-06 19:40:40'),('Blood Suckers','casino',2.5,'Blood Suckers è una slot ispirata al mondo dei vampiri. Almeno tre simboli bonus consentono al giocatore di accedere all’agghiacciante Bonus Game Vampire Slaying.',3,'','2017-07-06 19:40:40'),('Pac-Man','arcade',2.5,'l giocatore deve guidare una creatura sferica di colore giallo chiamata Pac-Man facendole mangiare tutti i numerosi puntini disseminati ordinatamente all interno del labirinto e nel far questo deve evitare di farsi toccare da quattro fantasmi, pena la perdita immediata di una delle vite a disposizione. ',6,'','2017-07-06 19:40:40'),('Space Invaders','arcade',2.5,' il giocatore controlla un cannone mobile che si muove orizzontalmente sul fondo dello schermo e deve abbattere uno ad uno gli alieni che piano piano si avvicinano alla Terra',6,'','2017-07-06 19:40:40'),('Starburst','casino',2.5,'Starburst è una slot video con 5 ruote e 3 file che presenta il Jolly Starburst con giri ripetuti e vincite in entrambi i sensi.',3,'','2017-07-06 19:40:40'),('Tetris','arcade',2.5,'I vari pezzi del gioco di Tetris si chiamano tetramini. Ciascuno composto da quattro blocchi. I tetramini cadono giù uno alla volta e il compito del giocatore è ruotarli e/o muoverli in modo che creino una riga orizzontale di blocchi senza interruzioni. Quando la riga è stata creata i mattoni spariscono e i pezzi sovrastanti (se ce ne sono) cadono a formare nuove linee.',6,'','2017-07-06 19:40:39'),('The Big Easy','casino',2.5,'La slot The Big Easy offre cinque rulli e 20 linee, oltre a giocate per raddoppiare e triplicare le vincite',3,'','2017-07-06 19:40:40'),('Treasures of the Pyramids','casino',2.5,'Gioca alla slot machine Treasures of the Pyramids e vai alla ricerca dell’antico Tesoro della Piramide. ',3,'','2017-07-06 19:40:39');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameplay`
--

DROP TABLE IF EXISTS `gameplay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gameplay` (
  `id_gameplay` int(10) NOT NULL AUTO_INCREMENT,
  `point` bigint(50) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(50) NOT NULL,
  `titlegame` varchar(50) NOT NULL,
  PRIMARY KEY (`id_gameplay`),
  KEY `username` (`username`),
  KEY `titlegame` (`titlegame`),
  CONSTRAINT `gameplay_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `gameplay_ibfk_2` FOREIGN KEY (`titlegame`) REFERENCES `game` (`title`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameplay`
--

LOCK TABLES `gameplay` WRITE;
/*!40000 ALTER TABLE `gameplay` DISABLE KEYS */;
INSERT INTO `gameplay` VALUES (17,100,'2017-07-08 10:38:53','osammot','Age Of The Gods: King Of Olympus'),(18,170,'2017-07-08 10:39:31','osammot','Asteroids'),(19,310,'2017-07-08 10:51:49','osammot','Age Of The Gods: King Of Olympus'),(20,160,'2017-07-08 10:59:04','osammot','Age Of The Gods: King Of Olympus'),(21,0,'2017-07-09 07:50:58','osammot','Age Of The Gods: King Of Olympus'),(22,0,'2017-07-09 08:11:34','osammot','Asteroids'),(23,0,'2017-07-09 09:39:41','osammot','Age Of The Gods: King Of Olympus'),(24,0,'2017-07-10 08:18:21','osammot','Age Of The Gods: King Of Olympus'),(25,0,'2017-07-10 08:27:31','coco','Age Of The Gods: King Of Olympus'),(26,0,'2017-07-10 08:27:58','coco','Age Of The Gods: King Of Olympus'),(27,0,'2017-07-10 08:33:46','coco','Age Of The Gods: King Of Olympus'),(28,0,'2017-07-10 08:35:55','coco','Age Of The Gods: King Of Olympus'),(29,0,'2017-07-10 09:03:04','coco','Age Of The Gods: King Of Olympus'),(30,0,'2017-07-10 09:07:52','coco','Age Of The Gods: King Of Olympus'),(31,220,'2017-07-10 09:15:17','coco','Age Of The Gods: King Of Olympus'),(32,200,'2017-07-10 09:28:43','coco','Age Of The Gods: King Of Olympus'),(33,60,'2017-07-10 09:42:54','coco','Age Of The Gods: King Of Olympus'),(34,160,'2017-07-10 10:11:23','qqq','Age Of The Gods: King Of Olympus'),(35,130,'2017-08-16 06:35:12','coco','Age Of The Gods: King Of Olympus'),(36,150,'2017-08-23 08:13:17','osammot','Age Of The Gods: King Of Olympus'),(37,20,'2017-09-05 07:49:27','aa','Space Invaders'),(38,30,'2017-09-06 08:59:14','osammot','Age Of The Gods: King Of Olympus');
/*!40000 ALTER TABLE `gameplay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupservice`
--

DROP TABLE IF EXISTS `groupservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupservice` (
  `ID_GROUP` int(10) DEFAULT NULL,
  `ID_SERVIZI` int(10) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupservice`
--

LOCK TABLES `groupservice` WRITE;
/*!40000 ALTER TABLE `groupservice` DISABLE KEYS */;
INSERT INTO `groupservice` VALUES (1,8,1),(2,9,3),(3,9,4),(3,8,5),(3,10,6);
/*!40000 ALTER TABLE `groupservice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gruppo`
--

DROP TABLE IF EXISTS `gruppo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gruppo` (
  `ID_GROUP` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_GROUP`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppo`
--

LOCK TABLES `gruppo` WRITE;
/*!40000 ALTER TABLE `gruppo` DISABLE KEYS */;
INSERT INTO `gruppo` VALUES (1,'USER'),(2,'MOD'),(3,'ADMIN');
/*!40000 ALTER TABLE `gruppo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `id_image` int(11) NOT NULL AUTO_INCREMENT,
  `path_image` varchar(500) NOT NULL,
  `title_image` varchar(50) NOT NULL,
  PRIMARY KEY (`id_image`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'img/game3.jpg','immagine gioco '),(2,'img/game4.jpg','immagine gioco '),(3,'img/game5.jpg','immagine gioco '),(4,'img/game6.jpg','immagine gioco '),(5,'img/game7.jpg','immagine gioco '),(6,'img/game8.jpg','immagine gioco '),(7,'img/game9.jpg','immagine gioco '),(8,'img/game10.jpg','immagine gioco'),(9,'img/game11.jpg','immagine gioco'),(10,'img/game12.jpg','immagine gioco'),(11,'img/game13.jpg','immagine gioco'),(12,'img/game14.jpg','immagine gioco'),(13,'img/game15.jpg','immagine gioco'),(14,'img/game16.jpg','immagine gioco'),(15,'img/trofeo1.jpg','immagine trofeo'),(16,'img/trofeo2.jpg','immagine trofeo'),(17,'img/trofeo3.jpg','immagine trofeo'),(18,'img/trofeo4.png','immagine trofeo');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagegame`
--

DROP TABLE IF EXISTS `imagegame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imagegame` (
  `id_image` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagegame`
--

LOCK TABLES `imagegame` WRITE;
/*!40000 ALTER TABLE `imagegame` DISABLE KEYS */;
INSERT INTO `imagegame` VALUES (1,'tetris'),(2,'Age Of The Gods: King Of Olympus'),(3,'Asteroids'),(4,'Blood Suckers'),(5,'Pac-Man '),(6,'Space Invaders'),(7,'Starburst'),(8,'The Big Easy'),(9,'Treasures of the Pyramids');
/*!40000 ALTER TABLE `imagegame` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level`
--

DROP TABLE IF EXISTS `level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level` (
  `id_level` int(10) NOT NULL AUTO_INCREMENT,
  `numberlevel` int(10) NOT NULL,
  `pointNextlevel` bigint(50) NOT NULL,
  `id_trophy` int(10) NOT NULL,
  PRIMARY KEY (`id_level`),
  UNIQUE KEY `numberlevel` (`numberlevel`),
  KEY `id_trophy` (`id_trophy`),
  CONSTRAINT `level_ibfk_1` FOREIGN KEY (`id_trophy`) REFERENCES `trophy` (`id_trophy`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level`
--

LOCK TABLES `level` WRITE;
/*!40000 ALTER TABLE `level` DISABLE KEYS */;
INSERT INTO `level` VALUES (1,0,100,1),(2,1,400,2),(3,2,1000,3),(4,5,3000,4);
/*!40000 ALTER TABLE `level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rank`
--

DROP TABLE IF EXISTS `rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rank` (
  `point` bigint(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `numberlevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username` (`username`),
  CONSTRAINT `rank_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rank`
--

LOCK TABLES `rank` WRITE;
/*!40000 ALTER TABLE `rank` DISABLE KEYS */;
INSERT INTO `rank` VALUES (0,'ff',0),(0,'ggg',0),(0,'iiii',0),(0,'ioio',0);
/*!40000 ALTER TABLE `rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id_review` int(10) NOT NULL AUTO_INCREMENT,
  `titlereview` varchar(50) NOT NULL,
  `textreview` text NOT NULL,
  `approved` tinyint(1) NOT NULL DEFAULT '0',
  `username` varchar(50) NOT NULL,
  `titlegame` varchar(50) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_review`),
  KEY `username` (`username`),
  KEY `titlegame` (`titlegame`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`titlegame`) REFERENCES `game` (`title`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (2,'qqq','qqqq',1,'osammot','Asteroids','2017-07-08 10:07:42'),(3,'qqqq','qqqq',1,'osammot','Asteroids','2017-07-09 15:48:41'),(4,'questo è un testo di prova abbastanza lungo','questo è un testo di prova abbastanza lungo',1,'osammot','Asteroids','2017-07-09 15:49:28'),(6,'pppp','pppppppp',1,'osammot','Age Of The Gods: King Of Olympus','2017-07-10 08:22:17'),(7,'poi','jm',0,'osammot','Space Invaders','2017-09-06 08:55:34');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id_role` int(10) NOT NULL AUTO_INCREMENT,
  `role` varchar(30) NOT NULL DEFAULT 'user',
  PRIMARY KEY (`id_role`,`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servizi`
--

DROP TABLE IF EXISTS `servizi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servizi` (
  `ID_SERVIZI` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_SERVIZI`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servizi`
--

LOCK TABLES `servizi` WRITE;
/*!40000 ALTER TABLE `servizi` DISABLE KEYS */;
INSERT INTO `servizi` VALUES (8,'GamePlay'),(9,'BO'),(10,'BOGroup');
/*!40000 ALTER TABLE `servizi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trophy`
--

DROP TABLE IF EXISTS `trophy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trophy` (
  `id_trophy` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `id_imagetrophy` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_trophy`),
  KEY `id_imagetrophy` (`id_imagetrophy`),
  CONSTRAINT `trophy_ibfk_1` FOREIGN KEY (`id_imagetrophy`) REFERENCES `image` (`id_image`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trophy`
--

LOCK TABLES `trophy` WRITE;
/*!40000 ALTER TABLE `trophy` DISABLE KEYS */;
INSERT INTO `trophy` VALUES (1,'diamante',15),(2,'oro',16),(3,'argento',17),(4,'bronzo',18);
/*!40000 ALTER TABLE `trophy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'osammot','tommaso','di salle','a123','a','tommasodisalle@gmail.com','a'),(3,'coco','luca','qweasdd','123','asdasddasd','prova1@email.cm','asdadsads'),(4,'qqq','qqq','qqqq','123','qqq','eugenioPucciettoso@gmail.com','qq'),(17,'aa','matteoa','a','123','via pirlaa','matteodisalle@fmail.it','a'),(18,'zzz','zzz','zzz','123','zzz','hjghfdslle@fmail.it','zzz'),(19,'poiiop','poiiop','poiiop','123','poiiop','hjghfdslle@fmail.it','poiiop'),(20,'mmm','mmmm','mmmm','123','mmmmm','matteodisalle@fmail.it','mmmm'),(21,'lll','lll','lll','123','lll','matteodisalle@fmail.it','lll'),(22,'az','az','az','123','az','matteodisalle@fmail.it','az'),(23,'zaz','azz','zz','123','zaz','matteodisalle@fmail.it','zaz'),(24,'uu','uu','uu','123','uuu','matteodisalle@fmail.it','uu'),(25,'ff','ff','ff','123','ff','matteodisalle@fmail.it','ff'),(26,'iiii','iiii','iiii','123','iiii','matteodisalle@fmail.it','iiiii'),(27,'ggg','qggg','gggg','123','gggg','qqq@jkl.it','ggg'),(29,'ioio','ioio','ioio','123','ioio','matteodisalle@fmail.it','ioio');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usergroup`
--

DROP TABLE IF EXISTS `usergroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usergroup` (
  `ID_USER` int(10) DEFAULT NULL,
  `ID_GROUP` int(10) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergroup`
--

LOCK TABLES `usergroup` WRITE;
/*!40000 ALTER TABLE `usergroup` DISABLE KEYS */;
INSERT INTO `usergroup` VALUES (2,3,1),(3,1,2),(4,3,3),(17,1,15),(18,1,16),(19,1,17),(20,1,18),(21,1,19),(22,1,20),(23,1,21),(24,1,22),(25,1,23),(26,1,24),(27,1,25),(29,1,26);
/*!40000 ALTER TABLE `usergroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertrophy`
--

DROP TABLE IF EXISTS `usertrophy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertrophy` (
  `username` varchar(50) NOT NULL,
  `id_trophy` int(10) NOT NULL,
  `id_gameplay` int(10) NOT NULL,
  `numberlevel` int(10) NOT NULL,
  `dataconquistatrofeo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `id_trophy` (`id_trophy`),
  KEY `numberlevel` (`numberlevel`),
  KEY `id_gameplay` (`id_gameplay`),
  KEY `username` (`username`),
  CONSTRAINT `usertrophy_ibfk_1` FOREIGN KEY (`id_trophy`) REFERENCES `trophy` (`id_trophy`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usertrophy_ibfk_2` FOREIGN KEY (`numberlevel`) REFERENCES `level` (`numberlevel`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usertrophy_ibfk_3` FOREIGN KEY (`id_gameplay`) REFERENCES `gameplay` (`id_gameplay`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usertrophy_ibfk_4` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertrophy`
--

LOCK TABLES `usertrophy` WRITE;
/*!40000 ALTER TABLE `usertrophy` DISABLE KEYS */;
INSERT INTO `usertrophy` VALUES ('osammot',1,18,0,'2017-07-08 10:39:33'),('osammot',2,19,1,'2017-07-08 10:52:28'),('coco',1,31,0,'2017-07-10 09:17:42'),('coco',2,32,1,'2017-07-10 09:33:01'),('coco',2,32,1,'2017-07-10 09:33:02'),('coco',2,33,1,'2017-07-10 09:42:55'),('coco',2,33,1,'2017-07-10 09:42:58'),('coco',2,33,1,'2017-07-10 09:43:00'),('coco',2,33,1,'2017-07-10 09:43:02'),('coco',2,33,1,'2017-07-10 10:10:20'),('coco',2,33,1,'2017-07-10 10:10:21'),('qqq',1,34,0,'2017-07-10 10:11:53'),('qqq',1,34,0,'2017-07-10 10:11:54'),('qqq',1,34,0,'2017-07-10 10:11:57'),('qqq',1,34,0,'2017-07-10 10:12:00'),('qqq',1,34,0,'2017-07-10 10:12:03'),('qqq',1,34,0,'2017-07-10 10:12:12'),('coco',2,35,1,'2017-08-16 06:35:15'),('coco',2,35,1,'2017-08-16 06:35:19'),('coco',2,35,1,'2017-08-16 06:35:23'),('coco',2,35,1,'2017-08-16 06:35:25'),('coco',2,35,1,'2017-08-16 06:35:29'),('coco',2,35,1,'2017-08-16 06:35:33'),('coco',2,35,1,'2017-08-16 06:35:36'),('coco',2,35,1,'2017-08-16 06:35:41'),('coco',2,35,1,'2017-08-16 06:35:45'),('coco',2,35,1,'2017-08-16 06:35:46'),('coco',2,35,1,'2017-08-16 06:35:47'),('coco',2,35,1,'2017-08-16 06:35:51'),('coco',2,35,1,'2017-08-16 06:35:53');
/*!40000 ALTER TABLE `usertrophy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote` (
  `username` varchar(50) NOT NULL,
  `titlevote` varchar(50) NOT NULL,
  `vote` int(1) NOT NULL,
  PRIMARY KEY (`username`,`titlevote`),
  KEY `titlevote` (`titlevote`),
  CONSTRAINT `vote_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vote_ibfk_2` FOREIGN KEY (`titlevote`) REFERENCES `game` (`title`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` VALUES ('osammot','Age Of The Gods: King Of Olympus',1);
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-06 12:14:12
