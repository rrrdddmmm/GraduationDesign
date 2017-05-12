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
  `email` varchar(50) NOT NULL COMMENT '邮件地址',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `role` varchar(5) NOT NULL COMMENT '角色',
  `title` varchar(5) DEFAULT '完善职称' COMMENT '职称',
  `education` varchar(5) DEFAULT '完善学历' COMMENT '学历',
  `direction` varchar(5) DEFAULT '完善方向' COMMENT '方向',
  `introduce` varchar(500) NOT NULL COMMENT '简介和补充说明',
  `image` varchar(20) DEFAULT '上传头像' COMMENT '用户头像',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '0' COMMENT '账号状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 职称常量表：Table structure for `t_title`
-- ----------------------------
DROP TABLE IF EXISTS `t_title`;
CREATE TABLE `t_title` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '职称名称',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '职称状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 学历常量表：Table structure for `t_education`
-- ----------------------------
DROP TABLE IF EXISTS `t_education`;
CREATE TABLE `t_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '学历名称',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '学历状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 方向常量表：Table structure for `t_direction`
-- ----------------------------
DROP TABLE IF EXISTS `t_direction`;
CREATE TABLE `t_direction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '方向名称',
  `state` varchar(5) NOT NULL DEFAULT '1' COMMENT '方向状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 新闻表：Table structure for `t_news`
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) NOT NULL COMMENT '新闻标题',
  `explain` varchar(500) NOT NULL COMMENT '新闻简介',
  `logo` varchar(20) DEFAULT '上传log' COMMENT '新闻logo',
  `details` varchar(50) COMMENT '详情连接',
  `creatTime` date DEFAULT NULL COMMENT '建创时间',
  `updateTime` date DEFAULT NULL COMMENT '修改时间',
  `state` varchar(5) NOT NULL DEFAULT '0' COMMENT '新闻状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 项目表Table structure for `t_project`
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50)  NOT NULL COMMENT '项目名称',
  `email` varchar(50)  NOT NULL COMMENT '创建人邮件账号',
  `language` varchar(50)  NOT NULL COMMENT '开发语言',
  `platform` varchar(50)  NOT NULL COMMENT '开发平台',
  `allNumber` int(11) NOT NULL DEFAULT '0' COMMENT '项目总人数',
  `currentNumber` int(11) NOT NULL DEFAULT '0' COMMENT '项目当前人数',
  `tutor` varchar(10)  NOT NULL COMMENT '指导老师账号',
  `budget` double(10,0) DEFAULT NULL COMMENT '项目预算价格',
  `describe` varchar(100)  DEFAULT NULL COMMENT '项目描述',
  `logo` varchar(20)  DEFAULT NULL COMMENT '项目logo',
  `creatTime` date NOT NULL COMMENT '创建时间',
  `startupTime` date DEFAULT NULL COMMENT '启动时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `endTime` date NOT NULL COMMENT '结束时间',
  `resultEvaluation` varchar(500) DEFAULT NULL COMMENT '项目评价',
  `status` int(10) NOT NULL DEFAULT '0' COMMENT '项目状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- 用户-项目表（不包括负责人）：Table structure for `home`
-- ----------------------------
DROP TABLE IF EXISTS `t_home`;
CREATE TABLE `t_home` (
  `projectId` int(11)  NOT NULL COMMENT '项目id',
  `email` varchar(50) NOT NULL COMMENT '用户email',
  `status` int(10) NOT NULL DEFAULT '0' COMMENT '加入项目状态',
  PRIMARY KEY (`projectId`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 任务表：Table structure for `t_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `projectId` int(11)  NOT NULL COMMENT '项目id',
  `email` varchar(50) NOT NULL COMMENT '用户email',
  `startupTime` date NOT NULL COMMENT '开始时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `endTime` date NOT NULL COMMENT '结束时间',
  `description` varchar(500) DEFAULT NULL COMMENT '任务描述',
  `taskFile` varchar(20)  DEFAULT NULL COMMENT '详细任务文件地址',
  `resultFile` varchar(20)  DEFAULT NULL COMMENT '成果文件地址',
  `resultEvaluation` varchar(500) DEFAULT NULL COMMENT '成果评价',
  `status` int(10) NOT NULL DEFAULT '0' COMMENT '任务是否有效',
  PRIMARY KEY (`projectId`,`email`,`startupTime`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
