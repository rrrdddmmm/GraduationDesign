DROP database IF EXISTS `simulation_laboratory`;
CREATE DATABASE simulation_laboratory;  
USE simulation_laboratory;  

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

-- ----------------------------
-- 用户表Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `email` varchar(50) NOT NULL COMMENT '邮件地址',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(50) NOT NULL DEFAULT 'e10adc3949ba59abbe56e057f20f883e' COMMENT '密码',
  `role` varchar(5) NOT NULL COMMENT '角色',
  `title` varchar(5) DEFAULT '完善职称' COMMENT '职称',
  `education` varchar(5) DEFAULT '完善学历' COMMENT '学历',
  `direction` varchar(5) DEFAULT '完善方向' COMMENT '方向',
  `introduce` varchar(500) NOT NULL COMMENT '简介和补充说明',
  `image` varchar(200) DEFAULT '/resource/default.jpg' COMMENT '头像照片',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5)  DEFAULT '2' COMMENT '账号状态',
  `grade` varchar(5)  DEFAULT '1000' COMMENT '用户等级数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
INSERT INTO `t_user` VALUES (1, '任勃', '314187985@qq.com','18829348437','e10adc3949ba59abbe56e057f20f883e', '3','职称','学历','方向','简介和补充说明','/resource/default.jpg','2017-04-13','2017-04-13','1','10');
INSERT INTO `t_user` VALUES (2, '董美丽', '850263340@qq.com','18292960987','e10adc3949ba59abbe56e057f20f883e', '3','职称','学历','方向','简介和补充说明','/resource/default.jpg','2017-04-13','2017-04-13','1','10');
INSERT INTO `t_user` VALUES (21,'ypf','111111111@qq.com','15225454879','e10adc3949ba59abbe56e057f20f883e','1','职称','本科','方向','qwdeqweqweqwe','/resource/default.jpg','2017-05-21','2017-05-21','1','1000');
-- ----------------------------
-- 职称常量表：Table structure for `t_title`
-- ----------------------------
DROP TABLE IF EXISTS `t_title`;
CREATE TABLE `t_title` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '职称名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '职称状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
INSERT INTO `t_title` VALUES ('1', '职称','2017-04-13','2017-04-13','1');
INSERT INTO `t_title` VALUES ('2', '讲师','2017-04-13','2017-04-13','1');
-- ----------------------------
-- 学历常量表：Table structure for `t_education`
-- ----------------------------
DROP TABLE IF EXISTS `t_education`;
CREATE TABLE `t_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '学历名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '学历状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
INSERT INTO `t_education` VALUES ('1', '学历','2017-04-13','2017-04-13','1');
INSERT INTO `t_education` VALUES ('2', '本科','2017-04-13','2017-04-13','1');

-- ----------------------------
-- 方向常量表：Table structure for `t_direction`
-- ----------------------------
DROP TABLE IF EXISTS `t_direction`;
CREATE TABLE `t_direction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '方向名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '方向状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
INSERT INTO `t_direction` VALUES ('1', '方向','2017-04-13','2017-04-13','1');
INSERT INTO `t_direction` VALUES ('2', '大数据','2017-04-13','2017-04-13','1');

-- ----------------------------
-- 新闻表：Table structure for `t_news`
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `newstitle` varchar(200) DEFAULT NULL COMMENT '新闻标题',
  `newsexplain` varchar(500) DEFAULT NULL COMMENT '新闻简介',
  `newslogo` varchar(200) DEFAULT '/resource/default.jpg' COMMENT '新闻logo',
  `newsdetails` varchar(200) DEFAULT '#' COMMENT '详情连接',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '0' COMMENT '新闻状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
