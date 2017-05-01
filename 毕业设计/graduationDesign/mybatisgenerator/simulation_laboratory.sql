DROP database IF EXISTS `simulation_laboratory`;
CREATE DATABASE simulation_laboratory;  
USE simulation_laboratory;  

DROP TABLE IF EXISTS `file_type`;
CREATE TABLE `file_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file_type
-- ----------------------------
INSERT INTO `file_type` VALUES ('1', '初级类');
INSERT INTO `file_type` VALUES ('2', '中级类');
INSERT INTO `file_type` VALUES ('3', '高级类');
-- ----------------------------
-- Table structure for `homework_title`
-- ----------------------------
DROP TABLE IF EXISTS `homework_title`;
CREATE TABLE `homework_title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pubtime` datetime DEFAULT NULL,
  `description` text,
  `title` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homework_title
-- ----------------------------
INSERT INTO `homework_title` VALUES ('1', '2013-04-26 14:22:49', '完成数组int[] a = {100,40, 60, 87, 34, 11, 56, 0}的快速排序、冒泡排序；', '实现快速排序、冒泡排序；');
INSERT INTO `homework_title` VALUES ('2', '2013-04-26 14:24:15', '将一个数组中值=0的项去掉,将不为0的值存入一个新的数组,比如:<br />\r\nint a[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};<br />\r\n生成的新数组为:<br />\r\nint b[]={1,3,4,5,6,6,5,4,7,6,7,5}<br />', '将一个数组中值=0的项去掉,将不为0的值存入一个新的数组');
-- ----------------------------
-- Table structure for `news_menu`
-- ----------------------------
DROP TABLE IF EXISTS `news_menu`;
CREATE TABLE `news_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_menu
-- ----------------------------
INSERT INTO `news_menu` VALUES ('3', '校园动态');
INSERT INTO `news_menu` VALUES ('4', '校园风采');


-- ----------------------------
-- Table structure for `source_menu`
-- ----------------------------
DROP TABLE IF EXISTS `source_menu`;
CREATE TABLE `source_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of source_menu
-- ----------------------------
INSERT INTO `source_menu` VALUES ('3', 'java资源');
INSERT INTO `source_menu` VALUES ('4', '网页基础资源');


-- ----------------------------
-- Table structure for `topic_menu`
-- ----------------------------
DROP TABLE IF EXISTS `topic_menu`;
CREATE TABLE `topic_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_menu
-- ----------------------------
INSERT INTO `topic_menu` VALUES ('1', '学习交流');
INSERT INTO `topic_menu` VALUES ('2', '灌水专区');


-- ----------------------------
-- Table structure for `user_table`
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `authorite` varchar(50) NOT NULL,
  `enable` bit(1) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES ('1', 'admin', '123', 'ROLE_SUPERVISOR', '', '123@126.com');
INSERT INTO `user_table` VALUES ('2', 'user1', '123', 'ROLE_USER', '\0', '234@qq.com');
INSERT INTO `user_table` VALUES ('3', 'user2', '123', 'ROLE_USER', '', '345@qq.com');


-- ----------------------------
-- Table structure for `clazz_menu`
-- ----------------------------
DROP TABLE IF EXISTS `clazz_menu`;
CREATE TABLE `clazz_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `parentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6CECDAE69F57DC30` (`parentId`),
  CONSTRAINT `FK6CECDAE69F57DC30` FOREIGN KEY (`parentId`) REFERENCES `clazz_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazz_menu
-- ----------------------------
INSERT INTO `clazz_menu` VALUES ('1', '网页基础', null);
INSERT INTO `clazz_menu` VALUES ('4', 'html', '1');
INSERT INTO `clazz_menu` VALUES ('7', 'css', '1');
INSERT INTO `clazz_menu` VALUES ('8', 'javascript', '1');
INSERT INTO `clazz_menu` VALUES ('9', 'Java基础', null);
INSERT INTO `clazz_menu` VALUES ('10', 'java语法', '9');
INSERT INTO `clazz_menu` VALUES ('11', 'java面向对象', '9');

-- ----------------------------
-- Table structure for `clazz_table`
-- ----------------------------
DROP TABLE IF EXISTS `clazz_table`;
CREATE TABLE `clazz_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `filename` varchar(40) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `author` varchar(10) DEFAULT NULL,
  `pubtime` datetime DEFAULT NULL,
  `img` varchar(40) DEFAULT NULL,
  `flashFilename` varchar(40) DEFAULT NULL,
  `school` varchar(50) DEFAULT NULL,
  `viewcount` int(11) DEFAULT NULL,
  `filetype` int(11) NOT NULL,
  `menuId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK310F2727190F8FA5` (`menuId`),
  KEY `FK310F27278CA3DC9E` (`filetype`),
  CONSTRAINT `FK310F2727190F8FA5` FOREIGN KEY (`menuId`) REFERENCES `clazz_menu` (`id`),
  CONSTRAINT `FK310F27278CA3DC9E` FOREIGN KEY (`filetype`) REFERENCES `file_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazz_table
