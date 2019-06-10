-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: Blog
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
-- Current Database: `Blog`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `Blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `Blog`;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `articleDestribute` varchar(255) DEFAULT NULL COMMENT '文档的描述',
  `articleName` varchar(40) DEFAULT NULL,
  `articlePublishTime` varchar(12) NOT NULL,
  `authorId` int(10) DEFAULT NULL,
  `articleAddress` varchar(100) DEFAULT NULL,
  `class` varchar(40) DEFAULT NULL,
  `articlePictureAddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`articlePublishTime`),
  KEY `article__author_fk` (`authorId`),
  CONSTRAINT `article__author_fk` FOREIGN KEY (`authorId`) REFERENCES `author` (`authorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表 ，存放的是文章的相关信息\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES ('3_css的-div-盒子模型 ','使用div实现网页的复杂布局','201811141832',111111,'/article/3_css_division_box_model.html','javascript学习基础','/html/img/three.jpeg'),('2_css技术美化网页','使用css样式修饰，让你的html网页更加美观','201811141843',111111,'/article/2_css_technology_beautifies_webpage.html','前端开发入门教程','/html/img/two.jpeg'),('4_列表与超链接 ','使用常见列表超链接，使你的网页不在孤单','201811141851',111111,'/article/4_list_and_link.html','javascript学习基础','/html/img/four.jpeg'),('1_常见标记','html里面的常用标记','201811141856',111111,'/article/1_common_mark.html','javascript学习基础','/html/img/one.jpeg'),('5_js简单入门，了解js的发展历史，js的简单运算，定义变量，赋值等操作，了解js的基本组成部分','5_js简单入门','201811151359',111111,'/article/float_and_position.html','javascript学习基础','/html/img/five.jpeg');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articleComment`
--

DROP TABLE IF EXISTS `articleComment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articleComment` (
  `userid` int(10) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `articleCommentid` int(10) NOT NULL AUTO_INCREMENT,
  `articlePublicTime` varchar(12) DEFAULT NULL,
  `commentTime` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`articleCommentid`),
  KEY `articleComment__article_fk` (`articlePublicTime`),
  CONSTRAINT `articleComment__article_fk` FOREIGN KEY (`articlePublicTime`) REFERENCES `article` (`articlePublishTime`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articleComment`
--

LOCK TABLES `articleComment` WRITE;
/*!40000 ALTER TABLE `articleComment` DISABLE KEYS */;
INSERT INTO `articleComment` VALUES (12245,'讲解的很基础，但很实用',1,'201811141832','201812221234');
/*!40000 ALTER TABLE `articleComment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `authorid` int(10) NOT NULL,
  `nikeName` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`authorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (111111,'小芳芳');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dayNote`
--

DROP TABLE IF EXISTS `dayNote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dayNote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `publishTime` varchar(12) DEFAULT NULL,
  `authorid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dayNode__author_fk` (`authorid`),
  CONSTRAINT `dayNode__author_fk` FOREIGN KEY (`authorid`) REFERENCES `author` (`authorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='日记表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dayNote`
--

LOCK TABLES `dayNote` WRITE;
/*!40000 ALTER TABLE `dayNote` DISABLE KEYS */;
INSERT INTO `dayNote` VALUES (1,'生活还在继续，努力前行','20180212',111111),(2,'简单的生活比什么都重要','20190523',111111);
/*!40000 ALTER TABLE `dayNote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaveMessage`
--

DROP TABLE IF EXISTS `leaveMessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leaveMessage` (
  `userid` int(10) DEFAULT NULL,
  `leaveMessageid` int(10) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `leaveMessageTime` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`leaveMessageid`),
  KEY `leaveMessage__user_fk` (`userid`),
  CONSTRAINT `leaveMessage__user_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='网站留言';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaveMessage`
--

LOCK TABLES `leaveMessage` WRITE;
/*!40000 ALTER TABLE `leaveMessage` DISABLE KEYS */;
INSERT INTO `leaveMessage` VALUES (123456,2,'感谢站站长的网站，让我在这里有了自己的站点，学习了很多的东西','20190432'),(123456,3,'日常打卡记录','201906100817');
/*!40000 ALTER TABLE `leaveMessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link`
--

DROP TABLE IF EXISTS `link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `link` (
  `linkAddress` varchar(255) DEFAULT NULL,
  `linkid` int(10) NOT NULL AUTO_INCREMENT,
  `authorid` int(10) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`linkid`),
  KEY `link__author_fk` (`authorid`),
  CONSTRAINT `link__author_fk` FOREIGN KEY (`authorid`) REFERENCES `author` (`authorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link`
--

LOCK TABLES `link` WRITE;
/*!40000 ALTER TABLE `link` DISABLE KEYS */;
INSERT INTO `link` VALUES ('http://www.baidu.com',1,111111,'百度一下');
/*!40000 ALTER TABLE `link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `logTime` varchar(12) DEFAULT NULL,
  `authorid` int(10) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `logid` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`logid`),
  KEY `log__author_fk` (`authorid`),
  CONSTRAINT `log__author_fk` FOREIGN KEY (`authorid`) REFERENCES `author` (`authorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES ('20180212',111111,'2018年12月开始编写，最终20多天开发结束',1);
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `password` varchar(12) NOT NULL,
  `userid` int(10) DEFAULT NULL,
  `managerid` int(10) NOT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `authorid` int(10) DEFAULT NULL,
  PRIMARY KEY (`managerid`),
  KEY `manager__author_fk` (`authorid`),
  CONSTRAINT `manager__author_fk` FOREIGN KEY (`authorid`) REFERENCES `author` (`authorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES ('123',123456,0,NULL,111111);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `authorid` int(10) DEFAULT NULL,
  `pictureAddress` varchar(255) DEFAULT NULL,
  `uploadTime` varchar(12) DEFAULT NULL,
  `pictureid` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pictureid`),
  KEY `picture__author_fk` (`authorid`),
  CONSTRAINT `picture__author_fk` FOREIGN KEY (`authorid`) REFERENCES `author` (`authorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (111111,'http://localhost:8080/Blog/html/img/one.jpeg','201811120900',1),(111111,'http://localhost:8080/Blog/html/img/two.jpeg','201811120900',2),(111111,'http://localhost:8080/Blog/html/img/three.jpeg','201811120900',3),(111111,'http://localhost:8080/Blog/html/img/four.jpeg','201811120900',4),(111111,'http://localhost:8080/Blog/html/img/five.jpeg','201811120900',5),(111111,'http://localhost:8080/Blog/html/img/six.jpeg','201811120900',6);
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proverb`
--

DROP TABLE IF EXISTS `proverb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proverb` (
  `publishTime` varchar(12) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `authorid` int(10) DEFAULT NULL,
  `proverbid` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`proverbid`),
  KEY `proverb__author_fk` (`authorid`),
  CONSTRAINT `proverb__author_fk` FOREIGN KEY (`authorid`) REFERENCES `author` (`authorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proverb`
--

LOCK TABLES `proverb` WRITE;
/*!40000 ALTER TABLE `proverb` DISABLE KEYS */;
INSERT INTO `proverb` VALUES ('201811120904','我是一只鸟',111111,1),('201811120404','生活应该简单才行',111111,2),('201811120404','没有什么是不能过去的',111111,3),('201811120404','简简单单，生活应该充满平淡',111111,4),('201811120404','墙角的花，你孤芳自赏时，天地变小了',111111,5),('201811120404','生命的舟，人参的诗',111111,6),('201811120404','没有什么使我们不能前进',111111,7),('201811120404','孔子曰，三人行必有我师',111111,8),('201811120404','不能生的精彩，就要活的强大',111111,9),('201811120404','岁岁天天年年',111111,10),('201811120404','花儿的世界，你不懂，我也不懂',111111,11),('201811141630','土地是以它的肥沃和收获而被估价的；才能也是土地，不过它生产的不是粮食，而是真理。如果只能滋生瞑想和幻想的话，即使再大的才能也只是砂地或盐池，那上面连小草也长不出来的',111111,12),('201811141630','\n过放荡不羁的生活，容易得像顺水推舟，但是要结识良朋益友，却难如登天。',111111,13);
/*!40000 ALTER TABLE `proverb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `readRecords`
--

DROP TABLE IF EXISTS `readRecords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `readRecords` (
  `readRecordsid` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) DEFAULT NULL,
  `articlePublishTime` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`readRecordsid`),
  KEY `readRecords__user_fk` (`userid`),
  CONSTRAINT `readRecords__user_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `readRecords`
--

LOCK TABLES `readRecords` WRITE;
/*!40000 ALTER TABLE `readRecords` DISABLE KEYS */;
INSERT INTO `readRecords` VALUES (1,34756,'201811141810'),(2,35367,'201811141812'),(3,56784,'201811141808'),(4,67953,'201811151354'),(5,24235,'201811141832'),(6,24235,'201811141843'),(7,24235,'201811141843'),(8,123456,'201811141843'),(9,123456,'201811141856'),(10,123456,'201811141832'),(11,123456,'201811141832'),(12,123456,'201811141832'),(13,123456,'201811141832'),(14,123456,'201811141832'),(15,123456,'201811141832'),(16,123456,'201811141832'),(17,123456,'201811141832'),(18,123456,'201811141832'),(19,123456,'201811141832'),(20,123456,'201811141832'),(21,123456,'201811141832'),(22,123456,'201811141832'),(23,123456,'201811141832'),(24,123456,'201811141832'),(25,123456,'201811141832'),(26,123456,'201811141832'),(27,123456,'201811141832'),(28,123456,'201811141832'),(29,123456,'201811141832'),(30,123456,'201811141832'),(31,123456,'201811141832'),(32,123456,'201811141832'),(33,123456,'201811141832'),(34,123456,'201811141832'),(35,123456,'201811141832'),(36,123456,'201811141832'),(37,123456,'201811141832'),(38,123456,'201811141832'),(39,123456,'201811141832'),(40,123456,'201811141832'),(41,123456,'201811141832'),(42,123456,'201811141832'),(43,123456,'201811141832'),(44,123456,'201811141832'),(45,123456,'201811141832'),(46,123456,'201811141832'),(47,123456,'201811141832'),(48,123456,'201811141832'),(49,123456,'201811141832'),(50,123456,'201811141832'),(51,123456,'201811141832'),(52,123456,'201811141832'),(53,123456,'201811141832'),(54,123456,'201811141843'),(55,123456,'201811141843'),(56,123456,'201811141843'),(57,123456,'201811141843'),(58,123456,'201811141832'),(59,123456,'201811141843'),(60,123456,'201811141832'),(61,123456,'201811141832'),(62,123456,'201811141832'),(63,123456,'201811141832'),(64,123456,'201811141832'),(65,123456,'201811141832'),(66,123456,'201811141832'),(67,123456,'201811141832'),(68,123456,'201811141851'),(69,123456,'201811141832'),(70,123456,'201811141832'),(71,123456,'201811141856'),(72,123456,'201811141856'),(73,123456,'201811151359'),(74,123456,'201811141851');
/*!40000 ALTER TABLE `readRecords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `name` char(10) DEFAULT NULL,
  `qqNumber` varchar(12) DEFAULT NULL,
  `occupation` varchar(20) DEFAULT NULL,
  `hobby` varchar(100) DEFAULT NULL,
  `likeSinger` varchar(12) DEFAULT NULL,
  `likeMusic` varchar(12) DEFAULT NULL,
  `motto` varchar(255) DEFAULT NULL,
  `userid` int(10) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `password` varchar(12) DEFAULT NULL,
  `nikeName` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,12245,'/userHeadPortrait/usepricture.jpeg','erwew',NULL),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,24235,'/userHeadPortrait/usepricture.jpeg','stwe',NULL),('芳芳不慌',NULL,NULL,NULL,NULL,NULL,NULL,34567,'/userHeadPortrait/usepricture.jpeg','rwe',NULL),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,34756,'/userHeadPortrait/usepricture.jpeg','erwwe',NULL),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,35367,'/userHeadPortrait/usepricture.jpeg','wywhw',NULL),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,43421,'/userHeadPortrait/usepricture.jpeg','wqtq',NULL),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,47346,'/userHeadPortrait/usepricture.jpeg','euey',NULL),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,56784,'/userHeadPortrait/usepricture.jpeg','rwefw',NULL),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,67953,'/userHeadPortrait/usepricture.jpeg','26hw',NULL),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,72747,'/userHeadPortrait/usepricture.jpeg','wy643',NULL),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,73742,'/userHeadPortrait/usepricture.jpeg','85eje',NULL),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,78574,'/userHeadPortrait/usepricture.jpeg','whwy4',NULL),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,90865,'/userHeadPortrait/usepricture.jpeg','fsdgs',NULL),('无名帅蟀','19***15**7','学生','code计算机 读书 篮球','周杰伦','周杰伦的歌','别人都可以，你为啥不行',123456,'/userHeadPortrait/usepricture.jpeg','123','小芳芳'),('小芳芳',NULL,NULL,NULL,NULL,NULL,NULL,333333,'http://localhost:8080/Blog/userHeadPortrait/usepricture.jpeg','123456','小芳芳'),('无名帅蟀',NULL,NULL,NULL,NULL,NULL,NULL,472674,'/userHeadPortrait/usepricture.jpeg','weuwry',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `videoName` varchar(40) DEFAULT NULL,
  `videoAddress` varchar(255) NOT NULL,
  `videoSize` char(10) DEFAULT NULL,
  `uploadTime` varchar(12) DEFAULT NULL,
  `videoNote` text,
  `videoDestribute` varchar(255) DEFAULT NULL,
  `authorid` int(10) DEFAULT NULL,
  `class` varchar(40) DEFAULT NULL,
  `classOrder` int(4) DEFAULT NULL,
  PRIMARY KEY (`videoAddress`),
  KEY `video__author_fk` (`authorid`),
  CONSTRAINT `video__author_fk` FOREIGN KEY (`authorid`) REFERENCES `author` (`authorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES ('udp通信程序功能讲解','/video/two.mp4','200mb','201811100544','自己编写的一个udp的系统结构框架，','udp通信的基础框架，自己编写的，主要是讲解具体的功能模块，没有讲解具体的编写流程',111111,'javaSE通信',1),('JavaWeb基础开发入门第一讲','/video/代码简单封装1-2019-05-21_14.41.38.mp4','200mb','201811100534','简单入门servlet，使用servlet进行简单的javaweb开发','常见的css选择器',111111,'javaWEB',1);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videoComment`
--

DROP TABLE IF EXISTS `videoComment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `videoComment` (
  `videoCommentid` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) DEFAULT NULL,
  `videoAddress` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `commentTime` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`videoCommentid`),
  KEY `videoComment__user_fk` (`userid`),
  CONSTRAINT `videoComment__user_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videoComment`
--

LOCK TABLES `videoComment` WRITE;
/*!40000 ALTER TABLE `videoComment` DISABLE KEYS */;
INSERT INTO `videoComment` VALUES (1,34567,'/video/HTML基础02_标准结构.mp4','很棒的课程',NULL),(2,34567,'/video/HTML基础08_表格(下).mp4','讲解的比较系统，比较清楚，我感觉让我对表格的理解又上了一个台阶，很感谢，大力支持',NULL),(3,123456,'/video/two.mp4','说的只是一个简单的课程设计思路 ，没有实际代码操作逻辑，感觉看了没啥作用','201906100818'),(4,123456,'/video/two.mp4','萨达所','201906101102');
/*!40000 ALTER TABLE `videoComment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videoWatch`
--

DROP TABLE IF EXISTS `videoWatch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `videoWatch` (
  `userid` int(10) DEFAULT NULL,
  `videoAddress` varchar(255) DEFAULT NULL,
  `videoWatchid` int(10) NOT NULL AUTO_INCREMENT,
  `watchTime` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`videoWatchid`),
  KEY `videoWatch__user_fk` (`userid`),
  CONSTRAINT `videoWatch__user_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videoWatch`
--

LOCK TABLES `videoWatch` WRITE;
/*!40000 ALTER TABLE `videoWatch` DISABLE KEYS */;
INSERT INTO `videoWatch` VALUES (24235,'/video/HTML基础02_标准结构.mp4',1,'201811131735'),(34756,'/video/HTML基础02_标准结构.mp4',2,'201811131735'),(35367,'/video/HTML基础02_标准结构.mp4',3,'201811131735'),(72747,'/video/two.mp4',4,'201811131735'),(35367,'/video/two.mp4',5,'201811131739'),(24235,'/video/two.mp4',7,'201811131743'),(35367,'/video/two.mp4',8,'201811131735'),(12245,'/video/two.mp4',10,'201811131735'),(67953,'/video/two.mp4',12,'201811131735'),(35367,'/video/two.mp4',14,'201811131735'),(24235,'/video/two.mp4',15,'201906100547'),(24235,'/video/two.mp4',16,'201906100547'),(123456,'/video/two.mp4',17,'201906100624'),(123456,'/video/two.mp4',18,'201906100646'),(123456,'/video/two.mp4',19,'201906100646'),(123456,'/video/two.mp4',20,'201906100647'),(123456,'/video/two.mp4',21,'201906100647'),(123456,'/video/HTML基础02_标准结构.mp4',22,'201906100649'),(123456,'/video/two.mp4',23,'201906100659'),(123456,'/video/two.mp4',24,'201906100700'),(123456,'/video/two.mp4',25,'201906100703'),(123456,'/video/two.mp4',26,'201906100703'),(123456,'/video/two.mp4',27,'201906100704'),(123456,'/video/two.mp4',28,'201906100705'),(123456,'/video/HTML基础02_标准结构.mp4',29,'201906100705'),(123456,'/video/two.mp4',30,'201906100705'),(123456,'/video/two.mp4',31,'201906100706'),(123456,'/video/two.mp4',32,'201906100709'),(123456,'/video/HTML基础02_标准结构.mp4',33,'201906100709'),(123456,'/video/two.mp4',34,'201906100710'),(123456,'/video/two.mp4',35,'201906100725'),(123456,'/video/two.mp4',36,'201906100725'),(123456,'/video/two.mp4',37,'201906100728'),(123456,'/video/two.mp4',38,'201906100729'),(123456,'/video/two.mp4',39,'201906100729'),(123456,'/video/two.mp4',40,'201906100730'),(123456,'/video/two.mp4',41,'201906100730'),(123456,'/video/two.mp4',42,'201906100731'),(123456,'/video/two.mp4',43,'201906100731'),(123456,'/video/two.mp4',44,'201906100732'),(123456,'/video/two.mp4',45,'201906100732'),(123456,'/video/two.mp4',46,'201906100733'),(123456,'/video/two.mp4',47,'201906100733'),(123456,'/video/two.mp4',48,'201906100739'),(123456,'/video/two.mp4',49,'201906100741'),(123456,'/video/two.mp4',50,'201906100742'),(123456,'/video/two.mp4',51,'201906100743'),(123456,'/video/two.mp4',52,'201906100743'),(123456,'/video/two.mp4',53,'201906100743'),(123456,'/video/HTML基础02_标准结构.mp4',54,'201906100743'),(123456,'/video/HTML基础02_标准结构.mp4',55,'201906100743'),(123456,'/video/two.mp4',56,'201906100743'),(123456,'/video/HTML基础02_标准结构.mp4',57,'201906100743'),(123456,'/video/two.mp4',58,'201906100747'),(123456,'/video/two.mp4',59,'201906100747'),(123456,'/video/two.mp4',60,'201906100748'),(123456,'/video/HTML基础02_标准结构.mp4',61,'201906100748'),(123456,'/video/two.mp4',62,'201906100748'),(123456,'/video/HTML基础02_标准结构.mp4',63,'201906100748'),(123456,'/video/two.mp4',64,'201906100752'),(123456,'/video/two.mp4',65,'201906100752'),(123456,'/video/代码简单封装1-2019-05-21_14.41.38.mp4',66,'201906100752'),(123456,'/video/two.mp4',67,'201906100817'),(123456,'/video/代码简单封装1-2019-05-21_14.41.38.mp4',68,'201906100818'),(123456,'/video/two.mp4',69,'201906100818'),(123456,'/video/two.mp4',70,'201906100819'),(123456,'/video/代码简单封装1-2019-05-21_14.41.38.mp4',71,'201906100826'),(123456,'/video/two.mp4',72,'201906100828'),(123456,'/video/two.mp4',73,'201906101048'),(123456,'/video/two.mp4',74,'201906101050'),(123456,'/video/two.mp4',75,'201906101050'),(123456,'/video/代码简单封装1-2019-05-21_14.41.38.mp4',76,'201906101050'),(123456,'/video/two.mp4',77,'201906101102'),(123456,'/video/代码简单封装1-2019-05-21_14.41.38.mp4',78,'201906101102'),(123456,'/video/代码简单封装1-2019-05-21_14.41.38.mp4',79,'201906101118'),(123456,'/video/two.mp4',80,'201906101125'),(123456,'/video/代码简单封装1-2019-05-21_14.41.38.mp4',81,'201906101125');
/*!40000 ALTER TABLE `videoWatch` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-10 11:32:04
