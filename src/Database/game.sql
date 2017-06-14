-- MySQL dump 10.16  Distrib 10.1.16-MariaDB, for Win32 (AMD64)
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
-- Table structure for table `gioco`
--

DROP TABLE IF EXISTS `gioco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gioco` (
  `titolo` varchar(50) NOT NULL,
  `genere` varchar(50) NOT NULL,
  `mediaVoto` float NOT NULL DEFAULT '2.5',
  `descrizione` text NOT NULL,
  `valore` int(10) NOT NULL,
  `template` varchar(50) NOT NULL,
  `datainserimento` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`titolo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gioco`
--

LOCK TABLES `gioco` WRITE;
/*!40000 ALTER TABLE `gioco` DISABLE KEYS */;
INSERT INTO `gioco` VALUES ('Age Of The Gods: King Of Olympus','casino',2.5,'Gioca con gli Dei dell Olimpo e prova a vincere!',3,'','2017-05-19 15:18:10'),('Asteroids','arcade',2.5,' Il giocatore comanda una navicella intrappolata in un campo di asteroidi. Lo scopo è distruggere tutti gli asteroidi nelle vicinanze',6,'','2017-05-19 15:18:10'),('Blood Suckers','casino',2.5,'Blood Suckers è una slot ispirata al mondo dei vampiri. Almeno tre simboli bonus consentono al giocatore di accedere all’agghiacciante Bonus Game Vampire Slaying.',3,'','2017-05-19 15:18:10'),('Pac-Man','arcade',2.5,'l giocatore deve guidare una creatura sferica di colore giallo chiamata Pac-Man facendole mangiare tutti i numerosi puntini disseminati ordinatamente all interno del labirinto e nel far questo deve evitare di farsi toccare da quattro fantasmi, pena la perdita immediata di una delle vite a disposizione. ',6,'','2017-05-19 15:18:10'),('Space Invaders','arcade',2.5,' il giocatore controlla un cannone mobile che si muove orizzontalmente sul fondo dello schermo e deve abbattere uno ad uno gli alieni che piano piano si avvicinano alla Terra',6,'','2017-05-19 15:18:10'),('Starburst','casino',2.5,'Starburst è una slot video con 5 ruote e 3 file che presenta il Jolly Starburst con giri ripetuti e vincite in entrambi i sensi.',3,'','2017-05-19 15:18:10'),('Tetris','arcade',2.5,'I vari pezzi del gioco di Tetris si chiamano tetramini. Ciascuno composto da quattro blocchi. I tetramini cadono giù uno alla volta e il compito del giocatore è ruotarli e/o muoverli in modo che creino una riga orizzontale di blocchi senza interruzioni. Quando la riga è stata creata i mattoni spariscono e i pezzi sovrastanti (se ce ne sono) cadono a formare nuove linee.',6,'','2017-05-19 15:18:10'),('The Big Easy','casino',2.5,'La slot The Big Easy offre cinque rulli e 20 linee, oltre a giocate per raddoppiare e triplicare le vincite',3,'','2017-05-19 15:18:10'),('Treasures of the Pyramids','casino',2.5,'Gioca alla slot machine Treasures of the Pyramids e vai alla ricerca dell’antico Tesoro della Piramide. ',3,'','2017-05-19 15:18:10');
/*!40000 ALTER TABLE `gioco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gruppo`
--

DROP TABLE IF EXISTS `gruppo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gruppo` (
  `id_gruppo` int(10) NOT NULL AUTO_INCREMENT,
  `nomeGruppo` varchar(30) NOT NULL,
  PRIMARY KEY (`id_gruppo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppo`
--

LOCK TABLES `gruppo` WRITE;
/*!40000 ALTER TABLE `gruppo` DISABLE KEYS */;
INSERT INTO `gruppo` VALUES (1,'admin'),(2,'moderatore2'),(3,'moderatore3'),(4,'utente');
/*!40000 ALTER TABLE `gruppo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupposervizio`
--

DROP TABLE IF EXISTS `grupposervizio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupposervizio` (
  `id_servizio` int(10) NOT NULL,
  `id_gruppo` int(10) NOT NULL,
  KEY `id_servizio` (`id_servizio`),
  KEY `id_gruppo` (`id_gruppo`),
  CONSTRAINT `grupposervizio_ibfk_1` FOREIGN KEY (`id_servizio`) REFERENCES `servizio` (`id_servizio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grupposervizio_ibfk_2` FOREIGN KEY (`id_gruppo`) REFERENCES `gruppo` (`id_gruppo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupposervizio`
--

LOCK TABLES `grupposervizio` WRITE;
/*!40000 ALTER TABLE `grupposervizio` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupposervizio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `immagine`
--

DROP TABLE IF EXISTS `immagine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `immagine` (
  `id_immagine` int(11) NOT NULL AUTO_INCREMENT,
  `pathImmagine` varchar(500) NOT NULL,
  `titoloImmagine` varchar(50) NOT NULL,
  PRIMARY KEY (`id_immagine`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `immagine`
--

LOCK TABLES `immagine` WRITE;
/*!40000 ALTER TABLE `immagine` DISABLE KEYS */;
INSERT INTO `immagine` VALUES (1,'img/game1.jpg','immagine gioco '),(2,'img/game2.jpg','immagine gioco '),(3,'img/game3.jpg','immagine gioco '),(4,'img/game4.jpg','immagine gioco '),(5,'img/game5.jpg','immagine gioco '),(6,'img/game6.jpg','immagine gioco '),(7,'img/game7.jpg','immagine gioco '),(8,'img/game8.jpg','immagine gioco '),(9,'img/game9.jpg','immagine gioco '),(10,'img/game10.jpg','immagine gioco'),(11,'img/game11.jpg','immagine gioco'),(12,'img/game12.jpg','immagine gioco'),(13,'img/game13.jpg','immagine gioco'),(14,'img/game14.jpg','immagine gioco'),(15,'img/game15.jpg','immagine gioco'),(16,'img/game16.jpg','immagine gioco'),(17,'img/trofeo1.jpg','immagine trofeo'),(18,'img/trofeo2.jpg','immagine trofeo'),(19,'img/trofeo3.jpg','immagine trofeo'),(20,'img/trofeo4.png','immagine trofeo');
/*!40000 ALTER TABLE `immagine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `immaginegioco`
--

DROP TABLE IF EXISTS `immaginegioco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `immaginegioco` (
  `id_immagine` int(10) NOT NULL,
  `titolo` varchar(50) NOT NULL,
  KEY `id_immagine` (`id_immagine`),
  KEY `titolo` (`titolo`),
  CONSTRAINT `immaginegioco_ibfk_1` FOREIGN KEY (`id_immagine`) REFERENCES `immagine` (`id_immagine`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `immaginegioco_ibfk_2` FOREIGN KEY (`titolo`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `immaginegioco`
--

LOCK TABLES `immaginegioco` WRITE;
/*!40000 ALTER TABLE `immaginegioco` DISABLE KEYS */;
INSERT INTO `immaginegioco` VALUES (1,'tetris'),(2,'Age Of The Gods: King Of Olympus'),(3,'Asteroids'),(4,'Blood Suckers'),(5,'Pac-Man '),(6,'Space Invaders'),(7,'Starburst'),(8,'The Big Easy'),(9,'Treasures of the Pyramids');
/*!40000 ALTER TABLE `immaginegioco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livello`
--

DROP TABLE IF EXISTS `livello`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livello` (
  `id_livello` int(10) NOT NULL AUTO_INCREMENT,
  `numeroLivello` int(10) NOT NULL,
  `punteggioProssimoLivello` bigint(50) NOT NULL,
  `titologiocolivello` varchar(50) NOT NULL,
  `id_trofeolivello` int(10) NOT NULL,
  PRIMARY KEY (`id_livello`),
  KEY `titologiocolivello` (`titologiocolivello`),
  KEY `id_trofeolivello` (`id_trofeolivello`),
  CONSTRAINT `livello_ibfk_1` FOREIGN KEY (`titologiocolivello`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `livello_ibfk_2` FOREIGN KEY (`id_trofeolivello`) REFERENCES `trofeo` (`id_trofeo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livello`
--

LOCK TABLES `livello` WRITE;
/*!40000 ALTER TABLE `livello` DISABLE KEYS */;
INSERT INTO `livello` VALUES (1,0,100,'tetris',4),(2,1,200,'tetris',3),(3,2,400,'tetris',2),(4,3,800,'tetris',1);
/*!40000 ALTER TABLE `livello` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partita`
--

DROP TABLE IF EXISTS `partita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partita` (
  `id_partita` int(10) NOT NULL AUTO_INCREMENT,
  `punteggio` bigint(50) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usernamepartita` varchar(50) NOT NULL,
  `id_livellopartita` int(10) NOT NULL,
  PRIMARY KEY (`id_partita`),
  KEY `usernamepartita` (`usernamepartita`),
  KEY `id_livellopartita` (`id_livellopartita`),
  CONSTRAINT `partita_ibfk_1` FOREIGN KEY (`usernamepartita`) REFERENCES `utente` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `partita_ibfk_2` FOREIGN KEY (`id_livellopartita`) REFERENCES `livello` (`id_livello`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partita`
--

LOCK TABLES `partita` WRITE;
/*!40000 ALTER TABLE `partita` DISABLE KEYS */;
/*!40000 ALTER TABLE `partita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recensione`
--

DROP TABLE IF EXISTS `recensione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recensione` (
  `id_recensione` int(10) NOT NULL AUTO_INCREMENT,
  `titoloRecensione` varchar(50) NOT NULL,
  `testo` text NOT NULL,
  `approvata` tinyint(1) NOT NULL DEFAULT '0',
  `usernamerec` varchar(50) NOT NULL,
  `titologiocorec` varchar(50) NOT NULL,
  `datainserimento` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_recensione`),
  KEY `usernamerec` (`usernamerec`),
  KEY `titologiocorec` (`titologiocorec`),
  CONSTRAINT `recensione_ibfk_1` FOREIGN KEY (`usernamerec`) REFERENCES `utente` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `recensione_ibfk_2` FOREIGN KEY (`titologiocorec`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recensione`
--

LOCK TABLES `recensione` WRITE;
/*!40000 ALTER TABLE `recensione` DISABLE KEYS */;
INSERT INTO `recensione` VALUES (1,'male','testotexttestotext',0,'tommasoa','tetris','2017-05-19 15:18:12'),(2,'fffe','1testotexttestotext',0,'tommasoa','tetris','2017-05-19 15:18:12'),(3,'eeee','2testotexttestotext',0,'tommasoa','tetris','2017-05-19 15:18:12'),(4,'bene','3testotexttestotext',0,'tommasoa','tetris','2017-05-19 15:18:14'),(5,'fffe','1testotexttestotext',0,'tommasoa','tetris','2017-05-19 15:22:07');
/*!40000 ALTER TABLE `recensione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servizio`
--

DROP TABLE IF EXISTS `servizio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servizio` (
  `id_servizio` int(10) NOT NULL AUTO_INCREMENT,
  `pagine` varchar(50) NOT NULL,
  PRIMARY KEY (`id_servizio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servizio`
--

LOCK TABLES `servizio` WRITE;
/*!40000 ALTER TABLE `servizio` DISABLE KEYS */;
/*!40000 ALTER TABLE `servizio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trofeo`
--

DROP TABLE IF EXISTS `trofeo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trofeo` (
  `id_trofeo` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `id_immaginetrofeo` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_trofeo`),
  KEY `id_immaginetrofeo` (`id_immaginetrofeo`),
  CONSTRAINT `trofeo_ibfk_1` FOREIGN KEY (`id_immaginetrofeo`) REFERENCES `immagine` (`id_immagine`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trofeo`
--

LOCK TABLES `trofeo` WRITE;
/*!40000 ALTER TABLE `trofeo` DISABLE KEYS */;
INSERT INTO `trofeo` VALUES (1,'diamante',20),(2,'oro',17),(3,'argento',18),(4,'bronzo',19);
/*!40000 ALTER TABLE `trofeo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `username` varchar(50) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `indirizzo` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  `città` varchar(30) NOT NULL,
  `ruolo` varchar(30) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('eugenioa','eugenio','mancini','a123','via tre ponti','eugenio@live.it','avezzano','utente'),('lucaa','luca','dorazio','a123','via fiume','lucaadorazio@gmail.com','roccavivi','amministratore'),('stefanoa','stefano','corsetti','a123','via dei gerani','stefanocorsetti@live.it','pescosolido','moderatore1'),('tommasoa','tommaso','di salle','a123','via boh 21','tommasodisalle@gmail.com','raiano','moderatore2');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utentegruppo`
--

DROP TABLE IF EXISTS `utentegruppo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utentegruppo` (
  `username` varchar(10) DEFAULT NULL,
  `id_gruppo` int(10) DEFAULT NULL,
  KEY `username` (`username`),
  KEY `id_gruppo` (`id_gruppo`),
  CONSTRAINT `utentegruppo_ibfk_1` FOREIGN KEY (`username`) REFERENCES `utente` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utentegruppo_ibfk_2` FOREIGN KEY (`id_gruppo`) REFERENCES `gruppo` (`id_gruppo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utentegruppo`
--

LOCK TABLES `utentegruppo` WRITE;
/*!40000 ALTER TABLE `utentegruppo` DISABLE KEYS */;
INSERT INTO `utentegruppo` VALUES ('lucaa',1),('tommasoa',2),('stefanoa',3),('eugenioa',4);
/*!40000 ALTER TABLE `utentegruppo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utentetrofeo`
--

DROP TABLE IF EXISTS `utentetrofeo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utentetrofeo` (
  `username` varchar(50) NOT NULL,
  `id_trofeo` int(10) NOT NULL,
  `titologioco` varchar(50) NOT NULL,
  `dataconquistatrofeo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `id_trofeo` (`id_trofeo`),
  KEY `username` (`username`),
  KEY `titologioco` (`titologioco`),
  CONSTRAINT `utentetrofeo_ibfk_1` FOREIGN KEY (`id_trofeo`) REFERENCES `trofeo` (`id_trofeo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utentetrofeo_ibfk_2` FOREIGN KEY (`username`) REFERENCES `utente` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utentetrofeo_ibfk_3` FOREIGN KEY (`titologioco`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utentetrofeo`
--

LOCK TABLES `utentetrofeo` WRITE;
/*!40000 ALTER TABLE `utentetrofeo` DISABLE KEYS */;
INSERT INTO `utentetrofeo` VALUES ('tommasoa',1,'tetris','2017-05-22 10:37:34');
/*!40000 ALTER TABLE `utentetrofeo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voto`
--

DROP TABLE IF EXISTS `voto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voto` (
  `usernamevoto` varchar(50) NOT NULL,
  `titologiocovoto` varchar(50) NOT NULL,
  `voto` int(1) NOT NULL,
  PRIMARY KEY (`usernamevoto`,`titologiocovoto`),
  KEY `titologiocovoto` (`titologiocovoto`),
  CONSTRAINT `voto_ibfk_1` FOREIGN KEY (`usernamevoto`) REFERENCES `utente` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `voto_ibfk_2` FOREIGN KEY (`titologiocovoto`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voto`
--

LOCK TABLES `voto` WRITE;
/*!40000 ALTER TABLE `voto` DISABLE KEYS */;
/*!40000 ALTER TABLE `voto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-22 14:13:19
