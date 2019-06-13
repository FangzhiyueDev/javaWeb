-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: wwMusic
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

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
-- Current Database: `wwMusic`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `wwMusic` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `wwMusic`;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `image` varchar(30) DEFAULT NULL,
  `author` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  `playCount` int(8) DEFAULT NULL,
  `language` varchar(30) DEFAULT '2019-01-01',
  `company` varchar(30) DEFAULT '华语大地盛宇传媒',
  `describute` varchar(255) DEFAULT '名曲抒情歌手，厉旭1月2日以第二张迷你专辑回归，打造华语歌曲新歌风潮',
  `publishTime` varchar(30) DEFAULT NULL,
  `classfyType` varchar(30) DEFAULT 'EP 单曲华风',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,'听到心脏爆炸的歌','/image/album/1.jpg','方志月','温柔',200,'','华语大地盛宇传媒','名曲抒情歌手，厉旭1月2日以第二张迷你专辑回归，打造华语歌曲新歌风潮','2018-4-23','EP 单曲华风'),(2,'时间可不可以停在这里','/image/album/2.jpg','小芳芳','毕业回忆',300,'中文 ','大地传媒','名曲抒情歌手，厉旭1月2日以第二张迷你专辑回归，打造华语歌曲新歌风潮','2017-12-28','EP 单曲华风'),(3,'对未来的热爱','/image/album/3.jpg','干枯的骆驼','未来努力',5000,'中文','广元大地传媒','','2016-06-21','EP 单曲华风'),(5,'轻映浅唱','/image/album/4.jpg','温柔的风','加油现在的自己',400,'中文','华谊兄弟传媒','名曲抒情歌手，厉旭1月2日以第二张迷你专辑回归，打造华语歌曲新歌风潮','2017-09-23','安静温柔'),(6,'那些伴随你的歌手','/image/album/5.jpg','淡淡的忧伤','90年代',500,'粤语','香港楼宇传媒','名曲抒情歌手，厉旭1月2日以第二张迷你专辑回归，打造华语歌曲新歌风潮','2019--5-21','粤语，回忆经典'),(7,'女生一定要听的甜歌','/image/album/6.jpg','小芳芳不慌张','网络，甜蜜',40000,'中文，英文','成都影音音乐','','2016-04-28','甜美，网络'),(8,'耳朵喜欢你','/image/album/7.jpg','方志月','甜，女生',4000,'英文','大地传媒','名曲抒情歌手，厉旭1月2日以第二张迷你专辑回归，打造华语歌曲新歌风潮','2016-04-28','安静温柔'),(9,'摇滚嗨到爆','/image/album/8.jpg','干枯的骆驼','high 摇滚',300,'英文','华语大地盛宇传媒','名曲抒情歌手，厉旭1月2日以第二张迷你专辑回归，打造华语歌曲新歌风潮','2015-09-24','high');
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classfy`
--

DROP TABLE IF EXISTS `classfy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classfy` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `image` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classfy`
--

