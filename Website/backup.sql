-- MySQL dump 10.13  Distrib 5.5.18, for linux2.6 (x86_64)
--
-- Host: localhost    Database: cc
-- ------------------------------------------------------
-- Server version	5.5.18

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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `eventid` int(11) NOT NULL AUTO_INCREMENT,
  `creatorid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `datet` datetime NOT NULL,
  `loc` text,
  `description` text,
  PRIMARY KEY (`eventid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventgroup`
--

DROP TABLE IF EXISTS `eventgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventgroup` (
  `eventid` int(11) NOT NULL,
  `groupid` int(11) NOT NULL,
  PRIMARY KEY (`eventid`,`groupid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventgroup`
--

LOCK TABLES `eventgroup` WRITE;
/*!40000 ALTER TABLE `eventgroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventtag`
--

DROP TABLE IF EXISTS `eventtag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventtag` (
  `eventid` int(11) NOT NULL,
  `tag` varchar(255) NOT NULL,
  PRIMARY KEY (`eventid`,`tag`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventtag`
--

LOCK TABLES `eventtag` WRITE;
/*!40000 ALTER TABLE `eventtag` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventtag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventuser`
--

DROP TABLE IF EXISTS `eventuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventuser` (
  `eventid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`eventid`,`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventuser`
--

LOCK TABLES `eventuser` WRITE;
/*!40000 ALTER TABLE `eventuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupcc`
--

DROP TABLE IF EXISTS `groupcc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupcc` (
  `groupid` int(11) NOT NULL AUTO_INCREMENT,
  `grouptype` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `description` text,
  PRIMARY KEY (`groupid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupcc`
--

LOCK TABLES `groupcc` WRITE;
/*!40000 ALTER TABLE `groupcc` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupcc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupevent`
--

DROP TABLE IF EXISTS `groupevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupevent` (
  `groupid` int(11) NOT NULL,
  `eventid` int(11) NOT NULL,
  PRIMARY KEY (`groupid`,`eventid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupevent`
--

LOCK TABLES `groupevent` WRITE;
/*!40000 ALTER TABLE `groupevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grouptag`
--

DROP TABLE IF EXISTS `grouptag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grouptag` (
  `groupid` int(11) NOT NULL,
  `tag` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`groupid`,`tag`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grouptag`
--

LOCK TABLES `grouptag` WRITE;
/*!40000 ALTER TABLE `grouptag` DISABLE KEYS */;
/*!40000 ALTER TABLE `grouptag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupuser`
--

DROP TABLE IF EXISTS `groupuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupuser` (
  `groupid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`groupid`,`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupuser`
--

LOCK TABLES `groupuser` WRITE;
/*!40000 ALTER TABLE `groupuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relateevent`
--

DROP TABLE IF EXISTS `relateevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relateevent` (
  `eventid` int(11) NOT NULL,
  `releventid` int(11) NOT NULL,
  PRIMARY KEY (`eventid`,`releventid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relateevent`
--

LOCK TABLES `relateevent` WRITE;
/*!40000 ALTER TABLE `relateevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `relateevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `pretendkey` int(11) NOT NULL AUTO_INCREMENT,
  `columnB` text,
  `columnC` int(11) DEFAULT NULL,
  `columnD` text,
  PRIMARY KEY (`pretendkey`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'yup this is in column b',72,NULL);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `major` varchar(255) DEFAULT 'Undeclared',
  `bio` blob,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `studentid` (`studentid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,9830219,'John Jacob Jingleheimer-Smith','jacob@macaroni.net','$2y$10$54F.HHPMwQ0vUQle5xhO5OxZccX0VitgIY2/i.vNejJAu23OBCXau','Undeclared',''),(2,23,'James Peach','wheee@real.email','$2y$10$PX1SZT2zw52wZ55gN6u1/eFS9bzTHGNboRJ5eLHEjvqwnBvS3O3K6','Shrinking','This hardly counts as a pun.'),(3,91007,'Groot','groot@groot.groot','$2y$10$54F.HHPMwQ0vUQle5xhO5OxZccX0VitgIY2/i.vNejJAu23OBCXau','Groot',''),(4,444,'aaaaaaaaaaa','a@a.a','$2y$10$54F.HHPMwQ0vUQle5xhO5OxZccX0VitgIY2/i.vNejJAu23OBCXau','aa',''),(5,101013,'Mergle','ijklm@uw.edu','$2y$10$54F.HHPMwQ0vUQle5xhO5OxZccX0VitgIY2/i.vNejJAu23OBCXau','Underwater Basketweaving',''),(6,7473,'fake fae','fake@fake.fake','$2y$10$54F.HHPMwQ0vUQle5xhO5OxZccX0VitgIY2/i.vNejJAu23OBCXau','fake','Nope'),(8,111,'w','w@w.w','$2y$10$0OHquVas.femHHY6jYCusuGy3VrGy7U2KgkRKhjppQEGjvhlJhheq','w','www'),(9,109,'jl','frik@U.U','$2y$10$AyyIlvdSASE6j2wDof8.XuMyVC6DB8AS4GEbtNha60ziIzd5kdpg2','yO','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-26 20:24:40