INSERT INTO `t_news` VALUES ('1', '大数据有大新闻啦!!!','后视镜的痕','/resource/default.jpg','#','2017-04-13','2017-04-13','1');
INSERT INTO `t_news` VALUES ('2', '大数据有大新闻啦!!!','后视镜的痕','/resource/default.jpg','#','2017-04-13','2017-04-13','1');
INSERT INTO `t_news` VALUES ('3', '大数据有大新闻啦!!!','后视镜的痕','/resource/default.jpg','#','2017-04-13','2017-04-13','1');
-- ----------------------------
-- 项目表Table structure for `t_project`
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `projid` varchar(100) NOT NULL  COMMENT '主键',
  `projname` varchar(50)  NOT NULL COMMENT '项目名称',
  `projemail` varchar(50)  NOT NULL COMMENT '创建人邮件账号',
  `creatpersionname` varchar(50)  NOT NULL COMMENT '创建人姓名',
  `projphone` varchar(20) NOT NULL COMMENT '手机号',
  `projlanguage` varchar(50)  NOT NULL COMMENT '开发语言',
  `projplatform` varchar(50)  NOT NULL COMMENT '开发平台',
  `projallNumber` int(11) NOT NULL DEFAULT '0' COMMENT '项目总人数',
  `projcurrentNumber` int(11) NOT NULL DEFAULT '0' COMMENT '项目当前人数',
  `projtutor` varchar(10)  NOT NULL COMMENT '指导老师账号',
  `projtutorname` varchar(10)  NOT NULL COMMENT '指导老师姓名',
  `projbudget` double(10,0) DEFAULT NULL COMMENT '项目预算价格',
  `projbudgetFile` varchar(200)  DEFAULT NULL COMMENT '预算账单地址',
  `projprogectFile` varchar(200)  DEFAULT NULL COMMENT '立项书',
  `projdescribe` varchar(500)  DEFAULT NULL COMMENT '项目描述',
  `projlogo` varchar(200)  DEFAULT NULL COMMENT '项目logo',
  `projcreatTime` date NOT NULL COMMENT '创建时间',
  `projstartupTime` date DEFAULT NULL COMMENT '启动时间',
  `projupdateTime` date DEFAULT NULL COMMENT '更新时间',
  `projendTime` date NOT NULL COMMENT '结束时间',
  `projstartupEvaluation` varchar(500) DEFAULT NULL COMMENT '项目启动审核评价',
  `projstartupEvaluationvalue` int(5) DEFAULT NULL COMMENT '项目启动审核评价等级',
  `projstartupEvaluationstate` int(5) DEFAULT 0 COMMENT '项目启动审核状态',
  
  `projresultEvaluationvalue` varchar(500) DEFAULT NULL COMMENT '项目结题审核评价',
  `projresultEvaluation` int(5) DEFAULT NULL COMMENT '项目结题审核评价等级',
  `projresultEvaluationstate` int(5) DEFAULT 0 COMMENT '项目结题审核状态',
  
  `projgrade` varchar(5) NOT NULL DEFAULT '0' COMMENT '项目最终等级数据',
  `projstatus` int(5) NOT NULL DEFAULT 0 COMMENT '项目最终结果状态',
  PRIMARY KEY (`projid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO `t_project` VALUES ('20170520212720','计算机开发','314187985@qq.com','任勃','18829348437','java语言','windows平台',12,1,'2','董美丽',123,'/resource/1/20170520212720/ffe6e3ea-9114-470b-b069-7c83fe6e295a日语学习计划.docx',NULL,'微型计算机开发',NULL,'2017-05-20',NULL,'2017-05-20','2017-05-25',NULL,NULL,0,NULL,NULL,0,0,0);
INSERT INTO `t_project` VALUES ('20170520213053','企业管理','314187985@qq.com','任勃','18829348437','java语言','windows平台',23,1,'1','任勃',456,'/resource/1/20170520213053/30119bc2-5eeb-4ec4-bb38-84c1d5aa8673日语学习计划.docx',NULL,'企业人事管理',NULL,'2017-05-20',NULL,'2017-05-20','2017-05-26',NULL,NULL,0,NULL,NULL,0,0,0);
INSERT INTO `t_project` VALUES ('20170520213214','学生系统管理','314187985@qq.com','任勃','18829348437','java语言','windows平台',123,1,'1','任勃',789,'/resource/1/20170520213214/1dea01f2-bd43-4d66-b6b6-baff267e3134日语学习计划.docx',NULL,'管理学生生活、学习、资费等',NULL,'2017-05-20',NULL,'2017-05-20','2017-06-10',NULL,NULL,0,NULL,NULL,0,0,0);
INSERT INTO `t_project` VALUES ('20170521105026','论文查重平台','850263340@qq.com','董美丽','18292960987','java语言','windows平台',12,1,'2','董美丽',456,'/resource/2/20170521105026/aa955e5a-f594-41a3-8aac-084edf943659913.docx',NULL,'123456489789765432123456',NULL,'2017-05-21',NULL,'2017-05-21','2017-05-30',NULL,NULL,0,NULL,NULL,0,'0',0);

-- ----------------------------
-- 开发语言常量表：Table structure for `t_language`
-- ----------------------------
DROP TABLE IF EXISTS `t_language`;
CREATE TABLE `t_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '语言名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '语言状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
INSERT INTO `t_language` VALUES ('1', 'java语言','2017-04-13','2017-04-13','1');
INSERT INTO `t_language` VALUES ('2', 'c语言','2017-04-13','2017-04-13','1');
INSERT INTO `t_language` VALUES ('3', 'c#语言','2017-04-13','2017-04-13','1');

-- ----------------------------
-- 开发平台常量表：Table structure for `t_platform`
-- ----------------------------
DROP TABLE IF EXISTS `t_platform`;
CREATE TABLE `t_platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '平台名称',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '方向状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
INSERT INTO `t_platform` VALUES ('1', 'windows平台','2017-04-13','2017-04-13','1');
INSERT INTO `t_platform` VALUES ('2', 'linux平台','2017-04-13','2017-04-13','1');

-- ----------------------------
-- 用户-项目表（不包括负责人）：Table structure for `home`
-- ----------------------------
DROP TABLE IF EXISTS `t_home`;
CREATE TABLE `t_home` (
  `projectId` varchar(100)  NOT NULL COMMENT '项目id',
  `email` varchar(50) NOT NULL COMMENT '用户email',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `status` int(10) NOT NULL DEFAULT '0' COMMENT '加入项目状态',
  PRIMARY KEY (`projectId`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
INSERT INTO `t_home` VALUES ('20170520212720', '111111111@qq.com','2017-04-13','2017-04-13','0');
INSERT INTO `t_home` VALUES ('20170520212720', '850263340@qq.com','2017-04-13','2017-04-13','0');
INSERT INTO `t_home` VALUES ('20170520213053', '111111111@qq.com','2017-04-13','2017-04-13','0');
INSERT INTO `t_home` VALUES ('20170520213053', '850263340@qq.com','2017-04-13','2017-04-13','0');
-- ----------------------------
-- 任务表：Table structure for `t_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `projectId` varchar(100)  NOT NULL COMMENT '项目id',
  `email` varchar(50) NOT NULL COMMENT '用户email',
  `startupTime` date NOT NULL COMMENT '开始时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `endTime` date NOT NULL COMMENT '结束时间',
  `description` varchar(500) DEFAULT NULL COMMENT '任务描述',
  `taskFile` varchar(20)  DEFAULT NULL COMMENT '详细任务文件地址',
  `resultDescription` varchar(20)  DEFAULT NULL COMMENT '成果描述',
  `resultFile` varchar(20)  DEFAULT NULL COMMENT '成果文件地址',
  `resultEvaluation` varchar(500) DEFAULT NULL COMMENT '成果评价',
  `status` int(10) NOT NULL DEFAULT '0' COMMENT '任务是否有效',
  PRIMARY KEY (`projectId`,`email`,`startupTime`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
-- ----------------------------
-- 数据库备份表：Table structure for `t_dbbackup`
-- ----------------------------
DROP TABLE IF EXISTS `t_dbbackup`;
CREATE TABLE `t_dbbackup` (
  `id` varchar(100) NOT NULL  COMMENT '主键',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `creatTimeStr` varchar(20) DEFAULT NULL COMMENT '建创时间',
  `backuppath` varchar(100) NOT NULL COMMENT '数据库备份地址',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;