-- ----------------------------
INSERT INTO `clazz_table` VALUES ('5', 'html初级教程', '201304271834049284.txt', '1', 'admin', '2013-04-27 18:34:04', '201304271836472989.jpg', '201304271834051459.swf', '哈哈', '0', '1', '4');
INSERT INTO `clazz_table` VALUES ('6', 'css中级', '201304271839100285.txt', '1', 'admin', '2013-04-27 18:39:09', '201304271839098787.jpg', '201304271839101767.swf', 'aa', '0', '2', '7');
INSERT INTO `clazz_table` VALUES ('7', 'java高级语法', '201304271840013347.txt', '1', 'admin', '2013-04-27 18:40:01', '201304271840012126.jpg', '201304271840014700.swf', 'aa', '0', '3', '10');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `source` varchar(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `author` varchar(10) DEFAULT NULL,
  `pubtime` datetime DEFAULT NULL,
  `viewnum` int(11) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  `menuId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK338AD3817C679E` (`menuId`),
  CONSTRAINT `FK338AD3817C679E` FOREIGN KEY (`menuId`) REFERENCES `news_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('10', '&nbsp;此新闻纯属虚构。', '校园网', '4', '大一美女新生报道', 'admin', '2013-04-27 17:33:39', '0', '201304271733396452.jpg', '3');
INSERT INTO `news` VALUES ('12', '&nbsp;这个校园动态新闻1，你懂的。', '哈哈', '1', '这个校园动态新闻1，你懂的。', 'admin', '2013-04-27 17:35:24', '0', null, '3');
INSERT INTO `news` VALUES ('13', '&nbsp;这个校园动态新闻1，你懂的。', '哈哈', '2', '这个校园动态新闻2，你懂的。', 'admin', '2013-04-27 17:35:42', '0', null, '3');
INSERT INTO `news` VALUES ('14', '&nbsp;这个校园动态新闻1，你懂的。', '哈哈', '1', '这个校园动态新闻1，你懂的。', 'admin', '2013-04-27 17:36:34', '0', null, '3');
INSERT INTO `news` VALUES ('15', '&nbsp;这个校园风采新闻1，你懂的。', '哈哈', '1', '这个校园风采新闻1，你懂的。', 'admin', '2013-04-27 17:37:10', '0', null, '4');
INSERT INTO `news` VALUES ('16', '&nbsp;这个校园风采新闻1，你懂的。', '哈哈', '2', '这个校园风采新闻2，你懂的。', 'admin', '2013-04-27 17:37:19', '0', null, '4');
INSERT INTO `news` VALUES ('17', '&nbsp;这个校园风采新闻1，你懂的。', '哈哈', '2', '这个校园风采新闻2，你懂的。', 'admin', '2013-04-27 17:37:19', '0', null, '4');
INSERT INTO `news` VALUES ('18', '&nbsp;这个校园风采新闻1，你懂的。', '哈哈', '2', '这个校园风采新闻1，你懂的。', 'admin', '2013-04-27 17:37:27', '0', null, '4');


-- ----------------------------
-- Table structure for `source_table`
-- ----------------------------
DROP TABLE IF EXISTS `source_table`;
CREATE TABLE `source_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `filename` varchar(50) NOT NULL,
  `pubtime` datetime DEFAULT NULL,
  `fileSize` varchar(20) NOT NULL,
  `menuId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK639746AADCD8A326` (`menuId`),
  CONSTRAINT `FK639746AADCD8A326` FOREIGN KEY (`menuId`) REFERENCES `source_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of source_table
-- ----------------------------
INSERT INTO `source_table` VALUES ('2', 'java编程思想', '201304271844560452.txt', '2013-04-27 18:44:56', '10', '3');
INSERT INTO `source_table` VALUES ('3', 'css基础', '201304271845128702.txt', '2013-04-27 18:45:12', '10', '4');


-- ----------------------------
-- Table structure for `topic_table`
-- ----------------------------
DROP TABLE IF EXISTS `topic_table`;
CREATE TABLE `topic_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `pubtime` datetime DEFAULT NULL,
  `detail` text NOT NULL,
  `replynum` int(11) DEFAULT NULL,
  `edituser` varchar(50) DEFAULT NULL,
  `edittime` datetime DEFAULT NULL,
  `menuId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFA7A8CBECC9051BC` (`menuId`),
  KEY `FKFA7A8CBE2A868CC3` (`userId`),
  CONSTRAINT `FKFA7A8CBE2A868CC3` FOREIGN KEY (`userId`) REFERENCES `user_table` (`id`),
  CONSTRAINT `FKFA7A8CBECC9051BC` FOREIGN KEY (`menuId`) REFERENCES `topic_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_table
-- ----------------------------
INSERT INTO `topic_table` VALUES ('2', 'java好好学啊', '2013-04-27 18:51:40', '&nbsp;哈哈', '1', 'user2', '2013-04-27 18:51:53', '1', '3');



-- ----------------------------
-- Table structure for `userhoumework_table`
-- ----------------------------
DROP TABLE IF EXISTS `userhoumework_table`;
CREATE TABLE `userhoumework_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `addtime` datetime DEFAULT NULL,
  `titleId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE86B38DB1D35ECEF` (`titleId`),
  KEY `FKE86B38DB2A868CC3` (`userId`),
  CONSTRAINT `FKE86B38DB1D35ECEF` FOREIGN KEY (`titleId`) REFERENCES `homework_title` (`id`),
  CONSTRAINT `FKE86B38DB2A868CC3` FOREIGN KEY (`userId`) REFERENCES `user_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userhoumework_table
-- ----------------------------

DROP TABLE IF EXISTS `answer_table`;
CREATE TABLE `answer_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `status` int(11) DEFAULT NULL,
  `pubtime` datetime DEFAULT NULL,
  `topicId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC06B980D29D8874D` (`topicId`),
  KEY `FKC06B980D2A868CC3` (`userId`),
  CONSTRAINT `FKC06B980D29D8874D` FOREIGN KEY (`topicId`) REFERENCES `topic_table` (`id`),
  CONSTRAINT `FKC06B980D2A868CC3` FOREIGN KEY (`userId`) REFERENCES `user_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer_table
-- ----------------------------
INSERT INTO `answer_table` VALUES ('2', '&nbsp;是的', '1', '2013-04-27 18:51:53', '2', '3');




-- ----------------------------
-- Table structure for `userhoumework_table`
-- ----------------------------
DROP TABLE IF EXISTS `userhoumework_table`;
CREATE TABLE `userhoumework_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `addtime` datetime DEFAULT NULL,
  `titleId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE86B38DB1D35ECEF` (`titleId`),
  KEY `FKE86B38DB2A868CC3` (`userId`),
  CONSTRAINT `FKE86B38DB1D35ECEF` FOREIGN KEY (`titleId`) REFERENCES `homework_title` (`id`),
  CONSTRAINT `FKE86B38DB2A868CC3` FOREIGN KEY (`userId`) REFERENCES `user_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userhoumework_table
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `home_information`
-- ----------------------------
DROP TABLE IF EXISTS `home_information`;
CREATE TABLE `home_information` (
  `project_no` int(10) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`project_no`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of home_information
-- ----------------------------
INSERT INTO `home_information` VALUES ('15', '314187985@qq.com');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_no` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home_no` int(11) DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `project_data` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `project_language` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `develop_platform` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `all_number` int(11) DEFAULT NULL,
  `pronser_number` int(11) DEFAULT NULL,
  `crt_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `leader` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `approver` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `projectbudget` double(10,0) DEFAULT NULL,
  `describeproject` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`project_no`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '计算机开发', null, '314187985@qq.com', null, 'java', 'windows', '5', '5', '2017-04-13', '2017-04-03', '0', '任博', '宁少杰', '2017', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊');
INSERT INTO `project` VALUES ('2', '会议管理系统', null, '925857350@qq.com', null, 'java', 'windows', '6', '4', '2017-04-16', '2017-04-16', '0', '宁少杰', '任博', '2303', '啊啊啊啊啊啊啊啊啊啊啊');
INSERT INTO `project` VALUES ('15', 'first', null, '314187985@qq44.com', null, 'java', 'windows', '4', '1', '2017-04-13', '2017-04-27', '0', 'nisj', 'renbo', '123', 'jisnjsgasdbhsagyuesdsaasd');
INSERT INTO `project` VALUES ('16', '', null, '314187985@qq44.com', null, '-1', '', null, '0', '2017-04-14', '2017-04-22', '0', '', '', null, '');
INSERT INTO `project` VALUES ('17', 'sad', null, '', null, 'java', 'asd', '12', '0', '2017-04-22', '2017-04-12', '0', 'sad', 'asd', '211', 'asd');
INSERT INTO `project` VALUES ('18', 'sad', null, '', null, 'java', 'asd', '12', '0', '2017-04-22', '2017-04-12', '0', 'sad', 'asd', '211', 'asd');
INSERT INTO `project` VALUES ('19', 'ad', null, '314187985@qq44.com', null, 'java', 'asd', '12', '0', '2017-04-29', '2017-04-18', '0', 'asd', 'sad', '21', 'asd');
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `role` varchar(5) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('12', '12', '12', '1');
INSERT INTO `user` VALUES ('123', '123', '123', '1');
INSERT INTO `user` VALUES ('12', '2111121', '12', '1');
INSERT INTO `user` VALUES ('123456', '314187985@qq.com', '123123', '1');
INSERT INTO `user` VALUES ('123456', '314187985@qq44.com', '18829348437', '1');