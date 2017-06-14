-- MySQL dump 10.13  Distrib 5.5.37, for Win32 (x86)
--
-- Host: localhost    Database: simulation_laboratory
-- ------------------------------------------------------
-- Server version	5.5.37

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
-- Table structure for table `t_dbbackup`
--

DROP TABLE IF EXISTS `t_dbbackup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_dbbackup` (
  `id` varchar(100) NOT NULL COMMENT '主键',
  `creatTime` date DEFAULT NULL COMMENT '建创日期',
  `creatTimeStr` varchar(20) DEFAULT NULL COMMENT '建创时间',
  `backuppath` varchar(100) NOT NULL COMMENT '数据库备份地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_dbbackup`
--

LOCK TABLES `t_dbbackup` WRITE;
/*!40000 ALTER TABLE `t_dbbackup` DISABLE KEYS */;
INSERT INTO `t_dbbackup` VALUES ('20170523191402','2017-05-23','2017-05-23 19:14:02','F:/resource/db/20170523191402.sql'),('20170523193105','2017-05-23','2017-05-23 19:31:05','F:/resource/db/20170523193105.sql'),('20170524122651','2017-05-24','2017-05-24 12:26:51','F:/resource/db/20170524122651.sql'),('20170524184400','2017-05-24','2017-05-24 18:44:00','F:/resource/db/20170524184400.sql'),('20170525003410','2017-05-25','2017-05-25 00:34:10','F:/resource/db/20170525003410.sql'),('20170525033428','2017-05-25','2017-05-25 03:34:28','F:/resource/db/20170525033428.sql'),('20170525161516','2017-05-25','2017-05-25 16:15:16','F:/resource/db/20170525161516.sql'),('20170525162319','2017-05-25','2017-05-25 16:23:19','F:/resource/db/20170525162319.sql'),('20170526012923','2017-05-26','2017-05-26 01:29:23','F:/resource/db/20170526012923.sql'),('20170526144810','2017-05-26','2017-05-26 14:48:10','F:/resource/db/20170526144810.sql'),('20170527071725','2017-05-27','2017-05-27 07:17:25','F:/resource/db/20170527071725.sql'),('20170527075704','2017-05-27','2017-05-27 07:57:04','F:/resource/db/20170527075704.sql'),('20170527090527','2017-05-27','2017-05-27 09:05:27','F:/resource/db/20170527090527.sql'),('20170527091507','2017-05-27','2017-05-27 09:15:07','F:/resource/db/20170527091507.sql'),('20170527135054','2017-05-27','2017-05-27 13:50:54','F:/resource/db/20170527135054.sql'),('20170528102633','2017-05-28','2017-05-28 10:26:33','F:/resource/db/20170528102633.sql'),('20170528102721','2017-05-28','2017-05-28 10:27:21','F:/resource/db/20170528102721.sql');
/*!40000 ALTER TABLE `t_dbbackup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_direction`
--

DROP TABLE IF EXISTS `t_direction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_direction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '方向名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '方向状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_direction`
--

LOCK TABLES `t_direction` WRITE;
/*!40000 ALTER TABLE `t_direction` DISABLE KEYS */;
INSERT INTO `t_direction` VALUES (21,'大数据','2017-05-23','2017-05-23','1'),(22,'云计算','2017-05-23','2017-05-23','1'),(23,'web开发','2017-05-23','2017-05-23','1'),(24,'android开发','2017-05-23','2017-05-23','1'),(25,'人工智能','2017-05-23','2017-05-23','1'),(26,'游戏开发','2017-05-23','2017-05-23','1'),(27,'算法','2017-05-23','2017-05-23','1'),(28,'硬件开发','2017-05-23','2017-05-23','1');
/*!40000 ALTER TABLE `t_direction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_education`
--

DROP TABLE IF EXISTS `t_education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '学历名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '学历状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_education`
--

LOCK TABLES `t_education` WRITE;
/*!40000 ALTER TABLE `t_education` DISABLE KEYS */;
INSERT INTO `t_education` VALUES (21,'初中','2017-05-23','2017-05-23','1'),(22,'小学','2017-05-23','2017-05-23','1'),(23,'本科','2017-05-23','2017-05-23','1'),(24,'研究生','2017-05-23','2017-05-23','1'),(25,'博士','2017-05-23','2017-05-23','1');
/*!40000 ALTER TABLE `t_education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_home`
--

DROP TABLE IF EXISTS `t_home`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_home` (
  `projectId` varchar(100) NOT NULL COMMENT '项目id',
  `email` varchar(50) NOT NULL COMMENT '用户email',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `status` varchar(5) DEFAULT '1' COMMENT '加入项目状态',
  PRIMARY KEY (`projectId`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_home`
--

LOCK TABLES `t_home` WRITE;
/*!40000 ALTER TABLE `t_home` DISABLE KEYS */;
INSERT INTO `t_home` VALUES ('20170523193658','456789123@qq.com','2017-05-24','2017-05-24','0'),('20170526141328','456789123@qq.com','2017-05-26','2017-05-26','0'),('20170527085807','456789123@qq.com','2017-05-27','2017-05-27','0');
/*!40000 ALTER TABLE `t_home` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_language`
--

DROP TABLE IF EXISTS `t_language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '语言名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '语言状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_language`
--

LOCK TABLES `t_language` WRITE;
/*!40000 ALTER TABLE `t_language` DISABLE KEYS */;
INSERT INTO `t_language` VALUES (21,'Java','2017-05-23','2017-05-23','1'),(22,'C语言','2017-05-23','2017-05-23','1'),(23,'C++语言','2017-05-23','2017-05-23','1'),(24,'Python','2017-05-23','2017-05-23','1'),(25,'汇编语言','2017-05-23','2017-05-23','1'),(26,'C#','2017-05-23','2017-05-23','1');
/*!40000 ALTER TABLE `t_language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_logininfo`
--

DROP TABLE IF EXISTS `t_logininfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_logininfo` (
  `id` varchar(10) NOT NULL COMMENT '主键（userid）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_logininfo`
--

LOCK TABLES `t_logininfo` WRITE;
/*!40000 ALTER TABLE `t_logininfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_logininfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_mytask`
--

DROP TABLE IF EXISTS `t_mytask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_mytask` (
  `id` int(11) NOT NULL COMMENT '主键',
  `description` varchar(500) DEFAULT NULL COMMENT '任务描述',
  `taskFile` varchar(200) DEFAULT NULL COMMENT '详细任务文件地址',
  `state` varchar(5) DEFAULT '1' COMMENT '默认任务是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mytask`
--

LOCK TABLES `t_mytask` WRITE;
/*!40000 ALTER TABLE `t_mytask` DISABLE KEYS */;
INSERT INTO `t_mytask` VALUES (1,'默认任务：本系统默认任务终期成果视屏上传','F:/resource/default.txt','1');
/*!40000 ALTER TABLE `t_mytask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_news`
--

DROP TABLE IF EXISTS `t_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `newstitle` varchar(200) DEFAULT NULL COMMENT '新闻标题',
  `newsexplain` varchar(500) DEFAULT NULL COMMENT '新闻简介',
  `newslogo` varchar(200) DEFAULT '/resource/default.jpg' COMMENT '新闻logo',
  `newsdetails` varchar(200) DEFAULT '#' COMMENT '详情连接',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '新闻状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_news`
--

LOCK TABLES `t_news` WRITE;
/*!40000 ALTER TABLE `t_news` DISABLE KEYS */;
INSERT INTO `t_news` VALUES (21,'平台测试','本平台开发阶段已将近完成马上进入测试阶段，希望广大内测人员尽力测试出bug，以便后期维护。','/resource/news/1495537091411','#','2017-05-23','2017-05-23','1'),(22,'软件测试全面启动','到目前为止该平台代码实现已经完成，现已全面进入软件测试阶段。在此阶段过程中遇到的问题希望大家积极配合实现bug的战斗。','/resource/news/1495537540521','#','2017-05-23','2017-05-23','1'),(23,'校园软件开发在线协同平台平台1.0版本发布','校园软件开发在线协同平台平台1.0版本发布，本平台1.0版本在于大家长期测试使用，再次阶段广大用户可以免费使用，在后期不确定是否会收费。','/resource/news/1495537812843','#','2017-05-23','2017-05-23','1'),(24,'平台启动授权','西安科技大学对校园软件开发平台项目启动授权，其中包括我校各级领导，以及老师，研发工作这共计100人。','/resource/news/1495702114725','#','2017-05-25','2017-05-25','1'),(25,'项目2.0发布','校园软件项目开发平台，在经历一年的测试交付使用后，终于迎来了2.0版本的上线，在这一年中感谢广大学生，老师，领导对校园软件在线开发平台的支持。','/resource/news/1495702304809','#','2017-05-25','2017-05-25','1'),(26,'bug发布','校园软件开发在线协同平台在2.0发布的一年后，出现了第一次网络攻击，在这次攻击的过程中影响了广大用户的操作，小编在此表示抱歉，不过的们的bug已经修复，大家可以正常使用该系统进行软件开发管理啦。','/resource/news/1495702571308','#','2017-05-25','2017-05-25','1');
/*!40000 ALTER TABLE `t_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_platform`
--

DROP TABLE IF EXISTS `t_platform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '平台名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '方向状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_platform`
--

LOCK TABLES `t_platform` WRITE;
/*!40000 ALTER TABLE `t_platform` DISABLE KEYS */;
INSERT INTO `t_platform` VALUES (21,'Windows','2017-05-23','2017-05-23','1'),(22,'Linux','2017-05-23','2017-05-23','1'),(23,'Unix','2017-05-23','2017-05-23','1');
/*!40000 ALTER TABLE `t_platform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_project`
--

DROP TABLE IF EXISTS `t_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_project` (
  `projid` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键',
  `projname` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '项目名称',
  `projemail` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '创建人邮件账号',
  `creatpersionname` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '创建人姓名',
  `projphone` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '手机号',
  `projlanguage` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '开发语言',
  `projplatform` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '开发平台',
  `projallNumber` int(11) NOT NULL DEFAULT '0' COMMENT '项目总人数',
  `projcurrentNumber` int(11) NOT NULL DEFAULT '0' COMMENT '项目当前人数',
  `projtutor` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '指导老师账号',
  `projtutorname` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '指导老师姓名',
  `projbudget` double(10,0) DEFAULT NULL COMMENT '项目预算价格',
  `projbudgetFile` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '预算账单地址',
  `projprogectFile` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '立项书',
  `projdescribe` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '项目描述',
  `projlogo` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '项目logo',
  `projcreatTime` date NOT NULL COMMENT '创建时间',
  `projstartupTime` date DEFAULT NULL COMMENT '启动时间',
  `projupdateTime` date DEFAULT NULL COMMENT '更新时间',
  `projendTime` date NOT NULL COMMENT '结束时间',
  `projstartupEvaluation` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '项目启动审核评价',
  `projstartupEvaluationvalue` int(5) DEFAULT '0' COMMENT '项目启动审核评价等级',
  `projstartupEvaluationstate` int(5) DEFAULT '0' COMMENT '项目启动审核状态',
  `projresultEvaluationvalue` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '项目结题审核评价',
  `projresultEvaluation` int(5) DEFAULT '0' COMMENT '项目结题审核评价等级',
  `projresultEvaluationstate` int(5) DEFAULT '0' COMMENT '项目结题审核状态',
  `projgrade` varchar(5) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '项目最终等级数据',
  `projstatus` int(5) NOT NULL DEFAULT '0' COMMENT '项目最终结果状态',
  PRIMARY KEY (`projid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_project`
--

LOCK TABLES `t_project` WRITE;
/*!40000 ALTER TABLE `t_project` DISABLE KEYS */;
INSERT INTO `t_project` VALUES ('20170523193658','计算机开发','123456789@qq.com','邝忠震','15548752689','Python','Windows',3,3,'22','董美丽',1255,'F:/resource/21/20170523193658/4c978c3c-df44-4c3e-8699-cc0e75e9a57d新版标准日本语初级单词文本(1-48课)电子文档.doc','F:/resource/21/20170523193658/c1d4aab9-7330-4b4d-9aeb-74ee37ea47c7日语学习计划.docx','微型计算机开发西安科技大学。',NULL,'2017-05-23','2017-05-27','2017-05-27','2017-05-23','该项目完成的不错哦！',3,1,'该项目完成的一般',3,1,'综合：良',3),('20170526141328','校园导航系统','123456789@qq.com','邝忠震','15548752689','C++语言','Linux',2,2,'22','董美丽',1500,'F:/resource/21/20170526141328/cc03a7e7-b397-4357-b2e0-8e3e0f630997预算书.docx','F:/resource/21/20170526141328/99a2cb21-4367-487b-8150-fb42ccaed1df立项书.docx','校园导航系统目的在于为广大学生提供优质服务，尤其是为新生报到提供服务。',NULL,'2017-05-26','2017-05-26','2017-05-26','2017-06-08','该系统个很大程度解决了校园的项目开发困难的问题，具有很强的应用性。',4,1,NULL,NULL,0,'初审：优',1),('20170527084651','图书馆预约系统','123456789@qq.com','邝忠震','15548752689','Java','Windows',3,1,'25','史晓楠',1566,'F:/resource/21/20170527084651/387b8260-8313-4076-962f-c38d68a3f386预算书.docx','F:/resource/21/20170527084651/aaee51a3-a036-4f9c-b0fe-a7160cd075f3立项书.docx','为西安科技大学广大学生提供图书借阅预约功能',NULL,'2017-05-27',NULL,'2017-05-27','2017-06-10',NULL,NULL,0,NULL,NULL,0,'0',0),('20170527085553','学生管理系统','123456789@qq.com','邝忠震','15548752689','Java','Windows',1,1,'22','董美丽',4588,'F:/resource/21/20170527085553/8278a211-2024-4f55-91cf-e42bc89130c1预算书.docx','F:/resource/21/20170527085553/2fb0ef2a-a915-4f4e-8750-50ac4882631a立项书.docx','管理学生宿舍，生活，缴费，考勤，卫生的一款自主系统',NULL,'2017-05-27',NULL,'2017-05-27','2017-06-10',NULL,NULL,0,NULL,NULL,0,'0',0),('20170527085807','酒店管理系统','123456789@qq.com','邝忠震','15548752689','Java','Windows',2,2,'25','史晓楠',45000,'F:/resource/21/20170527085807/baa2ce13-6ef3-47ac-b1f4-be725ab3d4ac预算书.docx','F:/resource/21/20170527085807/a9664e86-81d7-4be9-a980-fa8a7cc41abd立项书.docx','该系统为酒店提供业务管理，实现酒店的人员、财务、报销等的管理',NULL,'2017-05-27','2017-05-27','2017-05-27','2017-05-26','该系统针对酒店开发，需要考虑通用性，是一个难题。',3,1,NULL,NULL,0,'初审：良',2);
/*!40000 ALTER TABLE `t_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_task`
--

DROP TABLE IF EXISTS `t_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `projectId` varchar(100) NOT NULL COMMENT '项目id',
  `email` varchar(50) NOT NULL COMMENT '用户email',
  `name` varchar(50) NOT NULL COMMENT '用户name',
  `startupTime` date NOT NULL COMMENT '开始时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `endTime` date NOT NULL COMMENT '结束时间',
  `description` varchar(500) DEFAULT NULL COMMENT '任务描述',
  `taskFile` varchar(200) DEFAULT NULL COMMENT '详细任务文件地址',
  `resultDescription` varchar(200) DEFAULT NULL COMMENT '成果描述',
  `resultFile` varchar(200) DEFAULT NULL COMMENT '成果文件地址',
  `resultEvaluation` varchar(500) DEFAULT NULL COMMENT '成果评价',
  `parentTask` int(11) DEFAULT '-1' COMMENT '父任务',
  `status` varchar(5) DEFAULT '1' COMMENT '任务是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_task`
--

LOCK TABLES `t_task` WRITE;
/*!40000 ALTER TABLE `t_task` DISABLE KEYS */;
INSERT INTO `t_task` VALUES (22,'20170523193658','123456789@qq.com','邝忠震','2017-05-30','2017-05-25','2017-05-30','默认任务：本系统默认任务终期成果视屏上传','F:/resource/default.txt','该视屏展示了本系统的基本功能的演示','/resource/21/20170523193658/task/6ffc5c15-1138-4978-8ad0-68f522ebe9b6indexdefault.mp4',NULL,-1,'0'),(33,'20170526141328','123456789@qq.com','邝忠震','2017-06-08','2017-05-26','2017-06-08','默认任务：本系统默认任务终期成果视屏上传','F:/resource/default.txt',NULL,'/resource/default.mp4',NULL,NULL,NULL),(34,'20170526141328','123456789@qq.com','邝忠震','2017-05-27','2017-05-26','2017-05-28','项目需求的理解','F:/resource/21/20170526141328/task/aca2c476-f4b4-417d-9734-f620c622e22a预算书.docx',NULL,NULL,NULL,NULL,'0'),(35,'20170526141328','456789123@qq.com','姚鹏飞','2017-05-27','2017-05-27','2017-05-28','理解项目注册登录需求','F:/resource/21/20170526141328/task/55f57e58-17d0-4b17-ac7c-53aaf20b30a5立项书.docx','完成理解。理解文档已经上传，下载可以看到。','F:/resource/23/20170526141328/task/b532ae79-6b15-45ed-8bfc-05ba7c55c04c预算书.docx',NULL,NULL,'0'),(36,'20170523193658','123456789@qq.com','邝忠震','2017-05-24','2017-05-27','2017-05-25','研究计算机开发搭建的环境如何搭建','F:/resource/21/20170523193658/task/76d6d7d1-8439-4c1e-9281-a955392af84f预算书.docx','基本完成项目所需要的','F:/resource/21/20170523193658/task/b2c9dc9d-ce47-455b-b2fd-ab22f4d31808预算书.docx',NULL,NULL,'0'),(37,'20170523193658','456789123@qq.com','姚鹏飞','2017-05-24','2017-05-27','2017-05-25','理解登陆需求','F:/resource/21/20170523193658/task/550073de-fa77-4095-b6c2-f99a48ca6c8d立项书.docx','登陆需求理解完毕','F:/resource/21/20170523193658/task/d442f3e2-08d6-42e3-92d1-884bed5a12c1预算书.docx',NULL,NULL,'0'),(38,'20170523193658','789123456@qq.com','王朝','2017-05-24','2017-05-27','2017-05-25','理解注册需求','F:/resource/21/20170523193658/task/c15bd4be-c8d5-4fbf-9a1b-e95868873ffd立项书.docx','注册已经实现','F:/resource/21/20170523193658/task/fc701624-6b46-453c-8bfb-7aaecc017a41立项书.docx',NULL,NULL,'0'),(39,'20170527084651','123456789@qq.com','邝忠震','2017-06-10','2017-05-27','2017-06-10','默认任务：本系统默认任务终期成果视屏上传','F:/resource/default.txt',NULL,'/resource/default.mp4',NULL,NULL,NULL),(40,'20170527085553','123456789@qq.com','邝忠震','2017-06-10','2017-05-27','2017-06-10','默认任务：本系统默认任务终期成果视屏上传','F:/resource/default.txt',NULL,'/resource/default.mp4',NULL,NULL,NULL),(41,'20170527085807','123456789@qq.com','邝忠震','2017-05-31','2017-05-27','2017-05-31','默认任务：本系统默认任务终期成果视屏上传','F:/resource/default.txt',NULL,'/resource/default.mp4',NULL,NULL,NULL),(42,'20170526141328','123456789@qq.com','邝忠震','2017-05-27','2017-05-27','2017-05-28','王企鹅完全','F:/resource/21/20170526141328/task/cbb7a869-d928-4235-9fe9-24108aef4b55立项书.docx',NULL,NULL,NULL,NULL,'0'),(43,'20170526141328','456789123@qq.com','姚鹏飞','2017-05-27','2017-05-27','2017-05-28',NULL,NULL,NULL,NULL,NULL,NULL,'0');
/*!40000 ALTER TABLE `t_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_title`
--

DROP TABLE IF EXISTS `t_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_title` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '职称名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '职称状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_title`
--

LOCK TABLES `t_title` WRITE;
/*!40000 ALTER TABLE `t_title` DISABLE KEYS */;
INSERT INTO `t_title` VALUES (21,'学生','2017-05-23','2017-05-23','1'),(23,'讲师','2017-05-23','2017-05-23','1'),(24,'教授','2017-05-23','2017-05-23','1'),(25,'副教授','2017-05-23','2017-05-23','1');
/*!40000 ALTER TABLE `t_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `email` varchar(50) NOT NULL COMMENT '邮件地址',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(50) NOT NULL DEFAULT 'e10adc3949ba59abbe56e057f20f883e' COMMENT '密码',
  `role` varchar(5) NOT NULL COMMENT '角色',
  `title` varchar(10) DEFAULT '学生' COMMENT '职称',
  `education` varchar(10) DEFAULT '本科' COMMENT '学历',
  `direction` varchar(10) DEFAULT '大数据' COMMENT '方向',
  `introduce` varchar(500) DEFAULT '该用户没有留下任何痕迹!' COMMENT '简介和补充说明',
  `image` varchar(200) DEFAULT '/resource/default.jpg' COMMENT '头像照片',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) DEFAULT '2' COMMENT '账号状态',
  `grade` varchar(5) DEFAULT '1000' COMMENT '用户等级数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'任勃','314187985@qq.com','18829348437','e10adc3949ba59abbe56e057f20f883e','3','职称','学历','方向','简介和补充说明','/resource/1/TopImages/20170524144855','2017-04-13','2017-05-24','1','10'),(21,'邝忠震','123456789@qq.com','15548752689','e10adc3949ba59abbe56e057f20f883e','1','学生','本科','算法','本人家住湖南省，在西安科技大学学习四年。','/resource/21/TopImages/20170524144906','2017-05-23','2017-05-23','1','1000'),(22,'董美丽','850263341@qq.com','15548785826','e10adc3949ba59abbe56e057f20f883e','2','教授','研究生','大数据','本人本科在西安科技大学，研究生在西安交通大学，曾获得国家级奖项多项','/resource/22/TopImages/20170523193238','2017-05-23','2017-05-23','1','1000'),(23,'姚鹏飞','456789123@qq.com','18825478965','e10adc3949ba59abbe56e057f20f883e','1','学生','本科','web开发','本人在西安科技大学计算机学院软件工程专业学习四年，在这四年获得国家级软件奖项2项，省级5项，校级多项。','/resource/23/TopImages/20170524144932','2017-05-23','2017-05-23','1','1000'),(24,'王朝','789123456@qq.com','15228086532','e10adc3949ba59abbe56e057f20f883e','1','学生','研究生','大数据','曾经参加数学建模大赛在其中取得了很大的经验，并具有很强的泡妞能力，擅长数学，计算机软件使用，大数据。','/resource/24/TopImages/20170524145245','2017-05-24','2017-05-24','1','1000'),(25,'史晓楠','sxn314187985@qq.com','15229086531','e10adc3949ba59abbe56e057f20f883e','2','讲师','博士','算法','本人对算法颇有理解，尤其在地理信息方面，其次多次带领学生团队参加我校以及国家级各种重大比赛，并取得了优异的成绩!','/resource/default.jpg','2017-05-27','2017-05-27','1','1000'),(26,'朱莉','zl314187985@qq.com','18854835642','e10adc3949ba59abbe56e057f20f883e','2','讲师','博士','android开发','参与开发安卓多年，在安卓教育方面有自己的独特见解，为人和蔼，平易近人。曾带领我校学生团队参与多次重大比赛。','/resource/default.jpg','2017-05-27','2017-05-27','1','1000'),(27,'曹俊','cj223114445@qq.com','18829341234','e10adc3949ba59abbe56e057f20f883e','2','教授','博士','云计算','该用户没有留下任何痕迹!','/resource/default.jpg','2017-05-27','2017-05-27','1','1000'),(28,'赵思','zs5464454874@qq.com','18829344567','e10adc3949ba59abbe56e057f20f883e','2','副教授','博士','web开发','该用户没有留下任何痕迹!','/resource/default.jpg','2017-05-27','2017-05-27','1','1000'),(29,'李杰','lj5548698552@qq.com','18829342345','e10adc3949ba59abbe56e057f20f883e','2','讲师','研究生','人工智能','该用户没有留下任何痕迹!','/resource/default.jpg','2017-05-27','2017-05-27','1','1000'),(30,'白佳豪','bjh955659656@qq.com','18829343456','e10adc3949ba59abbe56e057f20f883e','2','教授','研究生','硬件开发','该用户没有留下任何痕迹!','/resource/default.jpg','2017-05-27','2017-05-27','1','1000'),(31,'宁少杰','nsj565666659@qq.com','18829345678','e10adc3949ba59abbe56e057f20f883e','2','副教授','博士','游戏开发','该用户没有留下任何痕迹!','/resource/default.jpg','2017-05-27','2017-05-27','1','1000');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-28 10:27:23