LOCK TABLES `classfy` WRITE;
/*!40000 ALTER TABLE `classfy` DISABLE KEYS */;
INSERT INTO `classfy` VALUES (1,'华语','/image/classfy/1.jpg'),(2,'欧美','/image/classfy/2.jpg'),(3,'日本','/image/classfy/3.jpg'),(4,'韩国','/image/classfy/4.jpg');
/*!40000 ALTER TABLE `classfy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collection` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `userName` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `musicId` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `collect__user_fk` (`userName`),
  CONSTRAINT `collect__user_fk` FOREIGN KEY (`userName`) REFERENCES `user` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
INSERT INTO `collection` VALUES (1,'123456',1),(2,'123456',2),(3,'123456',3),(4,'123456',4),(5,'123456',5);
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music`
--

DROP TABLE IF EXISTS `music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `music` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `albumid` int(8) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  `singerId` int(8) DEFAULT NULL,
  `playTime` varchar(8) DEFAULT NULL,
  `playCount` int(8) DEFAULT NULL,
  `classfyId` int(8) DEFAULT NULL,
  `musicAddress` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `music__album_fk` (`albumid`),
  KEY `music__singer_fk` (`singerId`),
  KEY `music__classfy_fk` (`classfyId`),
  CONSTRAINT `music__album_fk` FOREIGN KEY (`albumid`) REFERENCES `album` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `music__classfy_fk` FOREIGN KEY (`classfyId`) REFERENCES `classfy` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `music__singer_fk` FOREIGN KEY (`singerId`) REFERENCES `singer` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music`
--

LOCK TABLES `music` WRITE;
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` VALUES (1,'作业狂想曲',1,'/image/music/1.jpg',3,'03:56',200,1,'/music/1.mp3'),(4,'AZhen - Way Back Home',1,'/image/music/2.jpg',1,'03:12',100,2,'/music/2.mp3'),(5,'解药',2,'/image/music/3.jpg',3,'02:59',400,3,'/music/3.mp3'),(6,'哥哥呀(오빠야',1,'/image/music/4.jpg',2,'04:12',500,4,'/music/4.mp3'),(7,'礼仪之邦.mp3',2,'/image/music/5.jpg',2,'03:23',100,1,'/music/5.mp3');
/*!40000 ALTER TABLE `music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `singer`
--

DROP TABLE IF EXISTS `singer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `singer` (
  `Id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `describute` varchar(20) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  `englishName` varchar(50) DEFAULT 'maker',
  `county` varchar(20) DEFAULT '牛X的经历',
  `birthArea` varchar(50) DEFAULT '北京',
  `job` varchar(50) DEFAULT NULL,
  `works` varchar(255) DEFAULT '你是我的小星星 春天 认真的雪',
  `other` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `singer`
--

LOCK TABLES `singer` WRITE;
/*!40000 ALTER TABLE `singer` DISABLE KEYS */;
INSERT INTO `singer` VALUES (1,'周杰伦','小天王，音乐天才，','/image/singer/4.jpg','Zhou','中国','北京','歌手，主持，演员','稻香 听妈妈的话 十二新作',''),(2,'林俊杰','华语流行乐男歌手、词曲创作者','/image/singer/1.jpg','JJ Lin ','新加坡','北京','歌手，主持，演员','为你心跳  江南 杀手',NULL),(3,'光良','歌手、音乐制作人、演员','/image/singer/3.jpg','Michael Wong','马来西亚 ','马来西亚怡保','歌手、音乐制作人、演员 ','童话、第一次、约定、烟火、都是你、少年、女孩别哭、勇气、掌心','马来西亚十大杰出青年文化成就荣誉奖'),(4,'张杰','男歌手，音乐厂牌“行星文化”创始人','/image/singer/2.jpg','Jason Zhang ','中国 ','四川成都 ','歌手 ','这就是爱、勿忘心安、天下','得33次最受欢迎男歌手（大满贯）'),(5,'胡歌','中国内地男演员、歌手','/image/singer/5.jpg','Hugh','中国','上海市徐汇区 ','演员、歌手 ','六月的雨、逍遥叹、忘记时间 ','胡椒粉 '),(6,'罗志祥','华语流行男歌手、主持人、舞者、演员。','/image/singer/6.jpg','Show Lo','中国','台湾省基隆市','男歌手、主持人、舞者、演员','爱转角、精舞门、灰色空间、爱不单行',' MTV亚洲大奖最受欢迎男歌手 '),(7,'许嵩（Vae）','中国内地创作型男歌手','/image/singer/7.jpg','VAE','中国','合肥','歌手 ','最佳歌手、雅俗共赏、老古董、大千世界','2018嗨典年度最佳男歌手 '),(8,'周传雄','歌手、音乐制作人','/image/singer/8.jpg','Steve Chou ','中国','台湾省台中市','歌手、音乐制作人','哈萨雅琪、黄昏、关不上的窗、寂寞沙洲冷','2009音乐大典-年度最佳唱作人');
/*!40000 ALTER TABLE `singer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `name` varchar(10) CHARACTER SET latin1 NOT NULL,
  `password` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('123456','123');
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

-- Dump completed on 2019-06-11  9:39:30
